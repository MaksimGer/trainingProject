<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page "Spring Security Example">
<div class="mb-1">Добавить нового пользователя </div>
    <@l.login "/registration" true/>
</@c.page>