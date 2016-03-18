package tutorial.app.view.document;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public abstract class AbstractCsvView extends AbstractView {
    
    public AbstractCsvView() {
        setContentType("text/csv");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        addResponseHeader(model, request, response);
        buildCsvDocument(model, request, response);
    }
    
    protected abstract void buildCsvDocument(
            Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception;
    
    protected abstract void addResponseHeader(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response);

}
