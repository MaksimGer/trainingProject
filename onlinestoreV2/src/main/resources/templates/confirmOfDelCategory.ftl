<#import "parts/common.ftl" as c>
<@c.page "Category ${category.name}">
    <h1>Подтверждение удаления категории: ${category.name}</h1>
    <p>В этой категории находятся следующий продукты:</p>
    <table>
        <tr>
            <th>ID продукта</th>
            <th>Название</th>
            <th>Категория</th>
        </tr>
        <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td><a href="/products/product/${product.id}">${product.name}</a></td>
                <td>${product.category.name}</td>
            </tr>
        </#list>
    </table>
    <p>Вы точно хотите удалить категорию со всеми её продуктами?</p>
    <form method="post" action="/categories/confirmedDeletion/${category.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" >Удалить ктегорию</button>
    </form>
    <form method="get" action="/categories">
        <button type="submit">Отменить удаление</button>
    </form>
</@c.page>