package mbean;

import db.DBHandler;
import entity.Shot;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import util.InputShot;
import util.ShotHandler;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@ManagedBean(name="shotController")
@RequestScoped
public class ShotController {
    @Getter @Setter
    private InputShot inputShot = new InputShot();

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //  не является мбином, должен существовать в одном экземляре
    //  аннотации @jakarta.inject.Inject и @jakarta.inject.Singleton
    @Inject
    private ShotHandler shotHandler;

    //  инъекция с помощью средств jsf, чтобы избежать повторных инициализаций (возможно баг)
    @Getter @Setter
    @ManagedProperty(value = "#{dBHandler}")
    private DBHandler dbHandler;

    @Getter @Setter
    @ManagedProperty(value = "#{shotResults}")
    private ShotResults shotResults;

    public ShotController() {
        System.out.println("ShotController initialized");

        inputShot.setX(new BigDecimal("0.0"));
        inputShot.setY(0.0);
        inputShot.setR(new BigDecimal("2.0"));
    }

    public void getManageRequest() {

        try {

            System.out.println(inputShot.toString());

            double x;
            double y = inputShot.getY();
            double r = inputShot.getR().doubleValue();

            if (!shotHandler.isRValidStrict(r) || !shotHandler.isRValid(r)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "R: Невалидное значение!");
                throw new ValidatorException(msg);
            }

            String formSource = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formSource");
            ArrayList<Double> xs = new ArrayList<>();

            if (formSource.equals("form")) {
                if (inputShot.getX1()) xs.add(-2.0);
                if (inputShot.getX2()) xs.add(-1.5);
                if (inputShot.getX3()) xs.add(-1.0);
                if (inputShot.getX4()) xs.add(-0.5);
                if (inputShot.getX5()) xs.add(0.0);
                if (inputShot.getX6()) xs.add(0.5);
            } else if (formSource.equals("graph")) {
                xs.add(inputShot.getX().doubleValue());
            }

            if (xs.isEmpty()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "X: Выберите хотя бы одно значение!");
                throw new ValidatorException(msg);
            }

            for (double xi : xs) {
                x = xi;
                boolean isHit = shotHandler.isInside(x, y, r);
                if (shotHandler.isYValid(y)) {
                    long date = (new Date()).getTime();
                    String currentTime = sdf.format(date);
                    Shot newShot = new Shot(
                            decimalTransform(x, 2),
                            decimalTransform(y, 2),
                            decimalTransform(r, 2),
                            isHit,
                            currentTime
                    );

                    shotResults.getResults().add(newShot);
                    dbHandler.create(newShot);

                    System.out.println(newShot);
                    System.out.println(shotResults.getResults());

                } else System.out.println("Invalid input!");
            }

        } catch (ValidatorException ve) {
            FacesContext.getCurrentInstance().addMessage(null, ve.getFacesMessage());
            System.out.println("Ошибка валидации: " + ve.getFacesMessage().getSummary());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    private double decimalTransform(double number, int decimals) {
        double scale = Math.pow(10, decimals);
        number = Math.ceil(number * scale) / scale;
        return number;
    }
}
