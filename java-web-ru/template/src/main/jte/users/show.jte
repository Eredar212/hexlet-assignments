@import exercise.dto.users.UserPage
@param UserPage user

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<main>
    <h1>${user.getUser().getFirstName()} ${user.getUser().getLastName()}</h1>
    <p>${user.getUser().getEmail()}</p>
</main>
