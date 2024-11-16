package mbean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class FormBean {
    private Boolean x1;
    private Boolean x2;
    private Boolean x3;
    private Boolean x4;
    private Boolean x5;
    private Boolean x6;
    private Double y;
    private Double R;
    
}
