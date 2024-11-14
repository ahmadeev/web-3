package mbean;

import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "pageError", eager = true)
public class PageError {
    public PageError() {
        System.out.println("PageError bean started!");
    }
    //  этот класс мне нужен был для тестов :(
    public String getMessage() {
        return "Контент страницы-шаблона (сообщите об ошибке, если видите это)\n";
    }
}