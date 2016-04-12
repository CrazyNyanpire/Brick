<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
		           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">状态:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="statusIdID"></div>
                           <input name="statusId"  type="hidden"  id="statusIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 col-sm-3 control-label">状态时间:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="statusTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="statusTimeID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">Dut编号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="dutNumber" style="display:inline; width:94%;" class="form-control"  type="text"  id="dutNumberID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">bin别:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="binNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="binNoID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status4 status5 status9 status7">
                    <label class="col-lg-3 col-sm-3 control-label">机台型号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="platformID"></div>
                           <input name="platform" id="platformID_" type="hidden" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5 status9 status7">
                    <label class="col-lg-3 col-sm-3 control-label">机台编号:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="equipNo" style="display:inline;"></div>
                           <input name="platforms" style="display:inline; width:94%;" class="form-control"  type="text"  id="platformsID" dataType=""/>
                           <input name="nowPlatformId"  type="hidden"  id="nowPlatformIdID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 col-sm-3 control-label">嫁动机台:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="platformNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="platformNoID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status9 status7">
                    <label class="col-lg-3 col-sm-3 control-label">产品型号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="productModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productModelID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 col-sm-3 control-label">产品批次:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="productLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="productLotID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 col-sm-3 control-label">产品当前型号:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="productNowModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productNowModelID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
<!-- 				    <div class="form-group none status7">
                    <label class="col-lg-3 col-sm-3 control-label">领用人:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="probeCardApplyPersonID"></div>
	                    <input name="probeCardApplyPerson"   type="hidden"  id="probeCardApplyPersonID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div> -->
		           <div class="form-group none">
                    <label class="col-lg-3 col-sm-3 control-label">客户名称:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="customerName" style="display:inline; width:94%;" class="form-control"  type="text"  id="customerNameID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status2 status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">接触次数:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="touchTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="touchTimeID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
				    <div class="form-group none status1">
                    <label class="col-lg-3 col-sm-3 control-label">归还人:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="returnPersonID"></div>
	                    <input name="returnPerson"   type="hidden"  id="returnPersonID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status1">
                    <label class="col-lg-3 col-sm-3 control-label">归还水平:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="returnLevelID"></div>
                           <input name="returnLevel" type="hidden"  id="returnLevelID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status1 status4 status5 status6">
                    <label class="col-lg-3 col-sm-3 control-label">针位水平:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="needlePositionLevelID"></div>
                           <input name="needlePositionLevel"  type="hidden"  id="needlePositionLevelID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status1 status6">
                    <label class="col-lg-3 col-sm-3 control-label">外观水平:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="appearanceLevelID"></div>
                           <input name="appearanceLevel"  type="hidden"  id="appearanceLevelID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">X,Y针位:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="xyNeedlePosition" style="display:inline; width:94%;" class="form-control"  type="text"  id="xyNeedlePositionID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 col-sm-3 control-label">针尖最大直径:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="tipMaximumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipMaximumDiameterID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 col-sm-3 control-label">针尖最小直径:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="tipMinimumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipMinimumDiameterID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 col-sm-3 control-label">针尖最长长度:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="tipLongest" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipLongestID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 col-sm-3 control-label">针尖最短长度:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="tipShortest" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipShortestID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">维修人员:</label>
	                    <div class="col-lg-9 col-sm-9">
	                    <div class="btn-group select" id="maintenancePersonID"></div>
	                    <input name="maintenancePerson"   type="hidden"  id="maintenancePersonID_" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">维修项目:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="maintenanceItems" style="display:none; width:94%;" class="form-control"  type="text"  id="maintenanceItemsID" dataType=""/>
                           <span>磨针:</span><input class='maintenanceCheckbox' name="磨针" type='checkbox'><span>清针:</span><input class='maintenanceCheckbox' name="清针" type='checkbox'><span>清洗:</span><input class='maintenanceCheckbox' name="清洗" type='checkbox'><span>烘烤:</span><input class='maintenanceCheckbox' name="烘烤" type='checkbox'><span>手动调整:</span><input class='maintenanceCheckbox' name="手动调整" type='checkbox'><span> 调针机调整:</span><input class='maintenanceCheckbox' name="调针机调整" type='checkbox'><span> 蚀刻:</span><input class='maintenanceCheckbox' name="蚀刻" type='checkbox'>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group none status2 status3 status4 status5 status7 status8 status10">
                    <label class="col-lg-3 col-sm-3 control-label">备注:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <textarea name="remark" style="display:inline; width:94%;max-width: 94%;" class="form-control"  type="text"  id="remarkID"></textarea>
			    </div>
	</div>
				      <div class="form-group none status4 status5">
                    <label class="col-lg-3 col-sm-3 control-label">操作时间:</label>
	                 <div class="col-lg-9 col-sm-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="optDate" id="optDateID" dataType=""/>
                        <span class="required">*</span>
                     </div>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 col-sm-3 control-label">操作人:</label>
	                    <div class="col-lg-9 col-sm-9">
                           <input name="optUser" style="display:inline; width:94%;" class="form-control"  type="text" readonly id="optUserID" dataType=""/>
                           <span class="required">*</span>
			    </div>
	</div>
	</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'Pass' , value:'Pass'});
    contents.push({title:'Fail' , value:'Fail'});
    selectItems['returnLevelID'] = contents;
    selectItems['needlePositionLevelID'] = contents;
    selectItems['appearanceLevelID'] = contents;
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
    var contents = [{title:'请选择', value: ''}];
    $.ajax({
    	async:false,
    	url: '${pageContext.request.contextPath}/OAUser/findByCondition.koala?deptIds=76,77',
    	type: 'POST',
    	dataType: 'json',
    })
    .done(function(msg) {
    	for (var i=0;i<msg['data'].length;i++)
    	{
    		contents.push({title:msg['data'][i]['name'] , value: msg['data'][i]['accounts']+"|"+msg['data'][i]['name']});
    	}
    	selectItems['maintenancePersonID'] = contents;
    	selectItems['returnPersonID'] = contents;
    	selectItems['probeCardApplyPersonID'] = contents;
    });
</script>
</body>
</html>