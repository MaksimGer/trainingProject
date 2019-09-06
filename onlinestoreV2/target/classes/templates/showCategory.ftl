<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page "Category ${category.name}">
    <h4>Продукты в категории ${category.name}</h4>
    <table>
        <tr>
            <th>Продукт</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Купить</th>
        </tr>
        <#list productInfoList as productInfo>
        <tr>
            <td><a href="/products/product/${productInfo.product.id}">${productInfo.product.name}</a></td>
            <td>${productInfo.price}</td>
            <td>${productInfo.count}</td>
            <td><a href="/order/${productInfo.product.id}">Buy</a></td>
            <#if isAdmin>
                <td><a href="/products/update/${productInfo.product.id}">Изменить</a></td>
                <td><a href="/products/delete/${productInfo.product.id}">Удалить</a></td>
            </#if>
        </tr>
        </#list>
    </table>
    <a href="/categories">Все категории</a>
    <#if isAdmin>
        <a href="/products/addProduct/${category.id}">Добавить продукт</a>
    </#if>
</@c.page>