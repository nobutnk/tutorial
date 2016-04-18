package tutorial.app.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tutorial.app.common.validator.annotation.UploadFileRequired;

public class UploadFileRequiredValidator
    implements ConstraintValidator<UploadFileRequired, MultipartFile> {

    @Override
    public void initialize(UploadFileRequired constraint) {
    }

    @Override
    public boolean isValid(MultipartFile multipartFile,
        ConstraintValidatorContext context) {
        return multipartFile != null &&
            StringUtils.hasLength(multipartFile.getOriginalFilename());
    }
}
