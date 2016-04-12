<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<%-- <%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp --> --%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript" src="/lib/jquery.form.js"></script>
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
            	if(filename.length>50)
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
       	                 var contents = [{title:'请选择', value: ''}];
       	                     contents.push({title:'审批前' , value:'审批前'});
       	                     contents.push({title:'审批后' , value:'审批后'});
       	                     contents.push({title:'已借机' , value:'已借机'});
       	                     contents.push({title:'结单' , value:'结单'});
       	                     form.find('#state_SELECT').select({
                              title: '请选择',
                              contents: contents
                         }).on('change',function(){
                             form.find('#stateID_').val($(this).getValue());
                         });
  	            	        var contents = [{title:'请选择', value: ''}];
       	                    contents.push({title:'FT' , value:'FT'});
       	                    contents.push({title:'CP' , value:'CP'});
       	                	contents.push({title:'oven' , value:'oven'});
    	                    contents.push({title:'ink' , value:'ink'});
       	                    form.find('#type_SELECT').select({
                              title: '请选择',
                              contents: contents
                         }).on('change',function(){
                             form.find('#typeID_').val($(this).getValue());
                         });
	    },
	    initGridPanel: function(){
	         var self = this;
	         var width = 100;
	         var getButtons = function() {
                 return [{
                	 content: '<ks:hasSecurityResource identifier="borrowMachineAdd"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>提交申请</button></ks:hasSecurityResource>', 
                	 action: 'add'
                 },{
                	 content: '<ks:hasSecurityResource identifier="borrowMachineDele"><button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>撤销申请</button></ks:hasSecurityResource>', 
                	 action: 'delete'
                 },{
                	 content: '<ks:hasSecurityResource identifier="borrowMachineApprove"><button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>审批申请</button></ks:hasSecurityResource>', 
                	 action: 'approve'
                 },{
                	 content: '<ks:hasSecurityResource identifier="borrowMachineBorrow"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-import"><span>借机</button></ks:hasSecurityResource>', 
                	 action: 'borrow'
                 },{
                	 content: '<ks:hasSecurityResource identifier="borrowMachineReturn"><button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-export"><span>还机</button></ks:hasSecurityResource>', 
                	 action: 'returner'
                 }];
		 	 };
	         return grid.off().grid({
	                identity:"id",
	                buttons: getButtons(),
	                url:"${pageContext.request.contextPath}/BorrowMachine/pageJson.koala",
	                columns: [
	                     	         { title: '状态', name: 'state', width: 70},
           	                         { title: '申请人', name: 'proposer', width: 90},
           	                         { title: '部门', name: 'department', width: 70},
           	                         { title: '设备类型', name: 'type', width: 80},
           	                         { title: '申请时间', name: 'appTime', width: width},
           	                         { title: '平台编号', name: 'platformName', width: width},
           	                         { title: '预计开始时间', name: 'estimatedStartTime', width: 120},
           	                         { title: '预计结束时间', name: 'estimatedEndTime', width: 120},
           	                         { title: '预计时间', name: 'estimatedTime', width: width, render: function (rowdata, name, index)
		                                 {
		                                     var param = rowdata[name]/1000/3600;
		                                     return param.toFixed(2);
		                                 }
	                             	 },
           	                         { title: '借机单号', name: 'borrowNumber', width: width},
           	                         { title: '实际开始时间', name: 'actualBeginTime', width: 120},
           	                         { title: '实际结束时间', name: 'actualEndTime', width: 120},
           	                         { title: '实际需时', name: 'actualTime', width: width, render: function (rowdata, name, index)
		                                 {
		                                     var param = rowdata[name]/1000/3600;
		                                     return param.toFixed(2);
	                                 	 }
                             	 	 },
           	                         { title: '审批人', name: 'approver', width: width},
           	                         //{ title: '借用单位', name: 'company', width: width},
           	                         { title: '操作备注', name: 'remark', width: width}
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
	                        if(data.item[0].state != "审批前"){
	                            $this.message({
	                                type: 'warning',
	                                content: '当前记录状态不正确无法修改'
	                            })
	                            return;
	                        }
	                       self.modify(indexs[0], $this);
	                    },
	                    'approve': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行审批'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行审批'
	                            })
	                            return;
	                        }
	                        if(data.item[0].state != "审批前"){
	                            $this.message({
	                                type: 'warning',
	                                content: '当前记录状态不正确无法审批'
	                            })
	                            return;
	                        }
	                       self.approve(indexs[0], $this ,data['item'][0]);
	                    },
	                    'borrow': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行借机'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行借机'
	                            })
	                            return;
	                        }
	                        if(data.item[0].state != "审批后"){
	                            $this.message({
	                                type: 'warning',
	                                content: '当前记录状态不正确无法借机'
	                            })
	                            return;
	                        }
	                       self.borrow(indexs[0], $this ,data['item'][0]);
	                    },
	                    'returner': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行还机'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行还机'
	                            })
	                            return;
	                        }
	                        if(data.item[0].state != "已借机"){
	                            $this.message({
	                                type: 'warning',
	                                content: '当前记录状态不正确无法还机'
	                            })
	                            return;
	                        }
	                        var returner = function(){
	                        	self.returner(indexs[0], $this, data['item'][0]);
	                        };
	                        $this.confirm({
	                            content: '确定要还机结单?',
	                            callBack: returner
	                        });
	                    },
	                   'delete': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '请选择要撤销的记录'
	                            });
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '只能选择一条要撤销的记录'
	                            });
	                            return;
	                        }
	                        if(data.item[0].state == "已借机"||data.item[0].state == "结单"){
	                            $this.message({
	                                type: 'warning',
	                                content: '当前记录状态不正确无法撤销'
	                            })
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this,data.item[0].state);
	                        };
	                        $this.confirm({
	                            content: '确定要撤销所选记录吗?',
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
	        	+'<h4 class="modal-title">借机申请</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/BorrowMachine-add.jsp').done(function(html){
 	        	$.get('${pageContext.request.contextPath}/auth/currentUser/getUserDetail.koala').done(function(result){
	        		 dialog.find("#proposerID").val(result["data"]['userAccount']+"|"+result["data"]['name']);
	        		 $.get('${pageContext.request.contextPath}/OAUser/findByCondition.koala?accounts='+result["data"]['userAccount']).done(function(msg){
	        			 dialog.find("#departmentID").val(msg['data'][0]['deptName']);
	        		 });
	            }); 
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            dialog.find("#estimatedStartTimeID").val((new Date()).Format("yyyy-MM-ddThh:mm"));
	            self.initPage(dialog.find('form'));
	            dialog.find('#isPlantfromID .dropdown-menu').bind("click",function(){
		    		var isPlantfrom=$("#isPlantfromID input").val();
		    		debugger;
		    		if(isPlantfrom=="true")
		    			{
			    		   	var contents = [{title:'请选择', value: ''}];
			    	        contents.push({title:'CP' , value:"CP"});
			    	        contents.push({title:'FT' , value:"FT"});
			    	        selectItems['typeID'] = contents;
			    	        dialog.find("#typeID").data('koala.select',null);
			    			var partIdobj=dialog.find('#typeID');
			    			partIdobj['context']=partIdobj[0];
			    			partIdobj.select({
			                    title: '请选择',
			                    contents: contents
			                }).on('change', function(){
			                	dialog.find('#typeID_').val($(this).getValue());
			                });
			    			$("#typeID").parent().prev().text("平台类型:");
			    			$("#platformIdID").parent().prev().text("平台编号:");
			    			dialog.find('#typeID .dropdown-menu').bind("click",function(){
					    		var type=$("#typeID input").val();
					    		$.ajax({
					    			async:false,
					    			url: '${pageContext.request.contextPath}Platform/findByType.koala?type='+type,
					    			type: 'GET',
					    			dataType: 'json',
					    		})
					    		.done(function(msg) {
					    			var contents = [{title:'请选择', value: ''}];
					    			for (var i=0;i<msg['data'].length;i++)
					    			{
					    				contents.push({title:msg['data'][i]['platformNo'] , value: msg['data'][i]['id']});
					    			}
					    			dialog.find("#platformIdID").data('koala.select',null);
					    			var partIdobj=dialog.find('#platformIdID');
					    			partIdobj['context']=partIdobj[0];
					    			partIdobj.select({
					                    title: '请选择',
					                    contents: contents
					                }).on('change', function(){
					                	dialog.find('#platformIdID_').val($(this).getValue());
					                });
					    			dialog.find('#platformIdID .dropdown-menu').bind("click",function(){
							    		var platformId=$("#platformIdID input").val();
							    		$.ajax({
							    			async:false,
							    			url: '${pageContext.request.contextPath}Platform/findEquipmentsByPlatform/'+platformId+'.koala',
							    			type: 'GET',
							    			dataType: 'json',
							    		})
							    		.done(function(msg) {
							    			debugger;
							    			var appendString="";
							    			for(var i in msg['data'])
						    				{
							    				appendString+="<label for="+msg['data'][i]['equipmentNo']+">"+msg['data'][i]['equipmentNo']+"</label><input type='checkBox' id="+msg['data'][i]['equipmentNo']+" index="+msg['data'][i]['id']+" name="+msg['data'][i]['equipmentNo']+" />"
						    				}
							    			$(".platformEquipRoom").empty();
							    			$(".platformEquipRoom").append(appendString);
							    			$(".platformEquipBanner").show();
							    		});
					    			});
					    		});
			    			});
		    			}
		    		else{
			    			var contents = [{title:'请选择', value: ''}];
			    	        contents.push({title:'INK' , value:"10"});
			    	        contents.push({title:'OVEN' , value:"11"});
			    	        selectItems['typeID'] = contents;
			    	        dialog.find("#typeID").data('koala.select',null);
			    			var partIdobj=dialog.find('#typeID');
			    			partIdobj['context']=partIdobj[0];
			    			partIdobj.select({
			                    title: '请选择',
			                    contents: contents
			                }).on('change', function(){
			                	dialog.find('#typeID_').val($(this).getValue());
			                });
			    			$("#typeID").parent().prev().text("设备类型:");
			    			$("#platformIdID").parent().prev().text("设备编号:");
			    			$(".platformEquipRoom").empty();
			    			$(".platformEquipBanner").hide();
			    			dialog.find('#typeID .dropdown-menu').bind("click",function(){
					    		var type=$("#typeID input").val();
					    		$.ajax({
					    			async:false,
					    			url: '${pageContext.request.contextPath}/Equipment/findEquipments.koala?equipmentCategoryId='+type,
					    			type: 'GET',
					    			dataType: 'json',
					    		})
					    		.done(function(msg) {
					    			var contents = [{title:'请选择', value: ''}];
					    			for (var i=0;i<msg['data'].length;i++)
					    			{
					    				contents.push({title:msg['data'][i]['equipmentNo'] , value: msg['data'][i]['id']});
					    			}
					    			dialog.find("#platformIdID").data('koala.select',null);
					    			var partIdobj=dialog.find('#platformIdID');
					    			partIdobj['context']=partIdobj[0];
					    			partIdobj.select({
					                    title: '请选择',
					                    contents: contents
					                }).on('change', function(){
					                	dialog.find('#platformIdID_').val($(this).getValue());
					                });
					    		});
			    			});
		    		}
				});
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              if($("#estimatedStartTimeID").val()>=$("#estimatedEndTimeID").val())
            	  {
	            	  dialog.message({
                          type: 'error',
                          content: '预计开始时间应该小于结束时间请检查'
                       });
	            	  return;
            	  }
	              if($(".platformEquipRoom").children("input").length>0)
	            	  {
	            	  	var plantfromEquipId="";
	            	  	for(var i=0;i<$(".platformEquipRoom").children("input").length;i++)
            	  		{
	            	  		if($(".platformEquipRoom").children("input").eq(i).attr("checked")=="checked")
	            	  		{
	            	  			plantfromEquipId+=$(".platformEquipRoom").children("input").eq(i).attr("index")+",";
	            	  		}
            	  		}
	            	  	plantfromEquipId=plantfromEquipId.substring(0,plantfromEquipId.length-1);
	            	  	$("#platformEquipIdID").val(plantfromEquipId);
	            	  }
	              debugger;
	              $.post('${pageContext.request.contextPath}/BorrowMachine/add.koala', dialog.find('form').serialize()).done(function(result){
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
	        $.get('<%=path%>/BorrowMachine-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/BorrowMachine/get/' + id + '.koala').done(function(json){
	                       json = json.data;
	                       debugger;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(index=="appTime"||index=="estimatedStartTime"||index=="estimatedEndTime")
	                            	{
	                            		json[index]=json[index].replace(" ","T");
	                            	}
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
	                    $.post('${pageContext.request.contextPath}/BorrowMachine/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    borrow: function(id, grid ,data){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 750px;">'
	            	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	            	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	            	+'<h4 class="modal-title">借机</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
	            	+'</div></form></div><div class="modal-footer">'
	            	+'<button type="button" class="btn btn-default" id="cancle" data-dismiss="modal">取消</button>'
	            	+'<button type="button" class="btn btn-default" id="prv">上一步</button>'
	            	+'<button type="button" class="btn btn-success" id="next">下一步</button>'
	            	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	            	+'</div></div>');
	        $.get('<%=path%>/BorrowMachine-borrow.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               var contents = [{title:'请选择', value: ''}];
	          	    $.ajax({
	          	    	async:false,
	          	    	url: '${pageContext.request.contextPath}/ProbeCard/getProbeCardByPlatformId/'+data['platformId']+'.koala',
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
	     	     	url: '${pageContext.request.contextPath}/Socket/productAll.koala?nowPlatformId='+data['platformId'],
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
	               self.initPage(dialog.find('form'));
	               debugger;
	               equiType=data['type'];
	               if(equiType=="FT"){
	          	    	dialog.find(".part_CP").remove();
	          	    	dialog.find(".part_OVEN").remove();
	          	    	//dialog.find("#nowStationID").val('FT');
	          	    	debugger;
	          	    	$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
	           	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowStationID").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowLotID").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowProductIDPrv").val(msg['data']['productModel']);
	           	    		dialog.find("#nowProductID").val(msg['data']['productModel']);
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
	           	    	});
	           	    	$.get('${pageContext.request.contextPath}/TestData/ft.koala?id='+id).done(function(msg){//获取机台生产数据
	           	    		if(msg['success']==false){
	           	    			grid.message({
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
	          	    	dialog.find("#nowLotID").on("focusout",function(){
	           	    		$.ajax({ 
	           	    			type: "get", 
	           	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$("#nowLotID").val()+"&category=FT", 
	           	    			success: function (result) {
	           	    				var data=eval("(" + result.documentElement.textContent + ")");
	           	    				dialog.find("#nowProductID").val(data['productModel']);
	           	    				dialog.find("#nowStationID").val(data['nowStation']);
	           	    				
	           	    				dialog.find("#grossDieID").val(data['grossDie']);
	           	    	    		dialog.find("#standardWorkHoursID").val(data['standardWorkHours']);
	           	    	    		dialog.find("#teamID").val(data['team']);
	           	    	    		dialog.find("#touchdownID").val(data['touchdown']);
	           	    			} 
	           	    		});
	           	    	})
	               }
	          	   else if(equiType=="CP"||equiType=="ink"){
	          	    	dialog.find(".part_FT").remove();
	          	    	dialog.find(".part_OVEN").remove();
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
	          	    	$.get('${pageContext.request.contextPath}/'+lastOptUrl+'/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
	           	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowProductIDPrv").val(msg['data']['productModel']);
	           	    		dialog.find("#nowStationID").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowLotID").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowProductID").val(msg['data']['productModel']);
	           	    		
	           	    		dialog.find("#grossDieID").val(msg['data']['grossDie']);
	           	    		dialog.find("#standardWorkHoursID").val(msg['data']['standardWorkHours']);
	           	    		dialog.find("#teamID").val(msg['data']['team']);
	           	    		dialog.find("#touchdownID").val(msg['data']['touchdown']);
	           	    		for(var i in msg['data']['chipSelection'].split(","))
	        	   			{
	           	    			dialog.find(".pianxuanRoom input[index='"+msg['data']['chipSelection'].split(",")[i]+"']").attr("checked","checked");
	           	    			dialog.find(".pianxuanRoom input[index='"+msg['data']['chipSelection'].split(",")[i]+"']").attr("disabled","disabled");
	           	    			dialog.find(".pianxuanBeizhuRoom input[index='"+msg['data']['chipSelection'].split(",")[i]+"']").val("");
	           	    			dialog.find(".pianxuanBeizhuRoom input[index='"+msg['data']['chipSelection'].split(",")[i]+"']").css("background-color","#eee");
	           	    			dialog.find(".pianxuanBeizhuRoom input[index='"+msg['data']['chipSelection'].split(",")[i]+"']").attr("readonly","readonly");
	        	   			}
	           	    		for(var j in msg['data']['chipSelectionRemark'].split(","))
	            			{
	            				if(msg['data']['chipSelectionRemark'].split(",")[j]!="")
	           					{
	            					debugger;
	            					dialog.find(".pianxuanBeizhuRoom input[index='"+(Number(j)+1)+"']").val(msg['data']['chipSelectionRemark'].split(",")[j]);
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
	           	    			} 
	           	    		});
	           	    	})
	          	    }
	          	    else if(equiType=="oven"){
	          	    	dialog.find(".part_CP").remove();
	          	    	dialog.find(".part_FT").remove();
	          	    	dialog.find("#nowStationID").val('烘烤');
	          	    	dialog.find('#productQtyID .dropdown-menu').bind("click",function(){
	          	    		$("#nowLotID").hide();
	          	   	    	$("#nowProductID").hide();
	          	    		var typearray=$("#productQtyID input").val();
	          	    		$(".nowLotChildRoom").empty();
	          	    		$(".nowProductChildRoom").empty();
	       					for(var i=0; i<typearray;i++)
	       					{
								$(".nowLotChildRoom").append("<input class='col-md-2' style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;'/>");
								$(".nowProductChildRoom").append("<input class='col-md-2' readonly style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;background-color:#eee'/>");
	       					}
	          			});
	          	    	
	          	    }
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
	          	 	if(equiType=="oven"){
	          	 		dialog.find("#save").show();
	          	 		dialog.find("#cancle").show();
	          	   		dialog.find("#next").hide();
	          	   		dialog.find("#prv").hide();
	          	 		dialog.find(".prvShow").remove()
	          	 		dialog.find(".nextShow").show();
	          	 	}
 	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                }); 
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(equiType=="FT"){
		  		        	  var array=dialog.find('form').serializeArray();
		  		        	  string=dialog.find('form').serialize().split("partIds")[0]+"partIds="+$("#partIds0ID_").val()+","+$("#partIds1ID_").val()+","+$("#partIds2ID_").val()+","+$("#partIds3ID_").val();
	  		          	}
	  		          	else if(equiType=="CP"||equiType=="ink"){
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
	                    else if(equiType=="oven"){
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
				          string=dialog.find('form').serialize();
			          	}
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/BorrowMachine/borrowMachine.koala?id='+id, string).done(function(result){
	                        if(result.success){
	                        	dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '借机成功'
	                            });
	                        }else{
	                        	e.data.grid.message({
	                            type: 'error',
	                            content: result.errorMessage
	                            });
	                        }
	                    });
	                });
	        });
	    },
	    returner: function(id, grid,data){
	        var self = this;
	        var lastSubstatus="";
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 750px;">'
	            	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	            	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	            	+'<h4 class="modal-title">借机</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group">'
	            	+'</div></form></div><div class="modal-footer">'
	            	+'<button type="button" class="btn btn-default" id="cancle" data-dismiss="modal">取消</button>'
	            	+'<button type="button" class="btn btn-default" id="prv">上一步</button>'
	            	+'<button type="button" class="btn btn-success" id="next">下一步</button>'
	            	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	            	+'</div></div>');
	        $.get('<%=path%>/BorrowMachine-return.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               var contents = [{title:'请选择', value: ''}];
		           	$.ajax({
		           		async:false,
		           		url: '${pageContext.request.contextPath}/Category/getByType/76.koala?type='+data['type'],
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
		           	var contents = [{title:'请选择', value: ''}];
		       	    $.ajax({
		       	    	async:false,
		       	    	url: '${pageContext.request.contextPath}/ProbeCard/getProbeCardByPlatformId/'+data['platformId']+'.koala',
		       	    	type: 'GET',
		       	    	dataType: 'json',
		       	    })
		       	    .done(function(msg) {
		       	    	for (var i in msg['data'])
		       	    	{
		       	    		contents.push({title:msg['data'][i]['partNo'] , value: msg['data'][i]['id']});
		       	    	}
		       	    	selectItems['partIdsID'] = contents;
		       	    });
		       	 var contents = [{title:'请选择', value: ''}];
	     	     $.ajax({
	     	     	async:false,
	     	     	url: '${pageContext.request.contextPath}/Socket/productAll.koala?nowPlatformId='+data['platformId'],
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
	               self.initPage(dialog.find('form'));
	               dialog.find('#statusIdID .dropdown-menu').bind("click",function(){
	           		var typearray=$("#statusIdID input").val();
	           		var statusSelect=$("#statusIdID button[data-toggle='item']").text();
	        		if(statusSelect=="IDLE"||statusSelect=="停机"){
	        			$("#nowLotID").val("NA");
	        		}
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
                       		dialog.find('#subStatusIdID_').val($(this).getValue());
                       		var statusSelect=$("#statusIdID button[data-toggle='item']").text();
                       		debugger;
                        	if(statusSelect!="停机"&&$(this).data("koala.select").$item.text()!="不同批号换批"&&$(this).getValue()!=undefined)
                       		{
                        		$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
                       	    		dialog.find("#nowStationID").val(msg['data']['nowStation']);
                       	    		dialog.find("#nowLotID").val(msg['data']['nowLot']);
                       	    		dialog.find("#nowProductID").val(msg['data']['productModel']);
                       	    		dialog.find("#beforeTestQtyID").val(msg['data']['lastTestNo']);
                       	    	});
                       		}
                        	else{
                        		dialog.find("#nowStationID").val();
                   	    		dialog.find("#nowLotID").val();
                   	    		dialog.find("#nowProductID").val();
                   	    		dialog.find("#beforeTestQtyID").val();
                        	}
                       });
	           		});
	       		});
	               equiType=data['type']; 
	               if(equiType=="FT"){
	          	    	dialog.find(".part_CP").remove();
	          	    	dialog.find(".part_OVEN").remove();
	          	    	debugger;
	          	    	$.get('${pageContext.request.contextPath}/Platform/getLastPlatformOptionLog/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
	          	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowProductIDPrv").val(msg['data']['productModel']);
	           	    		dialog.find("#beforeTestQtyID").val(msg['data']['lastTestNo']);
	           	    		dialog.find("#testQtyID").val(msg['data']['lastTestNo']);
	           	    		
	           	    		dialog.find("#grossDieID").val(msg['data']['grossDie']);
	           	    		dialog.find("#standardWorkHoursID").val(msg['data']['standardWorkHours']);
	           	    		dialog.find("#teamID").val(msg['data']['team']);
	           	    		dialog.find("#touchdownID").val(msg['data']['touchdown']);
	           	    		
	           	    		lastSubstatus=msg['data']['subStatus'];
	           	    		var array=msg['data']['partIds'].split(",");
	           	    		for(var j in array)
	        	   			{
	        	   				dialog.find("#partIds"+j+"ID").setValue(array[j]);
	        	   			}
	           	    	});
	          	    	$.get('${pageContext.request.contextPath}/TestData/ft.koala?id='+id).done(function(msg){//获取机台生产数据
	           	    		if(msg['success']==false){
	           	    			grid.message({
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
	          	    	dialog.find("#nowLotID").on("focusout",function(){
	           	    		$.ajax({ 
	           	    			type: "get", 
	           	    			url: "http://192.168.1.37:8080/Time.asmx/GetLotInfo?lot="+$("#nowLotID").val()+"&category=FT", 
	           	    			success: function (result) {
	           	    				var data=eval("(" + result.documentElement.textContent + ")");
	           	    				dialog.find("#nowProductID").val(data['productModel']);
	           	    				dialog.find("#nowStationID").val(data['nowStation']);
	           	    				
	           	    				dialog.find("#grossDieID").val(data['grossDie']);
	           	    	    		dialog.find("#standardWorkHoursID").val(data['standardWorkHours']);
	           	    	    		dialog.find("#teamID").val(data['team']);
	           	    	    		dialog.find("#touchdownID").val(data['touchdown']);
	           	    			} 
	           	    		});
	           	    	})
	               }
	          	    else if(equiType=="CP"||equiType=="ink"){
	          	    	dialog.find(".part_FT").remove();
	          	    	dialog.find(".part_OVEN").remove();
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
	          	    	$.get('${pageContext.request.contextPath}/'+lastOptUrl+'/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
	          	    		debugger;
	          	    		dialog.find("#nowStationIDPrv").val(msg['data']['nowStation']);
	           	    		dialog.find("#nowLotIDPrv").val(msg['data']['nowLot']);
	           	    		dialog.find("#nowProductIDPrv").val(msg['data']['nowProduct']);
	           	    		
	           	    		dialog.find("#grossDieID").val(msg['data']['grossDie']);
	           	    		dialog.find("#standardWorkHoursID").val(msg['data']['standardWorkHours']);
	           	    		dialog.find("#teamID").val(msg['data']['team']);
	           	    		dialog.find("#touchdownID").val(msg['data']['touchdown']);
	           	    		lastSubstatus=msg['data']['subStatus'];
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
	            					debugger;
	            					dialog.find(".pianxuanBeizhuRoom input[index='"+(Number(j)+1)+"']").val(msg['data']['chipSelectionRemark'].split(",")[j]);
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
	           	    			} 
	           	    		});
	           	    	})
	          	    }
	          	    else if(equiType=="oven"){
	          	    	dialog.find(".part_CP").remove();
	          	    	dialog.find(".part_FT").remove();
	          	    	$.get('${pageContext.request.contextPath}/Equipment/getLastEquipmentOptionLog/'+data['platformId']+'.koala').done(function(msg){//获取上一状态的信息并且初始化弹框上输入项所具有的事件属性
	          	    		lastSubstatus=msg['data']['subStatus'];
	          	    	});
	          	    	dialog.find('#productQtyID .dropdown-menu').bind("click",function(){
	          	    		$("#nowLotID").hide();
	          	   	    	$("#nowProductID").hide();
	          	    		var typearray=$("#productQtyID input").val();
	          	    		$(".nowLotChildRoom").empty();
	          	    		$(".nowProductChildRoom").empty();
	       				for(var i=0; i<typearray;i++)
	       					{
								$(".nowLotChildRoom").append("<input class='col-md-2' style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;'/>");
								$(".nowProductChildRoom").append("<input class='col-md-2' readonly style='margin-right:4px;margin-right: 4px;padding: 0px 1px 0px 1px;border-radius: 3px;border: 1px solid #ccc;height: 23px;background-color:#eee'/>");
	       					}
	          			});
	          	    	
	          	    }
	                dialog.find(".prvShow").show();
	          		dialog.find(".nextShow").hide();
	          		dialog.find("#next").show();
	          		dialog.find("#prv").hide();
	          		dialog.find("#save").hide();
	          	 	dialog.find('#next').on('click', function(e){
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
	          	 	if(equiType=="oven"){
	          	 		dialog.find("#save").show();
	          	 		dialog.find("#cancle").show();
	          	   		dialog.find("#next").hide();
	          	   		dialog.find("#prv").hide();
	          	 		dialog.find(".prvShow").remove()
	          	 		dialog.find(".nextShow").show();
	          	 	}
 	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                }); 
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	 	                var stringPmType="";
	 	                for(var i=0;i<$("input[name*=repairCycle]:checked").length;i++){
	 	                	stringPmType+=$("input[name*=repairCycle]:checked").eq(i).next().text()+",";
	 	                }
	 	                stringPmType=stringPmType.substring(0,stringPmType.length-1);
	 	                $("#pmTypeID").val(stringPmType);
	                    if(equiType=="FT"){
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
	  		          	else if(equiType=="CP"||equiType=="ink"){
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
	                    else if(equiType=="oven"){
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
				          string=dialog.find('form').serialize();
			          	}
	                    if($("#statusIdID input").val()=="45"||$("#statusIdID input").val()=="67"||$("#statusIdID input").val()=="105"||$("#statusIdID input").val()=="107")
		  	        	{
		  		    		$("#partIdsID_").attr("dataType","Require");
		  	        	}
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    if(lastSubstatus=="PM")
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
	                    debugger;
			            $.post('${pageContext.request.contextPath}/BorrowMachine/returnMachine.koala?id='+id, string).done(function(result){
			                if(result.success){
			                	dialog.modal('hide');
			                    grid.data('koala.grid').refresh();
			                    grid.message({
			                    type: 'success',
			                    content: '还机成功'
			                    });
			                }else{
			                	dialog.modal('hide');
			                    grid.data('koala.grid').refresh();
			                	grid.message({
			                    type: 'error',
			                    content: result.errorMessage
			                    });
			                }
			            });
	                });
	        });
            //PageLoader.initSearchPanel();
	    },
	    approve: function(id, grid,data){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog" style="width: 40%;"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">审批</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        equiType=data['type'];
	        $.get('<%=path%>/BorrowMachine-approve.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/BorrowMachine/get/' + id + '.koala').done(function(json){
	                       json = json.data;
	                       if(equiType=="CP"||equiType=="FT"){
		                       $.ajax({
					    			async:false,
					    			url: '${pageContext.request.contextPath}Platform/findEquipmentsByPlatform/'+json['platformId']+'.koala',
					    			type: 'GET',
					    			dataType: 'json',
					    		})
					    		.done(function(msg) {
					    			var appendString="";
					    			for(var i in msg['data'])
				    				{
					    				appendString+="<label for="+msg['data'][i]['equipmentNo']+">"+msg['data'][i]['equipmentNo']+"</label><input type='checkBox' disabled id="+msg['data'][i]['equipmentNo']+" index="+msg['data'][i]['id']+" name="+msg['data'][i]['equipmentNo']+" />"
				    				}
					    			dialog.find(".platformEquipRoom").empty();
					    			dialog.find(".platformEquipRoom").append(appendString);
					    			dialog.find(".platformEquipBanner").show();
					    		});
		                       	for(var j in json['platformEquipId'].split(','))
	                       		{
		                       		dialog.find(".platformEquipRoom input[index='"+json['platformEquipId'].split(',')[j]+"']").attr("checked","checked");
	                       		}
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
	                        $.get('${pageContext.request.contextPath}/auth/currentUser/getUserDetail.koala').done(function(result){
	    	                	debugger;
	    	               		dialog.find("#approverID").val(result["data"]['userAccount']+"|"+result["data"]['name']);
	    		            }); 
	                });
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                debugger;
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/BorrowMachine/approve.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.success){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '审批成功'
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
	    remove: function(ids, grid, status){
	    	var data = [{ name: 'ids', value: ids.join(',') },{name:'status',value:status}];
	    	debugger;
	    	$.post('${pageContext.request.contextPath}/BorrowMachine/cancelMachine.koala', data).done(function(result){
	                        if(result.success){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '撤销成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.errorMessage
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
        $.get('<%=path%>/BorrowMachine-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/BorrowMachine/get/' + id + '.koala').done(function(json){
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
<table border="0" cellspacing="0" cellpadding="0" style="width:100%">
  <tr>
    <td>
           <div class="form-group">
<!--           	     <label class="control-label" style="width:100px;float:left;">申请时间:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="appTime" id="appTimeID_start" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
            <div class="input-group date form_datetime" style="width:160px;float:left;" >
                <input type="text" class="form-control" style="width:160px;" name="appTimeEnd" id="appTimeID_end" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
       </div> -->
          <label class="control-label" style="width:50px;float:left;">状态:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="state_SELECT"></div>
	        <input type="hidden" id="stateID_" name="state" />
	      </div>
	      		 <label class="control-label" style="width:100px;float:left;">设备类型:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      <div class="btn-group select" id="type_SELECT"></div>
	        <input type="hidden" id="typeID_" name="type" />
	      </div>
	  </div>
 <!--                  <div class="form-group">
          <label class="control-label" style="width:100px;float:left;">预计开始时间:&nbsp;</label>
		       <div style="margin-left:15px;float:left;">
		            <div class="input-group date form_datetime" style="width:160px;float:left;" >
		                <input type="text" class="form-control" style="width:160px;" name="estimatedStartTime" id="estimatedStartTimeID_start" >
		                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		            </div>
		            <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
		            <div class="input-group date form_datetime" style="width:160px;float:left;" >
		                <input type="text" class="form-control" style="width:160px;" name="estimatedStartTimeEnd" id="estimatedStartTimeID_end" >
		                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		            </div>
		       </div> 

            </div>-->
            </td>
       <td style="vertical-align: bottom; text-align: right;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
