<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<%-- <%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp --> --%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript">
var grid;
var form;
var _dialog;
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	                	 var startTimeVal = form.find('#optDateID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#optDateID_end');
	                     var endTime = endTimeVal.parent();
	                     startTime.datetimepicker({
	                                        language: 'zh-CN',
	                                        format: "yyyy-mm-dd",
	                                        autoclose: true,
	                                        todayBtn: true,
	                                        minView: 2,
	                                        pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(){
	                                 endTime.datetimepicker('setStartDate', startTimeVal.val());
	                           });//加载日期选择器
	                     var yesterday = new Date();
	                     yesterday.setDate(yesterday.getDate() - 1);
	                     endTime.datetimepicker({
	                             language: 'zh-CN',
	                             format: "yyyy-mm-dd",
	                             autoclose: true,
	                             todayBtn: true,
	                             minView: 2,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	            	                	            	                	                     var startTimeVal = form.find('#endDateID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#endDateID_end');
	                     var endTime = endTimeVal.parent();
	                     startTime.datetimepicker({
	                                        language: 'zh-CN',
	                                        format: "yyyy-mm-dd",
	                                        autoclose: true,
	                                        todayBtn: true,
	                                        minView: 2,
	                                        pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(){
	                                 endTime.datetimepicker('setStartDate', startTimeVal.val());
	                           });//加载日期选择器
	                     var yesterday = new Date();
	                     yesterday.setDate(yesterday.getDate() - 1);
	                     endTime.datetimepicker({
	                             language: 'zh-CN',
	                             format: "yyyy-mm-dd",
	                             autoclose: true,
	                             todayBtn: true,
	                             minView: 2,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 90;
	         var getButtons = function() {
                 return [/* {
                	 content: '<ks:hasSecurityResource identifier="probeCardAdd"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button></ks:hasSecurityResource>', 
                	 action: 'add'
                 }, */{
                	 content: '<ks:hasSecurityResource identifier="probeCardlogModify"><button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button></ks:hasSecurityResource>', 
                	 action: 'modify'
                 }, {
                	 content: '<ks:hasSecurityResource identifier="probeCardlogDelete"><button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button></ks:hasSecurityResource>', 
                	 action: 'delete'
                 }];
		 	 };
	         return grid.grid({
	                identity:"id",
	                isShowButtons : true,
	                buttons: getButtons(),
	                url:"${pageContext.request.contextPath}/ProbeCardOptionLog/pageJson.koala",
	                columns: [
  								   { title: '配件编号', name: 'partNo', width: 110, render: function (rowdata, name, index)
  	                                 {
	                                     var param = rowdata.probeCardDTO['partNo'];
	                                     return param;
	                                 }
	                               },
	                               { title: '状态', name: 'status', width: width},
				                   { title: '设备状态', name: 'platformStatus', width: width},
				                   { title: '操作人员', name: 'optUser', width: width},
				                   { title: '操作时间', name: 'optDate', width: width},
				                   { title: '状态时间', name: 'statusTime', width: width},
				                   { title: '接触次数', name: 'touchTime', width: width},
				                   { title: '维修人员', name: 'maintenancePerson', width: width},
				                   { title: '维修项目', name: 'maintenanceItems', width: width},
				                   { title: '操作备注', name: 'remark', width: width},
				                   { title: 'Dut编号', name: 'dutNumber', width: width},
				                   { title: 'Bin别', name: 'binNo', width: width},
				                   { title: '机台型号', name: 'platform', width: width},
				                   { title: '机台编号', name: 'platforms', width: width},
				                   /* { title: '嫁动机台', name: 'platformNo', width: width}, */
				                   { title: '产品型号', name: 'productModel', width: 465},
				                   { title: '产品批次', name: 'productLot', width: width},
				                   { title: '产品当前型号', name: 'productNowModel', width: 110},
				                   /* { title: '领用人', name: 'probeCardApplyPerson', width: width}, */
				                   { title: '客户名称', name: 'customerName', width: width},
				                   /* { title: '归还人', name: 'returnPerson', width: width}, */
				                   { title: '归还水平', name: 'returnLevel', width: width},
				                   { title: '针位水平', name: 'needlePositionLevel', width: width},
				                   { title: '外观水平', name: 'appearanceLevel', width: width},
				                   { title: 'X,Y针位', name: 'xyNeedlePosition', width: width},
				                   { title: '针尖最大直径', name: 'tipMaximumDiameter', width: 110},
				                   { title: '针尖最小直径', name: 'tipMinimumDiameter', width: 110},
				                   { title: '针尖最短长度', name: 'tipShortest', width: 110},
				                   { title: '针尖最长长度', name: 'tipLongest', width: 110},
				                   
	                ]
	         }).on({
	                   'add': function(){
	                       self.add($(this));
	                   },
	                   'modify': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                       self.modify(indexs[0], $this);
	                    },
	                   'delete': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '请选择要删除的记录'
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: '确定要删除所选记录吗?',
	                            callBack: remove
	                        });
	                   }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/ProbeCardOptionLog-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'));
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/ProbeCardOptionLog/add.koala', dialog.find('form').serialize()).done(function(result){
	                   if(result.success ){
	                        dialog.modal('hide');
	                        e.data.grid.data('koala.grid').refresh();
	                        e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                         });
	                    }else{
	                        dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                        });
	                     }
	              });
	        });
	    },
	    modify: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width:500px;">'
		        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
		        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
		        	+'<h4 class="modal-title">修改</h4></div><div class="modal-body">'
		        	+'<p><form class="form-horizontal"><div class="form-group">'
		        	+'<label class="col-lg-3 col-sm-3 control-label">产品型号:</label>'
		        	+'<div class="col-lg-9 col-sm-9">'
		        	+'<input name="productModel" style="display:inline; width:94%;" class="form-control"  type="text"  id="productModelID" dataType="Require"/>'
		        	+'<span class="required">*</span>'
		        	+'</div></div><div class="form-group">'
		        	+'<label class="col-lg-3 col-sm-3 control-label">设备编号:</label>'
		        	+'<div class="col-lg-9 col-sm-9">'
		        	+'<input name="platforms" style="display:inline; width:94%;" class="form-control"  type="text" id="platformsID" dataType="Require"/>'
		        	+'<span class="required">*</span>'
		        	+'</div></div></form>'
		        	+'</p></div><div class="modal-footer">'
		        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
		        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
		        	+'</div></div>');
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/ProbeCardOptionLog/get/' + id + '.koala').done(function(json){
	                       json = json.data;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(elm.hasClass('select')){
	                                elm.setValue(json[index]);
	                            }else{
	                                elm.val(json[index]);
	                            }
	                        }
	                });
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/ProbeCardOptionLog/updatelog.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                            });
	                        }else{
	                            dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                            });
	                        }
	                    });
	                });
	    },
	    initPage: function(form){
	              form.find('.form_datetime').datetimepicker({
	                   language: 'zh-CN',
	                   format: "yyyy-mm-dd",
	                   autoclose: true,
	                   todayBtn: true,
	                   minView: 2,
	                   pickerPosition: 'bottom-left'
	               }).datetimepicker('setDate', new Date());//加载日期选择器
	               form.find('.select').each(function(){
	                    var select = $(this);
	                    var idAttr = select.attr('id');
	                    select.select({
	                        title: '请选择',
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                    });
	               });
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/ProbeCardOptionLog/delete.koala', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.result
	                            });
	                        }
	    	});
	    }
	}
	PageLoader.initSearchPanel();
	PageLoader.initGridPanel();
	form.find('#search').on('click', function(){
            if(!Validator.Validate(document.getElementById("<%=formId%>"),3))return;
            var params = {};
            form.find('input').each(function(){
                var $this = $(this);
                var name = $this.attr('name');
                if(name){
                    params[name] = $this.val();
                }
            });
            grid.getGrid().search(params);
        });
	if("undefined" != typeof ProbeCardGlobleId)
	{
		grid.getGrid().searchCondition['probeCardId']=ProbeCardGlobleId;
		//params['probeCardId']=ProbeCardGlobleId;
	}
});
</script>
</head>
<body>
<div style="width:98%;margin-right:auto; margin-left:auto; padding-top: 15px;">
<!-- search form -->
<form name=<%=formId%> id=<%=formId%> target="_self" class="form-horizontal">
<!-- <input type="hidden" name="page" value="0">
<input type="hidden" name="pagesize" value="10"> -->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
                  <div class="form-group">
          <label class="control-label" style="width:75px;float:left;">操作日期:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="optDate" id="optDateID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="optDateEnd" id="optDateID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
                 <label class="control-label" style="width:100px;float:left;">配件编号:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="partNo" class="form-control" type="text" style="width:180px;" id="partNoID"  />
        </div>
            </div>
            </td>
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
