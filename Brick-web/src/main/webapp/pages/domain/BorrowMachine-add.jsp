<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
			  <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">申请人:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="proposer" style="display:inline; width:94%;" class="form-control"  type="text" readonly id="proposerID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">部门:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="department" style="display:inline; width:94%;" class="form-control"  type="text"  id="departmentID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			      <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">机台类型:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <div class="btn-group select" id="isPlantfromID"></div>
	                       <input type="hidden" id="isPlantfromID_"  name="isPlatform" dataType="Require"/>
	                       <span class="required">*</span>
			    </div>
	</div>	
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">平台类型:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <div class="btn-group select" id="typeID"></div>
	                       <input type="hidden" id="typeID_"  name="type" dataType="Require"/>
	                       <span class="required">*</span>
			    </div>
	</div>	
			  <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">平台编号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="platformIdID"></div>
                           <input name="platformId" type="hidden"  id="platformIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
				  <div class="form-group platformEquipBanner" style="display:none">
                    <label class="col-lg-3 col-sm-3 control-label">平台设备:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="platformEquipId" type="hidden"  id="platformEquipIdID"/>
                           <div class="platformEquipRoom" style="display:inline"></div>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">预计开始时间:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="estimatedStartTime" style="display:inline; width:94%;" class="form-control"  type="datetime-local"  id="estimatedStartTimeID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">预计结束时间:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="estimatedEndTime" style="display:inline; width:94%;" class="form-control"  type="datetime-local"  id="estimatedEndTimeID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
<!-- 		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">借机单号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="borrowNumber" style="display:inline; width:94%;" class="form-control" readonly type="text"  id="borrowNumberID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div> 
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">借用单位:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="company" style="display:inline; width:94%;" class="form-control"  type="text"  id="companyID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>-->
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">备注:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <textarea name="remark" style="display:inline; width:94%;max-width: 94%;" class="form-control"  type="text"  id="remarkID" ></textarea>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
   	var contents = [{title:'请选择', value: ''}];
        contents.push({title:'平台' , value:true});
        contents.push({title:'设备' , value:false});
        selectItems['isPlantfromID'] = contents;
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
		selectItems['proposerID'] = contents;
	});
</script>
</body>
</html>