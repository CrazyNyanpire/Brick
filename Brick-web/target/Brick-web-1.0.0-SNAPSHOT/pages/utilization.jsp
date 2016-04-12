<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head  lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style>
            body{
                font-family: 微软雅黑;
            }
            select{
            	padding:0;
            	margin:0;
            	font-size: 12px;
            	
            }
            input[type=date],input[type=time]{
            	line-height:normal!important;
            }
    </style>
    <script type="text/javascript">
        function search(type)
        {
            var begindate=$("#begindate").val();
            var begintime=$("#begintime").val();
            var enddate=$("#enddate").val();
            var endtime=$("#endtime").val();
            var i=0;
            var equipmentNumber="";
            var equipmentNumbers="";
/*             if($("#equipmentNumber option:selected").val()!="")
            {
                equipmentNumber=$("#equipmentNumber option:selected").val();
            }
            else{
                alert("请选择设备型号");
                return false;
            } */
            if($("#equipmentNumber_all option:selected").val()!="")
            {
                equipmentNumbers=$("#equipmentNumber_all option:selected").val();
            }
            else{
                //alert("请选择设备类型");
                //return false;
            }
            if(begindate!="")
            {
                var begindatetime=begindate+" "+begintime;
            }
            else{
                alert("开始时间不允许有空值，请检查");
                return false;
            }
            if(enddate!="")
            {
                var enddatetime=enddate+" "+endtime;
            }
            else{
                alert("结束时间不允许有空值，请检查");
                return false;
            }
/*             if(type=="pie")
            {
                //chartget(begindatetime,enddatetime,equipmentNumber);
                chartgetall(begindatetime,enddatetime,equipmentNumbers);
            }
            else{
                //zhuzhuangtuget(begindatetime,enddatetime,equipmentNumber);
                zhuzhuangtugetall(begindatetime,enddatetime,equipmentNumbers);
            } */
            zhuzhuangtugettest(begindatetime,enddatetime,equipmentNumbers);
        }
/*         function searchall(type)
        {
            var begindate=$("#begindate_all").val();
            var begintime=$("#begintime_all").val();
            var enddate=$("#enddate_all").val();
            var endtime=$("#endtime_all").val();
            var i=0;
            var equipmentNumber="";
            if($("#equipmentNumber_all option:selected").val()!="")
            {
                equipmentNumber=$("#equipmentNumber_all option:selected").val();
            }
            if(begindate!="")
            {
                var begindatetime=begindate+" "+begintime;
            }
            else{
                alert("开始时间不允许有空值，请检查");
                return false;
            }
            if(enddate!="")
            {
                var enddatetime=enddate+" "+endtime;
            }
            else{
                alert("结束时间不允许有空值，请检查");
                return false;
            }
            if(type=="pie")
            {
                chartgetall(begindatetime,enddatetime,equipmentNumber);
            }
            else{
                zhuzhuangtugetall(begindatetime,enddatetime,equipmentNumber);
            }
        }
        function zhuzhuangtuget(begintime,endtime,id)
        {
            $.ajax({
                    url: 'http://192.168.1.38/reportView/utilization_rate/equipmentBack.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime,id:id,type:'pillar'},
                })
                .done(function(msg) {
                var date=msg.split(",");
                $('#container').highcharts({
                    chart: {
                        type: 'column',
                        margin: [ 50, 50, 100, 80]
                    },
                    title: {
                        text: 'The machine equipment utilization rate ('+getequipmentname(id)+')'
                    },
                    xAxis: {
                        categories: [
                            'SET_UP',
                            'RUN',
                            'REWORK',
                            'HALT',
                            'ENG_RUN',
                            'R/T_RUN',
                            'LAT_RUN',
                            'IDLE',
                            'ENGINEERING',
                            'DOWN',
                            'CLEAN',
                            'CHECK',
                            'BLANK',
                            'SPACE'
                        ],
                        labels: {
                            rotation: -45,
                            align: 'right',
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'duration(H)'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.y:.2f} H</b>',
                    },
                    credits: {enabled:false}, 
                    series: [{
                        name: 'duration',
                        data: [parseFloat(date[0]), parseFloat(date[1]), parseFloat(date[2]), parseFloat(date[3]), parseFloat(date[4]), parseFloat(date[5]),parseFloat(date[6]), parseFloat(date[7]), parseFloat(date[8]), parseFloat(date[9]),parseFloat(date[10]),parseFloat(date[11]),parseFloat(date[12]),parseFloat(date[13])],
                        dataLabels: {
                            enabled: true,
                            rotation: -90,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 4,
                            y: 10,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
            });
        }

        function chartget(begintime,endtime,id){
            $.ajax({
                    url: 'http://192.168.1.38/reportView/utilization_rate/equipmentBack.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime,id:id,type:'pie'},
                })
                .done(function(msg) {
                var date=msg.split(",");
                $('#container').highcharts({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        colors:[
                            '#f08300',
                            '#98d98e',
                            '#69821b',
                            '#965042',
                            '#2ca9e1',
                            '#3eb370',
                            '#316745',
                            '#fef263', 
                            '#0094c8', 
                            '#d9333f', 
                            '#b3ada0',
                            '#5654a2',
                            '#333333',
                            '#555555'
                        ],
                        title: {
                            text: 'The machine equipment utilization rate ()'
                        },
                        tooltip: {
                            pointFormat: '{series.name}:<b>{point.percentage:.1f}%</b>'
                        },
                        credits: {enabled:false}, 
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    format: '{point.name} : {point.percentage:.1f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend:{align: "left",
                        	layout: 'vertical',
                        },
                        series: [{
                            type: 'pie',
                            name: 'Browser share',
                            data: [['SET_UP',parseFloat(date[0])],['RUN',parseFloat(date[1])],['REWORK',parseFloat(date[2])],['HALT',parseFloat(date[3])],['ENG_RUN',parseFloat(date[4])],['R/T_RUN',parseFloat(date[5])],['LAT_RUN',parseFloat(date[6])],['IDLE',parseFloat(date[7])],['ENGINEERING',parseFloat(date[8])],['DOWN',parseFloat(date[9])],['CLEAN',parseFloat(date[10])],['CHECK',parseFloat(date[11])],['BLANK',parseFloat(date[12])],['SPACE',parseFloat(date[13])]]
                        }]
                    });
                })
                .fail(function() {
                    alert('没有查到相关信息');
                })
        } 
         function zhuzhuangtugetall(begintime,endtime,id)
        {
            $.ajax({
                    url: 'http://192.168.1.38/reportView/utilization_rate/equipmentBack.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime,id:id,type:'pillar'},
                })
                .done(function(msg) {
                var date=msg.split(",");
                $('#containerall').highcharts({
                    chart: {
                        type: 'column',
                        margin: [ 50, 50, 100, 80]
                    },
                    title: {
                        text: 'The machine equipment utilization rate ('+$("#equipmentNumber_all option:selected").text()+')'
                    },
                    xAxis: {
                        categories: [
                            'SET_UP',
                            'RUN',
                            'REWORK',
                            'HALT',
                            'ENG_RUN',
                            'R/T_RUN',
                            'LAT_RUN',
                            'IDLE',
                            'ENGINEERING',
                            'DOWN',
                            'CLEAN',
                            'CHECK',
                            'BLANK',
                            'SPACE'
                        ],
                        labels: {
                            rotation: -45,
                            align: 'right',
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'duration(H)'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    credits: {enabled:false},
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.y:.2f} H</b>',
                    },
                    series: [{
                        name: 'duration',
                        data: [parseFloat(date[0]), parseFloat(date[1]), parseFloat(date[2]), parseFloat(date[3]), parseFloat(date[4]), parseFloat(date[5]),parseFloat(date[6]), parseFloat(date[7]), parseFloat(date[8]), parseFloat(date[9]),parseFloat(date[10]),parseFloat(date[11]),parseFloat(date[12]),parseFloat(date[13])],
                        dataLabels: {
                            enabled: true,
                            rotation: -90,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 4,
                            y: 10,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
            });
        }

        function chartgetall(begintime,endtime,id){
            $.ajax({
                    url: 'http://192.168.1.38/reportView/utilization_rate/equipmentBack.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime,id:id,type:'pie'},
                })
                .done(function(msg) {
                var date=msg.split(",");
                $('#containerall').highcharts({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        colors:[
							'#555555',
							'#333333',
							'#8a2be1',
							'#b3ada0',
							'#fe0000',
							'#5e9ea0',
							'#ffff00',
							'#008102',
							'#008102',
							'#0000fe',
							'#a52b2a',
							'#7f8000',
							'#008102',
							'#fea500'
                        ],
                        title: {
                            text: 'The machine equipment utilization rate ('+$("#equipmentNumber_all option:selected").text()+')'
                        },
                        tooltip: {
                            pointFormat: '{series.name}:<b>{point.percentage:.1f}%</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    format: '{point.name} : {point.percentage:.1f} %'
                                },
                                showInLegend: true
                            }
                        },
                        legend:{align: "left",
                        	layout: 'vertical',
                        },
                        credits: {enabled:false},
                        series: [{
                            type: 'pie',
                            name: 'Browser share',
                            data: [['SET_UP',parseFloat(date[0])],['RUN',parseFloat(date[1])],['REWORK',parseFloat(date[2])],['HALT',parseFloat(date[3])],['ENG_RUN',parseFloat(date[4])],['R/T_RUN',parseFloat(date[5])],['LAT_RUN',parseFloat(date[6])],['IDLE',parseFloat(date[7])],['ENGINEERING',parseFloat(date[8])],['DOWN',parseFloat(date[9])],['CLEAN',parseFloat(date[10])],['CHECK',parseFloat(date[11])],['BLANK',parseFloat(date[12])],['SPACE',parseFloat(date[13])]]
                        }]
                    });
                })
                .fail(function() {
                    alert('没有查到相关信息');
                })
        } */
        function zhuzhuangtugettest(begintime,endtime,id)
        {
            $.ajax({
                    url: 'http://192.168.1.38/reportView/utilization_rate/equipmenttest.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime,id:id},
                    dataType:'json'
                })
                .done(function(msg) {
                    var categories=[];
                    var series=[{name:'SPACE',data:[]},{name:'BLANK',data:[]},{name:'CHECK',data:[]},{name:'CLEAN',data:[]},{name:'DOWN',data:[]},{name:'ENGINEERING',data:[]},{name:'IDLE',data:[]},{name:'R/T_RUN',data:[]},{name:'LAT_RUN',data:[]},{name:'ENG_RUN',data:[]},{name:'HALT',data:[]},{name:'REWORK',data:[]},{name:'RUN',data:[]},{name:'SET_UP',data:[]},{name:'ENG_WAIT',data:[]}]
                    for(var i in msg){
                        categories.push(i);
                        msg[i]['ENG_WAIT']==undefined?series[14]['data'].push(0):series[14]['data'].push(msg[i]['ENG_WAIT']);
                        msg[i]['SET_UP']==undefined?series[13]['data'].push(0):series[13]['data'].push(msg[i]['SET_UP']);
                        msg[i]['RUN']==undefined?series[12]['data'].push(0):series[12]['data'].push(msg[i]['RUN']);
                        msg[i]['REWORK']==undefined?series[11]['data'].push(0):series[11]['data'].push(msg[i]['REWORK']);
                        msg[i]['HALT']==undefined?series[10]['data'].push(0):series[10]['data'].push(msg[i]['HALT']);
                        msg[i]['ENG_RUN']==undefined?series[9]['data'].push(0):series[9]['data'].push(msg[i]['ENG_RUN']);
                        msg[i]['LAT_RUN']==undefined?series[8]['data'].push(0):series[8]['data'].push(msg[i]['LAT_RUN']);
                        msg[i]['RT_RUN']==undefined?series[7]['data'].push(0):series[7]['data'].push(msg[i]['RT_RUN']);
                        msg[i]['IDLE']==undefined?series[6]['data'].push(0):series[6]['data'].push(msg[i]['IDLE']);
                        msg[i]['ENGINEERING']==undefined?series[5]['data'].push(0):series[5]['data'].push(msg[i]['ENGINEERING']);
                        msg[i]['DOWN']==undefined?series[4]['data'].push(0):series[4]['data'].push(msg[i]['DOWN']);
                        msg[i]['CLEAN']==undefined?series[3]['data'].push(0):series[3]['data'].push(msg[i]['CLEAN']);
                        msg[i]['CHECK']==undefined?series[2]['data'].push(0):series[2]['data'].push(msg[i]['CHECK']);
                        msg[i]['BLANK']==undefined?series[1]['data'].push(0):series[1]['data'].push(msg[i]['BLANK']);
                        msg[i]['SPACE']==undefined?series[0]['data'].push(0):series[0]['data'].push(msg[i]['SPACE']);
                    }
                    debugger;
                    $('#containertest').highcharts({
                        chart: {
                            type: 'bar'
                        },
                        title: {
                            text: 'The machine equipment utilization rate ('+$("#equipmentNumber_all option:selected").text()+')'
                        },
                        xAxis: {
                            categories: categories
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: 'Equipment status times(H)'
                            }
                        },
                        tooltip: {
                            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}H</b> ({point.percentage:.0f}%)<br>',
                            shared: false
                        },
                        colors:[
                            '#555555',
                            '#333333',
                            '#8a2be1',
                            '#b3ada0',
                            '#fe0000',
                            '#5e9ea0',
                            '#ffff00',
                            '#008102',
                            '#008102',
                            '#0000fe',
                            '#a52b2a',
                            '#7f8000',
                            '#008102',
                            '#fea500',
                            '#5e9ea0'
                        ],
                        credits: {enabled:false},
                        legend: {
                            backgroundColor: '#FFFFFF',
                            reversed: true
                        },
                        plotOptions: {
                            series: {
                                stacking: 'percent',
                                dataLabels: {
                                    enabled: true,
                                    formatter: function() {
                                    	if(this.percentage.toFixed(0)!=0)
                                        return this.percentage.toFixed(1)+"%<br>";
                                    },
                                    color: '#000'
                                }
                            }
                        },
                            series: series
                    });
                });
        }
        $(function () {
            var chart;
            $(document).ready(function () {
            	var contents = [];
            	$.ajax({
        			async:false,
        			url: '${pageContext.request.contextPath}/Category/get/7.koala',
        			type: 'POST',
        			dataType: 'json',
        		})
        		.done(function(msg) {
        			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        			{
        				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        			}
        		});
            	$.ajax({
        			async:false,
        			url: '${pageContext.request.contextPath}/Category/get/10.koala',
        			type: 'POST',
        			dataType: 'json',
        		})
        		.done(function(msg) {
        			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        			{
        				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        			}
        		});
            	$.ajax({
        			async:false,
        			url: '${pageContext.request.contextPath}/Category/get/11.koala',
        			type: 'POST',
        			dataType: 'json',
        		})
        		.done(function(msg) {
        			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        			{
        				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        			}
        		});
            	$.ajax({
        			async:false,
        			url: '${pageContext.request.contextPath}/Category/get/12.koala',
        			type: 'POST',
        			dataType: 'json',
        		})
        		.done(function(msg) {
        			for (var i=0;i<msg['data']['categoryChildren'].length;i++)
        			{
        				contents.push({title:msg['data']['categoryChildren'][i]['categoryName'] , value: msg['data']['categoryChildren'][i]['id']});
        			}
        		});
                var date = (new Date()).Format("yyyy-MM-dd");
                var datebegin = new Date(new Date()-432000000).Format("yyyy-MM-dd");
                var time = (new Date()).Format("hh:mm");
                $("#begindate").val(datebegin);
                $("#begintime").val("00:00");
                $("#enddate").val(date);
                $("#endtime").val(time);
                $("#equipmentNumber_all").append("<option value='27,28,29,14,15,16,17,18,19,20'>ALL</option>");
                for(var i in contents){
                	$("#equipmentNumber_all").append("<option value='"+contents[i]['value']+"'>"+contents[i]['title']+"</option>")
                }
                var begindatetimedefult = datebegin+" 00:00"; 
                var enddatetimedefult = date+" "+time;
                //chartget(begindatetimedefult,enddatetimedefult,"18");
                //chartgetall(begindatetimedefult,enddatetimedefult,"14");
                zhuzhuangtugettest(begindatetimedefult,enddatetimedefult,"27,28,29,14,15,16,17,18,19,20");
            });
        });
        </script>
</head>
<body>
<script type="text/javascript" src="/lib/highcharts.js"></script>
<script type="text/javascript" src="/lib/modules/exporting.js"></script>
    <div class="container-fluid">
    	<div class="row">
	    	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="height:30px;line-hight:30px;margin-bottom:1%">
		        <strong>beginTime:</strong>
		        <input id="begindate" type="date">
		        <input id="begintime" type="time">
		        <strong>endTime:</strong>
		        <input id="enddate" type="date">
		        <input id="endtime"type="time">
		        <strong>equipModul:</strong>
		        <select name="" id="equipmentNumber_all">
		        </select>
		        <input type="button" value="Search" onclick="search('pie')">
		        <input style="float:right" type="button" value="导出Excel" onclick="exportExle()">
	        </div>
        </div>
<!--        <div class="row">
         	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">    
		    	<div id="container" style="height: 300px;"></div>
		    </div>
		    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> 
		    	<div id="containerall" style="min-width: 310px;height: 300px;margin: 0 auto;"></div>
		    </div>
		    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		    	<div style="text-align:left;"><input type="button" value="Bar" onclick="search('zhuzi')"><input type="button" value="Pie" style="margin-left: 10px;" onclick="search('pie')"></div>
		    </div>
	    </div> -->
    	
     	<div class="row">
    		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		    	<div id="containertest" style="min-width: 310px;height: 600px;margin: 0 auto;"></div>
		    </div>
		</div> 
    </div>
</body>
<script>
function exportExle()
{
	var equipmentCategoryId=$("#equipmentNumber_all option:selected").val();
	if($("#equipmentNumber_all option:selected").text()=="ALL")
	{
		equipmentCategoryId="";
	}
	debugger;
	window.open("${pageContext.request.contextPath}/Export/Excel/equipmentStatus.koala?startTime="+$("#begindate").val()+" "+$("#begintime").val()+"&endTime="+$("#enddate").val()+" "+$("#endtime").val()+"&equipmentCategoryId="+equipmentCategoryId)
}
</script>
</html>