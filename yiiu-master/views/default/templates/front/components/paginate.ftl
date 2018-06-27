<#macro paginate currentPage totalPage actionUrl urlParas="" showdivide="yes">
  <#if (totalPage <= 0) || (currentPage > totalPage)><#return></#if>
  <#local startPage = currentPage - 2>
  <#if (startPage < 1)><#local startPage = 1></#if>

  <#local endPage = currentPage + 2>
  <#if (endPage > totalPage)><#local endPage = totalPage></#if>
  <#if totalPage &gt; 1 && showdivide == "yes">
  <div class="divide mar-top-5"></div>
  </#if>
<ul class="pagination pagination-sm <#if totalPage == 1>hidden-xs hidden-sm hidden-md hidden-lg</#if>">
  <#if (currentPage <= 3)>
    <#local startPage = 1>
  </#if>
  <#if ((totalPage - currentPage) < 2)>
    <#local endPage = totalPage>
  </#if>

  <#if (currentPage == 1)>
    <!--<li>上页</li>-->
  <#else>
    <li><a href="${actionUrl}?p=1${urlParas!}">&lt;&lt;</a></li>
    <li><a href="${actionUrl}?p=#{currentPage - 1}${urlParas!}">&lt;</a></li>
  </#if>

  <#list startPage..endPage as i>
    <#if currentPage == i>
      <li class="active"><a class="disabled">#{i}</a></li>
    <#else>
      <li><a href="${actionUrl}?p=#{i}${urlParas!}">#{i}</a></li>
    </#if>
  </#list>

  <#if (currentPage == totalPage)>
    <!--<li>下页</li>-->
  <#else>
    <li><a href="${actionUrl}?p=#{currentPage + 1}${urlParas!}">&gt;</a></li>
    <li><a href="${actionUrl}?p=#{totalPage}${urlParas!}">&gt;&gt;</a></li>
  </#if>
</ul>
</#macro>