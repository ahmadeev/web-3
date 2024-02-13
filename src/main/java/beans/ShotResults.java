package beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "shotResults", eager = true)
@ApplicationScoped
public class ShotResults implements Serializable {
    protected ArrayList<Shot> results;

    public ShotResults() {
        System.out.println("Shot results bean started!");
    }

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
    }

    public ArrayList<Shot> getResults() {
        return results;
    }

    public void setResults(ArrayList<Shot> results) {
        this.results = results;
    }

}
