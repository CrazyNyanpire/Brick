<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp -->
<%@ page import="java.util.Date"%>
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
	        	            	                	            	                	            	                	                     var startTimeVal = form.find('#createTimestampID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#createTimestampID_end');
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
	                	            	                	            	                	            	                	                     var startTimeVal = form.find('#lastModifyTimestampID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#lastModifyTimestampID_end');
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
	                	            	                	            	                	            	                	                     var startTimeVal = form.find('#maintenanceStartDateID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#maintenanceStartDateID_end');
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
	                	            	                	            	                	            	                	                     var startTimeVal = form.find('#checkInTimeID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#checkInTimeID_end');
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
	         var width = 100;
	         return grid.grid({
	                identity:"id",
	                buttons: [
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'},
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-wrench"><span>平台组合</button>', action: 'Combination'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-search"><span>组合设备明细</button>', action: 'childEquipShow'}
	                    ],
	                url:"${pageContext.request.contextPath}/Platform/pageJson.koala",
	                columns: [
           	                         { title: '平台编号', name: 'platformNo', width: width},
           	                         { title: '平台名称', name: 'platformName', width: width},
           	                         { title: '平台类型', name: 'platformCategory', width: width},
           	                         { title: '责任人', name: 'responsible', width: width},
           	                         { title: '代理人', name: 'agent', width: width},
           	                         { title: '保养起始日期', name: 'maintenanceStartDate', width: width},
           	                         { title: '维护周期', name: 'repairCycle', width: width},
           	                         { title: '校准周期', name: 'calibrationCycle', width: width},
           	                         { title: '平台位置', name: 'platformLocation', width: width},
           	                         { title: '组装时间', name: 'checkInTime', width: width},
           	                         { title: '平台状态', name: 'status', width: width}
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
	                   },
	                   'Combination':function(event, data){
	                	   var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一台设备记录进行组装'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一台设备记录进行组装'
	                            })
	                            return;
	                        }
	                       self.Combination(indexs[0], $this);
	                   },
	                   'childEquipShow':function(event, data){
	                	   var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一台设备记录进行查询'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一台设备记录进行查询'
	                            })
	                            return;
	                        }
	                       self.childEquipShow(indexs[0], $this);
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
	        $.get('<%=path%>/Platform-add.jsp').done(function(html){
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
	              $.post('${pageContext.request.contextPath}/Platform/add.koala', dialog.find('form').serialize()).done(function(result){
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
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/Platform-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/Platform/get/' + id + '.koala').done(function(json){
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
	                    $.post('${pageContext.request.contextPath}/Platform/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	                    	debugger;
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
	        });
	    },
	    Combination: function(id,grid){
        	var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 80%;">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">设备选择</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
	        	+'</div></form></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-success" id="save">组合</button></div></div>'
	        	+'</div></div>');
	        $.get('${pageContext.request.contextPath}/Equipment/findComposabilityEquipments.koala').done(function(msg){
	        	//msg['data']=[{equipid:'1',equipName:'3360P-001'},{equipid:'2',equipName:'3360P-002'},{equipid:'3',equipName:'3360P-003'},{equipid:'4',equipName:'3360P-004'},{equipid:'5',equipName:'3360P-005'},{equipid:'6',equipName:'3360P-006'},{equipid:'7',equipName:'3360P-007'},{equipid:'8',equipName:'3360P-008'},{equipid:'9',equipName:'3360P-009'}];
	        	for(var a in msg['data'])
        		{
	        		dialog.find('.modal-body .form-group').append('<label class="col-lg-2 control-label" name="'+msg['data'][a]['id']+'" style="text-align:center;margin-bottom: 20px;"><img src="/images/tester_3360_128.png" alt=""><br/><span>'+msg['data'][a]['equipmentNo']+'</span></label>');
        		}
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            });
	           	dialog.find(".control-label").on("click",function(e){
	           		if($(this).attr("click")=="true"){
	           			$(this).attr("click","");
	           			$(this).css("background-color","initial");
	           		}
	           		else{
	           			$(this).attr("click","true");
	           			$(this).css("background-color","#2AD");
	           		}
	           	});
	            //self.initPage(dialog.find('form'));
	            dialog.find('#save').on('click',{grid: grid}, function(e){
		              if(!Validator.Validate(dialog.find('form')[0],3))return;
		              var equipadd=[];
		              debugger;
		              //var equipName="";
		              for(var b in $(".modal-body .col-lg-2"))
	            	  {
	            	  	if($(".modal-body .col-lg-2").eq(b).attr('click')=="true")
            	  		{
            	  			equipadd.push($(".modal-body .col-lg-2").eq(b).attr("name"));
            	  			//equipName+=$(".modal-body .col-lg-2").eq(b).children("span").text()+",";
            	  		}
	            	  }
		              var string="id="+id+"&equipmentIds="+equipadd;
	                  $.post('${pageContext.request.contextPath}/Platform/assemble.koala', string).done(function(result){
	                	  debugger;
		                   if(result.success == true){
		                        dialog.modal('hide');
		                        e.data.grid.data('koala.grid').refresh();
		                        e.data.grid.message({
		                            type: 'success',
		                            content: '保存成功'
		                        });
		                    }else{
		                        dialog.find('.modal-content').message({
		                            type: 'error',
		                            content: result.errorMessage
		                        });
		                     }
		              });
		        });
	        });
	    },
	    childEquipShow:function(id,grid){
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 80%;"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group"></div></form></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
	        $.get('${pageContext.request.contextPath}/Platform/findEquipmentByPlatform/'+id+'.koala').done(function(msg){
	        	debugger;
	        	//msg['data']=[{equipid:'1',equipName:'3360P-001'},{equipid:'2',equipName:'3360P-002'},{equipid:'3',equipName:'3360P-003'},{equipid:'4',equipName:'3360P-004'},{equipid:'5',equipName:'3360P-005'},{equipid:'6',equipName:'3360P-006'},{equipid:'7',equipName:'3360P-007'},{equipid:'8',equipName:'3360P-008'},{equipid:'9',equipName:'3360P-009'}];
   	        	for(var a in msg['data'])
   	    		{
   	        		dialog.find('.modal-body .form-group').append('<label class="col-lg-2 control-label" name="'+msg['data'][a]['id']+'" style="text-align:center;margin-bottom: 20px;"><img src="/images/tester_3360_128.png" alt=""><br/><span>'+msg['data'][a]['equipmentNo']+'</span></label>');
   	    		}
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
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
	    	$.post('${pageContext.request.contextPath}/Platform/delete.koala', data).done(function(result){
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
});

var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/Platform-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/Platform/get/' + id + '.koala').done(function(json){
                       json = json.data;
                        var elm;
                        for(var index in json){
                        if(json[index]+"" == "false"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#d2322d' class='glyphicon glyphicon-remove'></span>");
                        	}else if(json[index]+"" == "true"){
                        		dialog.find('#'+ index + 'ID').html("<span style='color:#47a447' class='glyphicon glyphicon-ok'></span>");
                        	}else{
                          		 dialog.find('#'+ index + 'ID').html(json[index]+"");
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
        });
}
</script>
</head>
<body>
<div style="width:98%;margin-right:auto; margin-left:auto; padding-top: 15px;">
<!-- search form -->
<form name=<%=formId%> id=<%=formId%> target="_self" class="form-horizontal">
<input type="hidden" name="page" value="0">
<input type="hidden" name="pagesize" value="10">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
<!--           <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">createEmployNo:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="createEmployNo" class="form-control" type="text" style="width:180px;" id="createEmployNoID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">lastModifyEmployNo:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="lastModifyEmployNo" class="form-control" type="text" style="width:180px;" id="lastModifyEmployNoID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">createTimestamp:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="createTimestamp" id="createTimestampID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="createTimestampEnd" id="createTimestampID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
                      <label class="control-label" style="width:100px;float:left;">calibrationCycle:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="calibrationCycle" class="form-control" type="text" style="width:180px;" id="calibrationCycleID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">responsible:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="responsible" class="form-control" type="text" style="width:180px;" id="responsibleID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">lastModifyTimestamp:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="lastModifyTimestamp" id="lastModifyTimestampID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="lastModifyTimestampEnd" id="lastModifyTimestampID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">repairCycle:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="repairCycle" class="form-control" type="text" style="width:180px;" id="repairCycleID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">platformCategory:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="platformCategory" class="form-control" type="text" style="width:180px;" id="platformCategoryID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">maintenanceStartDate:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="maintenanceStartDate" id="maintenanceStartDateID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="maintenanceStartDateEnd" id="maintenanceStartDateID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
                      <label class="control-label" style="width:100px;float:left;">status:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="status" class="form-control" type="text" style="width:180px;" id="statusID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">agent:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="agent" class="form-control" type="text" style="width:180px;" id="agentID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">checkInTime:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="checkInTime" id="checkInTimeID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="checkInTimeEnd" id="checkInTimeID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">platformName:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="platformName" class="form-control" type="text" style="width:180px;" id="platformNameID"  />
        </div>
                      <label class="control-label" style="width:100px;float:left;">platformNo:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="platformNo" class="form-control" type="text" style="width:180px;" id="platformNoID"  />
        </div>
            </div>
                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">platformLocation:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <input name="platformLocation" class="form-control" type="text" style="width:180px;" id="platformLocationID"  />
        </div> -->
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
