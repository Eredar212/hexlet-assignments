package exercise;

import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.NewArticlePage;
import exercise.model.Article;
import exercise.repository.ArticleRepository;
import io.javalin.Javalin;
import io.javalin.validation.ValidationException;

import java.util.Collections;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/articles/new", ctx -> {
            var ap = new NewArticlePage();
            ctx.render("articles/build.jte", Collections.singletonMap("page", ap));
        });
        app.post("/articles", ctx -> {
            var tit = ctx.formParam("title");
            var con = ctx.formParam("content");
            try {
                var title = ctx.formParamAsClass("title", String.class)
                        .check(t -> t.length() >= 2, "Название не должно быть короче двух символов")
                        .check(t -> !ArticleRepository.existsByTitle(t), "Статья с таким названием уже существует")
                        .get();
                var content = ctx.formParamAsClass("content", String.class)
                        .check(c -> c.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();
                Article article = new Article(tit, con);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var ap = new NewArticlePage(tit, con, e.getErrors());
                ctx.status(422);
                ctx.render("articles/build.jte", Collections.singletonMap("page", ap));
            }

        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
