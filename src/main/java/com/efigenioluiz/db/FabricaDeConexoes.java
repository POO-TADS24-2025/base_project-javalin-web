package com.efigenioluiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

    private static FabricaDeConexoes instance;

//    private static final Dotenv dotenv = Dotenv.load();

//     private static final String DB_TYPE = dotenv.get("DB_TYPE");
//     private static final String DB_HOST = dotenv.get("DB_HOST");
//     private static final String DB_PORT = dotenv.get("DB_PORT");
//     private static final String DB_NAME = dotenv.get("DB_NAME");
//     private static final String DB_USER = dotenv.get("DB_USER");
//     private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    private static final String DB_URL = "jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    // Garante uma construtora privada, ninguém mais pode instanciar essa classe
    private FabricaDeConexoes() {
    }

    public static FabricaDeConexoes getInstance() {
        if (instance == null) {
            instance = new FabricaDeConexoes();
        }
        return instance;
    }

    public static Connection getConnection() throws RuntimeException {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}