package converters;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.util.regex.Pattern;

@FacesConverter(value = "RCoordinateConverter", managed = true)
public class RCoordinateConverter implements Converter<Double> {
    @Override
    public Double getAsObject(FacesContext facesContext, UIComponent uiComponent, String r) {
        if (r == null || r.isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "R: Значение отсутствует!");
            facesContext.addMessage(null, msg);
            throw new ConverterException(msg);
        }
        if (!Pattern.matches("([2-4])([.,](0{0,2}|25|50|75))?|5([.,](0{0,2}))?", r)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "R: Значение не подходит под допустимый диапазон слайдера.");
            facesContext.addMessage(null, msg);
            throw new ConverterException(msg);
        }
        return Double.parseDouble(r.replace(",", "."));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Double r) {
        return r == null ? "" : r.toString();
    }
}
