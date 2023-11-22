package exercise.controller;

import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.Security;
import io.javalin.http.Context;

import java.util.Collections;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String token = Security.generateToken();
        User user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        Long id = (long) UserRepository.getEntities().size();
        ctx.cookie("token", token);
        ctx.redirect("/users/" + id);
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id).get();
        String userToken = user.getToken();
        String cookieToken = ctx.cookie("token");
        if (user.getId() == null || !userToken.equals(cookieToken)) {
            ctx.redirect("/users/new");
        } else {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        }
    }
    // END
}
