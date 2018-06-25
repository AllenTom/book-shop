package common.view.form;

public class StringField implements FormField {
    @Override
    public Object castValue(Object value) {
        if (value instanceof String) {
            return value;
        } else {
            return value.toString();
        }
    }

    public StringField() {
    }
}
