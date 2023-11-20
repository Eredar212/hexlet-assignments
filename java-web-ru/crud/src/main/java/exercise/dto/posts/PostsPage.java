package exercise.dto.posts;

import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private int pageNumber;
}
// END


