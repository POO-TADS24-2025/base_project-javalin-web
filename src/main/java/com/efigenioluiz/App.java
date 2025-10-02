package com.efigenioluiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;
import com.efigenioluiz.DAO.ProdutoDAOImpl;
import java.sql.PreparedStatement;
import com.efigenioluiz.db.FabricaDeConexoes;

import com.efigenioluiz.models.Produto;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinFreemarker;

public class App {
    public static void main(String[] args) {

        // String query = "SELECT * FROM produtos";
        // try (
        // Connection con = FabricaDeConexoes.getInstance().getConnection();
        // PreparedStatement stmt = con.prepareStatement(query);
        // ResultSet rs = stmt.executeQuery()
        // ) {
        // while (rs.next()) {
        // System.out.println("ID: " + rs.getInt("id"));
        // System.out.println("Nome: " + rs.getString("nome"));
        // System.out.println("Preço: " + rs.getDouble("preco"));
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ProdutoDAOImpl produtoDAO = new ProdutoDAOImpl();
        Produto produto1 = new Produto("Teclado", 150.0);
        produtoDAO.salvar(produto1);

        System.out.println("Hello world!");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_34);
        cfg.setClassForTemplateLoading(App.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles -> {
                // staticFiles.directory = "/public";
                staticFiles.location = Location.CLASSPATH;
                config.fileRenderer(new JavalinFreemarker(cfg));
            });
        }).start(7070);

        app.get("/", ctx -> {
            Map<String, String> model = Map.of("nome", "Prof. Luiz");
            ctx.render("index.ftl", model);
        });

        app.get("/cadastro", ctx -> {
            ctx.render("cadastro.ftl");
        });

        app.post("/produtos", ctx -> {
            String nomeProduto = ctx.formParam("nome");
            Double precoProduto = Double.parseDouble(ctx.formParam("preco"));

            System.out.println("Nome do Produto: " + nomeProduto);
            System.out.println("Preço do Produto: " + precoProduto);

            Produto produto = new Produto(nomeProduto, precoProduto);
            ctx.render("produtos.ftl", Map.of("produto", produto));
        });
    }
}