package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;
import java.util.List;

public class PostsController {

    // BEGIN
    public static void getPost(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(-1L);
        Post post = PostRepository.find(id).orElseThrow(NotFoundResponse::new);
        PostPage postPage = new PostPage(post);
        ctx.render(NamedRoutes.showPost(), Collections.singletonMap("page", postPage));
    }

    public static void allPosts(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        List<Post> posts = PostRepository.getEntities();
        try {
            posts = posts.subList((pageNumber - 1) * 5, pageNumber * 5);
        } catch (IndexOutOfBoundsException e) {
            posts = posts.subList((pageNumber - 1) * 5, posts.size());
        }
        PostsPage postsPage = new PostsPage(posts, pageNumber);
        ctx.render(NamedRoutes.showAllPosts(), Collections.singletonMap("page", postsPage));
    }
    // END
}
