<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page "Categories">
    <table>
        <tr>
            <th>Список категорий: </th>
            <#if isAdmin>
                <th>Изменить </th>
                <th>Удалить </th>
            </#if>
        </tr>
        <#list categories as category>
            <tr>
                <td><a href="/categories/category/${category.id}">${category.name}</a></td>
                <#if isAdmin>
                    <td><a href="/categories/update/${category.id}">update</a></td>
                    <td><a href="/categories/delete/${category.id}">delete</a></td>
                </#if>
            </tr>
            <#else>
            Нет категорий
        </#list>
    </table>
    <#if isAdmin>
        <a href="/categories/addCategory">Добавить категорию </a>
    </#if>
    <a href="/">На главную </a>
</@c.page>