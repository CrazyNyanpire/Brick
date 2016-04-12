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
                    <label class="col-lg-3 control-label">型号:</label>
	                    <div class="col-lg-9">
                           <input name="model" style="display:inline; width:94%;" class="form-control"  type="text"  id="modelID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">已使用数量:</label>
	                    <div class="col-lg-9">
                           <input name="useQty" style="display:inline; width:94%;" class="form-control"  type="text"  id="useQtyID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">总数量:</label>
	                    <div class="col-lg-9">
                           <input name="totalQty" style="display:inline; width:94%;" class="form-control"  type="text"  id="totalQtyID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">剩余数量:</label>
	                    <div class="col-lg-9">
                           <input name="balanceQty" style="display:inline; width:94%;" class="form-control"  type="text"  id="balanceQtyID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
</script>
</body>
</html>