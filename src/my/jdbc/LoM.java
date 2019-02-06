package my.jdbc;

import java.util.ResourceBundle;

public class LoM {
    public static void main(String[] args) {
        String lang = "de";
        String country = "DE";
        ResourceBundle config = ResourceBundle.getBundle("config");
        System.out.println(config.getString("host"));
        System.out.println(config.getString("db"));
    }
}
