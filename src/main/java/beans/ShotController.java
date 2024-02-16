package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.inject.Inject;

@ManagedBean
@RequestScoped
public class ShotController {
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
        System.out.println("я начал");
        shot.setX(0);
        shot.setY(0);
        shot.setR(1.0);
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public void getManageRequest() {
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        boolean isHit = shotHandler.isInside(x, y, r);
        if (shotHandler.isYValid(y) && shotHandler.isRValid(r)) {
            Shot newShot = new Shot(decimalTransform(x, 2), decimalTransform(y, 2), decimalTransform(r, 2), isHit);

            System.out.println(newShot.toString());

            shotResults.getResults().add(newShot); //актульно при private
            System.out.println(shotResults.getResults()); //актульно при private

            dbHandler.create(newShot);
//            shotResults.setLastSentR(r); // установка последнего значения R на слайдере

        } else System.out.println("ошибка");

    }

        private double decimalTransform(double number, int decimals) {
        double scale = Math.pow(10, decimals);
        number = Math.ceil(number * scale) / scale;
        return number;
    }

    public void sayMeow() {
        System.out.println("meow");
    }
}
