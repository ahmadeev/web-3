package beans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@RequestScoped
public class ShotController {
    @Getter
    @Setter
    private Shot shot = new Shot();

    @Inject
    private ShotHandler shotHandler;

    @Inject
    private DBHandler dbHandler;

    @ManagedProperty(value = "#{shotResults}")
    private ShotResults shotResults;

    public ShotResults getShotResults() {
        return shotResults;
    }

    public void setShotResults(ShotResults shotResults) {
        this.shotResults = shotResults;
    }

    public ShotController() {
        System.out.println("Shot controller bean started!");
        shot.setX(0);
        shot.setY(0);
        shot.setR(2.0);
    }

    public void getManageRequest() {
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        boolean isHit = shotHandler.isInside(x, y, r);
        if (shotHandler.isYValid(y) && shotHandler.isRValid(r)) {
            long date = (new Date()).getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String currentTime = dateFormat.format(date);
            //System.out.println(currentTime);

            Shot newShot = new Shot(decimalTransform(x, 2), decimalTransform(y, 2), decimalTransform(r, 2), isHit, currentTime);

            System.out.println(newShot.toString());

            shotResults.getResults().add(newShot);
            System.out.println(shotResults.getResults());

            dbHandler.create(newShot);

        } else System.out.println("Неправильные входные данные!");
    }

    private double decimalTransform(double number, int decimals) {
        double scale = Math.pow(10, decimals);
        number = Math.ceil(number * scale) / scale;
        return number;
    }
}
