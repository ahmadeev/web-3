package beans;

import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="shotValidation")
@ApplicationScoped
public class ShotValidation {

/*    private final Shot shot = new Shot();

    private final List<Shot> shots = new ArrayList<>();*/

    private final List<Integer> availableX = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3);

    private final List<Double> availableR = List.of(1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0);

    public List<Integer> getAvailableX() {
        return availableX;
    }

    public List<Double> getAvailableR() {
        return availableR;
    }

    public boolean checkShot(int x, double y, double r) {
        if (availableX.contains(x) && availableR.contains(r) && (-3 <= y && y <= 3)) return true;
        else return false;
    }
}
