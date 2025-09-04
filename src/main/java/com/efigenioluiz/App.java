package com.efigenioluiz;

import java.util.ArrayList;
import com.efigenioluiz.models.Produto;
import io.javalin.Javalin;

public class App {
    // public static ArrayList<Produto> bdProdutos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Javalin app = Javalin.create().start(7070);

        app.get("/tads24", ctx -> ctx.result("TADS24 EH TOP"));
    }
}