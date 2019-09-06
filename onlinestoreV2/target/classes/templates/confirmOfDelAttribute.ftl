<#import "parts/common.ftl" as c>
<@c.page "Attribute ${attribute.name}">
    <h1>Подтверждение удаления атрибута: ${attribute.name}</h1>
    <p>С этим атрибутом связаны следующие таблицы:</p>
    <p>1. params</p>
    <p>2. category_param</p>
    <p>Вы точно хотите удалить атрибут со связанными с ним строками?</p>
    <form method="post" action="/attributes/confirmedDeletion/${attribute.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" >Удалить атрибут</button>
    </form>
    <form method="get" action="/attributes/">
        <button type="submit">Отменить удаление</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</@c.page>