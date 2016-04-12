<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/pages/common/header.jsp"%>
	<%
	String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
	%>
	<title>Insert title here</title>
	<link href="<%=contextPath %>/css/docs.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=contextPath %>/lib/bootstrap-pagy.js"></script>
	<style>
		.col-md-12{
			padding:10px;
			width: 100%;
		    border: 2px dashed #ddd;
		    border-bottom: 0;
		}
		.pagination{
			margin:0;
			float:right;
		}
		.bs-docs-sidebar.affix{
			position:static;
		}
		#record-product .grid-table-body {
		  height: auto!important;
		}
		@media (max-width: 1399px) {
			#record-product .grid-table-body {
			  height: 150px!important;
			}
		}
		@media (min-width: 1400px) {
			#record-product .grid-table-body {
			  height: 300px!important;
			}
		}
	</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" role="complementary" id="platform-tree" style="overflow: auto;border: 2px dashed #ddd;;border-right: 0px solid #ddd;">
			<nav class="bs-docs-sidebar affix" style="padding: 10px;">
				<ul class="nav bs-docs-sidenav-product bs-docs-sidenav" style="margin-top:0px;"></ul>
			</nav>
		</div>
		<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
			<div class="row">
				<!-- 功能按键容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 productButton">
					<div class="btn-group buttons">
						<button class="btn btn-primary" type="button" onclick="buttonactionProduct('changeStats')">
							<span class="glyphicon glyphicon-new-window">挂状态</span></span>
						</button>
						<button class="btn btn-primary" type="button" onclick="buttonactionProduct('allchangeStats')">
							<span class="glyphicon glyphicon-new-window">批量转状态</span></span>
						</button>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- 平台列表容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 grid-list grid-list-product">
				</div>
			</div>
			<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12" style="padding-top: 4px;padding-bottom: 4px;">
				<div class="pagination pagination-product" style="margin:0;">
					<ul class="pagination"></ul>
				</div>
			</div>	
			</div>
			<div class="row">
				<!-- 信息tab页容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border-bottom:2px dashed #ddd;margin-bottom:10px">
					<ul class="nav nav-tabs" role="tablist" id="myTab">
						<li role="presentation" class="active">
							<a href="#message-product" aria-controls="message-product" role="tab" data-toggle="tab">基本信息</a>
						</li>
						<li role="presentation">
							<a href="#record-product" aria-controls="record-product" role="tab" data-toggle="tab">操作记录</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="message-product" style="padding: 20px;">
							<div class="row"></div>
						</div>
						<div role="tabpanel" class="tab-pane" id="record-product" style="width: 100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function unique(array) {
    return array.sort().join(",,").replace(/(,|^)([^,]+)(,,\2)+(,|$)/g,"$1$2$4").replace(/,,+/g,",").replace(/,$/,"").split(",");
}
var params={};
params['pagesize']="24";params['page']="0";
/*
 * 初始化grid函数
 */
function inintGridProduct(params){
	$.ajax({
		type : "POST",
		url : "/ChangeStatus/pageJson.koala",
		data : params,
		dataType : 'json',
		success : function(result){
			debugger;	
			if (!result.data) {
				$(".productButton").message({
					type : 'error',
					content : '查询失败'
				});
				return;
			}
			if (result.data.length == 0) {
				$(".productButton").message({
					type : 'error',
					content : '无数据可查'
				});
			} else {
				$(".pagination-product ul").empty();
				$(".pagination-product").data('bs.pagy',"");
				$(".pagination-product").pagy({
					totalPages: result.pageCount,
					currentPage: ++result.pageIndex,
					page: function(page) {
						params['page']=--page;
						inintGridProduct(params);
					}
				});
				//初始化设备展示
				$(".grid-list-product").empty();
				var data=result['data'];
				for(var a in data)
					{
						if(data[a]['categoryImageUrl']=="")
						{
							data[a]['categoryImageUrl']="/images/tester_3360_128.png";
						}
						$(".grid-list-product").append('<div class="col-xs-2 col-sm-2 col-md-2" id="'+data[a]['id']+'" version="'+data[a]['version']+'" style="padding: 0;padding-right: 1%;margin-bottom:10px;" type="'+data[a]['type']+'">'+
								'<div class="thumbnail">'+
								'<div class="colorRoom" style="background-color:'+statusColor(data[a]['status'])+'">'+
								'<img src="'+data[a]['categoryImageUrl']+'" alt="..." style="width:69%;">'+
								'</div>'+
								'<div class="caption">'+
								'<h5><strong>'+data[a]['no']+'</strong></h5>'+
								'<h6><i>-'+data[a]['equipmentNo']+'</i></h6>'+
								'<p>类型:'+data[a]['category']+'</p>'+
								'<p>状态:'+data[a]['status']+'</p>'+
								'<p style="white-space: nowrap;overflow: hidden;">产品:'+data[a]['productModel']+'</p>'+
								/* '<p>组成:'+data[a]['equipmentNos'][0]+'+'+data[a]['equipmentNos'][1]+'</p>'+ */
								'</div>'+
								'</div></div>');
						if(a=='0'){
							debugger;
							if(data[a]['type']=="equipment"){
								$.get( '${pageContext.request.contextPath}/Equipment/get/' + data[a]['id'] + '.koala').done(function(json){
									$("#message-product").children("div").empty();   
									var translate='{"acceptanceList":"验收单","responsible":"责任人","sn":"S/N","status":"状态","category":"设备型号","equipmentCategory":"设备分类","maintenanceStartDate":"保养起始日期","equipmentLocation":"设备位置","agent":"代理人","checkInTime":"登记时间","lastModifyEmployNo":"修改人","repairCycle":"维护周期","createEmployNo":"创建人","equipmentNo":"设备编号","composability":"是否可组装"}';
									var translateobj=eval('(' + translate + ')');
									for(var b in json['data'])
										{
											if(translateobj[b]!=undefined)
											{
												if(translateobj[b]=="验收单")
												{
													$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : <a download  href="'+json['data'][b]+'">下载</a></div>');
												}
												else if(translateobj[b]=="维护周期")
												{
													var repairCycle="";
													if(data[0]['repairCycleMonth']=="on")
													{
														repairCycle+="月,";
													}
													if(data[0]['repairCycleSeason']=="on")
													{
														repairCycle+="季,";
													}
													if(data[0]['repairCycleYear']=="on")
													{
														repairCycle+="年,";
													}
													repairCycle=repairCycle.substring(0,repairCycle.length-1);
													$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+repairCycle+'</div>');
												}
												else{
													$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
												}
											}
										}
									$("#record-product").empty();
									$("#record-product").data("koala.grid","");
									recordGetEquipProduct(data[0]['id']);
				                });
							}
							else{
								$.get( '${pageContext.request.contextPath}/Platform/get/' + data[a]['id'] + '.koala').done(function(json){
									$("#message-product").children("div").empty();
									var translate='{"platformCategory":"平台分类","platformNo":"平台编号","createTimestamp":"创建时间","platformName":"平台名称","createEmployNo":"创建人","status":"状态","checkInTime":"进厂时间","equipmentNos":"组装设备","ip":"IP地址","isAuto":"是否自动获取数据"}';
									var translateobj=eval('(' + translate + ')');
									for(var b in json['data'])
										{
											if(translateobj[b]!=undefined)
												{
													$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
												}
											
										}
									$("#record-product").empty();
									$("#record-product").data("koala.grid","");
									recordGetProduct(data[0]['id']);
				                });
							}
						}
					}
				//绑定设备框点击查询基础信息及操作记录
				$(".grid-list-product").children("div").bind("click",function(){
					$(".grid-list-product").children("div").removeClass("active");
					$(".grid-list-product").children("div").children(".thumbnail").css("border-color","#ddd");
					$(this).children(".thumbnail").css("border-color","#428bca");
					$(this).addClass("active");
					var id = $(this).attr("id")
					var type = $(this).attr("type");
					if(type=="equipment"){
						$.get( '${pageContext.request.contextPath}/Equipment/get/' + id + '.koala').done(function(json){
							$("#message-product").children("div").empty();   
							var translate='{"acceptanceList":"验收单","responsible":"责任人","sn":"S/N","status":"状态","category":"设备型号","equipmentCategory":"设备分类","maintenanceStartDate":"保养起始日期","equipmentLocation":"设备位置","agent":"代理人","checkInTime":"登记时间","lastModifyEmployNo":"修改人","repairCycle":"维护周期","createEmployNo":"创建人","equipmentNo":"设备编号","composability":"是否可组装"}';
							var translateobj=eval('(' + translate + ')');
							for(var b in json['data'])
								{
									if(translateobj[b]!=undefined)
										{
											if(translateobj[b]=="验收单")
											{
												$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : <a download  href="'+json['data'][b]+'">下载</a></div>');
											}
											else if(translateobj[b]=="维护周期")
											{
												var repairCycle="";
												if(json['data']['repairCycleMonth']=="on")
												{
													repairCycle+="月,";
												}
												if(json['data']['repairCycleSeason']=="on")
												{
													repairCycle+="季,";
												}
												if(json['data']['repairCycleYear']=="on")
												{
													repairCycle+="年,";
												}
												repairCycle=repairCycle.substring(0,repairCycle.length-1);
												$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+repairCycle+'</div>');
											}
											else{
												$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
											}
										}
								}
							$("#record-product").empty();
							$("#record-product").data("koala.grid","");
							recordGetEquipProduct(id);
		                });
					}
					else{
						$.get( '${pageContext.request.contextPath}/Platform/get/' + id + '.koala').done(function(json){
							$("#message-product").children("div").empty();
							var translate='{"platformCategory":"平台分类","platformNo":"平台编号","createTimestamp":"创建时间","platformName":"平台名称","createEmployNo":"创建人","status":"状态","checkInTime":"进厂时间","equipmentNos":"组装设备","ip":"IP地址","isAuto":"是否自动获取数据"}';
							var translateobj=eval('(' + translate + ')');
							for(var b in json['data'])
								{
									if(translateobj[b]!=undefined)
										{
											$("#message-product").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
										}
									
								}
							$("#record-product").empty();
							$("#record-product").data("koala.grid","");
							recordGetProduct(id);
		                });
					}
				})
				setTimeout(function(){$("#platform-tree").height($("#platform-tree").next().height()-14);}, 500);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
			self.$element.message({
				type : 'error',
				content : '查询失败'
			});
			return;
		}
	});
}
//设备操作记录查询生成
function recordGetEquipProduct(id)
{
	var grid;
	var _dialog;
	    grid = $("#record-product");
		PageLoader = {
		   //            	                	            	                	            	                	            	        	     },
		    initGridPanel: function(){
		         var self = this;
		         var width = 120;
		         return grid.grid({
		        	 	isShowPages:false,
		        	 	isShowButtons:false,
		        	 	isShowIndexCol:false,
		                identity:"id",
		                pageSize : 1000,
		                buttons: [
		                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
		                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
		                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
		                    ],
		                url:"${pageContext.request.contextPath}/EquipmentOptionLog/pageJson.koala",
		                columns: [
	       	                         { title: '状态', name: 'status', width: width, render: function (rowdata, name, index){
		       	                    	 	var h="<div style='background-color:"+statusColor(rowdata[name])+"'>"+rowdata[name]+"</div>"
		       	                    	 	return h;
		                             	 }
	       	                         },
	       	                         { title: '子状态', name: 'subStatus', width: width},
	       	                      	 { title: '当前批次', name: 'nowLot', width: 135},
	       	                      	 { title: '当前站别', name: 'nowStation', width: width},
	       	                      	 { title: '产品型号', name: 'productModel', width: width},
	       	                      	 { title: '操作备注', name: 'optRemark', width: 180},
	       	                      	 { title: '产出', name: 'touchTimes', width: width},
	       	                      	 { title: '开始时间', name: 'startTime', width: width},
	    	                         { title: '结束时间', name: 'endTime', width: width},
	    	                         { title: '状态时间(min)', name: 'duration', width: 150},
	       	                         { title: '操作人', name: 'optUser', width: width},
	       	                         { title: '操作日期', name: 'optDate', width: width},
	       	                         { title: '结束人员', name: 'endOptUser', width: width},
	       	                         { title: '标准工时', name: 'standardWorkHours', width: width},
	       	                         { title: 'grossDie', name: 'grossDie', width: width},
	       	                         { title: '理论时间', name: 'theoryTime', width: width},
	       	                         { title: 'INK类型', name: 'inkType', width: width},
	       	                   		 { title: '完工片数', name: 'cpCompletedNum', width: width},
	       	                      	 { title: '完工片选', name: 'completedChip', width: width},
	       	                      	 { title: '片数详情', name: 'completedChipDescription', width: width},
	       	                      	 { title: '片选', name: 'chipSelection', width: 200},
	       	                      	 { title: '片选备注', name: 'chipSelectionRemark', width: 200},
	       	                         { title: '接触次数', name: 'touchTimes', width: width},
	       	                      	 { title: '配件编号', name: 'pcNo', width: 260},
	       	                      	 { title: '分类', name: 'category', width: width},
	       	                         { title: '班别', name: 'team', width: width},
	       	                         { title: '交接班', name: 'isShift', width: width}
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
		        $.get('<%=path%>/Category-add.jsp').done(function(html){
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
		              $.post('${pageContext.request.contextPath}/Category/add.koala', dialog.find('form').serialize()).done(function(result){
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
		        $.get('<%=path%>/Category-update.jsp').done(function(html){
		               dialog.find('.modal-body').html(html);
		               self.initPage(dialog.find('form'));
		               $.get( '${pageContext.request.contextPath}/Category/get/' + id + '.koala').done(function(json){
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
		                    $.post('${pageContext.request.contextPath}/Category/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
		    	$.post('${pageContext.request.contextPath}/Category/delete.koala', data).done(function(result){
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
		grid.data("koala.grid","");
		grid.empty();
		PageLoader.initGridPanel();
		grid.getGrid().searchCondition['equipmentId']=id;
		//params['equipmentId']=id;
}
//平台操作记录查询
function recordGetProduct(id)
{
	var grid;
	var _dialog;
	    grid = $("#record-product");
		PageLoader = {
		   //            	                	            	                	            	                	            	        	     },
		    initGridPanel: function(){
		         var self = this;
		         var width = 120;
		         return grid.grid({
		        	 	isShowPages:false,
		        	 	isShowButtons:false,
		        	 	isShowIndexCol:false,
		                identity:"id",
		                pageSize : 1000,
		                buttons: [
		                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
		                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
		                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
		                    ],
		                url:"${pageContext.request.contextPath}/PlatformOptionLog/pageJson.koala",
		                columns: [
	       	                         { title: '状态', name: 'status', width: width, render: function (rowdata, name, index){
		       	                    	 	var h="<div style='background-color:"+statusColor(rowdata[name])+"'>"+rowdata[name]+"</div>"
		       	                    	 	return h;
		                             	 }
	       	                         },
	       	                         { title: '子状态', name: 'subStatus', width: width},
	       	                      	 { title: '当前批次', name: 'nowLot', width: 135},
	       	                      	 { title: '当前站别', name: 'nowStation', width: width},
	       	                      	 { title: '产品型号', name: 'productModel', width: width},
	       	                      	 { title: '操作备注', name: 'optRemark', width: 180},
	       	                      	 { title: '产出', name: 'touchTimes', width: width},
	       	                      	 { title: '开始时间', name: 'startTime', width: width},
	    	                         { title: '结束时间', name: 'endTime', width: width},
	    	                         { title: '状态时间(min)', name: 'duration', width: 150},
	       	                         { title: '操作人', name: 'optUser', width: width},
	       	                         { title: '操作日期', name: 'optDate', width: width},
	       	                         { title: '结束人员', name: 'endOptUser', width: width},
	       	                         { title: '标准工时', name: 'standardWorkHours', width: width},
	       	                         { title: 'grossDie', name: 'grossDie', width: width},
	       	                         { title: '理论时间', name: 'theoryTime', width: width},
	       	                         { title: 'INK类型', name: 'inkType', width: width},
	       	                      	 { title: '完工片数', name: 'cpCompletedNum', width: width},
	       	                      	 { title: '完工片选', name: 'completedChip', width: 205},
	       	                      	 { title: '片数详情', name: 'completedChipDescription', width: 205},
	       	                      	 { title: '片选', name: 'chipSelection', width: 200},
	       	                      	 { title: '片选备注', name: 'chipSelectionRemark', width: 200},
	       	                         { title: '接触次数', name: 'touchTimes', width: width},
	       	                      	 { title: '配件编号', name: 'pcNo', width: 260},
	       	                      	 { title: '分类', name: 'category', width: width},
	       	                         { title: '班别', name: 'team', width: width},
	       	                         { title: '交接班', name: 'isShift', width: width}
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
		        $.get('<%=path%>/Category-add.jsp').done(function(html){
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
		              $.post('${pageContext.request.contextPath}/Category/add.koala', dialog.find('form').serialize()).done(function(result){
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
		        $.get('<%=path%>/Category-update.jsp').done(function(html){
		               dialog.find('.modal-body').html(html);
		               self.initPage(dialog.find('form'));
		               $.get( '${pageContext.request.contextPath}/Category/get/' + id + '.koala').done(function(json){
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
		                    $.post('${pageContext.request.contextPath}/Category/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
		    	$.post('${pageContext.request.contextPath}/Category/delete.koala', data).done(function(result){
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
		grid.data("koala.grid","");
		grid.empty();
		PageLoader.initGridPanel();
		grid.getGrid().searchCondition['platformId']=id;
		//params['platformId']=id;
}
//功能按钮绑定函数接口函数
function buttonactionProduct(action){
	var id=$('.grid-list-product').children('.active').attr('id');
	var type=$('.grid-list-product').children('.active').attr('type');
	if(action=='add'){
		add();
	}
	else if(action=="allchangeStats"){
		$('.productButton').confirm({
            content: '确定要交接班转系统?',
            callBack: allchangeStats
        });
	}
	else if(id!=undefined)
		{
			switch(action){
				case 'changeStats':
					if($('.grid-list-product').children('.active').find("p").eq(1).text().split(":")[1]=="ENGINEERING")
						{
							$('.productButton').message({
					            type: 'warning',
					            content: '请到借机管理中办理还机'
					        })
					        return;
						}
					changeStats(id,type);
					break;
				default:
				break;
			}
		}
	else{
		$('.productButton').message({
            type: 'warning',
            content: '请选择一条记录进行操作'
        })
        return;
	}
}
//批量转状态
function allchangeStats(){
	$.get('${pageContext.request.contextPath}/Platform/changePlatformStatusAll.koala.koala').done(function(msg){
   		debugger;
		if(msg['success']!=true)
		{
    		$(".productButton").message({
                type: 'error',
                content: msg['errorMessage']
            });
    		return;
		}
		else{
			$(".productButton").message({
                type: 'success',
                content: '批量转状态成功'
            });
		}
   	});
}
//改变状态
function changeStats(id,type){
	var self = this;
    var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 750px;">'
    	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
    	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
    	+'<h4 class="modal-title">设备状态变更</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
    	+'</div></form></div><div class="modal-footer">'
    	+'<button type="button" class="btn btn-default" id="cancle" data-dismiss="modal">取消</button>'
    	+'<button type="button" class="btn btn-default" id="prv">上一步</button>'
    	+'<button type="button" class="btn btn-success" id="next">下一步</button>'
    	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
    	+'</div></div>');
    $.get('<%=path%>/Platform-change.jsp').done(function(html){
        dialog.find('.modal-body').html(html);
        //初始化可供选择的主状态
        localStorage['productName']="";
        var equiType=$('.grid-list-product').children('.active').find("p").eq(0).text().split(":")[1];
        var contents = [{title:'请选择', value: ''}];
        $.ajax({
        	async:false,
        	url: '${pageContext.request.contextPath}/Category/getByType/76.koala?type='+equiType,
        	type: 'POST',
        	dataType: 'json',
        })
        .done(function(msg) {
        	for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        	{
        		contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        	}
        	selectItems['statusIdID'] = contents;
        });
        //初始化可供选择的procard数据
        var contents = [{title:'请选择', value: ''}];
   	    $.ajax({
   	    	async:false,
   	    	url: '${pageContext.request.contextPath}/ProbeCard/getProbeCardByPlatformId/'+id+'.koala',
   	    	type: 'GET',
   	    	dataType: 'json',
   	    })
   	    .done(function(msg) {
   	    	debugger;
   	    	for (var i in msg['data'])
   	    	{
   	    		contents.push({title:msg['data'][i]['partNo'] , value: msg['data'][i]['id']});
   	    	}
   	    	selectItems['partIdsID'] = contents;
   	    });
	   	 var contents = [{title:'请选择', value: ''}];
	     $.ajax({
	     	async:false,
	     	url: '${pageContext.request.contextPath}/Socket/productAll.koala?nowPlatformId='+id,
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
	     });
	     var contents = [{title:'请选择', value: ''}];
	     $.ajax({
	     	async:false,
	     	url: '${pageContext.request.contextPath}/Kits/productAll.koala?nowPlatformId='+id,
	     	type: 'POST',
	     	dataType: 'json',
	     })
	     .done(function(msg) {
	     	for (var i in msg)
	     	{
	     		contents.push({title:msg[i]['partNo'] , value: msg[i]['id']});
	     	}
	     	selectItems['KitsID'] = contents;
	     });
	     var contents = [{title:'请选择', value: ''}];
	     $.ajax({
	     	async:false,
	     	url: '${pageContext.request.contextPath}/LoadBoard/productAll.koala?nowPlatformId='+id,
	     	type: 'POST',
	     	dataType: 'json',
	     })
	     .done(function(msg) {
	     	for (var i in msg)
	     	{
	     		contents.push({title:msg[i]['partNo'] , value: msg[i]['id']});
	     	}
	     	selectItems['loadBoardID'] = contents;
	     });
	    self.initPage(dialog.find('form'));
	    dialog.find("#versionID").val($('.grid-list-product').children('.active').attr('version'));
	    //绑定点击主状态查询可供选择的子状态
        dialog.find('#statusIdID .dropdown-menu').bind("click",function(){
    		var typearray=$("#statusIdID input").val();
    		var statusSelect=$("#statusIdID button[data-toggle='item']").text();
/*     		if(statusSelect=="IDLE"||statusSelect=="停机"){
    			$("#nowLotID").val("NA");
    		} */
    		$.ajax({
    			async:false,
    			url: '${pageContext.request.contextPath}/Category/get/'+typearray+'.koala',
    			type: 'POST',
    			dataType: 'json',
    		})
    		.done(function(msg) {
    			var contents = [{title:'请选择', value: ''}];
    			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
    			{
    				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
    			}
    			//dialog.find("#subStatusIdID").data('koala.select',null);
    			var partIdobj=dialog.find('#subStatusIdID');
    			//partIdobj['context']=partIdobj[0];
    			partIdobj.select({
                    title: '请选择',
                    contents: contents
                }).on('change', function(){
                	debugger;
                	//根据选择的子状态判断是否带出上一状态批次的信息
                	dialog.find('#subStatusIdID_').val($(this).getValue());
                	var statusSelect=$("#statusIdID button[data-toggle='item']").text();
                	if(statusSelect!="停机"&&$(this).data("koala.select").$item.text()!="不同批号换批"&&$(this).getValue()!=undefined)
               		{
                		$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+id+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
               	    		dialog.find("#nowStationID").val(msg['data']['nowStation']);
               	    		dialog.find("#nowLotID").val(msg['data']['nowLot']);
               	    		dialog.find("#nowProductID").val(msg['data']['nowProduct']);
               	    		dialog.find("#beforeTestQtyID").val(msg['data']['lastTestNo']);
               	    	});
               		}
                	else{
                		$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+id+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
                			localStorage['productName']=msg['data']['nowProduct'];
               	    	});
                		dialog.find("#nowStationID").val();
           	    		dialog.find("#nowLotID").val();
           	    		dialog.find("#nowProductID").val();
           	    		dialog.find("#beforeTestQtyID").val();
                	}
                });
    		});
		});
	    //根据选择的设备状态生成对应的挂状态页面
   	    if(equiType=="FT"||equiType=="taping"){
   	    	dialog.find(".part_CP").remove();
   	    	dialog.find(".part_OVEN").remove();
   	    	$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+id+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
   	    		debugger;
   	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
   	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
   	    		dialog.find("#nowProductIDPrv").val(msg['data']['productModel']);
   	    		dialog.find("#beforeTestQtyID").val(msg['data']['lastTestNo']);
   	    		dialog.find("#testQtyID").val(msg['data']['lastTestNo']);
   	    		
   	    		dialog.find("#grossDieID").val(msg['data']['grossDie']);
   	    		dialog.find("#standardWorkHoursID").val(msg['data']['standardWorkHours']);
   	    		dialog.find("#teamID").val(msg['data']['team']);
   	    		dialog.find("#touchdownID").val(msg['data']['touchdown']);
   	    		
   	    		var array=msg['data']['partIds'].split(",");
   	    		for(var j in array)
	   			{
	   				dialog.find("#partIds"+j+"ID").setValue(array[j]);
	   			}
   	    		dialog.find("#KitsID").setValue(msg['data']['kitsId']);
   	    		dialog.find("#loadBoardID").setValue(msg['data']['loadBoardId']);
   	    	});
   	    	$.get('${pageContext.request.contextPath}/TestData/ft.koala?id='+id).done(function(msg){//获取机台生产数据
   	    		if(msg['success']==false){
   	    			$(".productButton").message({
	   	                 type: 'error',
	   	                content: msg['errorMessage']
	   	            });
   	    			dialog.find("#siteTestQtyID").val(",,,");
   	    		}
   	    		else{
   	    			dialog.find("#testQtyID").val(msg['data']['tested']);
   	   	    		dialog.find("#siteTestQtyID").val(msg['data']['site0']+","+msg['data']['site1']+","+msg['data']['site2']+","+msg['data']['site3']);
   	    		}
   	    	});
/*    	    $.get('${pageContext.request.contextPath}/Socket/getSocketByPlatformId/'+id+'.koala').done(function(msg){
   	    		for(var j in msg['data'])
   	    			{
   	    				dialog.find("#partIds"+msg['data'][j]['platformSite']+"ID").setValue(msg['data'][j]['id'])
   	    			}
   	    	}); */
   	    	dialog.find("#nowLotID").on("focusout",function(){
   	    		$.ajax({ 
   	    			type: "get", 
   	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$("#nowLotID").val()+"&category=FT", 
   	    			success: function (result) {
   	    				var data=eval("(" + result.documentElement.textContent + ")");
   	    				debugger;
   	    				dialog.find("#nowProductID").val(data['productModel']);
   	    				dialog.find("#nowStationID").val(data['nowStation']);
   	    				
   	    				dialog.find("#grossDieID").val(data['grossDie']);
   	    	    		dialog.find("#standardWorkHoursID").val(data['standardWorkHours']);
   	    	    		dialog.find("#teamID").val(data['team']);
   	    	    		dialog.find("#touchdownID").val(data['touchdown']);
   	    				if(localStorage['productName']!=undefined&&localStorage['productName']!="")
    					{
    						if(localStorage['productName']!=data['productModel'])
    							{
	    							alert("与上批次测试的产品型号不同，请联系技术员确认是否已更换对应设备配件！");
    							}
    					}
   	    			} 
   	    		});
   	    	})
        }
   	    else if(equiType=="CP"||equiType=="ink"){
   	    	dialog.find(".part_FT").remove();
   	    	dialog.find(".part_OVEN").remove();
/*    	    	$.get('${pageContext.request.contextPath}/ProbeCard/getProbeCardByPlatformId/'+id+'.koala').done(function(msg){
   	    		 dialog.find("#partIdsID").setValue(msg['data'][0]['id'])
   	    	}); */
   	    	dialog.find('.pianxuanRoom input').bind("click",function(){
   	    		if($(this).attr("checked")=="checked")
    			{
   	    			$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").val("");
   	    			$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").css("background-color","#eee");
    				$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").attr("readonly","readonly");
    			}
   	    		else{
   	    			$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").val("");
   	    			$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").css("background-color","#fff");
   	    			$(".pianxuanBeizhuRoom input[index='"+$(this).attr("index")+"']").removeAttr("readonly");
   	    		}
   	    	});
  	    	var lastOptUrl="";
  	    	if(equiType=="ink")
	    		{
  	    		lastOptUrl="Equipment/getLastEquipmentOptionLog";
	    		}
  	    	else{
  	    		lastOptUrl="Platform/getLastPlatformOptionLog";
  	    	}
  	    	debugger;
  	    	$.get('${pageContext.request.contextPath}/'+lastOptUrl+'/'+id+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
   	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
   	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
   	    		dialog.find("#nowProductIDPrv").val(msg['data']['productModel']);
   	    		
   	    		dialog.find("#grossDieID").val(msg['data']['grossDie']);
   	    		dialog.find("#standardWorkHoursID").val(msg['data']['standardWorkHours']);
   	    		dialog.find("#teamID").val(msg['data']['team']);
   	    		dialog.find("#touchdownID").val(msg['data']['touchdown']);
   	    		for(var i in msg['data']['chipSelection'].split(","))
	   			{
   	    			dialog.find(".pianxuanRoom input[index='"+Number(msg['data']['chipSelection'].split(",")[i])+"']").attr("checked","checked");
   	    			dialog.find(".pianxuanRoom input[index='"+Number(msg['data']['chipSelection'].split(",")[i])+"']").attr("disabled","disabled");
   	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data']['chipSelection'].split(",")[i])+"']").val("");
   	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data']['chipSelection'].split(",")[i])+"']").css("background-color","#eee");
   	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data']['chipSelection'].split(",")[i])+"']").attr("readonly","readonly");
	   			}
   	    		for(var j in msg['data']['chipSelectionRemark'].split(","))
    			{
    				if(msg['data']['chipSelectionRemark'].split(",")[j]!="")
   					{
    					dialog.find(".pianxuanBeizhuRoom input[index='"+(Number(j)+1)+"']").val(msg['data']['chipSelectionRemark'].split(",")[j]);
   					}
    			}
	   			dialog.find("#partIdsID").setValue(msg['data']['partIds']);
   	    	});
  	    	$.get('${pageContext.request.contextPath}/TestData/cp.koala?id='+id).done(function(msg){//获取机台生产数据
  	    		debugger;
  	    		//msg={"data":[{"waferId":"10","tested":"40","touchDown":"33"},{"waferId":"11","tested":"46","touchDown":"37"},{"waferId":"12","tested":"31","touchDown":"28"},{"waferId":"13","tested":"48","touchDown":"37"}],"errorMessage":null,"hasErrors":false,"success":true};
  	    		if(msg['success']==false){
   	    			$(".productButton").message({
	   	                type: 'error',
	   	                content: msg['errorMessage']
	   	            });
   	    		}
   	    		else{
   	    			if(dialog.find("#grossDieID").val()!=0&&dialog.find("#grossDieID").val()!="")
   	    				{
   	    					var waferTD=0;
	   	    				for(var a in msg['data']){
	   	    					waferTD+=Number(msg['data'][a]['touchDown']);
	   	    					if(msg['data'][a]['tested']==dialog.find("#grossDieID")||msg['data'][a]['isFinish']==true)
	   	    					{
	   	    						dialog.find(".pianxuanRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").attr("checked","checked");
		   	    	    			dialog.find(".pianxuanRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").attr("disabled","disabled");
		   	    	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").val("");
		   	    	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").css("background-color","#eee");
		   	    	    			dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").attr("readonly","readonly");
	   	    					}else{
	   	    						dialog.find(".pianxuanBeizhuRoom input[index='"+Number(msg['data'][a]['waferId'])+"']").val(msg['data'][a]['tested']);
	   	    					}
	   	    					
	   	   	    			}
	   	    				$("#waferTDID").val(waferTD);
   	    				}
   	    			
   	    		}
   	    	});
   	    	dialog.find("#nowLotID").on("focusout",function(){
   	    		$.ajax({ 
   	    			type: "get", 
   	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$("#nowLotID").val()+"&category=CP", 
   	    			success: function (result) {
   	    				var data=eval("(" + result.documentElement.textContent + ")");
   	    				dialog.find("#nowProductID").val(data['productModel']);
   	    				dialog.find("#nowStationID").val(data['nowStation']);
   	    				
   	    				dialog.find("#grossDieID").val(data['grossDie']);
   	    	    		dialog.find("#standardWorkHoursID").val(data['standardWorkHours']);
   	    	    		dialog.find("#teamID").val(data['team']);
   	    	    		dialog.find("#touchdownID").val(data['touchdown']);
   	    				if(localStorage['productName']!=undefined&&localStorage['productName']!="")
    					{
    						if(localStorage['productName']!=data['productModel'])
    							{
	    							alert("与上批次测试的产品型号不同，请联系技术员确认是否已更换对应设备配件！");
    							}
    					}
   	    			} 
   	    		});
   	    	})
   	    }
   	    else if(equiType=="oven"||equiType=="leadscan"){
   	    	dialog.find(".part_CP").remove();
   	    	dialog.find(".part_FT").remove();
   	    	dialog.find("#nowStationID").val('烘烤');
   	    	if(equiType="leadscan")
	   		{
	   			dialog.find("#nowStationID").val('LeadScan');
	  	    	dialog.find(".part_OVEN").remove();
	   		}
   	    	dialog.find('#productQtyID .dropdown-menu').bind("click",function(){
   	    		$("#nowLotID").hide();
   	   	    	$("#nowProductID").hide();
   	    		var typearray=$("#productQtyID input").val();
   	    		$(".nowLotChildRoom").empty();
   	    		$(".nowProductChildRoom").empty();
				for(var i=1; i<=typearray;i++)
					{
						$(".nowLotChildRoom").append("<input class='col-md-2' index='"+i+"' style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;'/>");
						$(".nowProductChildRoom").append("<input class='col-md-2' index='"+i+"' readonly style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;background-color:#eee'/>");
					}
				dialog.find(".nowLotChildRoom input").on("focusout",function(){
					var index=$(this).attr('index');
	   	    		$.ajax({ 
	   	    			type: "get", 
	   	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$(this).val()+"&category=CP", 
	   	    			success: function (result) {
	   	    				var data=eval("(" + result.documentElement.textContent + ")");
	   	    				if($(".nowProductChildRoom input[index='"+index+"']").val()=="")
	   	    				{
	   	    					$(".nowProductChildRoom input[index='"+index+"']").val(data['productModel']);
	   	    				}
	   	    			} 
	   	    		});
	   	    	})
	   	    	dialog.find(".nowLotChildRoom input").on("focusout",function(){
	   	    		var index=$(this).attr('index');
	   	    		$.ajax({ 
	   	    			type: "get", 
	   	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$(this).val()+"&category=FT", 
	   	    			success: function (result) {
	   	    				var data=eval("(" + result.documentElement.textContent + ")");
	   	    				if($(".nowProductChildRoom input[index='"+index+"']").val()=="")
	   	    				{
	   	    					$(".nowProductChildRoom input[index='"+index+"']").val(data['productModel']);
	   	    				}
	   	    			} 
	   	    		});
	   	    	})
   			});
   	    	
   	    }
	    //绑定页面点击上一步下一步的按钮事件
   	 	dialog.find(".prvShow").show();
   		dialog.find(".nextShow").hide();
   		dialog.find("#next").show();
   		dialog.find("#prv").hide();
   		dialog.find("#save").hide();
   	 	dialog.find('#next').on('click', function(e){
   	 		if(equiType=="FT"){
   	 			if($("#testQtyID").val()=="")
 				{
	   	 			showErrorMessage($("#testQtyID").closest('.modal'), $("#testQtyID"), "该字段不能为空");
	 				return;
 				}
   	 		}
   	 		dialog.find("#save").show();
   	 		dialog.find("#cancle").hide();
   	   		dialog.find("#next").hide();
   	   		dialog.find("#prv").show();
   	 		dialog.find(".prvShow").hide();
   			dialog.find(".nextShow").show();
   	 	});
   	 	dialog.find('#prv').on('click', function(e){
   	 		dialog.find("#save").hide();
   	 		dialog.find("#cancle").show();
   	   		dialog.find("#next").show();
   	   		dialog.find("#prv").hide();
   	 		dialog.find(".prvShow").show();
   	 		dialog.find(".nextShow").hide();
	 	});
   	 	if(equiType=="oven"||equiType=="leadscan"){
   	 		dialog.find("#save").show();
   	 		dialog.find("#cancle").show();
   	   		dialog.find("#next").hide();
   	   		dialog.find("#prv").hide();
   	 		dialog.find(".prvShow").remove()
   	 		dialog.find(".nextShow").show();
   	 	}
	    if(type=="platform"){
		    $.get('${pageContext.request.contextPath}/Platform/findEquipmentByPlatform/'+id+'.koala').done(function(msg){
		    	if(msg['data'][0]==null)
	    		{
		    		$(".grid-list-product").message({
		                type: 'error',
		                content: '该平台未组合设备无法挂状态'
		            });
		    		return;
	    		}
			    dialog.modal({
			        keyboard:false
			    }).on({
			        'hidden.bs.modal': function(){
			            $(this).remove();
			        }
			    });
		    	dialog.find('#save').on('click', function(e){
		    	  if($("#statusIdID input").val()=="45"||$("#statusIdID input").val()=="67"||$("#statusIdID input").val()=="105"||$("#statusIdID input").val()=="107")
	        	  {
		    		$(".part_CP #partIdsID_").attr("dataType","Require");
	        	  }
		    	  debugger;
		          if(!Validator.Validate(dialog.find('form')[0],3))return;
		          var string="";
		          if(equiType=="FT"){
		        	  debugger;
		        	  var array=[];
		        	  for(var a=0;a<$("input[id*=partIds]").length;a++)
	        		  {
	        		  	if($("input[id*=partIds]").eq(a).val()!="")
	        		  	array.push($("input[id*=partIds]").eq(a).val());
	        		  }
		        	  array=array.sort();
		        	  if($("#statusIdID input").val()=="45"||$("#statusIdID input").val()=="67"||$("#statusIdID input").val()=="105"||$("#statusIdID input").val()=="107")
	        		  {
		        		  if(array.length==0)
	        			  {
		        			  dialog.find('.modal-content').message({
			                        type: 'error',
			                        content: "请至少选择一个Socket"
			                  });
		        			  return;
	        			  }
		        		  if($("input[id='KitsID_']").val()==""){
		        			  dialog.find('.modal-content').message({
			                        type: 'error',
			                        content: "请至少选择一个Kits"
			                  });
		        			  return;
		        		  }
		        		  if($("input[id='loadBoardID_']").val()==""){
		        			  dialog.find('.modal-content').message({
			                        type: 'error',
			                        content: "请至少选择一个loadBoard"
			                  });
		        			  return;
		        		  }
	        		  }
		        	  for(var i=0;i<array.length;i++){ 
		        		  if (array[i]==array[i+1]){ 
		        			  dialog.find('.modal-content').message({
			                        type: 'error',
			                        content: "不能选择重复的socket，请检查"
			                  });
			        		  return;
		        		  }
		        	  }
		        	  var array=dialog.find('form').serializeArray();
	  		          $("#partIdsID_").val($("#partIds0ID_").val()+","+$("#partIds1ID_").val()+","+$("#partIds2ID_").val()+","+$("#partIds3ID_").val());
	  		          string=dialog.find('form').serialize();
		          }
		          else{
		        	  var string1="";
		        	  var string2="";
		        	  var a=$(".pianxuanRoom input");
		        	  for(var i=0;i<a.length;i++)
		        	  {
		        		  if(a.eq(i).attr("checked")=="checked")
	        			  {
	        			  	string1+=a.eq(i).attr("index")+",";
	        			  }
		        	  		
		        	  }
			          string1=string1.substring(0,string1.length-1);
			          $("#pianxuanID").val(string1);
			          var a=$(".pianxuanBeizhuRoom input");
		        	  for(var i=0;i<a.length;i++)
		        	  {
		        		  string2+=a.eq(i).val()+",";
		        	  		
		        	  }
		        	  string2=string2.substring(0,string2.length-1);
			          $("#pianxuanBeizhuID").val(string2);
		        	  string=dialog.find('form').serialize();
		          }
		          debugger;
		          $.post('${pageContext.request.contextPath}/Platform/changePlatformStatus.koala?id='+id, string).done(function(result){
		               if(result.success == true){
		                    dialog.modal('hide');
		                    inintGridProduct(params);
		                    $(".grid-list-product").message({
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
		}
		else{
		    dialog.modal({
		        keyboard:false
		    }).on({
		        'hidden.bs.modal': function(){
		            $(this).remove();
		        }
		    });
		    dialog.find('#save').on('click', function(e){
		          if(equiType=="oven"){
		        	  var string1="";
			          var string2="";
			          var a=$(".nowLotChildRoom input");
			          var b=$(".nowProductChildRoom input");
			          for(var i=0;i<a.length;i++)
		        	  {
		        	  		string1+=a.eq(i).val()+",";
		        	  }
			          string1=string1.substring(0,string1.length-1);
			          $("#nowLotID").val(string1);
			          for(var i=0;i<b.length;i++)
		        	  {
			        	  string2+=b.eq(i).val()+",";
		        	  }
			          string2=string2.substring(0,string2.length-1);
			          $("#nowProductID").val(string2);
		          }
		          if(equiType=="ink"){
		        	  var string1="";
		        	  var string2="";
		        	  var a=$(".pianxuanRoom input");
		        	  for(var i=0;i<a.length;i++)
		        	  {
		        		  if(a.eq(i).attr("checked")=="checked")
	        			  {
	        			  	string1+=a.eq(i).attr("index")+",";
	        			  }
		        	  		
		        	  }
			          string1=string1.substring(0,string1.length-1);
			          $("#pianxuanID").val(string1);
			          var a=$(".pianxuanBeizhuRoom input");
		        	  for(var i=0;i<a.length;i++)
		        	  {
		        		  string2+=a.eq(i).val()+",";
		        	  		
		        	  }
		        	  string2=string2.substring(0,string2.length-1);
			          $("#pianxuanBeizhuID").val(string2);
			          if($("#statusIdID input").val()=="45"||$("#statusIdID input").val()=="67"||$("#statusIdID input").val()=="105"||$("#statusIdID input").val()=="107")
		        	  {
			    		$("#partIdsID_").attr("dataType","Require");
		        	  }
		          }
		          if(!Validator.Validate(dialog.find('form')[0],3))return;
		          $.post('${pageContext.request.contextPath}/Equipment/changeStatus.koala?id='+id, dialog.find('form').serialize()).done(function(result){

		               if(result.success == true){
		                    dialog.modal('hide');
		                    inintGridProduct(params);
		                    $(".grid-list-product").message({
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
		}
   	});
}
function initPage(form){
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
}
$(function () {
	inintGridProduct(params);
	$.get('${pageContext.request.contextPath}/Category/changeStatusAll.koala').done(function(msg){
		debugger
		$(".bs-docs-sidenav-product").append('<p>分类</p>');
		var navstring="";
		for(var b in msg['data'])
			{
				if(b==0)
				{
					navstring+='<li class="'+msg['data'][b]['name']+' active"><a href="#glyphicons">'+msg['data'][b]['name']+'</a>';
				}
				else{
					navstring+='<li class="'+msg['data'][b]['name']+'"><a href="#glyphicons">'+msg['data'][b]['name']+'</a>';
				}
				navstring+='<ul class="nav">';
				for(var a in msg['data'][b]['children'])
				{
					navstring+='<li class="'+msg['data'][b]['type']+'" id="'+msg['data'][b]['children'][a]['id']+'"><a href="#">'+msg['data'][b]['children'][a]['name']+'</a></li>';
				}
				navstring+='</ul>';
				navstring+='</li>';
			}
		//树状图查询
		$(".bs-docs-sidenav-product").append(navstring);
	   	$(".bs-docs-sidenav-product").children("li").on("click",function(){
	   		//$(".bs-docs-sidenav-product").children("li").removeClass("active");
	   		$(this).addClass("active");
	   	});
		$(".bs-docs-sidenav-product p").css("cursor","pointer");
	   	$(".bs-docs-sidenav-product p").on("click",function(){
	   		params['page']="0";
	   		delete params['category'];
	   		delete params['type'];
			delete params['Location'];
			delete params['testerCategoryId'];
			delete params['status'];
			$("#searchDiv").empty();
	   		inintGridProduct(params);
	   	});
	   	$(".bs-docs-sidenav-product .nav").children("li").on("click",function(){
	   		if($(this).attr("class")=="equipment"||$(this).attr("class")=="Platform")
			{
		   		params['category']=$(this).find("a").text();
				params['type']=$(this).attr("class");
				params['page']="0";
				delete params['Location'];
			}
			if($(this).attr("class")=="tester")
			{
				//delete params['category'];
				params['testerCategoryId']=$(this).attr("id");
				delete params['Location'];
				params['type']="Platform";
			}
			if($(this).attr("class")=="location")
			{
				delete params['category'];
				params['Location']=$(this).attr("id");
				delete params['type'];
			}
			if($(this).attr("class")=="EQUPMENT_STATUS")
			{
				//delete params['category'];
				params['status']=$(this).find("a").text();
				//delete params['type'];
			}
			var classbiaoshi=$(this).attr("class");
			$("#searchDiv").find("div").each(function(){
				if(classbiaoshi==$(this).children("span").attr("class"))
				{
					$(this).remove();
				}	
			});
			$("#searchDiv").append("<div style='display:inline-block;margin-right: 4px;border: 1px solid #555;padding:4px;font-weight: bold;color: red;'>"+$(this).find("a").text()+"<span style='cursor: pointer;  margin-left: 4px;' class='"+$(this).attr("class")+"'>×</span></div>");
	   		searchBind();
			inintGridProduct(params);
	   	});
   	});
  })
  function searchBind()
	{
		$("#searchDiv").find("span").bind("click",function(){
			$(this).parent().remove();
			if($(this).attr("class")=="location")
			{
				delete params['Location'];
			}
			if($(this).attr("class")=="EQUPMENT_STATUS")
			{
				delete params['status'];
			}
			if($(this).attr("class")=="tester")
			{
				delete params['testerCategoryId'];
			}
			if($(this).attr("class")=="equipment"||$(this).attr("class")=="Platform")
			{
				delete params['category'];
				delete params['type']
			}
			inintGridProduct(params);
		});
	}
</script>
<div style="width:30%;height:30px;position:absolute;top: 61px;right: 517px;" id="searchDiv"></div>
<script type="text/javascript" src="<%=contextPath %>/lib/docs.min.js"></script>       
</body>
</html>