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
                    <label class="col-lg-3 col-sm-3 control-label">申请人:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="proposer" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="proposerID"/>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">部门:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="department" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="departmentID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">类型:</label>
	                    <div class="col-lg-9 col-sm-9">
	                       <input name="" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="typeID" />
			    </div>
	</div>	
			  <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">编号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="" type="text" style="display:inline; width:94%;" readonly class="form-control" id="platformNameID"/>
			    </div>
	</div>
			<div class="form-group platformEquipBanner" style="display:none">
                    <label class="col-lg-3 col-sm-3 control-label">平台设备:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="platformEquipId" type="hidden"  id="platformEquipIdID"/>
                           <div class="platformEquipRoom" style="display:inline"></div>
			    </div>
			</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">预计开始时间:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="estimatedStartTimeID"/>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">预计结束时间:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="estimatedEndTimeID"/>
			    </div>
	</div>
<!-- 		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">借用单位:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="companyID"/>
			    </div>
	</div> -->
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">备注:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <textarea name="" style="display:inline; width:94%;max-width: 94%;"  class="form-control"  type="text"  id="remarkID" ></textarea>
			    </div>
	</div>
				  <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">审批人:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="approver" style="display:inline; width:94%;" class="form-control" readonly type="text"  id="approverID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">状态:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <div class="btn-group select" id="stateID"></div>
	                       <input type="hidden" id="stateID_"  name="state" dataType="Require"/>
	                       <span class="required">*</span>
			    </div>
	</div>
</form>
<script type="text/javascript">
   var selectItems = {};
   var contents = [{title:'请选择', value: ''}];
   contents.push({title:'同意' , value:'同意'});
   contents.push({title:'不同意' , value:'不同意'});
   selectItems['stateID'] = contents;
</script>
</body>
</html>