package beans;

import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@ApplicationScoped
public class Results implements Serializable {
    private ArrayList<String> results;
}
