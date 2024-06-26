package beans;

import jakarta.persistence.*;

@Entity
public class Shot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "x", nullable = false)
    private double x;
    @Column(name = "y", nullable = false)
    private double y;
    @Column(name = "r", nullable = false)
    private double R;
    @Column(name = "hit", nullable = false)
    private boolean isHit;
    @Column(nullable = false, name = "currentTime")
    private String currentTime;

    public Shot() {
        System.out.println("Shot bean started");
    }

    public Shot(Shot shot) {
        this.x = shot.x;
        this.y = shot.y;
        this.R = shot.R;
        this.isHit = shot.isHit;
    }

    public Shot(double x, double y, double r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.R = r;
        this.isHit = isHit;
    }

    public Shot(double x, double y, double r, boolean isHit, String currentTime) {
        this.x = x;
        this.y = y;
        this.R = r;
        this.isHit = isHit;
        this.currentTime = currentTime;
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

    public String getCurrentTime() {
        return currentTime;
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

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "shot{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + R +
                ", result=" + isHit +
                ", currentTime=" + currentTime +
                "}";
    }
}