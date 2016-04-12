<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal" name="upload"  enctype="multipart/form-data"  method="post" target="hiddenIframename" action="">
	<input type="hidden" id="StateID" name="state" value="结单"/> 
	<input  name="grossDie" type="hidden"  id="grossDieID"/>
	<input  name="standardWorkHours" type="hidden"  id="standardWorkHoursID"/>
	<input  name="team" type="hidden"  id="teamID"/>
	<input  name="touchdown" type="hidden"  id="touchdownID"/>
	<div class="nextShow">
		           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">设备状态:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="statusIdID"></div>
                           <input name="statusId"  type="hidden"  id="statusIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
		           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">子状态:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="subStatusIdID"></div>
                           <input name="subStatusId"  type="hidden"  id="subStatusIdID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
	</div>
	<div class="prvShow">
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">当前站点:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowStationPrv" style="display:inline;width:94%;" readonly class="form-control"  type="text"  id="nowStationIDPrv"/>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">产品批次:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowLotPrv" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="nowLotIDPrv" />
                           <div class="nowLotChildRoom" style="display:inline;"></div>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">产品型号:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowProductPrv" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="nowProductIDPrv" />
                           <div class="nowProductChildRoom" style="display:inline;"></div>
			    </div>
	</div>
	</div>
	<div class="nextShow">
		           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">当前站点:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowStation" style="display:inline;width:94%;" readonly class="form-control"  type="text"  id="nowStationID"/>
			    </div>
	</div>
			           <div class="form-group part_OVEN">
                    <label class="col-lg-2 col-sm-2 control-label">产品数量:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="productQtyID"></div>
                           <input  name="productQty" type="hidden"  id="productQtyID_" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">产品批次:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowLot" style="display:inline; width:94%;" class="form-control"  type="text"  id="nowLotID" dataType="Require"/>
                           <div class="nowLotChildRoom" style="display:inline;"></div>
                           <span class="required">*</span>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">产品型号:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="nowProduct" style="display:inline; width:94%;" class="form-control" readonly type="text"  id="nowProductID" />
                           <div class="nowProductChildRoom" style="display:inline;"></div>
			    </div>
	</div>
			           <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label">操作备注:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <textarea name="optRemark" style="display:inline; width:94%;" class="form-control"  type="text"  id="optRemarkID"></textarea>
			    </div>
	</div>
	</div>
	<div class="prvShow">
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">上状态测试数:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="beforeTestQty" style="display:inline; width:94%;" class="form-control" readonly type="text"  id="beforeTestQtyID"/>
			    </div>
	</div>
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">当前测试数:</label>
	                    <div class="col-lg-10 col-sm-10">
                           <input name="testQty" style="display:inline; width:94%;" readonly class="form-control"  type="text"  id="testQtyID" dataType="Require"/>
                           <span class="required">*</span>
			    </div>
	</div>
				           <div class="form-group part_CP">
                    <label class="col-lg-2 col-sm-2 control-label">片选:</label>
                     <div class="col-lg-10 col-sm-10">
	                    <input name="pianxuan" style="display:none; width:94%;" class="form-control"  type="text"  id="pianxuanID"/>
	                    <div class="pianxuanRoom" style="display:inline">
	                    <div style="display:inline-block;margin-right:2px;">01<br/><input index="1" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">02<br/><input index="2" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">03<br/><input index="3" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">04<br/><input index="4" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">05<br/><input index="5" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">06<br/><input index="6" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">07<br/><input index="7" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">08<br/><input index="8" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">09<br/><input index="9" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">10<br/><input index="10" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">11<br/><input index="11" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">12<br/><input index="12" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">13<br/><input index="13" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">14<br/><input index="14" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">15<br/><input index="15" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">16<br/><input index="16" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">17<br/><input index="17" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">18<br/><input index="18" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">19<br/><input index="19" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">20<br/><input index="20" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">21<br/><input index="21" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">22<br/><input index="22" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">23<br/><input index="23" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">24<br/><input index="24" type="checkBox"/></div>
	                    <div style="display:inline-block;margin-right:2px;">25<br/><input index="25" type="checkBox"/></div>
	                    </div>
                        <span class="required">*</span>
                        <input type="button" value="反选" onclick="pianxuanChange()"/>
                </div>
	</div>
				           <div class="form-group part_CP">
                    <label class="col-lg-2 col-sm-2 control-label">片选备注:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <input name="pianxuanBeizhu" style="display:none; width:94%;" class="form-control"  type="text"  id="pianxuanBeizhuID"/>
	                    <div class="pianxuanBeizhuRoom" style="display:inline">
	                    <div style="display:inline-block;margin-right:2px;">01<br/><input type="text" index="1" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">02<br/><input type="text" index="2" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">03<br/><input type="text" index="3" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">04<br/><input type="text" index="4" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">05<br/><input type="text" index="5" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">06<br/><input type="text" index="6" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">07<br/><input type="text" index="7" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">08<br/><input type="text" index="8" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">09<br/><input type="text" index="9" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">10<br/><input type="text" index="10" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">11<br/><input type="text" index="11" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">12<br/><input type="text" index="12" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">13<br/><input type="text" index="13" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">14<br/><input type="text" index="14" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">15<br/><input type="text" index="15" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">16<br/><input type="text" index="16" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">17<br/><input type="text" index="17" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">18<br/><input type="text" index="18" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">19<br/><input type="text" index="19" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">20<br/><input type="text" index="20" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">21<br/><input type="text" index="21" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">22<br/><input type="text" index="22" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">23<br/><input type="text" index="23" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">24<br/><input type="text" index="24" style="width:30px"/></div>
	                    <div style="display:inline-block;margin-right:2px;">25<br/><input type="text" index="25" style="width:30px"/></div>
	                    </div>
                           <span class="required">*</span>
                </div>
	</div>
	</div>
	<div class="nextShow">
			           <div class="form-group part_CP">
                    <label class="col-lg-2 col-sm-2 control-label">P/C编号:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="partIdsID"></div>
                           <input name="partIds"  type="hidden"  id="partIdsID_"/>
			    </div>
	</div>
						           <div class="form-group part_FT">
                           <input name="siteTestQty"  type="hidden"  id="siteTestQtyID"/>
			    </div>
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">site0:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="partIds0ID"></div>
	                       <input name="partIds"  type="hidden"  id="partIdsID_"/>
                           <input name="partIds0"  type="hidden"  id="partIds0ID_"/>
                           <span class="required">*</span>
			    </div>
	</div>
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">site1:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="partIds1ID"></div>
                           <input name="partIds1"  type="hidden"  id="partIds1ID_" />
			    </div>
	</div>
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">site2:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="partIds2ID"></div>
                           <input name="partIds2"  type="hidden"  id="partIds2ID_" />
			    </div>
	</div>
				           <div class="form-group part_FT">
                    <label class="col-lg-2 col-sm-2 control-label">site3:</label>
	                    <div class="col-lg-10 col-sm-10">
	                    <div class="btn-group select" id="partIds3ID"></div>
                           <input name="partIds3"  type="hidden"  id="partIds3ID_" />
			    </div>
	</div>
				           <div class="form-group part_PM">
                    <label class="col-lg-2 col-sm-2 control-label">保养周期:</label>
	                    <div class="col-lg-10 col-sm-10">
	                       <input name="pmType"   type="hidden"  id="pmTypeID"/>
                           <input name="repairCycleMonth" type="checkBox"  id="repairCycle_monthID" /><span>月</span>
                           <input name="repairCycleSeason" type="checkBox"  id="repairCycle_seasonID" /><span>季</span>
                           <input name="repairCycleYear" type="checkBox"  id="repairCycle_yearID" /><span>年</span>
			    </div>  
	</div>
			           <div class="form-group part_PM">
                    <label class="col-lg-2 col-sm-2 control-label">PM单:</label>
	                    <div class="col-lg-10 col-sm-10">
                            <div id="filelist"></div>
							<input name="file" type="file" style="display: inline;" id="tablefile" onchange="if($(this).val()!=''){ajaxsubmit('');}"/>	
							<iframe style="display:none;"name="hiddenIframename">
							</iframe>
						</div>    
	</div>
	</div>
</form>
<script type="text/javascript">
function pianxuanChange(){
	var array=$('.pianxuanRoom input');
	for(var i in array)
	{
		if(array.eq(i).attr("disabled")=="disabled")
		{
			return;
			break;
		}
	}
	for(var i in array)
	{
		if(array.eq(i).attr("checked")=="checked")
		{
			array.eq(i).attr("checked",false);
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").val("");
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").css("background-color","#fff");
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").removeAttr("readonly");
		}
		else{
			array.eq(i).attr("checked","checked");
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").val("");
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").css("background-color","#eee");
			$(".pianxuanBeizhuRoom input[index='"+array.eq(i).attr("index")+"']").attr("readonly","readonly");
		}
	}		
}
   var selectItems = {};
   var contents = [{title:'请选择', value: ''}];
   contents.push({title:'1' , value: '1'});
   contents.push({title:'2' , value: '2'});
   contents.push({title:'3' , value: '3'});
   contents.push({title:'4' , value: '4'});
   contents.push({title:'5' , value: '5'});
   selectItems['productQtyID'] = contents;
/*    var contents = [{title:'请选择', value: ''}];
   $.ajax({
   	async:false,
   	url: '${pageContext.request.contextPath}/Socket/productAll.koala',
   	type: 'POST',
   	dataType: 'json',
   })
   .done(function(msg) {
   	for (var i in msg)
   	{
   		contents.push({title:msg[i]['partNo'] , value: msg[i]['id']});
   	}
   	selectItems['partIds0ID'] = contents;
   	selectItems['partIds1ID'] = contents;
   	selectItems['partIds2ID'] = contents;
   	selectItems['partIds3ID'] = contents;
   }); */
</script>
</body>
</html>