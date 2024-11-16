package util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class InputShot {

    private BigDecimal x;
    private Boolean x1 = false;
    private Boolean x2 = false;
    private Boolean x3 = false;
    private Boolean x4 = false;
    private Boolean x5 = false;
    private Boolean x6 = false;
    private Double y;
    private BigDecimal R;

    public InputShot() {
        System.out.println("Object InputShot created");
    }

    @Override
    public String toString() {
        return "inputShot{" +
                "x=" + x +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", x4=" + x4 +
                ", x5=" + x5 +
                ", x6=" + x6 +
                ", y=" + y +
                ", r=" + R +
                "}";
    }
}