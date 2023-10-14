package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> invalidFields = new ArrayList<>();
        for (Field field : fields) {
            if (field.getAnnotation(NotNull.class) != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        List<String> notNullInvalidFields = validate(address);
        Map<String, List<String>> result = new HashMap<>();
        for (String fieldName : notNullInvalidFields) {
            result.put(fieldName, List.of("can not be null"));
        }
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> minLengthInvalidFields = new ArrayList<>();
        for (Field field : fields) {
            MinLength minLength = field.getAnnotation(MinLength.class);
            if (minLength != null) {
                try {
                    field.setAccessible(true);
                    if (String.valueOf(field.get(address)).length() < minLength.minLength()) {
                        if (notNullInvalidFields.contains(field.getName())) {
                            result.replace(field.getName(),
                                    List.of(result.get(field.getName()).toString(), "length less than 4"));
                        } else {
                            result.put(field.getName(), List.of("length less than 4"));
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}
// END
