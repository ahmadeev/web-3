package beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "shotResults", eager = true)
@SessionScoped
public class ShotResults implements Serializable {
    private ArrayList<Shot> results;
//    private double lastSentR = 1.0;

    public ShotResults() {
        System.out.println("Shot results bean started!");
    }

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
//        lastSentR = 1.0;
        System.out.println("очистился");
    }

    public ArrayList<Shot> getResults() {
        return results;
    }

    public void setResults(ArrayList<Shot> results) {
        this.results = results;
    }

/*    // установка последнего значения R на слайдере
    public double getLastSentR() {
        System.out.println(lastSentR);
        return lastSentR;
    }

    public void setLastSentR(double lastSentR) {
        this.lastSentR = lastSentR;
        System.out.println(lastSentR);
    }*/
}
