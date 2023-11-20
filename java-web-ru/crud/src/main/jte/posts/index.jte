@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage page
@template.layout.page(content = @`
    <table>
        <thead>
        <tr>
            <th>Posts</th>
        </tr>
        </thead>
        @for(Post post: page.getPosts())
            <tr>
                <td>
                    <a href="${NamedRoutes.postLink(post.getId())}">${post.getName()}</a>
                </td>
            </tr>
        @endfor
    </table>
    <br>
    <div>
        @if(page.getPageNumber() > 1)
            <div>
                <a href="${NamedRoutes.postsPath(page.getPageNumber() - 1)}">Prev</a>
            </div>
        @endif
        @if(page.getPosts().size() == 5)
            <div>
                <a href="${NamedRoutes.postsPath(page.getPageNumber() + 1)}">Next</a>
            </div>
        @endif
    </div>
`)