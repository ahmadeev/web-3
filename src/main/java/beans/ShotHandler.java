package beans;

import java.util.List;

public class ShotHandler {

    private final List<Integer> availableX = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3);

    private final List<Double> availableR = List.of(1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0);

    public List<Integer> getAvailableX() {
        return availableX;
    }

    public List<Double> getAvailableR() {
        return availableR;
    }

    public boolean isValid(double x, double y, double r) {
        return isXValid(x) && isYValid(y) && isRValid(r);
    }

    public boolean isXValid(double x) {
        return availableX.contains(x);
    }

    public boolean isYValid(double y) {
        return y >= -3.0 && y <= 3.0;
    }

    public boolean isRValid(double r) {
        return availableR.contains(r);
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
