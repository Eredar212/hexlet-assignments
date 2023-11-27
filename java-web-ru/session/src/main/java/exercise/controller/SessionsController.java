package exercise.controller;

import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

import java.util.Collections;

public class SessionsController {

    // BEGIN
    public static void build(Context context) {
        LoginPage loginPage = new LoginPage(null, null);
        context.render("build.jte", Collections.singletonMap("page", loginPage));
    }

    public static void createSession(Context context) {
        var name = context.formParam("name");
        var pass = context.formParam("password");
        if (!UsersRepository.existsByName(name)) {
            LoginPage loginPage = new LoginPage(name, "Wrong username or password");
            context.render("build.jte", Collections.singletonMap("page", loginPage));
        } else if (UsersRepository.findByName(name).getPassword().equals(Security.encrypt(pass))) {
            context.sessionAttribute("currUser", name);
            context.redirect(NamedRoutes.rootPath());
        } else {
            LoginPage loginPage = new LoginPage(name, "Wrong username or password");
            context.render("build.jte", Collections.singletonMap("page", loginPage));
        }
    }

    public static void destroy(Context context) {
        context.sessionAttribute("currUser", null);
        context.redirect(NamedRoutes.rootPath());
    }
    // END
}
