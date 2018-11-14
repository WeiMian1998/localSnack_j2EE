<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"></meta>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
    <title>学生信息</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"></link>
    <link rel="stylesheet" type="text/css" href="/css/style.css"></link>
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"></link>
</head>
<body>
<!-- 内容 -->
<div class="container">
	<br></br>
	<div class="panel panel-warning">
      	<div class="panel-heading"><span class="text-size"><i class="icon-link"></i> 学生所有信息</span></div>
      	<div class="panel-body">
			<table class="table table-bordered">
			   <thead>
			     <tr>
			        <th>ID</th>
				    <th>姓名</th>
				    <th>年龄</th>
				    <th>地址</th>
			     </tr>
			   </thead>
			   <tbody>
			   <#list list as data>
			     <tr>
				    <td>${data.id}</td>
				    <td>${data.name}</td>
				    <td>${data.age}</td>
				    <td>${data.address}</td>
				  </tr>
			   </#list>
			   </tbody>
			 </table>
      	</div>
	</div>
</div>
<!-- 内容 -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="@{js/jquery-1.11.2.min.js}"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/popover.js"></script>
</body>
</html>
