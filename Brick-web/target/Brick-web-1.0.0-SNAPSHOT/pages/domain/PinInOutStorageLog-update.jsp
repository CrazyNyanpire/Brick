<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	<input type="hidden" id="idID" name="id" /> 
	<input type="hidden" id="versionID" name="version" /> 
		           <div class="form-group">
                    <label class="col-lg-3 control-label">Socket:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="socketIdID"></div>
                           <input name="socketId"  type="hidden"  id="socketIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">领出数量:</label>
	                    <div class="col-lg-9">
                           <input name="qty" style="display:inline; width:94%;" class="form-control"  type="text"  id="qtyID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">备注:</label>
	                    <div class="col-lg-9">
                           <input name="remark" style="display:inline; width:94%;" class="form-control"  type="text"  id="remarkID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/Socket/all.koala',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i in msg)
    	{
    		contents.push({title:msg[i]['partNo'] , value: msg[i]['id']});
    	}
    	selectItems['socketIdID'] = contents;
    });
</script>
</body>
</html>