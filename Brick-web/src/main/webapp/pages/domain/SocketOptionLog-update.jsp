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
                    <label class="col-lg-3 control-label">状态:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="statusIdID"></div>
                           <input name="statusId"  type="hidden"  id="statusIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">当前批次:</label>
	                    <div class="col-lg-9">
                           <input name="nowLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="nowLotID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">当前站点:</label>
	                    <div class="col-lg-9">
                           <input name="nowStation" style="display:inline; width:94%;" class="form-control"  type="text"  id="nowStationID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">产品型号:</label>
	                    <div class="col-lg-9">
                           <input name="productModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productModelID" />
			    </div>
	</div>
		           <div class="form-group none status5">
                    <label class="col-lg-3 control-label">开始时间:</label>
                     <div class="col-lg-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="startTime" id="startTimeID" >
                     </div>
			    </div>
	</div>
				      <div class="form-group none status5">
                    <label class="col-lg-3 control-label">结束时间:</label>
	                 <div class="col-lg-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="endTime" id="endTimeID" >
                     </div>
			    </div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">持续时间:</label>
	                    <div class="col-lg-9">
                           <input name="duration" style="display:inline; width:94%;" class="form-control"  type="text"  id="durationID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">结束人员:</label>
	                    <div class="col-lg-9">
                           <input name="endOptUser" style="display:inline; width:94%;" class="form-control"  type="text"  id="endOptUserID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">理论时间:</label>
	                    <div class="col-lg-9">
                           <input name="theoryTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="theoryTimeID" />
			    </div>
	</div>
		           <div class="form-group none status6">
                    <label class="col-lg-3 control-label">TouchTimes:</label>
	                    <div class="col-lg-9">
                           <input name="touchTimes" style="display:inline; width:94%;" class="form-control"  type="text"  id="touchTimesID" />
			    </div>
	</div>
			           <div class="form-group none status6 status4">
                    <label class="col-lg-3 control-label">外观水平:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="appearanceLevelID"></div>
                           <input name="appearanceLevel"  type="hidden"  id="appearanceLevelID_" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">操作备注:</label>
	                    <div class="col-lg-9">
                           <textarea name="optRemark" style="display:inline; width:94%;" class="form-control"  type="text"  id="optRemarkID" ></textarea>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">生产批次:</label>
	                    <div class="col-lg-9">
                           <input name="productLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="productLotID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">设备编号:</label>
	                    <div class="col-lg-9">
                           <input name="equipmentNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="equipmentNoID" />
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
                                                                                                                                                    </script>
</body>
</html>