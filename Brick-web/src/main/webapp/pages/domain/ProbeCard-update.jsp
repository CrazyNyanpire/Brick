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
	<label class="col-lg-2 col-sm-2 control-label">客户中文名称:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="customerName" style="display:inline; width:94%;" class="form-control"  type="text"  id="customerNameID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">保养基数:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="maintenanceBase" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="maintenanceBaseID" dataType="Require"/>
		<span class="required">*</span>
	</div>
</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">客户英文名称:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="customerNameEn" style="display:inline; width:94%;" class="form-control"  type="text"  id="customerNameEnID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">X,Y针位:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="xyNeedlePosition" style="display:inline; width:94%;" class="form-control"  type="text"  id="xyNeedlePositionID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">储存位置:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="partLocaltion" style="display:inline; width:94%;" class="form-control"  type="text"  id="partLocaltionID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">针位平坦度:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="zNeedlePositionFlatness" style="display:inline; width:94%;" class="form-control"  type="text"  id="zNeedlePositionFlatnessID" dataType="Require"/>
		<span class="required">*</span>
	</div>


</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">进厂最长针长:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="inLongestNeedle" style="display:inline; width:94%;" class="form-control"  type="text"  id="inLongestNeedleID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">针尖最大直径:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="inTipMaximumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="inTipMaximumDiameterID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">进厂最短针长:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="inShortestNeedle" style="display:inline; width:94%;" class="form-control"  type="text"  id="inShortestNeedleID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">针尖最小直径:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="inTipMinimumDiameter" style="display:inline; width:94%;" class="form-control"  type="text"  id="inTipMinimumDiameterID" dataType="Require"/>
		<span class="required">*</span>
	</div>


</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">制作厂商:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="manufacturerName" style="display:inline; width:94%;" class="form-control"  type="text"  id="manufacturerNameID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">针尖高度:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="tipHeight" style="display:inline; width:94%;" class="form-control"  type="text"  id="tipHeightID" dataType="Require"/>
		<span class="required">*</span>
	</div>



</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">制作编号:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="manufacturerNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="manufacturerNoID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">Expoxy至针尖Angle距离:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="expoxyToTipAngleDistance" style="display:inline; width:94%;" class="form-control"  type="text"  id="expoxyToTipAngleDistanceID" dataType="Require"/>
		<span class="required">*</span>
	</div>


</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">报废标准:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="scrappingStandard" style="display:inline; width:94%;" class="form-control"  type="text"  id="scrappingStandardID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">PCB尺寸:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="pcbSize" style="display:inline; width:94%;" class="form-control"  type="text"  id="pcbSizeID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">财产归属:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="ownership" style="display:inline; width:94%;" class="form-control"  type="text"  id="ownershipID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">PIN总数:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="pinQty" style="display:inline; width:94%;" class="form-control"  type="text"  id="pinQtyID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">配件编号:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="partNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="partNoID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">测试温度:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="testTemperature" style="display:inline; width:94%;" class="form-control"  type="text"  id="testTemperatureID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">探针材质:</label>
	<div class="col-lg-4 col-sm-4">
		<div class="btn-group select" id="probeMaterialsID"></div>
		<input name="probeMaterials"  type="hidden"  id="probeMaterialsID_" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">Probe Card外观:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="appearanceOfProbeCard" style="display:inline; width:94%;" class="form-control"  type="text"  id="appearanceOfProbeCardID" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">保养上限:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="maintenanceUpperLimit" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="maintenanceUpperLimitID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">补强板:</label>
	<div class="col-lg-4 col-sm-4">
		<div class="btn-group select" id="reinforcingPlateID"></div>
		<input name="reinforcingPlate"  type="hidden"  id="reinforcingPlateID_" dataType="Require"/>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">保养下限:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="maintenanceLowerLimit" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="maintenanceLowerLimitID" dataType="Require"/>
		<span class="required">*</span>
	</div>
	<label class="col-lg-2 col-sm-2 control-label">进场时间:</label>
	<div class="col-lg-4 col-sm-4">
		<div class="input-group date form_datetime" style="width:160px;float:left;" >
			<input type="text" class="form-control" style="width:160px;" name="inDate" id="inDateID" dataType="Require"/>
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-th"></span>
			</span>
		</div>
		<span class="required">*</span>
	</div>

</div>
<div class="form-group">
	<label class="col-lg-2 col-sm-2 control-label">是否拆板重制:</label>
	<div class="col-lg-4 col-sm-4">
		<div class="btn-group select" id="openRemakeID"></div>
		<input name="openRemake"  type="hidden"  id="openRemakeID_" dataType="Require"/>
		<span class="required">*</span>
	</div>

	<label class="col-lg-2 col-sm-2 control-label">重制次数:</label>
	<div class="col-lg-4 col-sm-4">
		<input name="remakeNumber" style="display:inline; width:94%;" class="form-control"  type="text"  id="remakeNumberID" dataType="Require"/>
		<span class="required">*</span>
	</div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
	var contents = [{title:'请选择', value: ''}];
    contents.push({title:'铼钨针' , value:'铼钨针'});
    contents.push({title:'免清针' , value:'免清针'});
    contents.push({title:'钨针' , value:'钨针'});
    selectItems['probeMaterialsID'] = contents;
	var contents = [{title:'请选择', value: ''}];
    contents.push({title:'是' , value:'是'});
    contents.push({title:'否' , value:'否'});
    selectItems['openRemakeID'] = contents;
	var contents = [{title:'请选择', value: ''}];
    contents.push({title:'是' , value:'是'});
    contents.push({title:'否' , value:'否'});
    selectItems['reinforcingPlateID'] = contents; 
</script>
</body>
</html>