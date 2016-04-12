<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
				  <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">平台编号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="testerIdID"></div>
                           <input name="testerId" type="hidden"  id="testerIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
	var contents = [{title:'请选择', value: ''}];
	$.ajax({
		async:false,
		url: '${pageContext.request.contextPath}/Equipment/findTesterEquipments.koala',
		type: 'POST',
		dataType: 'json',
	})
	.done(function(msg) {
		for (var i in msg['data'])
		{
			contents.push({title:msg['data'][i]['equipmentNo'] , value: msg['data'][i]['id']});
		}
		selectItems['testerIdID'] = contents;
	});
</script>
</body>
</html>