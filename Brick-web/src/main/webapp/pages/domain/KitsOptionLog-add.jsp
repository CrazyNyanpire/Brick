<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
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
                           <input name="nowLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="nowLotID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">当前站点:</label>
	                    <div class="col-lg-9">
                           <input name="nowStation" style="display:inline; width:94%;" class="form-control"  type="text"  id="nowStationID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">产品型号:</label>
	                    <div class="col-lg-9">
                           <input name="productModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productModelID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status5">
                    <label class="col-lg-3 control-label">是否换针:</label>
                     <div class="col-lg-9">
                     <div class="btn-group select" id="isChangePinID"></div>
                        <input name="isChangePin"  type="hidden"  id="isChangePinID_" dataType=""/>
                        <span class="required">*</span>
                     </div>
			    </div>
	</div>
		           <div class="form-group none status5">
                    <label class="col-lg-3 control-label">开始时间:</label>
                     <div class="col-lg-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="startTime" id="startTimeID" dataType=""/>
                        <span class="required">*</span>
                     </div>
			    </div>
	</div>
				      <div class="form-group none status5">
                    <label class="col-lg-3 control-label">结束时间:</label>
	                 <div class="col-lg-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="endTime" id="endTimeID" dataType=""/>
                        <span class="required">*</span>
                     </div>
			    </div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">接触次数:</label>
	                    <div class="col-lg-9">
                           <input name="touchTimes" style="display:inline; width:94%;" class="form-control"  type="text"  id="touchTimesID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status6 status4">
                    <label class="col-lg-3 control-label">外观水平:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="appearanceLevelID"></div>
                           <input name="appearanceLevel"  type="hidden"  id="appearanceLevelID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
				           <div class="form-group none status7">
                    <label class="col-lg-3 col-sm-3 control-label">机台型号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="platformID"></div>
                           <input name="platform" id="platformID_" type="hidden" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status7">
                    <label class="col-lg-3 col-sm-3 control-label">机台编号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="equipNo" style="display:inline;"></div>
                           <input name="equipmentList" style="display:inline; width:94%;" class="form-control"  type="text"  id="equipmentListID" dataType=""/>
                           <input name="equipmentListId"  type="hidden"  id="equipmentListIdID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status7">
                    <label class="col-lg-3 control-label">适用型号:</label>
	                    <div class="col-lg-9">
                           <textarea name="applicableModels" style="display:inline; width:94%;" class="form-control"  type="text"  id="applicableModelsID"></textarea>
			    </div>
	</div>
				           <div class="form-group none status4">
                    <label class="col-lg-3 control-label">领出机台:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="nowPlatformIdID"></div>
                           <input name="nowPlatformId"  type="hidden"  id="nowPlatformIdID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
<!-- 				           <div class="form-group none status6 status4">
                    <label class="col-lg-3 control-label">领出site:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="platformSiteID"></div>
                           <input name="platformSite"  type="hidden"  id="platformSiteID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div> -->
		           <div class="form-group">
                    <label class="col-lg-3 control-label">操作备注:</label>
	                    <div class="col-lg-9">
                           <textarea name="optRemark" style="display:inline; width:94%;" class="form-control"  type="text"  id="optRemarkID"></textarea>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">生产批次:</label>
	                    <div class="col-lg-9">
                           <input name="productLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="productLotID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">设备编号:</label>
	                    <div class="col-lg-9">
                           <input name="equipmentNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="equipmentNoID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'Pass' , value:'Pass'});
    contents.push({title:'Fail' , value:'Fail'});
    selectItems['appearanceLevelID'] = contents;
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'是' , value:'true'});
    contents.push({title:'否' , value:'false'});
    selectItems['isChangePinID'] = contents;  
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/Platform/pageJson.koala?pagesize=100&page=0&platformCategory=FT',
    	type: 'GET',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data'].length;i++)
    	{
    		contents.push({title:msg['data'][i]['platformNo'] , value: msg['data'][i]['id']});
    	}
    	selectItems['nowPlatformIdID'] = contents;
    });
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'site0' , value:'0'});
    contents.push({title:'site1' , value:'1'});
    contents.push({title:'site2' , value:'2'});
    contents.push({title:'site3' , value:'3'});
    selectItems['platformSiteID'] = contents; 
    var contents = [{title:'请选择', value: ''}];
	$.ajax({
		async:false,
		url: '${pageContext.request.contextPath}/Category/get/7.koala',
		type: 'POST',
		dataType: 'json',
	})
	.done(function(msg) {
		for (var i in msg['data']['categoryChildren'])
		{
			contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
		}
		selectItems['platformID'] = contents;
	});
</script>
</body>
</html>