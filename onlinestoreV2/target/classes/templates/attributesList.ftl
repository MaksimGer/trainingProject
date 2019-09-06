<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page "Attributes">
    <div>
        <@l.logout />
    </div>
    <table>
        <tr>
            <th>ID: </th>
            <th>Атрибут: </th>
            <th>Изменить </th>
            <th>Удалить </th>
        </tr>
        <#list attributes as attribute>
            <tr>
                <td>${attribute.id}</td>
                <td>${attribute.name}</td>
                <td><a href="/attributes/update/${attribute.id}">Update</a> </td>
                <td><a href="/attributes/delete/${attribute.id}">DELETE</a> </td>
            </tr>
        </#list>
    </table>
    <div>
        <form method="post" action="/attributes/addAttribute">
            <input type="text" name="name" placeholder="Введите название" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить атрибут</button>
        </form>
    </div>
    <a href="/">На главную: </a>
</@c.page>