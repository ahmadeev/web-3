package util;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class ShotHandler {
    private static final BigDecimal MIN_X = new BigDecimal(-2);
    private static final BigDecimal MAX_X = new BigDecimal("0.5");

    private static final BigDecimal MIN_Y = new BigDecimal(-3);
    private static final BigDecimal MAX_Y = new BigDecimal(5);

    private static final BigDecimal MIN_R = new BigDecimal(2);
    private static final BigDecimal MAX_R = new BigDecimal(5);

    private final List<Double> availableX = List.of(-5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0);

    private final List<Double> availableR = List.of(1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0);

    public ShotHandler() {
        System.out.println("ShotHandler initialized");
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
