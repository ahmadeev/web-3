package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

@ManagedBean(name = "validate", eager = true)
@SessionScoped
public class Validate {
    private int x;
    private double y;
    private double R;

    public Validate() {
        System.out.println("Validate bean started");
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

    /*public String getCoords() {
        return "" + x + "; " + y + "; " + R;
    }*/

    public String getCoords() {
        return "" + x + "; " + decimalTransform(y, 2) + "; " + decimalTransform(R, 2);
    }
}