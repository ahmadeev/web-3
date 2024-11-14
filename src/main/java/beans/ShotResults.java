package beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "shotResults", eager = true)
@ApplicationScoped
public class ShotResults implements Serializable {
    @Getter @Setter
    private ArrayList<Shot> results;

    @Inject
    private DBHandler dbHandler;

    public ShotResults() {
        System.out.println("ShotResults initialized");
    }

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
        dbHandler.resetTable();
        System.out.println("Инициализация бина ShotResults (с очисткой результатов)");
    }
}
