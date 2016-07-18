package tutorial.app.todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import tutorial.domain.service.todo.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
    @ContextConfiguration(locations = {
            "classpath*:META-INF/spring/applicationContext.xml",
            "classpath*:META-INF/spring/spring-security.xml",
            "classpath*:META-INF/spring/**/*-codelist.xml"}),
    @ContextConfiguration(locations = {
            "classpath:META-INF/spring/spring-mvc.xml"})
        })
@WebAppConfiguration
public class TodoControllerTest {
    
    @Inject
    WebApplicationContext wac;
    
    @Mock
    Mapper beanMapper;
    
    @Mock
    TodoService todoService; 
    
    @Inject
    @InjectMocks
    private TodoController todoController;

    protected MockMvc mockMvc;
    
    @Before
    public void setup() {
        
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        MockitoAnnotations.initMocks(this);
        
        // TODO: Serviceのmockを記述する
//        Mockito.when(todoService.findAll()).thenThrow(new BusinessException("test"));

    }

    @Test
    public void expectSuccessTodoListTest() throws Exception {
        this.mockMvc.perform(get("/todo/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("todo/list"))
            .andExpect(model().hasNoErrors())
            .andExpect(model().attributeExists("todos"));
    }
    
    @Test
    public void expectOkCreateTest() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2020-10-10")
                .param("publicTodo", "false")
                .param("parties[0]", "1")
                .param("todoCategory", "1"));
        
        result
            .andExpect(status().is3xxRedirection());
    }
    
    @Test
    public void expectInputErrorCreateTest() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2020-10-10")
                .param("publicTodo", "false")
                .param("parties[0]", "1")
                .param("todoCategory", "21"));
        
        result
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(model().errorCount(1))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoCategory", "ExistInCodeList"));
    }
    
    @Test
    public void expectInputErrorListCreateTest() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2020-10-10")
                .param("publicTodo", "false")
                .param("parties[0]", "1")
                .param("parties[1]", "11")
                .param("todoCategory", "21"));
        
        result
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(model().errorCount(2))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoCategory", "ExistInCodeList"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "parties", "ListExistInCodeList"));
    }
    
    @Test
    public void expectInputDateErrorListCreateTest() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2016-02-30")
                .param("publicTodo", "false")
                .param("parties[0]", "1")
                .param("parties[1]", "11")
                .param("todoCategory", "21"));
        
        result
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(model().errorCount(3))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "dueDate", "typeMismatch"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoCategory", "ExistInCodeList"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "parties", "ListExistInCodeList"));
    }
    
    @Test
    public void expectInputErrorsCreateTest() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/todo/create"));
        
        result
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(model().errorCount(6))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoTitle", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoDetail", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "dueDate", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "parties", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("todoForm", "todoCategory", "NotNull"));
    }
}
