<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<%-- <%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp --> --%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript" src="/lib/jquery.form.js"></script>
<script type="text/javascript">
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
        	if(filename.length>50)
    		{
        		alert("文件名过长");
        		return false;
    		}
        	if(filearray[1]!="jpg"&&filearray[1]!="png"&&filearray[1]!="xls"&&filearray[1]!="docx"&&filearray[1]!="doc"&&filearray[1]!="xlsx"&&filearray[1]!="txt")
    		{
        		alert("文件格式不正确,请上传图片或文档格式的文件");
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
        	$("#filelist").append("<p>"+data['data'].split("/")[data['data'].split("/").length-1]+"<a style='margin-left:20px;' download  href='"+data['data']+"'>下载</a><input name='lastFileUrl' style='display:none;' value='"+data['data']+"'></p>");
        	}
        },
        error : function(result) {
			var data = eval("("+result.responseText+")");
			var message = data['actionError'];
            $("body").message({
                type: 'error',
                content: message
             });
		}
    };    
    form.ajaxSubmit(options);
}
</script>
<script type="text/javascript">
var grid;
var form;
var _dialog;
var SocketGlobleId;
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
	                     yesterday.setDate(yesterday.getDate() - 5);
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
		                		url : "/Category/get/96.koala",
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
                	 content: '<ks:hasSecurityResource identifier="SocketAdd"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button></ks:hasSecurityResource>', 
                	 action: 'add'
                 },{
                	 content: '<ks:hasSecurityResource identifier="SocketModify"><button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button></ks:hasSecurityResource>', 
                	 action: 'modify'
                 },/* {
                	 content: '<ks:hasSecurityResource identifier="SocketDelete"><button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button></ks:hasSecurityResource>', 
                	 action: 'delete'
                 }, */{
                	 content: '<ks:hasSecurityResource identifier="SocketChange"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-edit"><span>状态变更</button></ks:hasSecurityResource>', 
                	 action: 'change'
                 }];
		 	 };
	         return grid.grid({
	                identity:"id",
	                buttons: getButtons(),
	                pageSize : 1000,
	                isShowPages:false,
	                url:"${pageContext.request.contextPath}/Socket/pageJson.koala",
	                columns: [
								 { title: '配件编号', name: 'partNo', width: width},
								 
								 { title: '状态', name: 'status', width: width, render: function (rowdata, name, index){
	       	                    	 	var h="<div style='background-color:"+proCardstatusColor(rowdata[name])+"'>"+rowdata[name]+"</div>"
	       	                    	 	return h;
	                             	 }
	                         	 },
	                         	 { title: '嫁动平台', name: 'platform', width: width},
	                         	 { title: '嫁动Site', name: 'platformSite', width: width},
       	                         { title: '配件类别', name: 'partType', width: width},
       	                      	 { title: '配件规格', name: 'partModel', width: 100},
       	                         { title: '可用机台', name: 'equipmentList', width: 180},
       	                      	 { title: '当前接触数量', name: 'touchTime', width: 110},
    	                   		 { title: '接触总数', name: 'touchTimeTotal', width: width},
       	                      	 { title: 'P/N(S/N)', name: 'pn', width: 128},
       	                      	 { title: 'PIN Model', name: 'pinModels', width: 450},
       	                      	 { title: '供应商', name: 'supplier', width: 120},
       	                      	 { title: '归属', name: 'ownership', width: width},
       	                      	 { title: 'pin数量', name: 'pinQty', width: width},
       	                      	 { title: '备注', name: 'remark', width: 330},
       	                      	 { title: '适用型号', name: 'applicableModels', width: width},
       	                      	 { title: '进厂时间', name: 'inDate', width: width},
       	                      	 { title: '配件名称', name: 'partName', width: width},
    	                         { title: '验收单', name: 'lastFileUrl', width: width, render: function (rowdata, name, index)
	                                 {
	                                     var param = '"' + rowdata[name] + '"';
	                                     var h = "<a href="+ param +" download >下载</a> ";
	                                     return h;
                                 	 }
                             	 },
	       	                     { title: '操作详情', name: 'detil', width: width, render: function (rowdata, name, index){
	       	                    	 	var h="<a href='#' onclick='socketDetilView("+rowdata.id+")'>查看</a>"
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
	        $.get('<%=path%>/Socket-add.jsp').done(function(html){
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
	    		  if($("input[name='acceptanceList']").val()==""||$("input[name='acceptanceList']").val()==undefined)
	    		  {
	    			//showErrorMessage($("#tablefile").closest('.modal'), $("#tablefile"), "请上传验收单");
	    			//return;
	    		  }
	              $.post('${pageContext.request.contextPath}/Socket/add.koala', dialog.find('form').serialize()).done(function(result){
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
	        $.get('<%=path%>/Socket-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/Socket/get/' + id + '.koala').done(function(json){
	                       json = json.data
	                       if(json['acceptanceList']!=null)
	                     	{
	                       		dialog.find("#filelist").append("<p>"+json['lastFileUrl'].split("/")[json['lastFileUrl'].split("/").length-1]+"</p>");
	                     	};
	                     	if(json['inDate']!=null)
	                     	{
	                     		json['inDate']=json['inDate'].substring(0,10);
	                     	};
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
	          		  if($("input[name='acceptanceList']").val()==""||$("input[name='acceptanceList']").val()==undefined)
	        		  {
	        			//showErrorMessage($("#tablefile").closest('.modal'), $("#tablefile"), "请上传验收单");
	        			//return;
	        		  }
	                    $.post('${pageContext.request.contextPath}/Socket/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    change: function(id, grid,data){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">状态变更</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/SocketOptionLog-add.jsp').done(function(html){
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
	                self.initPage(dialog.find('form'));
	                dialog.find(".none").css("display","none");
	                dialog.find('#statusIdID .dropdown-menu').bind("click",function(){
	                	debugger;
		                switch($("#statusIdID input").val())
		                {
		                	case '103'://退回厂商
		                	case '104'://归还客户
		                		$(".none").css("display","none");
		                		$(".status1").css("display","block");
		                		break;
		                	case '102'://报废
		                		$(".none").css("display","none");
		                		$(".status2").css("display","block")
		                		break;
		                	case '101'://暂停使用
		                		$(".none").css("display","none");
		                		$(".status3").css("display","block")
		                		break;
		                	case '98'://维修
		                		$(".none").css("display","none");
		                		$(".status5").css("display","block")
		                		break;
		                	case '97'://在库正常
		                		$(".none").css("display","none");
		                		$(".status6").css("display","block")
		                		break;
		                	case '99'://生产领出
		                	case '100'://工程领出
		                		$(".none").css("display","none");
		                		$(".status4").css("display","block")
		                		break;
		                	case '116'://Release
		                		$(".none").css("display","none");
		                		$(".status7").css("display","block")
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
	                		data: {"testerCategoryId":$("#platformID input").val(),"category":"FT"},
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
	                    $("#equipmentListID").val(string);
	                    $("#equipmentListIdID").val(stringId);
	                    $.post('${pageContext.request.contextPath}/Socket/changeStatus.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    	$.post('${pageContext.request.contextPath}/Socket/delete.koala', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.actionError
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
            $("#<%=formId%>").find('input').each(function(){
                var $this = $(this);
                var name = $this.attr('name');
                if(name){
                    params[name] = $this.val();
                }
            });
            params['pagesize']=1000;
            $("#<%=gridId%>").getGrid().search(params);
        });
});
function socketDetilView(id){
	openTab('/pages/domain/SocketOptionLog-list.jsp', 'Socket操作记录', 'menuMark205');
	SocketGlobleId=id;
}
var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/Socket-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/Socket/get/' + id + '.koala').done(function(json){
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
        <div class="form-group">
<!--           <label class="control-label" style="width:75px;float:left;">进场时间:&nbsp;</label>
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
                  <label class="control-label" style="width:100px;float:left;">状态:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            <div class="btn-group select" id="statusID"></div>
            <input name="status"  type="hidden" id="statusID_" />
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
