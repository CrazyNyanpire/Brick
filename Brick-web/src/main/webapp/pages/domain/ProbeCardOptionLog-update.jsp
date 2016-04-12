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
                    <label class="col-lg-3 control-label">状态时间:</label>
	                    <div class="col-lg-9">
                           <input name="statusTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="statusTimeID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">Dut编号:</label>
	                    <div class="col-lg-9">
                           <input name="dutNumber" style="display:inline; width:94%;" class="form-control"  type="text"  id="dutNumberID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">bin别:</label>
	                    <div class="col-lg-9">
                           <input name="binNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="binNoID" />
			    </div>
	</div>
			           <div class="form-group none status4 status5 status9">
                    <label class="col-lg-3 control-label">机台型号:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="platformID"></div>
                           <input name="platform" id="platformID_" type="hidden"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group none status4 status5 status9">
                    <label class="col-lg-3 control-label">机台编号:</label>
	                    <div class="col-lg-9">
	                    <div class="equipNo"></div>
                           <input name="platforms" style="display:inline; width:94%;" class="form-control"  type="text"  id="platformsID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">嫁动机台:</label>
	                    <div class="col-lg-9">
                           <input name="platformNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="platformNoID" />
			    </div>
	</div>
		           <div class="form-group none status9">
                    <label class="col-lg-3 control-label">产品型号:</label>
	                    <div class="col-lg-9">
                           <input name="productModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productModelID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">产品批次:</label>
	                    <div class="col-lg-9">
                           <input name="productLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="productLotID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">产品当前型号:</label>
	                    <div class="col-lg-9">
                           <input name="productNowModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productNowModelID" />
			    </div>
	</div>
		           <div class="form-group none status7">
                    <label class="col-lg-3 control-label">领用人:</label>
	                    <div class="col-lg-9">
                           <input name="probeCardApplyPerson" style="display:inline; width:94%;" class="form-control"  type="text"  id="probeCardApplyPersonID" />
			    </div>
	</div>
		           <div class="form-group none">
                    <label class="col-lg-3 control-label">客户名称:</label>
	                    <div class="col-lg-9">
                           <input name="customerName" style="display:inline; width:94%;" class="form-control"  type="text"  id="customerNameID" />
			    </div>
	</div>
		           <div class="form-group none status2 status4 status5">
                    <label class="col-lg-3 control-label">接触次数:</label>
	                    <div class="col-lg-9">
                           <input name="touchTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="touchTimeID" />
			    </div>
	</div>
		           <div class="form-group none status1">
                    <label class="col-lg-3 control-label">归还人:</label>
	                    <div class="col-lg-9">
                           <input name="returnPerson" style="display:inline; width:94%;" class="form-control"  type="text"  id="returnPersonID" />
			    </div>
	</div>
		           <div class="form-group none status1">
                    <label class="col-lg-3 control-label">归还水平:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="returnLevelID"></div>
                           <input name="returnLevel" type="hidden"  id="returnLevelID_" />
			    </div>
	</div>
		           <div class="form-group none status1 status4 status5 status6">
                    <label class="col-lg-3 control-label">针位水平:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="needlePositionLevelID"></div>
                           <input name="needlePositionLevel"  type="hidden"  id="needlePositionLevelID_" />
			    </div>
	</div>
		           <div class="form-group none status1 status6">
                    <label class="col-lg-3 control-label">外观水平:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="appearanceLevelID"></div>
                           <input name="appearanceLevel"  type="hidden"  id="appearanceLevelID_" />
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">X，Y针位:</label>
	                    <div class="col-lg-9">
                           <input name="xyNeedlePosition" style="display:inline; width:94%;" class="form-control"  type="text"  id="xyNeedlePositionID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 control-label">针尖最大直径:</label>
	                    <div class="col-lg-9">
                           <input name="tipMaximumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipMaximumDiameterID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 control-label">针尖最小直径:</label>
	                    <div class="col-lg-9">
                           <input name="tipMinimumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipMinimumDiameterID" />
			    </div>
	</div>
			           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 control-label">针尖最长长度:</label>
	                    <div class="col-lg-9">
                           <input name="tipLongest" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipLongestID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5 status6">
                    <label class="col-lg-3 control-label">针尖最短长度:</label>
	                    <div class="col-lg-9">
                           <input name="tipShortest" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipShortestID" />
			    </div>
	</div>
			           <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">维修人员:</label>
	                    <div class="col-lg-9">
                           <input name="maintenancePerson" style="display:inline; width:94%;" class="form-control"  type="text"  id="maintenancePersonID" />
			    </div>
	</div>
		           <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">维修项目:</label>
	                    <div class="col-lg-9">
                           <input name="maintenanceItems" style="display:inline; width:94%;" class="form-control"  type="text"  id="maintenanceItemsID" />
			    </div>
	</div>
			           <div class="form-group none status2 status3 status4 status5 status7 status8">
                    <label class="col-lg-3 control-label">备注:</label>
	                    <div class="col-lg-9">
                           <textarea name="remark" style="display:inline; width:94%;max-width: 94%;" class="form-control"  type="text"  id="remarkID"></textarea>
			    </div>
	</div>
				      <div class="form-group none status4 status5">
                    <label class="col-lg-3 control-label">操作时间:</label>
	                 <div class="col-lg-9">
                        <input type="datetime-local" class="form-control" style="width:94%;" name="optDate" id="optDateID" >
                     </div>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 control-label">操作人:</label>
	                    <div class="col-lg-9">
                           <input name="optUser" style="display:inline; width:94%;" class="form-control"  type="text"  id="optUserID" />
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
		url: '${pageContext.request.contextPath}/Equipment/findEquipmentCategroyAll.koala.koala',
		type: 'POST',
		dataType: 'json',
	})
	.done(function(msg) {
		for (var i in msg['data'])
		{
			contents.push({title:msg['data'][i]['categoryName'] , value: msg['data'][i]['id']});
		}
		selectItems['platformID'] = contents;
	});
</script>
</body>
</html>