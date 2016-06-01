package tutorial.app.common.validator;

import java.util.ArrayList;
import java.util.List;

public class ListExistInCodeListValidatorForString extends AbstractListExistInCodeListValidator<List<String>> {

    @Override
    protected List<String> getCodes(List<String> values) {
        if (values == null) {
            return null;
        }
        
        List<String> codes = new ArrayList<String>();
        for (CharSequence value : values) {
            codes.add(value == null ? null : value.toString());
        }
        return codes;
    }

}
