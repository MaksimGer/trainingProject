<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page "Products from ${category.name}">
    <div>${product.name} </div>
    <div>Категороия: ${category.name}</div>
    <table>
        <tr>
            <#list params as param>
                <th>${param.attribute.name}</th>
            </#list>
        </tr>
        <tr>
            <#list params as param>
                <td>${param.value}</td>
            </#list>
        </tr>
    </table>
    <a href="/categories/category/${category.id}">${category.name} </a>
</@c.page>