package exercise.controller;

import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void create(Context context) {
        try {
            var name = context.formParamAsClass("name", String.class)
                    .check(e -> e.length() >= 2, "Название поста должно быть не короче двух символов")
                    .get();
            var body = context.formParam("body");
            Post post = new Post(name, body);
            PostRepository.save(post);
            context.sessionAttribute("flash", "Пост был успешно создан!");
            context.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var name = context.formParam("name");
            var body = context.formParam("body");
            var ap = new BuildPostPage(name, body, e.getErrors());
            context.status(422);
            context.render("posts/build.jte", Collections.singletonMap("page", ap));
        }
    }
    public static void index(Context context) {
        PostsPage postsPage = new PostsPage(PostRepository.getEntities());
        postsPage.setFlash(context.consumeSessionAttribute("flash"));
        context.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
