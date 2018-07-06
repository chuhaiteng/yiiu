<#include "../layout/layout.ftl">
<@html page_title="话题新增" page_tab="topic">
  <section class="content-header">
    <h1>
      话题
      <small>新增</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
      <li><a href="/admin/topic/list">话题</a></li>
      <li class="active">新增</li>
    </ol>
  </section>
  <section class="content">
    <div class="box box-info">
      <div class="box-header with-border">
        <h3 class="box-title">话题新增</h3>
      </div>
      <!-- /.box-header -->
      <div class="box-body">
        <form id="form">
          <div class="form-group">
            <label>模块选择</label>
            <select id="module">
                <#list moduleAll as m>
                    <option value="${m.id}">${m.name}</option>
                </#list>
            </select>
          </div>
          <div class="form-group">
            <label>标题</label>
            <input type="text" id="title" value="" class="form-control"/>
          </div>
          <div class="form-group">
            <label>内容</label>
            <#include "../../front/components/editor.ftl"/>
            <@editor height="400px" content=""/>
          </div>
          <div class="form-group">
              <label for="tag">标签</label>
              <#include "../../front/components/tagsinput.ftl"/>
              <@tagsinput/>
          </div>
          <button type="submit" id="btn" class="btn btn-sm btn-primary">提交</button>
        </form>
      </div>
    </div>
  </section>
<script>
  $(function() {
    $("#form").submit(function() {
      var title = $("#title").val();
      var contentHtml = editor.txt.html();
      var contentText = editor.txt.text();
      var tag = $("#tag").val();
      var module = $("#module").val();
      if(!title) {
        alert("请输入标题");
      } else if(!contentText) {
        alert("请输入内容");
      } else if(!tag) {
        alert("请输入标签");
      }  else if(!module) {
        alert("请选择对应的模块");
      } else {
        $.ajax({
          url: '/admin/topic/create',
          type: 'post',
          async: false,
          cache: false,
          dataType: 'json',
          data: {
            title: title,
            content: contentHtml,
            tag: tag,
            module: module
          },
          success: function(data){
            if(data.code === 200) {
              window.location.href = "/admin/topic/list";
            } else {
              toast(data.description);
            }
          }
        })
        return false;
      }
    });
  })
</script>
</@html>