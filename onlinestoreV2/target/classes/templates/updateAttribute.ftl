<#import "parts/common.ftl" as c>
<@c.page "Update attribute ${attribute.name}">
    <form method="post" action="/attributes/updateAttribute">
        <p>ID</p>
        <input title="Id" type="number" name="id" value="${attribute.id}" readonly>
        <p>Name</p>
        <input title="Name" type="text" name="name" value="${attribute.name}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Изменить атрибут</button>
    </form>
</@c.page>