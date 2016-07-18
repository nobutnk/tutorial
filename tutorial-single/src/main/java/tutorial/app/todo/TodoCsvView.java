package tutorial.app.todo;

import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import tutorial.app.view.document.AbstractCsvView;
import tutorial.domain.model.Todo;

@Component
public class TodoCsvView extends AbstractCsvView {

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CsvBeanWriter writer =
                new CsvBeanWriter(
                        new OutputStreamWriter(
                                response.getOutputStream()),
                                CsvPreference.STANDARD_PREFERENCE); 
        writer.writeHeader("todoId", "todoTitle", "todoCategory", "todoDetail", "finished", "updatedAt", "createdAt");
        
        Collection<Todo> todos = (Collection<Todo>) model.get("todos");
        
        for (Todo todo : todos) {
            writer.write(todo, "todoId", "todoTitle", "todoCategory", "todoDetail", "finished", "updatedAt", "createdAt");
        }
        
        writer.close();
    }
    
    @Override
    public String getContentType() {
        return "text/csv; charset=Shift_JIS";
    }

    @Override
    protected void addResponseHeader(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) {
        response.setHeader("Content-Disposition",
                "attachment; filename=todolist.csv");
    }
    
    
}
