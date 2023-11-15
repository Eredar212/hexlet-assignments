@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page
@template.layout.page(content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать"/>
    </form>
    <ul>
    @for(User u: page.getUsers())
        <li>${u.getFirstName()} ${u.getLastName()}</li>
    @endfor
    </ul>
`)
