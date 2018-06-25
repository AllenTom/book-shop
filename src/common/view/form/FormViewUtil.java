package common.view.form;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class FormViewUtil {
    public static void bindFormToBean(Object object, HttpServletRequest request, FormView form, Map<String, String> bindMap) throws NoSuchFieldException {
        if (bindMap == null) {
            //parse form and convert
            Field[] formFields = form.getClass().getDeclaredFields();
            Field[] beanFields = object.getClass().getDeclaredFields();
            Arrays.stream(beanFields).forEach(field -> {
                String param = request.getParameter(field.getName());
                if (param != null) {
                    try {
                        Optional fieldOption = Arrays.stream(formFields).filter(
                                formField -> formField.getName().equals(field.getName())).findFirst();
                        if (fieldOption.isPresent()) {

                            Field convertField = (Field) fieldOption.get();

                            Class<?> clazz = Class.forName(convertField.getType().getName());

                            FormField fieldInterface = (FormField) clazz.newInstance();
                            field.setAccessible(true);
                            field.set(object, fieldInterface.castValue(param));
                        }

                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            bindMap.forEach(((beanMember, formName) -> {
                try {
                    object.getClass().getField(beanMember).set(object, request.getParameter(formName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
