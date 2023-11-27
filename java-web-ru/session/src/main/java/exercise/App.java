package exercise;

import exercise.controller.SessionsController;
import exercise.dto.MainPage;
import exercise.util.NamedRoutes;
import io.javalin.Javalin;

import java.util.Collections;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> {
            var cu = ctx.sessionAttribute("currUser");
            var page = new MainPage(cu);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(), SessionsController::createSession);
        app.post(NamedRoutes.logoutPath(), SessionsController::destroy);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
