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
var ProbeCardGlobleId;
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	                	 var startTimeVal = form.find('#inDateID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#inDateID_end');
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
	                     var contents = [{title:'请选择', value: ''}];
		                 	$.ajax({
		                		type : "POST",
		                		url : "/Category/get/78.koala",
		                		dataType : 'json',
		                		success : function(result){
		                			for(var i in result['data']['categoryChildren'])
	                				{
		                				contents.push({title:result["data"]['categoryChildren'][i]["categoryName"],value:result["data"]['categoryChildren'][i]["id"]});
	                				}
	        	                    form.find('#statusID').select({
			                               title: '请选择',
			                               contents: contents
			                          }).on('change',function(){
			                              form.find('#statusID_').val($(this).getValue());
			                          });  
		                		}
		                 	});
},
	    initGridPanel: function(){
	         var self = this;
	         var width = 90;
	         var getButtons = function() {
                 return [{
                	 content: '<ks:hasSecurityResource identifier="probeCardAdd"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button></ks:hasSecurityResource>', 
                	 action: 'add'
                 },{
                	 content: '<ks:hasSecurityResource identifier="probeCardModify"><button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button></ks:hasSecurityResource>', 
                	 action: 'modify'
                 },/* {
                	 content: '<ks:hasSecurityResource identifier="probeCardDelete"><button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button></ks:hasSecurityResource>', 
                	 action: 'delete'
                 }, */{
                	 content: '<ks:hasSecurityResource identifier="probeCardChange"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-edit"><span>状态变更</button></ks:hasSecurityResource>', 
                	 action: 'change'
                 },{
                	 content: '<ks:hasSecurityResource identifier="touchTimeChange"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-edit"><span>修改接触次数</button></ks:hasSecurityResource>', 
                	 action: 'timeChange'
                 },{
                	 content: '<ks:hasSecurityResource identifier="releaseChange"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-edit"><span>修改release信息</button></ks:hasSecurityResource>', 
                	 action: 'releaseChange'
                 }];
		 	 };
	         return grid.grid({
	                identity:"id",
	                buttons: getButtons(),
	                pageSize : 1000,
	                isShowPages:false,
	                url:"${pageContext.request.contextPath}/ProbeCard/pageJson.koala",
	                columns: [
         	                         { title: '配件编号', name: 'partNo', width: 120},
         	                         { title: '状态', name: 'status', width: width, render: function (rowdata, name, index){
		       	                    	 	var h="<div style='background-color:"+proCardstatusColor(rowdata[name])+"'>"+rowdata[name]+"</div>"
		       	                    	 	return h;
		                             	 }
		                         	 },
         	                         { title: '嫁动平台', name: 'platform', width: width},
         	                         { title: '产品型号', name: 'productModel', width: 250},
         	                         { title: '产品当前型号', name: 'nowProductModel', width: 110},
         	                         { title: '接触次数', name: 'touchTime', width: width},
        	                         { title: '接触总数', name: 'touchTimeTotal', width: width},
         	                         { title: '探针材质', name: 'probeMaterials', width: width},
         	                         { title: '保养上限', name: 'maintenanceUpperLimit', width: width},
         	                         { title: '保养下限', name: 'maintenanceLowerLimit', width: width},
         	                         { title: '设备类型', name: 'equipmentCategory', width: width},
         	                         { title: '设备编号', name: 'equipmentList', width: 200},
         	                         { title: '报废标准', name: 'scrappingStandard', width: width},
         	                         { title: '客户中文名称', name: 'customerName', width: 110},
         	                         { title: '客户英文名称', name: 'customerNameEn', width: 110},
         	                         { title: '储存位置', name: 'partLocaltion', width: width},
         	                         { title: '制作厂商', name: 'manufacturerName', width: width},
         	                         { title: '制作编号', name: 'manufacturerNo', width: 110},
         	                         { title: '进厂最长针长', name: 'inLongestNeedle', width: 110},
         	                         { title: '进厂最短针长', name: 'inShortestNeedle', width: 110},
         	                         { title: '当前针尖最大长度', name: 'tipLongest', width: 135},
         	                         { title: '当前针尖最小长度', name: 'tipShortest', width: 135}, 
         	                         { title: '针尖最大直径', name: 'inTipMaximumDiameter', width: 110},
         	                         { title: '针尖最小直径', name: 'inTipMinimumDiameter', width: 110},
         	                         { title: '当前针尖最大直径', name: 'tipMaximumDiameter', width: 135},
        	                         { title: '当前针尖最小直径', name: 'tipMinimumDiameter', width: 135},
        	                         { title: '财产归属', name: 'ownership', width: width},
         	                         { title: 'PIN总数', name: 'pinQty', width: width},
 				                   	 { title: 'PCB尺寸', name: 'pcbSize', width: width},
         	                         { title: '进厂时间', name: 'inDate', width: width},
	         	                     { title: '操作详情', name: 'detil', width: width, render: function (rowdata, name, index){
		       	                    	 	var h="<a href='#' onclick='probeDetilView("+rowdata.id+")'>查看</a>"
		       	                    	 	return h;
		                             	 }
		                         	 }
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
	                    'change': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                       self.change(indexs[0], $this,data['item'][0]);
	                    },
	                    'timeChange': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                       self.timeChange(indexs[0], $this,data['item'][0]);
	                    },
	                    'releaseChange': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行变更'
	                            })
	                            return;
	                        }
	                       self.releaseChange(indexs[0], $this,data['item'][0]);
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
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width:770px;">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/ProbeCard-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'));
	            dialog.find("#probeMaterialsID .dropdown-menu").bind("click",function(){
    	    		var typearray=$("#probeMaterialsID input").val();
    	    		if(typearray=="铼钨针")
   	    			{
   	    				$("#maintenanceUpperLimitID").val("200000");
   	    				$("#maintenanceLowerLimitID").val("180000");
   	    				$("#maintenanceBaseID").val("200000");
   	    			}
    	    		else if(typearray=="免清针")
   	    			{
    	    			$("#maintenanceUpperLimitID").val("300000");
   	    				$("#maintenanceLowerLimitID").val("260000");
   	    				$("#maintenanceBaseID").val("300000");
   	    			}
    	    		else{
    	    			$("#maintenanceUpperLimitID").val("100000");
   	    				$("#maintenanceLowerLimitID").val("80000");
   	    				$("#maintenanceBaseID").val("100000");
    	    		}
	        	});
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/ProbeCard/add.koala', dialog.find('form').serialize()).done(function(result){
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
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width:770px;"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/ProbeCard-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/ProbeCard/get/' + id + '.koala').done(function(json){
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
	               dialog.find("#probeMaterialsID .dropdown-menu").bind("click",function(){
	    	    		var typearray=$("#probeMaterialsID input").val();
	    	    		if(typearray=="铼钨针")
	   	    			{
	   	    				$("#maintenanceUpperLimitID").val("200000");
	   	    				$("#maintenanceLowerLimitID").val("160000");
	   	    				$("#maintenanceBaseID").val("200000");
	   	    			}
	    	    		else if(typearray=="免清针")
	   	    			{
	    	    			$("#maintenanceUpperLimitID").val("300000");
	   	    				$("#maintenanceLowerLimitID").val("260000");
	   	    				$("#maintenanceBaseID").val("300000");
	   	    			}
	    	    		else{
	    	    			$("#maintenanceUpperLimitID").val("100000");
	   	    				$("#maintenanceLowerLimitID").val("80000");
	   	    				$("#maintenanceBaseID").val("100000");
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
	                    $.post('${pageContext.request.contextPath}/ProbeCard/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    timeChange: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width:500px;">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">修改</h4></div><div class="modal-body">'
	        	+'<p><form class="form-horizontal"><div class="form-group">'
	        	+'<label class="col-lg-3 col-sm-3 control-label">接触次数:</label>'
	        	+'<div class="col-lg-9 col-sm-9">'
	        	+'<input name="touchTime" style="display:inline; width:94%;" class="form-control"  type="text"  id="touchTimeID" dataType="Require"/>'
	        	+'<span class="required">*</span>'
	        	+'</div></div><div class="form-group">'
	        	+'<label class="col-lg-3 col-sm-3 control-label">总接触次数:</label>'
	        	+'<div class="col-lg-9 col-sm-9">'
	        	+'<input name="touchTimeTotal" style="display:inline; width:94%;" class="form-control"  type="text" id="touchTimeTotalID" dataType="Require"/>'
	        	+'<span class="required">*</span>'
	        	+'</div></div></form>'
	        	+'</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
        		self.initPage(dialog.find('form'));
        		$.get( '${pageContext.request.contextPath}/ProbeCard/get/' + id + '.koala').done(function(json){
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
                    $.get('${pageContext.request.contextPath}/ProbeCard/updateTouchdownNum.koala?touchTime='+$("#touchTimeID").val()+'&touchTimeTotal='+$("#touchTimeTotalID").val()+'&id='+id).done(function(result){
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
	    releaseChange: function(id, grid){
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
	        	+'<input name="equipmentList" style="display:inline; width:94%;" class="form-control"  type="text" id="equipmentListID" dataType="Require"/>'
	        	+'<span class="required">*</span>'
	        	+'</div></div></form>'
	        	+'</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
        		self.initPage(dialog.find('form'));
        		$.get( '${pageContext.request.contextPath}/ProbeCard/get/' + id + '.koala').done(function(json){
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
                    $.get('${pageContext.request.contextPath}/ProbeCard/updateRelease.koala?productModel='+$(".modal-body #productModelID").val()+'&equipmentList='+$(".modal-body #equipmentListID").val()+'&id='+id).done(function(result){
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
	    change: function(id, grid,data){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">状态变更</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/ProbeCardOptionLog-add.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               	var contents = [{title:'请选择', value: ''}];
	            	$.ajax({
	            		async:false,
	            		url: '${pageContext.request.contextPath}/Category/nextStatusCategorys/'+data['statusId']+'.koala',
	            		type: 'POST',
	            		dataType: 'json',
	            	})
	            	.done(function(msg) {
	            		for (var i in msg['data'])
	            		{
	            			contents.push({title:msg['data'][i]['categoryName'] , value: msg['data'][i]['id']});
	            		}
	            		selectItems['statusIdID'] = contents;
	            	});
	            	debugger;
	                self.initPage(dialog.find('form'));
	                dialog.find(".none").css("display","none");
	                dialog.find("#touchTimeID").val(data['touchTime']);
	                dialog.find('#statusIdID .dropdown-menu').bind("click",function(){
	                	debugger;
		                switch($("#statusIdID input").val())
		                {
		                	case '91'://退回厂商
		                	case '90'://归还客户
		                		$(".none").css("display","none");
		                		$(".status1").css("display","block");
		                		break;
		                	case '89'://报废
		                		$(".none").css("display","none");
		                		$(".status2").css("display","block")
		                		break;
		                	case '88'://暂停使用
		                		$(".none").css("display","none");
		                		$(".status3").css("display","block")
		                		break;
		                	case '94'://开始保养
		                		$(".none").css("display","none");
		                		$(".status4").css("display","block")
		                		break;
		                	case '95'://结束保养
		                		$.get( '${pageContext.request.contextPath}/ProbeCardOptionLog/findLastProbeCardOptionLog/' + id + '.koala').done(function(json){
			 	                       json = json.data;
			 	                        var elm;
			 	                        for(var index in json){
			 	                        	if(index == "optUser")
		 	                        		{
		 	                        			continue;
		 	                        		}
			 	                            elm = dialog.find('#'+ index + 'ID');
			 	                            if(elm.hasClass('select')){
			 	                                elm.setValue(json[index]);
			 	                            }else{
			 	                                elm.val(json[index]);
			 	                            }
			 	                        }
			 	                        for(var i in json['maintenanceItems'].split(","))
		 	                        	{
		 	                        		$("input[name='"+json['maintenanceItems'].split(",")[i]+"']").attr("checked","checked");
		 	                        	}
			 	               	 	});
		                		$(".none").css("display","none");
		                		$(".status4").css("display","block")
		                		break;
		                	case '82'://开始维修
		                		$(".none").css("display","none");
		                		$(".status5").css("display","block")
		                		break;
		                	case '83'://结束维修
		                		$.get( '${pageContext.request.contextPath}/ProbeCardOptionLog/findLastProbeCardOptionLog/' + id + '.koala').done(function(json){
		 	                       json = json.data;
		 	                       debugger;
		 	                        var elm;
		 	                        if(json['maintenanceItems']!=""&&json['maintenanceItems']!=null)
		 	                        	{
		 	                        		var a=json['maintenanceItems'].split(",");
		 	                        		for(var i in a)
		 	                        			{
		 	                        				dialog.find("input[name='"+a[i]+"']").attr("checked","checked");
		 	                        			}
		 	                        	}
		 	                       	if(json['optDate']!="")
		 	                       		{
		 	                       			json['optDate']=json['optDate'].replace(" ","T");
		 	                       		}
		 	                        for(var index in json){
		 	                        	if(index == "optUser")
	 	                        		{
	 	                        			continue;
	 	                        		}
		 	                            elm = dialog.find('#'+ index + 'ID');
		 	                            if(elm.hasClass('select')){
		 	                                elm.setValue(json[index]);
		 	                            }else{
		 	                                elm.val(json[index]);
		 	                            }
		 	                        }
		 	               	 	});
		                		$(".none").css("display","none");
		                		$(".status5").css("display","block")
		                		break;
		                	case '81'://在库正常
		                		$(".none").css("display","none");
		                		$(".status6").css("display","block");
		                		$.get( '${pageContext.request.contextPath}/ProbeCardOptionLog/findLastProbeCardOptionLog/' + id + '.koala').done(function(json){
			 	                       json = json.data;
			 	                       debugger;
			 	                        var elm;
			 	                        for(var index in json){
			 	                        	if(index == "optUser")
		 	                        		{
		 	                        			continue;
		 	                        		}
			 	                            elm = dialog.find('#'+ index + 'ID');
			 	                            if(elm.hasClass('select')){
			 	                                elm.setValue(json[index]);
			 	                            }else{
			 	                                elm.val(json[index]);
			 	                            }
			 	                        }
			 	               	 	});
		                		break;
		                	case '86'://工程领用申请
		                	case '84'://生产领用申请
		                		$(".none").css("display","none");
		                		$(".status7").css("display","block")
		                		break;
		                	case '92'://待维修
		                	case '93'://待保养
		                		$(".none").css("display","none");
		                		$(".status8").css("display","block");
		                		break;
		                	case '80'://程序Release
		                		$(".none").css("display","none");
		                		$(".status9").css("display","block");
		                		break;
		                	case '87'://工程领出
		                	case '85'://生产领出
		                		$(".none").css("display","none");
		                		$(".status10").css("display","block")
		                		break;
		                	default:
		                		$(".none").css("display","none");
		                		break;
		                }
	                });
	                dialog.find('#platformID .dropdown-menu').bind("click",function(){
	                	$.ajax({
	                		async:false,
	                		url: '${pageContext.request.contextPath}/ChangeStatus/changeStatusList.koala',
	                		type: 'POST',
	                		data: {"testerCategoryId":$("#platformID input").val(),"category":"CP"},
	                		dataType: 'json',
	                	})
	                	.done(function(msg) {
	                		$(".equipNo").empty();
	                		$(".equipNo").next().hide();
	                		for (var i in msg['data'])
	                		{
	                			$(".equipNo").append("<span>"+msg['data'][i]['no']+": </span><input class='equipNoCheckbox' indexId="+msg['data'][i]['id']+" name="+msg['data'][i]['no']+" type='checkbox'>");
	                		}
	                	});
	                });
	                dialog.find("#optDateID").val((new Date()).Format("yyyy-MM-ddThh:mm"));
	                $.get('${pageContext.request.contextPath}/auth/currentUser/getUserDetail.koala').done(function(result){
		        		 dialog.find("#optUserID").val(result["data"]['userAccount']+"|"+result["data"]['name']);
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
	                    var a=$(".equipNoCheckbox");
	                    var string="";
	                    var stringId="";
	                    for(var j in a)
                    	{
	                    	if(a.eq(j).attr("checked")=="checked")
	                    		{
	                    			string+=a.eq(j).attr("name")+",";
	                    			//stringId+=a.eq(j).attr("indexid")+",";
	                    			stringId=a.eq(j).attr("indexid");
	                    		}
                    	}
	                    string=string.substring(0,string.length-1);
	                    //stringId=stringId.substring(0,stringId.length-1);
	                    if(($("#statusIdID input").val()==84||$("#statusIdID input").val()==86)&&string.split(",").length>1)
                		{
                    		dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: "请只选择一台机台"
	                            });
                    		return;
                		}
	                    $("#platformsID").val(string);
	                    $("#nowPlatformIdID").val(stringId);
	                    var b=$(".maintenanceCheckbox");
	                    string="";
	                    for(var j in b)
                    	{
	                    	if(b.eq(j).attr("checked")=="checked")
	                    		{
	                    			string+=b.eq(j).attr("name")+",";
	                    		}
                    	}
	                    string=string.substring(0,string.length-1);
	                    $("#maintenanceItemsID").val(string);
	                    debugger;
	                    $.post('${pageContext.request.contextPath}/ProbeCard/changeStatus.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	                            content: result.errorMessage
	                            });
	                        }
	                    });
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
	    	$.post('${pageContext.request.contextPath}/ProbeCard/delete.koala', data).done(function(result){
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
            params['pagesize']=1000;
            grid.getGrid().search(params);
        });
});
function probeDetilView(id){
	openTab('/pages/domain/ProbeCardOptionLog-list.jsp', 'Probe Card操作记录', 'menuMark204');
	ProbeCardGlobleId=id;
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
        <div class="form-group">
<!--          <label class="control-label" style="width:75px;float:left;">进场时间:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="inDate" id="inDateID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="inDateEnd" id="inDateID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div> -->
               <label class="control-label" style="width:100px;float:left;">配件编号:&nbsp;</label>
        <div style="margin-left:15px;float:left;">
            <input name="partNo" class="form-control" type="text" style="width:180px;" id="partNoID"  />
        </div>
        <label class="control-label" style="width:100px;float:left;">产品型号:&nbsp;</label>
        <div style="margin-left:15px;float:left;">
            <input name="productModel" class="form-control" type="text" style="width:180px;" id="productModelID"  />
        </div>
        <label class="control-label" style="width:100px;float:left;">客户名称:&nbsp;</label>
        <div style="margin-left:15px;float:left;">
            <input name="customerName" class="form-control" type="text" style="width:180px;" id="customerNameID"  />
        </div>
                  <label class="control-label" style="width:100px;float:left;">状态:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <div class="btn-group select" id="statusID"></div>
            <input name="status"  type="hidden" id="statusID_" />
        </div>
      </div>
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
