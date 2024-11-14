package beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Shot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(name = "x", nullable = false)
    private double x;

    @Setter
    @Column(name = "y", nullable = false)
    private double y;

    @Setter
    @Column(name = "r", nullable = false)
    private double R;

    @Setter
    @Column(name = "hit", nullable = false)
    private boolean isHit;

    @Setter
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