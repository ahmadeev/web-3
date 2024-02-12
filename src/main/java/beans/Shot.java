package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.inject.Inject;

import static java.util.Objects.isNull;

@ManagedBean(name = "shot", eager = true)
@RequestScoped
public class Shot {
    private int x;
    private double y;
    private double R;

    public Shot() {
        System.out.println("Shot bean started");
    };

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return R;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        R = r;
    }

    private double decimalTransform(double number, double decimals) {
        double scale = Math.pow(10, decimals);
        number = Math.ceil(number * scale) / scale;
        return number;
    }

    @ManagedProperty(value = "#{shotValidation}")
    private ShotValidation shotValidation;

    public ShotValidation getShotValidation() {
        return shotValidation;
    }

    public void setShotValidation(ShotValidation shotValidation) {
        this.shotValidation = shotValidation;
    }

    public String getCoords() {

        if (shotValidation.checkShot(x, y, R)) {return "" + x + "; " + decimalTransform(y, 2) + "; " + decimalTransform(R, 2);}
        else return "ошибка валидации";
    }

    /*public String getCoords() {
        return "" + x + "; " + decimalTransform(y, 2) + "; " + decimalTransform(R, 2);
    }*/
}