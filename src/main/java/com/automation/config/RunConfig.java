package com.automation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunConfig {

    private RunConfig() {
    }

    private static RunConfig instance = null;
    private String host;
    private String uiHost;
    private String username;
    private String password;

    public static RunConfig getInstance() {

        if (instance == null) {

            String config = System.getProperty("config");
            instance = new RunConfig();
            instance.load(config);
        }
        return instance;
    }

    public boolean load(String config) {

        if (config == null) {
            config = System.getProperty("user.dir") + File.separator + "config";
        }

        File configFile = new File(config);
        if (configFile.isDirectory()) {
            config = config + File.separator + "default.properties";
        }

        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(config);
            properties.load(fis);
            host = properties.getProperty("host");
            uiHost = properties.getProperty("uiHost");
            username = properties.getProperty("username");
            password=properties.getProperty("password");
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public String getHost() {
        return host;
    }
    public String getUiHost() {
        return uiHost;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setHost(String host) {
        this.host = host;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUiHost(String uiHost) {
        this.uiHost = uiHost;
    }

}
