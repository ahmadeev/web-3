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

    private BigDecimal y;

    private BigDecimal R;

    public InputShot() {
        System.out.println("Object InputShot created");
    }

    public InputShot(InputShot shot) {
        this.x = shot.x;
        this.y = shot.y;
        this.R = shot.R;
    }
}