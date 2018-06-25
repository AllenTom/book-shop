package admin.view.forms;

import common.view.form.FormView;
import common.view.form.StringField;

public class CreateCategoryForm extends FormView {
    private StringField categoryName;

    public StringField getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(StringField categoryName) {
        this.categoryName = categoryName;
    }
}
