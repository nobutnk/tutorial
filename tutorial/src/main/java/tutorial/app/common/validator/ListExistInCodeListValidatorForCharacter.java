package tutorial.app.common.validator;

import java.util.ArrayList;
import java.util.List;

public class ListExistInCodeListValidatorForCharacter extends AbstractListExistInCodeListValidator<List<Character>> {

    @Override
    protected List<String> getCodes(List<Character> values) {
        List<String> codes = new ArrayList<String>();
        for (Character value : values) {
            codes.add(value == null ? null : value.toString());
        }
        return codes;
    }

}
