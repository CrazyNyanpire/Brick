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
            strong {
			  color: #666;
			}
    </style>
    <script type="text/javascript">
        function search()
        {
            var begindate=$("#begindateCa").val();
            var begintime=$("#begintimeCa").val();
            var enddate=$("#enddateCa").val();
            var endtime=$("#endtimeCa").val();
            var i=0;
            var equipmentNumber="";
            var equipmentNumbers="";
            if($("#equipmentNumber option:selected").val()!="")
            {
                equipmentNumber=$("#equipmentNumber option:selected").val();
            }
            else{
                alert("请选择设备型号");
                return false;
            }
            if($("#equipmentNumber_all option:selected").val()!="")
            {
                equipmentNumbers=$("#equipmentNumber_all option:selected").val();
            }
            else{
                alert("请选择设备类型");
                return false;
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
          	barget(begindatetime,enddatetime);
          	platfromBarget(begindatetime,enddatetime);
        }
        function platfromBarget(begintime,endtime)
        {
                $.ajax({
                    url: 'http://192.168.1.38/reportView/equipCapacity/platfromCapacityGet.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime},
                    dataType:'json'
                })
                .done(function(msg) {
                debugger;
                $('#palntfromContainer').highcharts({
                    chart: {
                        type: 'column',
                        margin: [ 50, 50, 100, 80]
                    },
                    title: {
                        text: 'The platfrom Capacity'
                    },
                    xAxis: {
                        categories: msg['equipmentNo'],
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
                            text: 'capctiy(times)'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.y:.2f} times</b>',
                    },
                    credits: {enabled:false}, 
                    series: [{
                        name: 'capctiy',
                        data: msg['capctiy'],
                        dataLabels: {
                            enabled: true,
                            rotation: 0,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 0,
                            y: 20,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
            })
            .fail(function() {
                alert("查询失败");
            });
        }
        function barget(begintime,endtime)
        {
        		$.ajax({
                    url: 'http://192.168.1.38/reportView/equipCapacity/equipCapacityGet.php',
                    type: 'POST',
                    data: {begintime:begintime,endtime:endtime},
                    dataType:'json'
                })
                .done(function(msg) {
                debugger;
                $('#containerCapacity').highcharts({
                    chart: {
                        type: 'column',
                        margin: [ 50, 50, 100, 80]
                    },
                    title: {
                        text: 'The machine Capacity'
                    },
                    xAxis: {
                        categories: msg['equipmentNo'],
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
                            text: 'capctiy(times)'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.y:.2f} times</b>',
                    },
                    credits: {enabled:false}, 
                    series: [{
                        name: 'capctiy',
                        data: msg['capctiy'],
                        dataLabels: {
                            enabled: true,
                            rotation: 0,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 0,
                            y: 20,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
            })
			.fail(function() {
			    alert("查询失败");
            });
		}
        $(function () {
            var chart;
            $(document).ready(function () {
                var date = (new Date()).Format("yyyy-MM-dd");
                var datebegin = new Date(new Date()-432000000).Format("yyyy-MM-dd");
                var time = (new Date()).Format("hh:mm");
                $("#begindateCa").val(datebegin);
                $("#begintimeCa").val("00:00");
                $("#enddateCa").val(date);
                $("#endtimeCa").val(time);
                var begindatetimedefult = datebegin+" 00:00"; 
                var enddatetimedefult = date+" "+time;
                barget(begindatetimedefult,enddatetimedefult);
                platfromBarget(begindatetimedefult,enddatetimedefult);
            });
        });
        </script>
</head>
<body>
<script type="text/javascript" src="/lib/highcharts.js"></script>
<script type="text/javascript" src="/lib/modules/exporting.js"></script>
    <div class="container-fluid">
  	<div class="row">
    	<div style="height:30px;line-hight:30px;margin-bottom:2%;margin-left: 2%;">
	        <strong>beginTime:</strong>
	        <input id="begindateCa" type="date">
	        <input id="begintimeCa" type="time">
	        <strong>endTime:</strong>
	        <input id="enddateCa" type="date">
	        <input id="endtimeCa"type="time">
	        <input type="button" value="Search" onclick="search()">
        </div>
        <div class="row">
<!-- 		    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> 
		    	<div id="containerCapacity" style="min-width: 310px;height: 300px;margin: 0 auto;"></div>
		    </div> -->
		    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> 
		    	<div id="palntfromContainer" style="min-width: 310px;height: 600px;margin: 0 auto;"></div>
		    </div>
	    </div>
    </div>
    </div>
</body>
</html>