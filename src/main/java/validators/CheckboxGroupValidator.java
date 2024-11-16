package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("checkboxGroupValidator")
public class CheckboxGroupValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIComponent form = component.getParent();  // Получаем форму, содержащую все чекбоксы
        boolean x1 = (boolean) form.findComponent("x_input_1").getValueExpression("value").getValue(context.getELContext());
        boolean x2 = (boolean) form.findComponent("x_input_2").getValueExpression("value").getValue(context.getELContext());
        boolean x3 = (boolean) form.findComponent("x_input_3").getValueExpression("value").getValue(context.getELContext());
        boolean x4 = (boolean) form.findComponent("x_input_4").getValueExpression("value").getValue(context.getELContext());
        boolean x5 = (boolean) form.findComponent("x_input_5").getValueExpression("value").getValue(context.getELContext());
        boolean x6 = (boolean) form.findComponent("x_input_6").getValueExpression("value").getValue(context.getELContext());

        System.out.printf("x1: %b, x2: %b, x3: %b, x4: %b, x5: %b, x6: %b%n", x1, x2, x3, x4, x5, x6);

        if (!(x1 || x2 || x3 || x4 || x5 || x6)) {
            System.out.println("Выберите хотя бы один пункт.");
            throw new ValidatorException(new FacesMessage("Выберите хотя бы один пункт."));
        }
    }
}
