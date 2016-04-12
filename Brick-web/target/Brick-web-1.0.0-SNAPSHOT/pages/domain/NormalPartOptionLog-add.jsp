<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal" name="upload"  enctype="multipart/form-data"  method="post" target="hiddenIframename" action="">
	
		           <div class="form-group">
                    <label class="col-lg-3 control-label">目前状态:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="statusID"></div>
                           <input name="status"  type="hidden"  id="statusID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">备注:</label>
	                    <div class="col-lg-9">
                           <textarea name="remark" style="display:inline; width:94%;" class="form-control"  type="text"  id="remarkID" /></textarea>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">异常单:</label>
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
    contents.push({title:'使用中' , value: '使用中'});
    contents.push({title:'在库正常' , value: '在库正常'});
    contents.push({title:'暂借' , value: '暂借'});
    contents.push({title:'待维修' , value: '待维修'});
    contents.push({title:'送修' , value: '送修'});
    selectItems['statusID'] = contents;
</script>
</body>
</html>