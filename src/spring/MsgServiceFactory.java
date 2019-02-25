package spring;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class MsgServiceFactory {
    private static MsgProvider mp;
    private static MsgRenderer mr;
    private Properties props;

    private static MsgServiceFactory instance = null;

    private MsgServiceFactory() {
        props = new Properties();
        try {
            props.load(new FileInputStream(new File("src/spring-props.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String rendererClass = props.getProperty("renderer.class");
        String providerClass = props.getProperty("provider.class");
        try {
            mp = (MsgProvider) Class.forName(providerClass).newInstance();
            mr = (MsgRenderer) Class.forName(rendererClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MsgServiceFactory();
    }

    static MsgServiceFactory getInstance() {
        return instance;
    }

    public static MsgProvider getMsgProvider() {
        return mp;
    }

    public static  MsgRenderer getMsgRenderer() {
        return mr;
    }
}
