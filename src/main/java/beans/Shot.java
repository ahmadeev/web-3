package beans;

import jakarta.persistence.*;

@Entity
public class Shot {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private double x;
    @Column(nullable = false)
    private double y;
    @Column(nullable = false)
    private double R;
    @Column(nullable = false)
    private boolean isHit;

    public Shot() {
        System.out.println("Shot bean started");
    }

    public Shot(Shot shot) {
        this.x = shot.x;
        this.y = shot.y;
        this.R = shot.R;
    }

    public Shot(double x, double y, double r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.R = r;
        this.isHit = isHit;
    }

    public long getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return R;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.R = r;
    }

    public void setHit(boolean hit) {
        this.isHit = hit;
    }

    @Override
    public String toString() {
        return "shot{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + R +
                ", result=" + isHit +
                "}";
    }
}