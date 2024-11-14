package converter;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.util.regex.Pattern;

@FacesConverter(value = "TextInputCoordinateConverter", managed = true)
public class TextInputCoordinateConverter implements Converter<Double> {
    @Override
    public Double getAsObject(FacesContext facesContext, UIComponent uiComponent, String y) {
        if (y == null || y.isEmpty()) {
            System.out.println("Y: Значение отсутствует!");
            return null;
        }
        if (!Pattern.matches("(?:-[210]|\\+?[01234])(?:[.,]\\d{1,15})?", y)) {
            System.out.println("Y: Значение не подходит под диапазон (-3, 5).");
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Y: Значение не подходит под диапазон (-3, 5).", ""));
        }
        return Double.parseDouble(y.replace(",", "."));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Double y) {
        return y == null ? "" : y.toString();
    }
}
