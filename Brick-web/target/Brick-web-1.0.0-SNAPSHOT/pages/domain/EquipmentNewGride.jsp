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
		#record-equip .grid-table-body {
			  height: 150px!important;
			}
		@media (max-width: 1399px) {
			#record-equip .grid-table-body {
			  height: 150px!important;
			}
		}
		@media (min-width: 1400px) {
			#record-equip .grid-table-body {
			  height: 300px!important;
			}
		}
	</style>
	<script>
	function ajaxsubmit()
	{
		var form = $("form[name=upload]");
		var options  = {    
            url: "/FileUpload/upload.koala",    
            type:'post',
            dataType : 'xml',
            beforeSubmit:function(){
            	var filename=$("#tablefile").val();
            	var filearray=filename.split('.');
            	if(filename.length>80)
        		{
            		alert("文件名过长");
            		return false;
        		}
            	if(filearray[1]!="jpg"&&filearray[1]!="png"&&filearray[1]!="xls"&&filearray[1]!="docx"&&filearray[1]!="doc"&&filearray[1]!="xlsx"&&filearray[1]!="txt")
        		{
            		debugger;
            		alert("文件格式不正确，请上传图片或文档格式的文件");
            		return false;
        		}
            	if(filename==""){
            		alert("上传文件不能为空");
            		return false;
            	}
            	
            },
            success:function(data)    
            {
            	debugger;
            	data=eval('(' + data['body']['innerText'] + ')');
            	if(data['data']==""||data['data']==null)
           		{
            		$(".modal-body").message({
                        type: 'error',
                        content: data['errorMessage']
                    });
           		}
            	else{
            		$(".modal-body").message({
                        type: 'success',
                        content: "上传成功"
                    });
            	$("#filelist").empty();
            	$("#filelist").append("<p>"+data['data'].split("/")[data['data'].split("/").length-1]+"<a style='margin-left:20px;' download  href='"+data['data']+"'>下载</a><input name='acceptanceList' style='display:none;' value='"+data['data']+"'></p>");
            	}
            },
            error : function(result) {
    			var data = eval("("+result.responseText+")");
    			var message = data['actionError'];
                $(".modal-dialog").message({
                    type: 'error',
                    content: message
                 });
    		}
        };    
        form.ajaxSubmit(options);
	}
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-2 col-sm-2 col-md-2" role="complementary" id="equip-tree" style="overflow: auto;border: 2px dashed #ddd;border-right: 0px solid #ddd;">
			<nav class="bs-docs-sidebar affix"  style="padding: 10px;">
				<ul class="nav bs-docs-sidenav bs-docs-sidenav-equip" style="margin-top:0px;"></ul>
			</nav>
		</div>
		<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
			<div class="row">
				<!-- 功能按键容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 equimentButton">
					<div class="btn-group buttons">
						<button class="btn btn-primary" type="button" onclick="buttonactionEquip('add')">
							<span class="glyphicon glyphicon-plus">添加</span>
						</button>
						<button class="btn btn-success" type="button" onclick="buttonactionEquip('modify')">
							<span class="glyphicon glyphicon-edit">修改</span>
						</button>
						<button class="btn btn-danger" type="button" onclick="buttonactionEquip('remove')">
							<span class="glyphicon glyphicon-remove">删除</span>
						</button>
						<button class="btn btn-primary" type="button" onclick="buttonactionEquip('changeStats')">
							<span class="glyphicon glyphicon-new-window">变更状态</span>
						</button>
						<button class="btn btn-primary" type="button" onclick="buttonactionEquip('upkeep')">
							<span class="glyphicon glyphicon-new-window">保养清单</span>
						</button>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- 平台列表容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 grid-list-equip grid-list"></div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12" style="padding-top: 4px;padding-bottom: 4px;">
					<div class="pagination pagination-equip" style="margin:0;">
						<ul class="pagination"></ul>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- 信息tab页容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border-bottom:2px dashed #ddd;margin-bottom:10px">
					<ul class="nav nav-tabs" role="tablist" id="myTab">
						<li role="presentation" class="active">
							<a href="#message-equip" aria-controls="message-equip" role="tab" data-toggle="tab">基本信息</a>
						</li>
						<li role="presentation">
							<a href="#record-equip" aria-controls="record-equip" role="tab" data-toggle="tab">操作记录</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="message-equip" style="padding: 20px;">
							<div class="row"></div>
						</div>
						<div role="tabpanel" class="tab-pane" id="record-equip" style="width: 100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
var params={};
params['pagesize']="24";params['page']="0";
function inintGridEquip(params){
	$.ajax({
		type : "POST",
		url : "/Equipment/pageJson.koala",
		data : params,
		dataType : 'json',
		success : function(result){
			debugger;	
			if (!result.data) {
				$(".grid-list-equip").message({
					type : 'error',
					content : '查询失败'
				});
				return;
			}
			if (result.data.length == 0) {
				$(".grid-list-equip").message({
					type : 'error',
					content : '无数据可查'
				});
				//$(".pagination-equip ul").empty();
			} else {
				debugger;
				$(".pagination-equip ul").empty();
				$(".pagination-equip").data('bs.pagy',"");
				$(".pagination-equip").pagy({
					totalPages: result.pageCount,
					currentPage: ++result.pageIndex,
					page: function(page) {
						params['page']=--page;
						inintGridEquip(params);
					}
				});
				$(".grid-list-equip").empty();
				var data=result['data'];
				for(var a in data)
					{
						if(data[a]['categoryImageUrl']=="")
						{
							data[a]['categoryImageUrl']="/images/tester_3360_128.png";
						}
						$(".grid-list-equip").append('<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" id="'+data[a]['id']+'" style="padding:0;padding-right: 1%;padding-bottom: 1%;">'+
								'<div class="thumbnail">'+
								'<div class="colorRoom" style="background-color:'+statusColor(data[a]['status'])+'">'+
								'<img src="'+data[a]['categoryImageUrl']+'" alt="..." style="width:69%;">'+
								'</div>'+
								'<div class="caption">'+
								'<h5><strong>'+data[a]['equipmentNo']+'</strong></h5>'+
								'<p>类型:'+data[a]['equipmentCategory']+'</p>'+
								'<p>状态:'+data[a]['status']+'</p>'+
								'<p style="white-space: nowrap;overflow: hidden;">批次:'+data[a]['nowLot']+'</p>'+
								'</div>'+
								'</div></div>');
						if(a=='0'){
							$("#message-equip").children("div").empty();
							var translate='{"acceptanceList":"验收单","responsible":"责任人","sn":"S/N","status":"状态","category":"设备型号","equipmentCategory":"设备分类","maintenanceStartDate":"保养起始日期","equipmentLocation":"设备位置","agent":"代理人","checkInTime":"登记时间","lastModifyEmployNo":"修改人","repairCycle":"维护周期","createEmployNo":"创建人","equipmentNo":"设备编号","composability":"是否可组装","ip":"IP地址"}';
							var translateobj=eval('(' + translate + ')');
							for(var b in data[0])
								{
									if(translateobj[b]!=undefined)
									{
										if(translateobj[b]=="验收单")
										{
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : <a download  href="'+data[a][b]+'">下载</a></div>');
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
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+repairCycle+'</div>');
										}
										else{
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+data[a][b]+'</div>');
										}
										
									}
								}
							recordGetEquip(data[0]["id"]);
						}
					}
				$(".grid-list-equip").children("div").bind("click",function(){
					$(".grid-list-equip").children("div").removeClass("active");
					$(".grid-list-equip").children("div").children(".thumbnail").css("border-color","#ddd");
					$(this).children(".thumbnail").css("border-color","#428bca");
					$(this).addClass("active");
					var id = $(this).attr("id");
					$.get( '${pageContext.request.contextPath}/Equipment/get/' + id + '.koala').done(function(json){
						$("#message-equip").children("div").empty();   
						var translate='{"acceptanceList":"验收单","responsible":"责任人","sn":"S/N","status":"状态","category":"设备型号","equipmentCategory":"设备分类","maintenanceStartDate":"保养起始日期","equipmentLocation":"设备位置","agent":"代理人","checkInTime":"登记时间","lastModifyEmployNo":"修改人","repairCycle":"维护周期","createEmployNo":"创建人","equipmentNo":"设备编号","composability":"是否可组装","ip":"IP地址"}';
						var translateobj=eval('(' + translate + ')');
						for(var b in json['data'])
							{
								if(translateobj[b]!=undefined)
									{
										if(translateobj[b]=="验收单")
										{
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : <a download  href="'+json['data'][b]+'">下载</a></div>');
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
											debugger;
											repairCycle=repairCycle.substring(0,repairCycle.length-1);
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+repairCycle+'</div>');
										}
										else{
											$("#message-equip").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
										}
									}
								
							}
						recordGetEquip(id);
	                });
				})
				setTimeout(function(){$("#equip-tree").height($("#equip-tree").next().height()-14);}, 500);
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
function recordGetEquip(id)
{
	var grid;
	var _dialog;
	    grid = $("#record-equip");
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
	       	                      	 { title: '开始时间', name: 'startTime', width: width},
	    	                         { title: '结束时间', name: 'endTime', width: width},
	    	                         { title: '状态时间', name: 'duration', width: width},
	       	                         { title: '操作人', name: 'optUser', width: width},
	       	                         { title: '操作日期', name: 'optDate', width: width},
	       	                         { title: '结束人员', name: 'endOptUser', width: width},
	       	                      	 { title: '片数详情', name: 'completedChipDescription', width: width},
	       	                      	 { title: '完工片术', name: 'completedChip', width: width},
	       	                         { title: '标准工时', name: 'standardWorkHours', width: width},
	       	                         { title: 'grossDie', name: 'grossDie', width: width},
	       	                         { title: '理论时间', name: 'theoryTime', width: width},
	       	                         { title: 'INK类型', name: 'inkType', width: width},
	       	                      	 { title: '片选', name: 'chipSelection', width: 200},
	       	                      	 { title: '片选备注', name: 'chipSelectionRemark', width: 200},
	       	                         { title: '接触次数', name: 'touchTimes', width: width},
	       	                      	 { title: 'P/C编号', name: 'pcNo', width: 260},
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
}
function buttonactionEquip(action){
	var id=$('.grid-list-equip').children('.active').attr('id');
	if(action=='add'){
		addEquip();
	}
	else if(id!=undefined)
		{
			switch(action){
				case 'modify':
					modifyEquip(id);	
					break;
				case 'remove':
					var returner = function(){
						removeEquip(id);
	                };
	                $(this).confirm({
	                    content: '确定要删除?',
	                    callBack: returner
	                });
					break;
				case 'changeStats':
					debugger;
					var type=$('.grid-list-equip').children('.active').find("h5").next().text().split(":")[1];
                    if(type=='taping'||type=='oven'||type=='ink'){
                    	$('.equimentButton').message({
                            type: 'warning',
                            content: '选择的设备类型有误请确认'
                        })
                        return;
                    }
                    $.ajax({
            			async:false,
            			url: '${pageContext.request.contextPath}/Equipment/checkEquipmentAssemble/'+id+'.koala',
            			type: 'POST',
            			dataType: 'json',
            		})
            		.done(function(msg) {
            			if(msg['success']==false)
           				{
           					changeStatsEquip(id);
           				}
            			else{
            				$('.equimentButton').message({
                                type: 'warning',
                                content: '选择的设备类型有误请确认'
                            })
            			}
            		});	
					break;
				case 'upkeep':
					upkeep(id);
					break;
				default:
				break;
			}
		}
	else{
		$('.equimentButton').message({
            type: 'warning',
            content: '请选择一条记录进行操作'
        })
        return;
	}
}
function addEquip(){
    var self = this;
    var dialog = $('<div class="modal fade"><div class="modal-dialog">'
    	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
    	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
    	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
    	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
    	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
    	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
    	+'</div></div>');
    $.get('<%=path%>/Equipment-add.jsp').done(function(html){
        dialog.modal({
            keyboard:false
        }).on({
            'hidden.bs.modal': function(){
                $(this).remove();
            }
        }).find('.modal-body').html(html);
        self.initPage(dialog.find('form'));
        dialog.find('#equipmentCategoryIdID .dropdown-menu').bind("click",function(){
    		var typearray=$("#equipmentCategoryIdID input").val();
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
    			dialog.find("#categoryIdID").data('koala.select',null);
    			var partIdobj=dialog.find('#categoryIdID');
    			partIdobj['context']=partIdobj[0];
    			partIdobj.select({
                    title: '请选择',
                    contents: contents
                }).on('change', function(){
                	dialog.find('#categoryIdID_').val($(this).getValue());
                });
    		});
		});
    });
    dialog.find('#save').on('click', function(e){
          if(!Validator.Validate(dialog.find('form')[0],3))return;
		  if($("input[name='acceptanceList']").val()==""||$("input[name='acceptanceList']").val()==undefined)
		  {
			showErrorMessage($("#tablefile").closest('.modal'), $("#tablefile"), "请上传验收单");
			return;
		  }
          if($("#maintenanceStartDateID").val()<$("#checkInTimeID").val())
       	  {
        	  dialog.find('.modal-content').message({
                  type: 'error',
                  content: "保养其实时间不得小于登记时间"
              });
        	  return;
       	  }
          $.post('${pageContext.request.contextPath}/Equipment/add.koala', dialog.find('form').serialize()).done(function(result){
               if(result.success ){
                    dialog.modal('hide');
                    inintGridEquip(params);
                    $(".grid-list-equip").message({
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
}
function modifyEquip(id){
    var self = this;
    var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
    $.get('<%=path%>/Equipment-update.jsp').done(function(html){
           dialog.find('.modal-body').html(html);
           self.initPage(dialog.find('form'));
           dialog.find('#equipmentCategoryIdID .dropdown-menu').bind("click",function(){
       		var typearray=$("#equipmentCategoryIdID input").val();
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
       			dialog.find("#categoryIdID").data('koala.select',null);
       			var partIdobj=dialog.find('#categoryIdID');
       			partIdobj['context']=partIdobj[0];
       			partIdobj.select({
                       title: '请选择',
                       contents: contents
                   }).on('change', function(){
                   	dialog.find('#categoryIdID_').val($(this).getValue());
                   });
       		});
   		 });
           $.get( '${pageContext.request.contextPath}/Equipment/get/' + id + '.koala').done(function(json){
                   json = json.data;
                   debugger
                   $.ajax({
              			async:false,
              			url: '${pageContext.request.contextPath}/Category/get/'+json['equipmentCategoryId']+'.koala',
              			type: 'POST',
              			dataType: 'json',
              		})
              		.done(function(msg) {
              			debugger;
              			var contents = [{title:'请选择', value: ''}];
              			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
              			{
              				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
              			}
              			dialog.find("#categoryIdID").data('koala.select',null);
              			var partIdobj=dialog.find('#categoryIdID');
              			partIdobj['context']=partIdobj[0];
              			partIdobj.select({
                              title: '请选择',
                              contents: contents
                          }).on('change', function(){
                          	dialog.find('#categoryIdID_').val($(this).getValue());
                          });
              		});
                    if(json['acceptanceList']!=null)
                  	{
                    	dialog.find("#filelist").append("<p>"+json['acceptanceList'].split("/")[json['acceptanceList'].split("/").length-1]+"</p>");
                  	}
                   	if(json['repairCycleSeason']=="on")
              		{
                   		dialog.find("#repairCycle_seasonID").attr("checked","checked");
              		}
                   	if(json['repairCycleMonth']=="on")
               		{
                   		dialog.find("#repairCycle_monthID").attr("checked","checked");
               		}
                   	if(json['repairCycleYear']=="on")
               		{
                   		dialog.find("#repairCycle_yearID").attr("checked","checked");
               		}
                    var elm;
                    for(var index in json){
                        elm = dialog.find('#'+ index + 'ID');
                        if(elm.hasClass('select')){
                            elm.setValue(json[index]);
                        }else{
                            elm.val(json[index]);
                        }
                    }
                   	if(json['composability']==true)
              		{
              			dialog.find('#composabilityID').setValue("1");
              		}
                   	else{
                   		dialog.find('#composabilityID').setValue("0");
                   	}
            });
            dialog.modal({
                keyboard:false
            }).on({
                'hidden.bs.modal': function(){
                    $(this).remove();
                }
            });
            dialog.find('#save').on('click', function(e){
                if(!Validator.Validate(dialog.find('form')[0],3))return;
/* 	      		  if($("input[name='acceptanceList']").val()==""||$("input[name='acceptanceList']").val()==undefined)
	    		  {
	    			showErrorMessage($("#tablefile").closest('.modal'), $("#tablefile"), "请上传验收单");
	    			return;
	    		  } */
                $.post('${pageContext.request.contextPath}/Equipment/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
                	debugger;
                    if(result.success){
                        dialog.modal('hide');
                        inintGridEquip(params);
                        $(".grid-list-equip").message({
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
}
function changeStatsEquip(id){
	var self = this;
	var substatus="";
    var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 43%;">'
    	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
    	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
    	+'<h4 class="modal-title">设备状态变更</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
    	+'</div></form></div><div class="modal-footer">'
    	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
    	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
    	+'</div></div>');
    $.get('<%=path%>/Equipment-Change.jsp').done(function(html){
        dialog.find('.modal-body').html(html);
        var contents = [{title:'请选择', value: ''}];
        $.ajax({
        	async:false,
        	url: '${pageContext.request.contextPath}/Category/getByType/76.koala?type=FT',
        	type: 'POST',
        	dataType: 'json',
        })
        .done(function(msg) {
        	contents.push({title:"ENGINEERING" , value: "61"});
        	for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        	{
        		contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        	}
        	selectItems['statusIdID'] = contents;
        });
	    self.initPage(dialog.find('form'));
        dialog.find('#statusIdID .dropdown-menu').bind("click",function(){
    		var typearray=$("#statusIdID input").val();
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
    			dialog.find("#subStatusIdID").data('koala.select',null);
    			var partIdobj=dialog.find('#subStatusIdID');
    			partIdobj['context']=partIdobj[0];
    			partIdobj.select({
                    title: '请选择',
                    contents: contents
                }).on('change', function(){
                	dialog.find('#subStatusIdID_').val($(this).getValue());
                });
    		});
		});
        $.get('${pageContext.request.contextPath}/Equipment/getLastEquipmentOptionLog/'+id+'.koala').done(function(msg){
        	if(msg['data']["subStatus"]!="PM")
       		{
        		dialog.find(".part_PM").remove();
       		}
        	else{
        		substatus=msg['data']["subStatus"];
        	}
        });
	    dialog.modal({
	        keyboard:false
	    }).on({
	        'hidden.bs.modal': function(){
	            $(this).remove();
	        }
	    });
	    dialog.find('#save').on('click', function(e){
	          var stringPmType="";
              for(var i=0;i<$("input[name*=repairCycle]:checked").length;i++){
              	stringPmType+=$("input[name*=repairCycle]:checked").eq(i).next().text()+",";
              }
              stringPmType=stringPmType.substring(0,stringPmType.length-1);
              $("#pmTypeID").val(stringPmType);
	          if(!Validator.Validate(dialog.find('form')[0],3))return;
	          if(substatus=="PM")
        	  {
	        	  if($("#pmTypeID").val()==""||$("#pmTypeID").val()==undefined)
	      		  {
	      			showErrorMessage($("#repairCycle_yearID").closest('.modal'), $("#repairCycle_yearID"), "请选择保养周期");
	      			return;
	      		  }
	              if($("input[name='acceptanceList']").val()==""||$("input[name='acceptanceList']").val()==undefined)
	    		  {
	    			showErrorMessage($("#tablefile").closest('.modal'), $("#tablefile"), "请上传验收单");
	    			return;
	    		  }
        	  }
	          $.post('${pageContext.request.contextPath}/Equipment/changeStatus.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	        	  debugger;
	               if(result.success == true){
	                    dialog.modal('hide');
	                    inintGridEquip(params);
	                    $(".grid-list-equip").message({
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
}
function removeEquip(ids){
	var data = [{ name: 'ids', value: ids }];
	$.post('${pageContext.request.contextPath}/Equipment/delete.koala', data).done(function(result){
                    if(result.success){
                    	inintGridEquip(params);
                        $(".grid-list-equip").message({
                            type: 'success',
                            content: '删除成功'
                        });
                    }else{
                    	$(".grid-list-equip").message({
                            type: 'error',
                            content: result.actionError
                        });
                    }
	});
}
function upkeep(id){
	var self = this;
    var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 43%;">'
    	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
    	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
    	+'<h4 class="modal-title">保养清单</h4></div><div class="modal-body" style="max-height: 300px;overflow: auto;"><form class="form-horizontal"><div class="form-group">'
    	+'</div></form></div><div class="modal-footer">'
    	+'<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>'
    	+'</div></div>'
    	+'</div></div>');
    $.get('${pageContext.request.contextPath}/EquipmentMaintenanceLog/findEquipmentMaintenanceLog/'+id+'.koala').done(function(msg){
    	msg=msg['data'];
        //var msg="[{'responsible':'0187|汤智凯','repairCycle':'月','plannedTime':'2015-10-23','actualTime':'2015-10-23'},{'responsible':'0187|汤智凯','repairCycle':'月','plannedTime':'2015-10-23','actualTime':'2015-10-23'},{'responsible':'0187|汤智凯','repairCycle':'月','plannedTime':'2015-10-23','actualTime':'2015-10-23'}]";
    	//msg=eval('(' + msg + ')');
        var table="<table class='table'><tr><th>责任人</th><th>保养周期</th><th>计划保养日期</th><th>实际保养日期</th><tr/>";
    	var tr="";
    	debugger;
    	for(var a in msg){
    		tr+="<tr><td>"+msg[a]['createEmployNo']+"</td><td>"+msg[a]['pmType']+"</td><td>"+msg[a]['planStartDate']+"</td><td>"+msg[a]['realStartDate']+"</td></tr>";
    	}
    	table=table+tr+"</table>";
        dialog.find('.modal-body').html(table);
        self.initPage(dialog.find('form'));
        dialog.modal({
	        keyboard:false
	    }).on({
	        'hidden.bs.modal': function(){
	            $(this).remove();
	        }
	    });
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
$(function () {//页面展示初始化
	inintGridEquip(params);
	$.get('${pageContext.request.contextPath}/Category/getEquipmentTree.koala').done(function(msg){
		$(".bs-docs-sidenav-equip").append('<p>'+msg['data']['categoryName']+'</p>');
		if(msg['data']['hasChildren']==true)
			{
				var navstring="";
				for(var b in msg['data']['categoryChildren'])
					{
						if(b==0)
						{
							navstring+='<li class="'+msg['data']['categoryChildren'][b]['categoryCode']+' active"><a href="#glyphicons">'+msg['data']['categoryChildren'][b]['categoryName']+'</a>';
						}
						else{
							navstring+='<li class="'+msg['data']['categoryChildren'][b]['categoryCode']+'"><a href="#glyphicons">'+msg['data']['categoryChildren'][b]['categoryName']+'</a>';
						}
						if(msg['data']['categoryChildren'][b]['hasChildren']==true)
							{
								navstring+='<ul class="nav">';
								for(var a in msg['data']['categoryChildren'][b]['categoryChildren'])
									{
										navstring+='<li class="'+msg['data']['categoryChildren'][b]['categoryCode']+'" id="'+msg['data']['categoryChildren'][b]['categoryChildren'][a]['id']+'"><a href="#">'+msg['data']['categoryChildren'][b]['categoryChildren'][a]['categoryName']+'</a></li>';
									}
								navstring+='</ul>';
							}
						navstring+='</li>';
					}
					
			}
		$(".bs-docs-sidenav-equip").append(navstring);
   	   	$(".bs-docs-sidenav-equip").children("li").children("a").on("click",function(){
	   		//$(".bs-docs-sidenav-equip").children("li").removeClass("active");
	   		$(this).parent().addClass("active");
	   		if($(this).text()=="设备位置")
	   		return;
	   		params['equipmentCategory']=$(this).text();
	   		delete params['category'];
	   		delete params['equipmentLocationId'];
	   		params['page']="0";
	   		inintGridEquip(params);
	   	});
		$(".bs-docs-sidenav-equip p").css("cursor","pointer");
	   	$(".bs-docs-sidenav-equip p").on("click",function(){
	   		params['page']="0";
	   		params['equipmentCategory']="";
	   		params['category']="";
	   		delete params['equipmentLocationId'];
	   		inintGridEquip(params);
	   	});
   	 	$(".bs-docs-sidenav-equip .nav").children("li").unbind();
 	   	$(".bs-docs-sidenav-equip .nav").children("li").on("click",function(){
 	   		debugger;
	 	   	if($(this).attr("class")!="location")
			{
	 	   		params['category']=$(this).find("a").text();
		   		params['page']="0";
		   		delete params['equipmentCategory'];
		   		//delete params['equipmentLocationId'];
			}else{
	   		 	delete params['equipmentId'];
	   		 	delete params['equipmentCategory'];
	   		 	//delete params['category'];
				params['equipmentLocationId']=$(this).attr("id");
			}
	   		inintGridEquip(params);
	   	}); 
   	});
	
  })
</script>
<script type="text/javascript" src="<%=contextPath %>/lib/docs.min.js"></script>       
</body>
</html>