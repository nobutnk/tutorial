package tutorial.app.common.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ApplicationObjectSupport;
import org.terasoluna.gfw.common.codelist.CodeList;

import tutorial.app.common.validator.annotation.ListExistInCodeList;

public abstract class AbstractListExistInCodeListValidator<T> extends ApplicationObjectSupport
        implements ConstraintValidator<ListExistInCodeList, T> {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * codelist
     */
    private CodeList codeList = null;

    /**
     * Initialize.
     * <p>
     * Get the codelist from applicationContext.
     * </p>
     */
    @Override
    public void initialize(ListExistInCodeList codeConstraint) {
        this.codeList = getApplicationContext().getBean(
                codeConstraint.codeListId(), CodeList.class);
    }

    protected abstract List<String> getCodes(T values);

    /**
     * Validate.
     * 
     * @param value
     *            target value.
     * @param constraintContext
     *            constraint context.
     * @return if valid value, return true.
     */
    @Override
    public boolean isValid(T value, ConstraintValidatorContext constraintContext) {
        List<String> codes = getCodes(value);

        if (codes == null) {
            return true;
        }
        if (logger.isTraceEnabled()) {
            logger.trace("check if {} exists in {}", codes, codeList.getCodeListId());
        }
        for (String code : codes) {
            if (!codeList.asMap().containsKey(code)) {
                return false;
            }
        }
        return true;
    }

}
