package org.selenium.pom.utils;

import org.checkerframework.checker.units.qual.C;
import org.selenium.pom.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.PRODUCTION)); //ustawienie domyślnego środowiska
        switch (EnvType.valueOf(env)){
            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
            break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                  break;
            default:throw new IllegalStateException("Invalid env type: " + env);

        }

    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException(("property baseUrl is not specified in the confiq.properties file"));
    }
}
