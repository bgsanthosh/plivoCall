package com.plivo.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by santhosh.b on 20/10/15.
 */
public class Config {

    private static Properties properties;
    static  {

        try {

            properties = new Properties();
            properties.load(new BufferedReader(new FileReader("src/main/resources/config.properties")));

        }
        catch(Exception e)  {

            e.printStackTrace();
            System.exit(-1);
        }


    }

    public static String getConfig(String name)    {

        return properties.getProperty(name);
    }
}
