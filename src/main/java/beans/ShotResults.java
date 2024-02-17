package beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "shotResults", eager = true)
@SessionScoped
public class ShotResults implements Serializable {
    private ArrayList<Shot> results;

    @Inject
    private DBHandler dbHandler;

    public ShotResults() {
        System.out.println("Shot results bean started!");
    }

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
        dbHandler.resetTable();
        System.out.println("Инициализация бина ShotResults (с очисткой результатов)");
    }

    public ArrayList<Shot> getResults() {
        return results;
    }

    public void setResults(ArrayList<Shot> results) {
        this.results = results;
    }

}
