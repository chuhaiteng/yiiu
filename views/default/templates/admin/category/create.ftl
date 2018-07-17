<#include "../layout/layout.ftl">
<@html page_title="模块新增" page_tab="category">
  <section class="content-header">
    <h1>
      模块
      <small>新增</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
      <li><a href="/admin/topic/list">模块</a></li>
      <li class="active">新增</li>
    </ol>
  </section>
  <section class="content">
    <div class="box box-info">
      <!-- /.box-header -->
      <div class="box-body">
        <form id="form">
          <div class="form-group">
            <label>模块名称</label>
            <input type="text" id="catename" value="" class="form-control"/>
          </div>
          <button type="submit" id="btn" class="btn btn-sm btn-primary">提交</button>
        </form>
      </div>
    </div>
  </section>
<script>
  $(function() {
    $("#form").submit(function() {
      var catename = $("#catename").val();
      if(!catename) {
        alert("请输入模块内容");
      } else {
        $.ajax({
          url: '/admin/category/create',
          type: 'post',
          async: false,
          cache: false,
          dataType: 'json',
          data: {
            catename: catename
          },
          success: function(data){
            if(data.code === 200) {
              window.location.href = "/admin/category/list";
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