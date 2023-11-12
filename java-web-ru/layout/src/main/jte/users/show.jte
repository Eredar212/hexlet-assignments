@import exercise.Data
@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(welcome = null,
users = null,
user = @`
        <div id="${page.getUser().getId()}">
            <h3>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h3>
            <b>${page.getUser().getEmail()}</b>
        </div>
`)
