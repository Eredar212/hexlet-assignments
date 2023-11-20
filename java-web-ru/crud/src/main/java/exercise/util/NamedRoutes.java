package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String showPost() {
        return "posts/show.jte";
    }

    public static String showAllPosts() {
        return "posts/index.jte";
    }

    public static String postsPath() {
        return "/posts";

    }

    public static String postsPath(int pageNumber) {
        return "/posts?page=" + pageNumber;
    }

    public static String postLink(Long id) {
        return "/posts/" + id;
    }

    public static String postLink(String id) {
        return "/posts/" + id;
    }
    // END
}
