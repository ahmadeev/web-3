package mbean;

import db.DBHandler;
import entity.Shot;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
public class ShotResults implements Serializable {
    @Getter
    private ArrayList<Shot> results;

    private DBHandler dbHandler;

    public ShotResults() {
        System.out.println("ShotResults initialized");
    }

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
        dbHandler.resetTable();
        System.out.println("PostConstruct ShotResults mbean method (result array was cleaned)");
    }
}
