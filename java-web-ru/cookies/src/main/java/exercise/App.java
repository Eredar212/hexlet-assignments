package exercise;

import exercise.controller.UsersController;
import exercise.util.NamedRoutes;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("users/new", UsersController::build);
        app.post("/users", UsersController::create);
        // END

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
