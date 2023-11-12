@import gg.jte.Content

@param Content welcome
@param Content users
@param Content user

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<header>
    <a href="/">Main</a>
    <a href="/users">Users</a>
</header>
<main>
    <p>
        Exercise Layout. Hexlet.
    </p>
    <div class="welcome">
        ${welcome}
    </div>
    <div class="users">
        ${users}
    </div>
    <div class="user">
        ${user}
    </div>
</main>
</body>
</html>
