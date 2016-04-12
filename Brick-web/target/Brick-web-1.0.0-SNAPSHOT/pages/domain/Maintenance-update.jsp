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
                    <label class="col-lg-3 col-sm-3 control-label">平台编号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="platformIdID"></div>
                           <input name="platformId" type="hidden"  id="platformIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>	
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">处理类型:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="optType" style="display:inline; width:94%;" class="form-control"  type="text"  id="optTypeID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">处理人:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="optUserID"></div>
	                    <input name="optUser"   type="hidden"  id="optUserID_" dataType="Require"/>
                        <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">处理日期:</label>
	                 <div class="col-lg-9 col-sm-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="optDate" id="optDateID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">备注:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <textarea name="remark" style="display:inline; width:94%;max-width: 94%;" class="form-control"  type="text"  id="remarkID" ></textarea>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">故障描述单:</label>
	                    <div class="col-lg-9 col-sm-9">
                            <div id="filelist"></div>
							<input name="file" type="file" style="display: inline;" id="tablefile" onchange="if($(this).val()!=''){ajaxsubmit('');}"/>	
							<span class="required">*</span>
							<iframe style="display:none;"name="hiddenIframename">
							</iframe>
						</div>    
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
	var contents = [{title:'请选择', value: ''}];
	$.ajax({
		async:false,
		url: '${pageContext.request.contextPath}/Platform/all.koala',
		type: 'POST',
		dataType: 'json',
	})
	.done(function(msg) {
		for (var i in msg['data'])
		{
			contents.push({title:msg['data'][i]['platformNo'] , value: msg['data'][i]['id']});
		}
		selectItems['platformIdID'] = contents;
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
    	selectItems['optUserID'] = contents;
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
    	selectItems['optUserID'] = contents;
    });
</script>
</body>
</html>