package tutorial.domain.service.todo;

import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tutorial.domain.model.Todo;
import tutorial.testutil.TutorialDataSourceBasedDBTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@Rollback
public class TodoServiceDbunitTest extends TutorialDataSourceBasedDBTestCase {
    
    @Inject
    TodoService todoService;

    @Inject
    NamedParameterJdbcTemplate jdbcTemplate;
    
    @Inject
    private TransactionAwareDataSourceProxy dataSourceTest;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }
    
    @Test
    public void expected100findOne() {
        Todo actualTodo = todoService.findOne(100);
        
        Assert.assertThat(actualTodo.getTodoId(), is(100));
        Assert.assertThat(actualTodo.getTodoTitle(), is("junit test"));
        Assert.assertThat(actualTodo.getTodoCategory(), is("1"));
        Assert.assertThat(actualTodo.getTodoDetail(), is("junit detail"));
    }
    
    @Test
    public void expected200create() {
        Todo todo = new Todo();
        todo.setTodoTitle("create test");
        todo.setTodoCategory("2");
        todo.setTodoDetail("create detail");
        todo.setDueDate(LocalDate.now());
        todo.setPublicTodo(false);
        todo.setFinished(false);
        todo.setUpdatedAt(LocalDateTime.now());
        todo.setCreatedAt(LocalDateTime.now());
        todoService.create(todo);
        
        String q = "select "
                + "todo_id, todo_title, todo_category, todo_detail, "
                + "due_date, public, finished, updated_at, created_at"
                + " from todo where todo_id = :todoId";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("todoId", 200);
        Map<String, Object> actualMap = jdbcTemplate.queryForMap(q, param);
        
        Assert.assertThat(actualMap.get("todo_id"), is("200"));
        Assert.assertThat(actualMap.get("todo_title"), is("create test"));
        Assert.assertThat(actualMap.get("todo_category"), is("2"));
        Assert.assertThat(actualMap.get("todo_detail"), is("create detail"));
    }
    
    @Test
    public void expectedTrueFinish() {
        Todo findTodo = todoService.findOne(100);
        todoService.finish(100, findTodo.getUpdatedAt());
        
        String q = "select "
                + "todo_id, todo_title, todo_category, todo_detail, "
                + "due_date, public, finished, updated_at, created_at"
                + " from todo where todo_id = :todoId";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("todoId", 100);
        Map<String, Object> actualMap = jdbcTemplate.queryForMap(q, param);
        
        Assert.assertThat(actualMap.get("todo_id"), is("100"));
        Assert.assertThat(actualMap.get("finished"), is(true));
    }
    
    @Test
    public void expectedTrueUpdate() {
        Todo todo = new Todo();
        todo.setTodoTitle("update test");
        todo.setTodoCategory("2");
        todo.setTodoDetail("update detail");
        todo.setDueDate(LocalDate.now());
        todo.setPublicTodo(false);
        todo.setFinished(false);
        Todo createdTodo = todoService.create(todo);
        
        Todo findTodo = todoService.findOne(createdTodo.getTodoId());
        
        Todo updateTodo = new Todo();
        updateTodo.setTodoId(createdTodo.getTodoId());
        updateTodo.setTodoTitle("update test updated");
        updateTodo.setTodoCategory("3");
        updateTodo.setTodoDetail("update detail is updated");
        updateTodo.setDueDate(LocalDate.of(2020, 10, 10));
        updateTodo.setPublicTodo(true);
        updateTodo.setFinished(true);
        updateTodo.setUpdatedAt(findTodo.getUpdatedAt());
        
        todoService.update(updateTodo);
        
        String q = "select "
                + "todo_id, todo_title, todo_category, todo_detail, "
                + "due_date, public, finished, updated_at, created_at"
                + " from todo where todo_id = :todoId";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("todoId", createdTodo.getTodoId());
        Map<String, Object> actualMap = jdbcTemplate.queryForMap(q, param);
        
        Assert.assertThat(actualMap.get("todo_id"), is(createdTodo.getTodoId().toString()));
        Assert.assertThat(actualMap.get("todo_title"), is("update test updated"));
        Assert.assertThat(actualMap.get("todo_category"), is("3"));
        Assert.assertThat(actualMap.get("todo_detail"), is("update detail is updated"));
    }
    
    @Test
    public void expectedTrueDelete() {
        Todo todo = new Todo();
        todo.setTodoTitle("delete test");
        todo.setTodoCategory("2");
        todo.setTodoDetail("delete detail");
        todo.setDueDate(LocalDate.now());
        todo.setPublicTodo(false);
        todo.setFinished(false);
        Todo createdTodo = todoService.create(todo);
        
        Todo findTodo = todoService.findOne(createdTodo.getTodoId());
        
        todoService.delete(createdTodo.getTodoId(), findTodo.getUpdatedAt());
        
        String q = "select "
                + "todo_id, todo_title, todo_category, todo_detail, "
                + "due_date, public, finished, updated_at, created_at"
                + " from todo where todo_id = :todoId";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("todoId", createdTodo.getTodoId());
        
        try {
            jdbcTemplate.queryForMap(q, param);
            fail("data is found.");
        } catch (EmptyResultDataAccessException e) {
        
        }
        
    }

    @Override
    protected DataSource getDataSource() {
        return dataSourceTest;
    }
    
    @Override
    protected String getFilePath() {
        return "classpath:testdata/todo/tutorial.xlsx";
    }

}
