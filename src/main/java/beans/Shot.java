package beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.inject.Inject;

import java.util.Objects;

import static java.util.Objects.isNull;

@ManagedBean(name = "shot", eager = true)
@RequestScoped
public class Shot {
    private double x;
    private double y;
    private double R;
    private boolean isHit;

    public Shot() {
        System.out.println("Shot bean started");
    };

    public Shot(double x, double y, double r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.R = r;
        this.isHit = isHit;
    }

/*    @PostConstruct
    public void init() {
        R = 1;
    }*/

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return R;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.R = r;
    }

    public void setHit(boolean hit) {
        this.isHit = hit;
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

    @ManagedProperty(value = "#{shotResults}")
    private ShotResults shotResults;

    public ShotResults getShotResults() {
        return shotResults;
    }

    public void setShotResults(ShotResults shotResults) {
        this.shotResults = shotResults;
    }

    public String getCoords() {

        if (shotValidation.isYValid(y) && shotValidation.isRValid(R)) {
            Shot shot = new Shot(x, y, R, shotValidation.isInside(x, y, R));
            shotResults.results.add(shot);
            System.out.println(Objects.toString(shotResults.results));
            System.out.println(shot.toString());
            return ("{\"x\": " + x + ", \"y\": " + y + ", \"R\": " + R + ", \"isHit\": " + shotValidation.isInside(x, y, R) + "}");
        }
        else return "validation error";
    }

    public void sayMeow() { System.out.println("meow"); }

    @Override
    public String toString() {
        return "shot{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + R +
                ", result=" + isHit +
                "}";
    }
}