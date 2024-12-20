package mbean;

import db.DBHandler;
import entity.Shot;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

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
        dbHandler.clear();
        System.out.println("PostConstruct ShotResults mbean method (result array was cleaned)");
    }
}
