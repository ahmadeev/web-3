package beans;

import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="shotValidation")
@SessionScoped
public class ShotValidation {

    private final List<Integer> availableX = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3);

    private final List<Double> availableR = List.of(1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0);

    public List<Integer> getAvailableX() {
        return availableX;
    }

    public List<Double> getAvailableR() {
        return availableR;
    }

    public boolean isValid(double x, double y, double r) {
        if (isXValid(x) && isYValid(y) && isRValid(r)) return true;
        else return false;
    }

    public boolean isXValid(double x) {
        if (availableX.contains(x)) return true;
        else return false;
    }

    public boolean isYValid(double y) {
        if (y >= -3.0 && y <= 3.0) return true;
        else return false;
    }

    public boolean isRValid(double r) {
        if (availableR.contains(r)) return true;
        else return false;
    }

    public boolean isInside(double x, double y, double r) {
        // 2nd
        if ((y >= 0) && (x <= 0)) return (y <= r / 2) && (x >= -r);
        // 3rd
        if ((y < 0) && (x <= 0)) return (x * x + y * y <= r * r);
        // 4th
        if ((y <= 0) && (x > 0)) return (y >= x - r);
        // 1st
        return false;
    }
}
