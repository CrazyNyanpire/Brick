<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
			       <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">是否同意:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="isPassID"></div>
                           <input name="isPass"  type="hidden"  id="isPassID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
var selectItems = {};
var contents = [{title:'请选择', value: ''}];
contents.push({title:'是' , value: '1'});
contents.push({title:'否' , value: '0'});
selectItems['isPassID'] = contents;
</script>
</body>
</html>