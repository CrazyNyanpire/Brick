<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
		           <div class="form-group">
                    <label class="col-lg-3 control-label">进场时间:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="inDate" id="inDateID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">型号:</label>
	                    <div class="col-lg-9">
                           <input name="model" style="display:inline; width:94%;" class="form-control"  type="text"  id="modelID" dataType="Require"/>
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
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
</script>
</body>
</html>