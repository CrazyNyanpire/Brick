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
		#record .grid-table-body {
		  height: auto!important;
		}
		@media (max-width: 1399px) {
			#record .grid-table-body {
			  height: 150px!important;
			}
		}
		@media (min-width: 1400px) {
			#record .grid-table-body {
			  height: 300px!important;
			}
		}
	</style>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" role="complementary" id="platform-tree" style="overflow: auto;border: 2px dashed #ddd;border-right: 0px solid #ddd;">
			<nav class="bs-docs-sidebar affix" style="padding: 10px;">
				<ul class="nav bs-docs-sidenav-platform bs-docs-sidenav" style="margin-top:0px;"></ul>
			</nav>
		</div>
		<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
			<div class="row">
				<!-- 功能按键容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 platformButton">
					<div class="btn-group buttons">
						<button class="btn btn-primary" type="button" onclick="buttonaction('add')">
							<span class="glyphicon glyphicon-plus">添加</span>
						</button>
<!-- 						<button class="btn btn-success" type="button" onclick="buttonaction('modify')">
							<span class="glyphicon glyphicon-edit">修改</span>
						</button> -->
						<button class="btn btn-danger" type="button" onclick="buttonaction('remove')">
							<span class="glyphicon glyphicon-remove">删除</span>
						</button>
						<button class="btn btn-primary" type="button" onclick="buttonaction('Combination')">
							<span class="glyphicon glyphicon-wrench">平台组合</span>
						</button>
						<button class="btn btn-primary" type="button" onclick="buttonaction('split')">
							<span class="glyphicon glyphicon-wrench">平台拆分</span>
						</button>
<!--						<button class="btn btn-success" type="button" onclick="buttonaction('childEquipShow')">
							<span class="glyphicon glyphicon-search">组合设备明细</span>
						</button>
 						<button class="btn btn-primary" type="button" onclick="buttonaction('changeStats')">
							<span class="glyphicon glyphicon-new-window">挂状态</span></span>
						</button> -->
					</div>
				</div>
			</div>
			<div class="row">
				<!-- 平台列表容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 grid-list grid-list-platform">
				</div>
			</div>
			<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12" style="padding-top: 4px;padding-bottom: 4px;">
				<div class="pagination pagination-platform" style="margin:0;">
					<ul class="pagination"></ul>
				</div>
			</div>	
			</div>
			<div class="row">
				<!-- 信息tab页容器  -->
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border-bottom:2px dashed #ddd;margin-bottom:10px">
					<ul class="nav nav-tabs" role="tablist" id="myTab">
						<li role="presentation" class="active">
							<a href="#message" aria-controls="message" role="tab" data-toggle="tab">基本信息</a>
						</li>
						<li role="presentation">
							<a href="#record" aria-controls="record" role="tab" data-toggle="tab">操作记录</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="message" style="padding: 20px;">
							<div class="row"></div>
						</div>
						<div role="tabpanel" class="tab-pane" id="record" style="width: 100%;"></div>
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
function inintGrid(params){
	$.ajax({
		type : "POST",
		url : "/Platform/pageJson.koala",
		data : params,
		dataType : 'json',
		success : function(result){
			debugger;	
			if (!result.data) {
				$(".platformButton").message({
					type : 'error',
					content : '查询失败'
				});
				return;
			}
			if (result.data.length == 0) {
				$(".platformButton").message({
					type : 'error',
					content : '无数据可查'
				});
				//$(".pagination-platform ul").empty();
			} else {
				debugger;
				$(".pagination-platform ul").empty();
				$(".pagination-platform").data('bs.pagy',"");
				$(".pagination-platform").pagy({
					totalPages: result.pageCount,
					currentPage: ++result.pageIndex,
					page: function(page) {
						params['page']=--page;
						inintGrid(params);
					}
				});
				$(".grid-list-platform").empty();
				var data=result['data'];
				for(var a in data)
					{
						$(".grid-list-platform").append('<div class="col-xs-2 col-sm-2 col-md-2" id="'+data[a]['id']+'" style="padding: 0;padding-right: 1%;padding-bottom: 1%;">'+
								'<div class="thumbnail">'+
								'<div class="colorRoom" style="background-color:'+statusColor(data[a]['status'])+'">'+
								'<img src="/images/tester_3360_128.png" alt="..." style="width:86%;padding:8px 0;">'+
								'</div>'+
								'<div class="caption">'+
								'<h5 style="font-size:16px;"><strong>'+data[a]['platformNo']+'</strong></h5>'+
								'<h6><i>-'+data[a]['equipmentNos']+'</i></h6>'+
								'<p>类型:'+data[a]['platformCategory']+'</p>'+
								'<p>状态:'+data[a]['status']+'</p>'+
								/* '<p>组成:'+data[a]['equipmentNos'][0]+'+'+data[a]['equipmentNos'][1]+'</p>'+ */
								'</div>'+
								'</div></div>');
						if(a=='0'){
							$("#message").children("div").empty();
							var translate='{"platformNo":"平台编号","platformCategory":"平台分类","createTimestamp":"创建时间","platformName":"平台名称","createEmployNo":"创建人","status":"状态","checkInTime":"进厂时间","equipmentNos":"组装设备","ip":"IP地址","isAuto":"是否自动获取数据"}';
							var translateobj=eval('(' + translate + ')');
							for(var b in data[0])
								{
									if(translateobj[b]!=undefined)
									{
										$("#message").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+data[a][b]+'</div>');
									}
								}
							recordGet(data[0]['id']);
						}
					}
				$(".grid-list-platform").children("div").bind("click",function(){
					$(".grid-list-platform").children("div").removeClass("active");
					$(".grid-list-platform").children("div").children(".thumbnail").css("border-color","#ddd");
					$(this).children(".thumbnail").css("border-color","#428bca");
					$(this).addClass("active");
					var id = $(this).attr("id")
					$.get( '${pageContext.request.contextPath}/Platform/get/' + id + '.koala').done(function(json){
						debugger;
						$("#message").children("div").empty();
						var translate='{"platformNo":"平台编号","platformCategory":"平台分类","createTimestamp":"创建时间","platformName":"平台名称","createEmployNo":"创建人","status":"状态","checkInTime":"进厂时间","equipmentNos":"组装设备","ip":"IP地址","isAuto":"是否自动获取数据"}';
						var translateobj=eval('(' + translate + ')');
						for(var b in json['data'])
							{
								if(translateobj[b]!=undefined)
									{
										$("#message").children("div").append('<div class="col-xs-4 col-sm-4 col-md-4" style="margin-bottom:10px">'+translateobj[b]+' : '+json['data'][b]+'</div>');
									}
								
							}
						$("#record").empty();
						$("#record").data("koala.grid","");
						recordGet(id);
	                });
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
function recordGet(id)
{
	var grid;
	var _dialog;
	    grid = $("#record");
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
		                            content: result.errorMessage
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
function buttonaction(action){
	var id=$('.grid-list').children('.active').attr('id');
	if(action=='add'){
		add();
	}
	else if(id!=undefined)
		{
			switch(action){
				case 'modify':
					modify(id);	
					break;
				case 'Combination':
					Combination(id);	
					break;
				case 'split':
					var returners = function(){
						split(id);	
	                };
	                $(this).confirm({
	                    content: '确定要拆解?',
	                    callBack: returners
	                });
					
					break;
				case 'remove':
					var returner = function(){
						remove(id);
	                };
	                $(this).confirm({
	                    content: '确定要删除?',
	                    callBack: returner
	                });
					break;
				default:
				break;
			}
		}
	else{
		$('.grid-list').message({
            type: 'warning',
            content: '请选择一条记录进行操作'
        })
        return;
	}
}
function add(){
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
    dialog.find('#save').on('click', function(e){
          if(!Validator.Validate(dialog.find('form')[0],3))return;
          debugger;
          $.post('${pageContext.request.contextPath}/Platform/add.koala', dialog.find('form').serialize()).done(function(result){
               if(result.success ){
                    dialog.modal('hide');
                    inintGrid(params);
                    $(".grid-list-platform").message({
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
function modify(id){
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
            dialog.find('#save').on('click', function(e){
                if(!Validator.Validate(dialog.find('form')[0],3))return;
                $.post('${pageContext.request.contextPath}/Platform/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
                	debugger;
                    if(result.success){
                        dialog.modal('hide');
                        inintGrid(params);
                        $(".grid-list-platform").message({
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
function Combination(id){
	var self = this;
    var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 80%;">'
    	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
    	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
    	+'<h4 class="modal-title">设备选择</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
    	+'</div></form></div><div class="modal-footer">'
    	+'<button type="button" class="btn btn-success" id="save">组合</button></div></div>'
    	+'</div></div>');
    $.get('${pageContext.request.contextPath}/Equipment/findComposabilityEquipments.koala').done(function(msg){
    	debugger;
    	//msg['data']=[{equipid:'1',equipName:'3360P-001'},{equipid:'2',equipName:'3360P-002'},{equipid:'3',equipName:'3360P-003'},{equipid:'4',equipName:'3360P-004'},{equipid:'5',equipName:'3360P-005'},{equipid:'6',equipName:'3360P-006'},{equipid:'7',equipName:'3360P-007'},{equipid:'8',equipName:'3360P-008'},{equipid:'9',equipName:'3360P-009'}];
    	var array=[];
    	for(var a in msg['data'])
		{
    		array.push(msg['data'][a]['equipmentCategory']);
		}
    	array=unique(array);
   	    var j=0;
   	    while(j<array.length)
   	    	{
   	    		dialog.find('.modal-body .form-group').append('<p class="col-xs-12 col-sm-12 col-lg-12" style="border-bottom:1px solid #ddd;font-size: 19px;">'+array[j]+'</p>');
	   	    	for(var a in msg['data'])
	   			{
	   	    		if(msg['data'][a]['equipmentCategory']==array[j])
	   	    		{
	   	    			dialog.find('.modal-body .form-group').append('<label class="col-xs-2 col-sm-2 col-lg-2 control-label" name="'+msg['data'][a]['id']+'" style="text-align:center;margin-bottom: 20px;"><img style="width:100%;" src="/images/tester_3360_128.png" alt=""><br/><span>'+msg['data'][a]['equipmentNo']+'</span></label>');
	   	    		}
	   			}
	   	    	j++;
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
        dialog.find('#save').on('click', function(e){
              if(!Validator.Validate(dialog.find('form')[0],3))return;
              var equipadd=[];
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
              if(equipadd==""){
            	  dialog.message({
                      type: 'error',
                      content: '请选择要组合的设备'
                  });
            	  return;
              }
              if(equipadd.length>1)
           	  {
            	  dialog.message({
                      type: 'error',
                      content: '只能选择一个设备进行组装'
                  });
            	  return;
           	  }
              $.post('${pageContext.request.contextPath}/Platform/assemble.koala', string).done(function(result){
                   if(result.success == true){
                        dialog.modal('hide');
                        inintGrid(params);
                        dialog.message({
                            type: 'success',
                            content: '组装成功'
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
function split(id){
       $.get('${pageContext.request.contextPath}/Platform/split.koala?id='+id).done(function(result){
    	   debugger;
            if(result.success == true){
                 inintGrid(params);
                 $(".platformButton").message({
                     type: 'success',
                     content: '拆解成功'
                 });
             }else{
                 $(".platformButton").find('.modal-content').message({
                     type: 'error',
                     content: result.errorMessage
                 });
              }
       });
}
function childEquipShow(id){
    var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 55%;"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">明细查询</h4></div><div class="modal-body"><form class="form-horizontal"><div class="row"></div></form></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
    $.get('${pageContext.request.contextPath}/Platform/findEquipmentByPlatform/'+id+'.koala').done(function(msg){
    	debugger;
    	if(msg['data'][0]==null)
    		{
	    		$(".grid-list-platform").message({
	                type: 'error',
	                content: '该平台未组合设备'
	            });
	    		return;
    		}
    	//msg['data']=[{equipid:'1',equipName:'3360P-001'},{equipid:'2',equipName:'3360P-002'},{equipid:'3',equipName:'3360P-003'},{equipid:'4',equipName:'3360P-004'},{equipid:'5',equipName:'3360P-005'},{equipid:'6',equipName:'3360P-006'},{equipid:'7',equipName:'3360P-007'},{equipid:'8',equipName:'3360P-008'},{equipid:'9',equipName:'3360P-009'}];
       	for(var a in msg['data'])
   		{
       		dialog.find('.modal-body .row').append('<div class="col-xs-3 col-sm-3 col-lg-3" name="'+msg['data'][a]['id']+'" style="text-align:center;"><img style="width:100%;" style="100%" src="/images/tester_3360_128.png" alt=""><span>'+msg['data'][a]['equipmentNo']+'</span></div>');
   		}
        dialog.modal({
            keyboard:false
        }).on({
            'hidden.bs.modal': function(){
                $(this).remove();
            }
        });
   });
}
function remove(ids){
	var data = [{ name: 'ids', value: ids }];
	$.post('${pageContext.request.contextPath}/Platform/delete.koala', data).done(function(result){
                    if(result.success){
                    	inintGrid(params);
                        $(".grid-list-platform").message({
                            type: 'success',
                            content: '删除成功'
                        });
                    }else{
                    	$(".grid-list").message({
                            type: 'error',
                            content: result.result
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
	inintGrid(params);
	$.get('${pageContext.request.contextPath}/Category/get/1.koala').done(function(msg){
		$(".bs-docs-sidenav-platform").append('<p>'+msg['data']['categoryName']+'</p>');
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
										navstring+='<li class="'+msg['data']['categoryChildren'][b]['categoryCode']+'"><a href="#">'+msg['data']['categoryChildren'][b]['categoryChildren'][a]['categoryName']+'</a></li>';
									}
								navstring+='</ul>';
							}
						navstring+='</li>';
					}
					
			}
		$(".bs-docs-sidenav-platform").append(navstring);
	   	$(".bs-docs-sidenav-platform").children("li").on("click",function(){
	   		//$(".bs-docs-sidenav-platform").children("li").removeClass("active");
	   		$(this).addClass("active");
	   	});
		$(".bs-docs-sidenav-platform p").css("cursor","pointer");
	   	$(".bs-docs-sidenav-platform p").on("click",function(){
	   		params['platformCategory']="";
	   		params['page']="0";
	   		inintGrid(params);
	   	});
	   	$(".bs-docs-sidenav-platform .nav").children("li").on("click",function(){
	   		if($(this).attr("class")=="Type")
	   			{
	   				params['platformCategory']=$(this).find("a").text();
	   			}
	   		params['page']="0";
	   		inintGrid(params);
	   	});
   	});
  })
</script>
<script type="text/javascript" src="<%=contextPath %>/lib/docs.min.js"></script>       
</body>
</html>