<#import "parts/common.ftl" as c>
<@c.page "Update product">
    <form method="post" action="/products/updateProduct">
        <p>Изменить продукт ${product.name}: </p>

        <table>
            <tr>
                <td>ID</td>
                <td><input title="Id" type="number" name="productId" value="${product.id}" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input title="Name" type="text" name="productName" value="${product.name}"></td>
            </tr>
            <#list params as param>
                <tr>
                    <td>${param.attribute.name}</td>
                    <td><input title="attribute[${param.attribute.id}]" type="text"
                               name="value[${param.attribute.id}]" value="${param.value}"></td>
                </tr>
            </#list>
        </table>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Изменить продукт</button>
    </form>
</@c.page>