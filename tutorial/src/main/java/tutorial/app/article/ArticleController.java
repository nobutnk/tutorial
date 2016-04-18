package tutorial.app.article;

import java.io.IOException;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.SystemException;
import org.terasoluna.gfw.common.message.ResultMessages;

import tutorial.domain.model.Article;
import tutorial.domain.service.article.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {
    
    @Value("${upload.allowableFileSize}")
    private int uploadAllowableFileSize;
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    ArticleService articleService;

    @ModelAttribute
    public ArticleForm setForm() {
        return new ArticleForm();
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET, params = "form")
    public String uploadForm(Model model) {
        return "article/uploadForm";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(
            @Validated ArticleForm form,
            BindingResult result,
            Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "article/uploadForm";
        }

        MultipartFile uploadFile = form.getFile();

        if (!StringUtils.hasLength(uploadFile.getOriginalFilename())) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6002");
            return "article/uploadForm";
        }

        if (uploadFile.isEmpty()) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6003");
            return "article/uploadForm";
        }

        if (uploadAllowableFileSize < uploadFile.getSize()) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6004",
                    new Object[] { uploadAllowableFileSize }, null);
            return "article/uploadForm";
        }

        
        try {
            Article article = new Article();
            article.setDescription(form.getDescription());
            article.setContentType(uploadFile.getContentType());
            article.setFile(uploadFile.getInputStream());
            articleService.create(article);
        } catch (IOException e) {
            throw new SystemException("e.xx.fw.6001", e);
        }
        

        redirectAttributes.addFlashAttribute(
                ResultMessages.success().add("i.xx.at.0001"));
        return "redirect:/article/upload?complete";
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET, params = "complete")
    public String uploadComplete() {
        return "article/uploadComplete";
    }

}
