@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все посты</h1>

            <table class="table table-striped">
                @for(var article : page.getPosts())
                    <tr>
                        <td>
                            ${article.getId()}
                        </td>
                        <td>
                            ${article.getName()}
                        </td>
                        <td>
                            ${article.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
`,
page = page
)
