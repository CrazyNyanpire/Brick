<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal" name="upload"  enctype="multipart/form-data"  method="post" target="hiddenIframename" action="">
		           <div class="form-group">
                    <label class="col-lg-2 control-label">设备状态:</label>
	                    <div class="col-lg-10">
	                    <div class="btn-group select" id="statusIdID"></div>
                           <input name="statusId"  type="hidden"  id="statusIdID_" dataType="Require"/>
                            <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 control-label">子状态:</label>
	                    <div class="col-lg-10">
	                    <div class="btn-group select" id="subStatusIdID"></div>
                           <input name="subStatusId"  type="hidden"  id="subStatusIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
		                 <label class="col-lg-2 control-label">操作备注:</label>
		                  <div class="col-lg-10">
		                        <textarea name="optRemark" style="display:inline; width:94%;" class="form-control"  type="text"  id="optRemarkID"></textarea>
		    </div>
	</div>
				           <div class="form-group part_PM">
                    <label class="col-lg-2 col-sm-2 control-label">保养周期:</label>
	                    <div class="col-lg-10 col-sm-10">
	                       <input name="pmType"   type="hidden"  id="pmTypeID"/>
                           <input name="repairCycleMonth" type="checkBox"  id="repairCycle_monthID" /><span>月</span>
                           <input name="repairCycleSeason" type="checkBox"  id="repairCycle_seasonID" /><span>季</span>
                           <input name="repairCycleYear" type="checkBox"  id="repairCycle_yearID" /><span>年</span>
			    </div>  
	</div>
			           <div class="form-group part_PM">
                    <label class="col-lg-2 col-sm-2 control-label">PM单:</label>
	                    <div class="col-lg-10 col-sm-10">
                            <div id="filelist"></div>
							<input name="file" type="file" style="display: inline;" id="tablefile" onchange="if($(this).val()!=''){ajaxsubmit('');}"/>	
							<iframe style="display:none;"name="hiddenIframename">
							</iframe>
						</div>    
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
</script>
</body>
</html>