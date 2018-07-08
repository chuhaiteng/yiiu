<#include "layout/layout.ftl">
<@html page_title="首页 - ${site.name!}" page_tab="index">
<div class="row">
  <div class="col-md-9" style="width:100%">
  <#--tab info-->
    <div class="panel panel-default">
      <div class="panel-heading">

        <ul class="nav nav-pills">
            <li <#if !category?? || category == ''>class="active"</#if>><a href="/">全部</a></li>
        <#list categorylist as categorylist>
            <#--${category!}   ${categorylist.id }-->
            <#--&lt;#&ndash;${category.id}--${category.name}&ndash;&gt;-->
            <li <#if category??  && category?eval==categorylist.id?eval >class="active"</#if>><a href="/?category=${categorylist.id}">${categorylist.name}</a></li>
            <#--<#if category == ''>class="active"</#if>-->

        </#list>
          <#--<li <#if !tab?? || tab == ''>class="active"</#if>><a href="/">桌面运维</a></li>
          <li <#if tab?? && tab == 'good'>class="active"</#if>><a href="/?tab=good">oa运维</a></li>
          <li <#if tab?? && tab == 'newest'>class="active"</#if>><a href="/?tab=newest">卓越运维</a></li>
          <li <#if tab?? && tab == 'noanswer'>class="active"</#if>><a href="/?tab=noanswer">热点问题</a></li>-->
        </ul>
      </div>

    <#--topic list-->
      <@topics_category p=p category=category>
        <div class="panel-body paginate-bot">
          <#include "./components/topics.ftl"/>
          <@topics topics=page.content/>
          <#include "./components/paginate.ftl"/>
          <@paginate currentPage=(page.getNumber() + 1) totalPage=page.getTotalPages() actionUrl="/" urlParas="&category=${category!}"/>
        </div>
      </@topics_category>
    </div>
  </div>
 <#-- <div class="col-md-3 hidden-sm hidden-xs">
    <#if user??>
      <#include "./components/user_info.ftl"/>
      <@user_info/>
    <#else>
      <#include "./components/welcome.ftl"/>
      <@welcome/>
    </#if>
    <#include "./components/reputation.ftl"/>
    <@reputation p=1 limit=10/>
  </div>-->
</div>
</@html>
