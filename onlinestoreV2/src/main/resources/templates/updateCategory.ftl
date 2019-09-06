<#import "parts/common.ftl" as c>
<@c.page "Update attribute ${category.name}">
    <form method="post" action="/categories/updateCategory">
        <p>Изменить категорию: </p>
        <table>
            <tr>
                <td>ID</td>
                <td><input title="Id" type="number" name="categoryId" value="${category.id}" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input title="Name" type="text" name="categoryName" value="${category.name}"></td>
            </tr>
            <#list attributes as attribute>
                <tr>
                    <td>${attribute.name}}</td>
                    <td><input type="checkbox" name="attribute[${attribute.id}]" checked></td>
                </tr>
            </#list>
        </table>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Изменить категорию</button>
    </form>
</@c.page>