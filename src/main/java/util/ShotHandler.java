package util;

import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.List;

@Getter
@Singleton
public class ShotHandler {
    private static final double MIN_X = -2;
    private static final double MAX_X = 0.5;

    private static final double MIN_Y = -3;
    private static final double MAX_Y = 5;

    private static final double MIN_R = 2;
    private static final double MAX_R = 5;

    private final List<Double> availableX = List.of(-2.0, -1.5, -1.0, -0.5, 0.0, 0.5);

    private final List<Double> availableR = List.of(2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0);

    public ShotHandler() {
        System.out.println("ShotHandler initialized");
    }

    public boolean isValid(double x, double y, double r) {
        return (isXValid(x) || isXValidStrict(x))
                && isYValid(y)
                && (isRValid(r) || isRValidStrict(r));
    }

    public boolean isXValid(double x) {
        return x >= MIN_X && x <= MAX_X;
    }

    public boolean isXValidStrict(double x) {
        return availableX.contains(x);
    }

    public boolean isYValid(double y) {
        return y > MIN_Y && y < MAX_Y;
    }

    public boolean isRValid(double r) {
        return r >= MIN_R && r <= MAX_R;
    }

    public boolean isRValidStrict(double r) {
        return availableR.contains(r);
    }

    public boolean isInside(double x, double y, double r) {
        // 1st
        if ((y >= 0) && (x >= 0)) return (y <= r) && (x <= r);
        // 2nd
        if ((y >= 0) && (x <= 0)) return (x * x + y * y <= r * r);
        // 4th
        if ((y <= 0) && (x >= 0)) return (y >= 2 * x - r);
        // 3rd
        return false;
    }
}
