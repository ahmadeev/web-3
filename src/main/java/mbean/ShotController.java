package mbean;

import db.DBHandler;
import entity.Shot;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import util.ShotHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name="shotController")
@RequestScoped
public class ShotController {
    @Getter
    @Setter
    private Shot shot = new Shot();

    private final SimpleDateFormat sdf;

    //  не является мбином, должен существовать в одном экземляре
    //  аннотации @jakarta.inject.Inject и @jakarta.inject.Singleton
    @Inject
    private ShotHandler shotHandler;

    //  инъекция с помощью средств jsf, чтобы избежать повторных инициализаций (возможно баг)
    @Getter @Setter
    @ManagedProperty(value = "#{dBHandler}")
    private DBHandler dbHandler;

    @Getter @Setter
    @ManagedProperty(value = "#{shotResults}")
    private ShotResults shotResults;

    public ShotController() {
        System.out.println("ShotController initialized");
        shot.setX(0);
        shot.setY(0);
        shot.setR(2.0);
        sdf = new SimpleDateFormat("HH:mm:ss");
    }

    public void getManageRequest() {
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        boolean isHit = shotHandler.isInside(x, y, r);
        if (shotHandler.isYValid(y) && shotHandler.isRValid(r)) {
            long date = (new Date()).getTime();
            String currentTime = sdf.format(date);
            Shot newShot = new Shot(
                    decimalTransform(x, 2),
                    decimalTransform(y, 2),
                    decimalTransform(r, 2),
                    isHit,
                    currentTime
            );

            shotResults.getResults().add(newShot);
            dbHandler.create(newShot);

            System.out.println(newShot);
            System.out.println(shotResults.getResults());

        } else System.out.println("Invalid input!");
    }

    private double decimalTransform(double number, int decimals) {
        double scale = Math.pow(10, decimals);
        number = Math.ceil(number * scale) / scale;
        return number;
    }
}
