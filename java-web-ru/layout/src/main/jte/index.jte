@import exercise.Data
@import exercise.dto.users.UsersPage
@param UsersPage usersPage

@template.layout.page(welcome = @`
<h1>WELCOME!</h1>
`,
users = null,
user = null)