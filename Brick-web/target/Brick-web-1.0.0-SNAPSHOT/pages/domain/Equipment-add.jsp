<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal" name="upload"  enctype="multipart/form-data"  method="post" target="hiddenIframename" action="">
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">设备编号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="equipmentNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="equipmentNoID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">设备分类:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="equipmentCategoryIdID"></div>
                           <input name="equipmentCategoryId"   type="hidden"  id="equipmentCategoryIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			       <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">设备型号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="categoryIdID"></div>
                           <input name="categoryId"  type="hidden"  id="categoryIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">责任人:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="responsibleID"></div>
                           <input name="responsible"  type="hidden"  id="responsibleID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">代理人:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="agentID"></div>
	                    <input name="agent"   type="hidden"  id="agentID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">PM起始时间:</label>
	                 <div class="col-lg-9 col-sm-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="maintenanceStartDate" id="maintenanceStartDateID" dataType="Require"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">PM周期:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="repairCycleMonth" type="checkBox"  id="repairCycle_monthID" /><span>月</span>
                           <input name="repairCycleSeason" type="checkBox"  id="repairCycle_seasonID" /><span>季</span>
                           <input name="repairCycleYear" type="checkBox"  id="repairCycle_yearID" /><span>年</span>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">设备位置:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="equipmentLocationIdID"></div>
                           <input name="equipmentLocationId"  type="hidden" id="equipmentLocationIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">登记时间:</label>
	                 <div class="col-lg-9 col-sm-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="checkInTime" id="checkInTimeID" dataType="Require"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
				    <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">S/N:</label>
                   	<div class="col-lg-9 col-sm-9">
                           <input name="sn" style="display:inline; width:94%;" class="form-control"  type="text"  id="snID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
					    <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">IP地址:</label>
                   	<div class="col-lg-9 col-sm-9">
                           <input name="ip" style="display:inline; width:94%;" class="form-control"  type="text"  id="ipID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">验收单:</label>
	                    <div class="col-lg-9 col-sm-9">
                            <div id="filelist"></div>
							<input name="file" type="file" style="display: inline;" id="tablefile" onchange="if($(this).val()!=''){ajaxsubmit('');}"/>	
							<span class="required">*</span>
							<iframe style="display:none;"name="hiddenIframename">
							</iframe>
						</div>    
	</div>
				       <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">是否可组合:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="composabilityID"></div>
                           <input name="composability"  type="hidden"  id="composabilityID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
					    <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">自动获取数据:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="isAutoID"></div>
                           <input name="isAuto"  type="hidden"  id="isAutoID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'是' , value: '1'});
    contents.push({title:'否' , value: '0'});
    selectItems['composabilityID'] = contents;
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'是' , value: 'true'});
    contents.push({title:'否' , value: 'false'});
    selectItems['isAutoID'] = contents;
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/Category/get/6.koala',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data']['categoryChildren'].length;i++)
    	{
    		contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
    	}
    	selectItems['equipmentCategoryIdID'] = contents;
    });
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/Category/get/35.koala',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data']['categoryChildren'].length;i++)
    	{
    		contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
    	}
    	selectItems['equipmentLocationIdID'] = contents;
    }); 
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/OAUser/findByCondition.koala?deptId=76',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data'].length;i++)
    	{
    		contents.push({title:msg['data'][i]['name'] , value: msg['data'][i]['accounts']+"|"+msg['data'][i]['name']});
    	}
    	selectItems['responsibleID'] = contents;
    	selectItems['agentID'] = contents;
    });
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/OAUser/findByCondition.koala?deptId=77',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data'].length;i++)
    	{
    		contents.push({title:msg['data'][i]['name'] , value: msg['data'][i]['accounts']+"|"+msg['data'][i]['name']});
    	}
    	selectItems['responsibleID'] = contents;
    	selectItems['agentID'] = contents;
    });
</script>
</body>
</html>