package br.com.kasolution.util;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Parametrizador {

    private static final Parametrizador instance = new Parametrizador();
    //CAP. 19 - DECLARAR VARIAVEL
    private Properties properties;

    private Parametrizador() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream in = classLoader.getResourceAsStream("settings.properties");
                BufferedInputStream bis = new BufferedInputStream(in);
            ) {
            this.properties = new Properties();
            this.properties.load(bis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro ao obter parâmetros: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao obter parâmetros: " + e.getMessage());
        }
    }

    public static Parametrizador getInstance() {
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
