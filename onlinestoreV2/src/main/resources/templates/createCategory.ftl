<#import "parts/common.ftl" as c>
<@c.page "Create category">
    Создание новой категории:
    <form method="post" action="/categories/addCategory">
        <p>Название категории: </p>
        <input title="Name" type="text" name="categoryName">
        <table>
            <tr>
                <th>Атрибут </th>
                <th>Добавить </th>
            </tr>
            <#list attributes as attribute>
                <tr>
                    <td>${attribute.name}</td>
                    <td><input type="checkbox" name="attribute[${attribute.id}]" checked></td>
                </tr>
            </#list>
        </table>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить категорию</button>
    </form>
</@c.page>