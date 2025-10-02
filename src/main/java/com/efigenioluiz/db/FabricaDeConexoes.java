package com.efigenioluiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

    private static FabricaDeConexoes instance;

    private static final String DB_TYPE = "mysql";
    private static final String DB_HOST = "efigenioluiz.xyz";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "nykolas_gt_db";
    private static final String DB_USER = "nykolas_gt";
    private static final String DB_PASSWORD = "12345678";

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