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
                    <label class="col-lg-3 control-label">进厂日期:</label>
	                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="inDate" id="inDateID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 control-label">保修到期</label>
	                    <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="warrantyPeriod" id="warrantyPeriodID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
                     <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">配件名称:</label>
	                    <div class="col-lg-9">
                           <input name="partName" style="display:inline; width:94%;" class="form-control"  type="text"  id="partNameID" dataType="Require"/>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">配件S/N:</label>
	                    <div class="col-lg-9">
                           <input name="serialNumber" style="display:inline; width:94%;" class="form-control"  type="text"  id="serialNumberID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 control-label">配件P/N:</label>
	                    <div class="col-lg-9">
                           <input name="pn" style="display:inline; width:94%;" class="form-control"  type="text"  id="pnID" dataType="Require"/>
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
                    <label class="col-lg-3 control-label">目前位置:</label>
	                    <div class="col-lg-9">
                           <input name="location" style="display:inline; width:94%;" class="form-control"  type="text"  id="locationID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 control-label">slot插槽:</label>
	                    <div class="col-lg-9">
                           <input name="slotSite" style="display:inline; width:94%;" class="form-control"  type="text"  id="slotSiteID" />
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-3 control-label">数量:</label>
	                    <div class="col-lg-9">
                           <input name="quantity" style="display:inline; width:94%;" class="form-control"  type="text"  id="quantityID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">随来机台:</label>
	                    <div class="col-lg-9">
                           <input name="equipment" style="display:inline; width:94%;" class="form-control"  type="text"  id="equipmentID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">机台S/N:</label>
	                    <div class="col-lg-9">
                           <input name="propertyNumber" style="display:inline; width:94%;" class="form-control"  type="text"  id="propertyNumberID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">厂商:</label>
	                    <div class="col-lg-9">
                           <input name="manufacturer" style="display:inline; width:94%;" class="form-control"  type="text"  id="manufacturerID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">类型:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="typeID"></div>
                           <input name="type"  type="hidden"  id="typeID_" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">配件类型:</label>
	                    <div class="col-lg-9">
	                    <div class="btn-group select" id="partTypeID"></div>
                           <input name="partType"  type="hidden"  id="partTypeID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">板卡Revision:</label>
	                    <div class="col-lg-9">
                           <input name="partRevision" style="display:inline; width:94%;" class="form-control"  type="text"  id="partRevisionID" />
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-3 control-label">板卡Config:</label>
	                    <div class="col-lg-9">
                           <input name="partConfig" style="display:inline; width:94%;" class="form-control"  type="text"  id="partConfigID" />
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
	contents.push({title:'归还客户' , value: '归还客户'});
	contents.push({title:'退回厂商' , value: '退回厂商'});
    selectItems['statusID'] = contents;
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'Rider' , value: 'Rider'});
    contents.push({title:'HALF' , value: 'HALF'});
    contents.push({title:'FULL' , value: 'FULL'});
    contents.push({title:'Main Power' , value: 'Main Power'});
    contents.push({title:'Other' , value: 'Other'});
    selectItems['typeID'] = contents;
    var contents = [{title:'请选择', value: ''}];
    contents.push({title:'板卡' , value: '板卡'});
    contents.push({title:'测试机配件' , value: '测试机配件'});
    contents.push({title:'其他' , value: '其他'});
    selectItems['partTypeID'] = contents;
    </script>
</body>
</html>