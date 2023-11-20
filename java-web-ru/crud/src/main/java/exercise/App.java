package exercise;

import exercise.controller.PostsController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        // BEGIN
        app.get(NamedRoutes.postsPath(), PostsController::allPosts);
        app.get(NamedRoutes.postLink("{id}"), PostsController::getPost);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
