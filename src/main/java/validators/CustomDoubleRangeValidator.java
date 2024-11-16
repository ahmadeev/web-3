package validators;

import jakarta.faces.validator.FacesValidator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("customDoubleRangeValidator")
public class CustomDoubleRangeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof Double) {
            Double doubleValue = (Double) value;
            if (doubleValue < 2.0 || doubleValue > 5.0) {
                System.out.println("meow");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка диапазона",
                        "Значение должно быть между 2.0 и 5.0.");
                throw new ValidatorException(message);
            }
        }
    }
}

