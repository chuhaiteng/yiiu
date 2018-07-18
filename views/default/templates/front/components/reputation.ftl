<#macro reputation topic title p=1 limit=10 >
  <div class="panel panel-default">
    <div class="panel-heading">相关问题  <#--<a href="/top100">TOP 100 >></a>--></div>
    <@reputation_tag p=p limit=limit topic = topic title=title>
      <table class="table">
        <tbody>
        <#list page.getContent() as content>
            <#--<#if "${content.id}" != topic>-->
                <tr>
                  <td><a href="/topic/${content.id}">${content.title}</a></td>
                </tr>
            <#--</#if>-->
        </#list>
        </tbody>
      </table>
    </@reputation_tag>
  </div>
</#macro>