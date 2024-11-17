package converters;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.util.regex.Pattern;

@FacesConverter(value = "YCoordinateConverter", managed = true)
public class YCoordinateConverter implements Converter<Double> {
    @Override
    public Double getAsObject(FacesContext facesContext, UIComponent uiComponent, String y) {
        if (y == null || y.isEmpty()) {
            System.out.println("Y: Значение отсутствует!");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Y: Значение отсутствует!");
            facesContext.addMessage(null, msg);
            throw new ConverterException(msg);
            //  раньше return null;
        }
        if (!Pattern.matches("(?:-[210]|\\+?[01234])(?:[.,]\\d{1,15})?", y)) {
            System.out.println("Y: Значение не подходит под диапазон (-3, 5).");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Y: Значение не подходит под диапазон (-3, 5).");
            facesContext.addMessage(null, msg);
            throw new ConverterException(msg);
        }
        return Double.parseDouble(y.replace(",", "."));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Double y) {
        return y == null ? "" : y.toString();
    }
}
