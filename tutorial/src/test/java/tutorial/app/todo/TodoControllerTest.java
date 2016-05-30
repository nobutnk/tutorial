package tutorial.app.todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.terasoluna.gfw.common.exception.BusinessException;

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
        Mockito.when(todoService.findAll()).thenThrow(new BusinessException("test"));

    }

    @Test
    public void sampleTest() throws Exception {
        this.mockMvc.perform(get("/todo/list")).andExpect(status().isOk());
    }
    
    @Test
    public void expectOkcreateTest() throws Exception {
        this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2020-10-10")
                .param("publicTodo", "false")
                .param("todoCategory", "1")).andExpect(status().is3xxRedirection());
    }
    
    @Test
    public void expectInputErrorcreateTest() throws Exception {
        this.mockMvc.perform(post("/todo/create")
                .param("todoTitle", "junitTitle")
                .param("todoDetail", "junitDetail")
                .param("dueDate", "2020-10-10")
                .param("publicTodo", "false")
                .param("todoCategory", "21")).andExpect(status().isOk())
                .andExpect(flash().attribute("flash1", "flash1"));
    }
}
