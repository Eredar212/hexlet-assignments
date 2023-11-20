@import exercise.dto.posts.PostPage
@param PostPage page
@template.layout.page(content = @`
    <h4>${page.getPost().getId()}</h4>
    <h1>${page.getPost().getName()}</h1>
    <div>${page.getPost().getBody()}</div>
`)