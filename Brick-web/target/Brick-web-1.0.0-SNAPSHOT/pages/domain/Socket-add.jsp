<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal" name="upload"  enctype="multipart/form-data"  method="post" target="hiddenIframename" action="">
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">进场时间:</label>
	                 <div class="col-lg-9 col-sm-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="inDate" id="inDateID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group" style="display:none;">
                    <label class="col-lg-3 col-sm-3 control-label">配件名称:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="partName" style="display:inline; width:94%;" class="form-control"  type="text" value="Socket" id="partNameID" />
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">配件类型:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="partType" style="display:inline; width:94%;" class="form-control"  type="text"  id="partTypeID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">配件规格:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="partModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="partModelID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">P/N(S/N):</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="pn" style="display:inline; width:94%;" class="form-control"  type="text"  id="pnID" />
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">PIN Model:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <textarea name="pinModels" style="display:inline; width:94%;" class="form-control"  type="text"  id="pinModelsID" dataType="Require"></textarea>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">供应商:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="supplier" style="display:inline; width:94%;" class="form-control"  type="text"  id="supplierID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">编号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="partNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="partNoID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">归属:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="ownership" style="display:inline; width:94%;" class="form-control"  type="text"  id="ownershipID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">pinQty:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="pinQty" style="display:inline; width:94%;" class="form-control"  type="text"  id="pinQtyID" dataType="Require"/>
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
                    <label class="col-lg-3 col-sm-3 control-label">适用型号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="applicableModels" style="display:inline; width:94%;" class="form-control"  type="text"  id="applicableModelsID" dataType="Require"/>
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
</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                                                                                                                            </script>
</body>
</html>