<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head  lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div class="container-fluid">
  <div class="row">
  		<div class="welcomEquip col-sm-12 col-md-12">
  			<div class="row">
  			</div>
  		</div>
  </div>
</div>
</body>
<!-- <script>
var params={"pagesize":"1000","page":"0"};
$(function() {
	$.ajax({
		type : "POST",
		url : "/ChangeStatus/pageJson.koala",
		data : params,
		dataType : 'json',
		success : function(result){
			debugger;
			data=result['data'];
			for(var a in data)
			{
				$(".welcomEquip .row").append('<div class="col-xs-2 col-sm-2 col-md-2" style="margin-bottom:5px;padding:0 5px" id="'+data[a]['id']+'" type="'+data[a]['type']+'">'+
/* 						'<div class="thumbnail">'+ */
						'<div class="colorRoom" style="border: 1px solid #ccc;background-color:'+statusColor(data[a]['status'])+'">'+
/* 						'<img src="'+data[a]['categoryImageUrl']+'" alt="..." style="width:69%;">'+ */
						'<div style="text-align:left;margin-left: 10px;">'+
						'<h5><strong>'+data[a]['no']+'</strong></h5>'+
						'<h6><i>-'+data[a]['equipmentNo']+'</i></h6>'+
						'<p>类型:'+data[a]['category']+'</p>'+
						'<p>状态:'+data[a]['status']+'</p>'+
/* 						'</div>'+ */
						'</div></div></div>');
			}
		}
	});
});
</script> -->
</html>