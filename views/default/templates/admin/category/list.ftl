<#include "../layout/layout.ftl">
<@html page_title="模块列表" page_tab="category">
  <section class="content-header">
    <h1>
      模块
      <small>列表</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
      <li><a href="/admin/topic/list">模块</a></li>
      <li class="active">列表</li>
    </ol>
  </section>
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title">模块列表</h3>
            <a href="/admin/category/create" class="btn btn-sm btn-warning">模块新增</a>
      </div>
      <!-- /.box-header -->
      <div class="box-body">
        <table class="table table-bordered">
          <thead>
          <tr>
            <th>#</th>
            <th>模块名称</th>
            <th>时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <#list page.content as map>
            <tr>
              <td>${map.category.id}</td>
              <td>${map.category.name}</td>
              <td>${map.category.inTime!}</td>
              <td>
                  <a href="/admin/category/edit?id=${map.category.id}" class="btn btn-sm btn-warning">编辑</a>
                  <button onclick="actionBtn('${map.category.id}', 'delete')" class="btn btn-sm btn-danger">删除</button>
              </td>
            </tr>
          </#list>
          </tbody>
        </table>
      </div>
      <#if page.totalPages &gt; 1>
        <div class="box-footer clearfix">
          <#include "../layout/paginate.ftl">
          <@paginate currentPage=(page.getNumber() + 1) totalPage=page.getTotalPages() actionUrl="/admin/category/list" urlParas=""/>
        </div>
      </#if>
    </div>
  </section>
<script>
  function actionBtn(id, action) {
    var msg, url;
    if(action === 'delete') {
      url = '/admin/category/delete';
      msg = '确定要删除这条模块吗？';
    }
    if (confirm(msg)) {
      $.ajax({
        url: url,
        type: 'get',
        async: false,
        cache: false,
        dataType: 'json',
        data: {
          id: id
        },
        success: function(data) {
          if (data.code === 200) {
            window.location.reload();
          } else {
            toast(data.description);
          }
        }
      })
    }
  }
</script>
</@html>