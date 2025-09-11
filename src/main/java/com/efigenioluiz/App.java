package com.efigenioluiz;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinFreemarker;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_34);
        cfg.setClassForTemplateLoading(App.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles -> {
                staticFiles.directory = "/public";
                staticFiles.location = Location.CLASSPATH;
                config.fileRenderer(new JavalinFreemarker(cfg));
            });
        }).start(7070);

        app.get("/", ctx -> {
            ctx.redirect("index.html");
        });
    }
}