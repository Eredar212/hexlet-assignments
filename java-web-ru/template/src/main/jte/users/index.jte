@import exercise.dto.users.UsersPage
@param UsersPage users

<html>
<head>
    <title>Хекслет</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>${users.getHeader()}</h1>
@if(users.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : users.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>
