<#import "parts/common.ftl" as c>
<@c.page "Create product">
    Добавление продукта в ${category.name} категорию:
    <form method="post" action="/products/addProduct/${category.id}">
        <p>Имя продукта: </p>
        <input title="Name" type="text" name="productName">
        <#list params as param>
            <p>${param.attribute.name}</p>
            <input title="value" type="text" name="value[${param.attribute.id}]">
        </#list>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить продукт</button>
    </form>
</@c.page>