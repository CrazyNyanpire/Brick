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
                    <label class="col-lg-3 control-label">createTimestamp:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="createTimestamp" id="createTimestampID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">lastModifyTimestamp:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="lastModifyTimestamp" id="lastModifyTimestampID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">createEmployNo:</label>
	                    <div class="col-lg-9">
                           <input name="createEmployNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="createEmployNoID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">lastModifyEmployNo:</label>
	                    <div class="col-lg-9">
                           <input name="lastModifyEmployNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="lastModifyEmployNoID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">subject:</label>
	                    <div class="col-lg-9">
                           <input name="subject" style="display:inline; width:94%;" class="form-control"  type="text"  id="subjectID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">content:</label>
	                    <div class="col-lg-9">
                           <input name="content" style="display:inline; width:94%;" class="form-control"  type="text"  id="contentID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">from:</label>
	                    <div class="col-lg-9">
                           <input name="from" style="display:inline; width:94%;" class="form-control"  type="text"  id="fromID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">to:</label>
	                    <div class="col-lg-9">
                           <input name="to" style="display:inline; width:94%;" class="form-control"  type="text"  id="toID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">cc:</label>
	                    <div class="col-lg-9">
                           <input name="cc" style="display:inline; width:94%;" class="form-control"  type="text"  id="ccID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">bcc:</label>
	                    <div class="col-lg-9">
                           <input name="bcc" style="display:inline; width:94%;" class="form-control"  type="text"  id="bccID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                    </script>
</body>
</html>