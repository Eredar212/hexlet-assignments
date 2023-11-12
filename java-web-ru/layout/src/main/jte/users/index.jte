@import exercise.Data
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(welcome = null, 
users = @`
    @for(var user: page.getUsers())
        <div id="${user.getId()}">
            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
        </div>
    @endfor
`,
user = null)
