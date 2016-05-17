package tutorial.domain.repository.todo;

import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tutorial.domain.model.Todo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@Rollback
public class TodoRepositoryDbunitTest extends DataSourceBasedDBTestCase {
    
    @Inject
    TodoRepository todoRepository;

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
        Todo actualTodo = todoRepository.findOne("100");
        
        Assert.assertThat(actualTodo.getTodoId(), is("100"));
        Assert.assertThat(actualTodo.getTodoTitle(), is("junit test"));
        Assert.assertThat(actualTodo.getTodoCategory(), is("1"));
        Assert.assertThat(actualTodo.getTodoDetail(), is("junit detail"));
    }
    
    @Test
    public void expected100create() {
        Todo todo = new Todo();
        todo.setTodoId("101");
        todo.setTodoTitle("create test");
        todo.setTodoCategory("2");
        todo.setTodoDetail("create detail");
        todo.setDueDate(LocalDate.now());
        todo.setPublicTodo(false);
        todo.setFinished(false);
        todo.setUpdatedAt(LocalDateTime.now());
        todo.setCreatedAt(LocalDateTime.now());
        todoRepository.create(todo);
        
        String q = "select "
                + "todo_id, todo_title, todo_category, todo_detail, "
                + "due_date, public, finished, updated_at, created_at"
                + " from todo where todo_id = :todoId";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("todoId", 101);
        Map<String, Object> actualMap = jdbcTemplate.queryForMap(q, param);
        
        Assert.assertThat(actualMap.get("todo_id"), is("101"));
        Assert.assertThat(actualMap.get("todo_title"), is("create test"));
        Assert.assertThat(actualMap.get("todo_category"), is("2"));
        Assert.assertThat(actualMap.get("todo_detail"), is("create detail"));
    }

    @Override
    protected DataSource getDataSource() {
        return dataSourceTest;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new XlsDataSet(new File("fixtures.xls"));
    }

}
