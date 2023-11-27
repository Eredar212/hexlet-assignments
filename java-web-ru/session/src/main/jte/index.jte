@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page != null && page.getName() != null)
        <div>
            ${page.getName().toString()}
        </div>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
`)
