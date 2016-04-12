<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
   String contextPath = request.getContextPath();
%>
<script src="<%=contextPath %>/kendo-ui/js/jszip.min.js"></script>
<script src="<%=contextPath %>/kendo-ui/js/kendo.all.min.js"></script>
<script src="<%=contextPath %>/kendo-ui/js/kendo.timezones.min.js"></script>

<link href="<%=contextPath %>/kendo-ui/styles/kendo.common-material.min.css" rel="stylesheet" />
<link href="<%=contextPath %>/kendo-ui/styles/kendo.rtl.min.css" rel="stylesheet" />
<link href="<%=contextPath %>/kendo-ui/styles/kendo.material.min.css" rel="stylesheet" />
<link href="<%=contextPath %>/kendo-ui/styles/kendo.material.mobile.min.css" rel="stylesheet" />
<link href="<%=contextPath %>/kendo-ui/styles/kendo.dataviz.min.css" rel="stylesheet" />
<link href="<%=contextPath %>/kendo-ui/styles/kendo.dataviz.material.min.css" rel="stylesheet" />

<link rel="canonical" href="http://demos.telerik.com/kendo-ui/grid/excel-export" />

<link href="<%=contextPath %>/kendo-ui/content/shared/styles/examples.css" rel="stylesheet" />

<script src="<%=contextPath %>/kendo-ui/content/shared/js/kendo-dojo.js"></script>
<script src="<%=contextPath %>/kendo-ui/content/shared/js/console.js"></script>
<script src="<%=contextPath %>/kendo-ui/content/shared/js/prettify.js"></script>

<script src="<%=contextPath %>/kendo-ui/content/shared/js/example-datasources.js"></script>
<title>gridetest</title>
</head>
<body>
	<div id="example">
    <div id="grid"></div>
<script>
	$("#grid").kendoGrid({
            height: 549,//高度
            sortable: true,//排序
            groupable: true,//分组，聚合
            filterable: true,//过滤
            columnMenu: true,//列显示
            reorderable: true,//列拖动
            resizable: true,//列调整大小
            editable: "popup",//可编辑，默认Batch,可选inline，popup
            scrollable: true,//滚动条
            pageable: {
                input: false,//输入页数
                numeric: true,//是否显示数字页
                refresh: true,//自刷新
                pageSizes: true,//每页显示多少行
                buttonCount: 10
            },//翻页
            toolbar: ["create","excel","pdf", "cancel"],//定义按钮，可直接加{text: "Export to PDF",imageClass: "k-i-pdf",className: "k-grid-pdf",iconClass: "k-icon"}
            excel: {
                fileName: "Kendo UI Grid Export.xlsx",
                proxyURL: "http://demos.telerik.com/kendo-ui/service/export",
                filterable: true
            },
            dataSource: {
                type: "odata",
                transport: {
                    read: "http://demos.telerik.com/kendo-ui/service/Northwind.svc/Products"
                },
                schema:{
                    model: {
                        fields: {
                            UnitsInStock: { type: "number" },
                            ProductName: { type: "string" },
                            UnitPrice: { type: "number" },
                            UnitsOnOrder: { type: "number" },
                            UnitsInStock: { type: "number" }
                        }
                    }
                },//定义显示的列字段
                pageSize: 10,
                group: {
                    field: "UnitsInStock", aggregates: [
                        { field: "ProductName", aggregate: "count" },
                        { field: "UnitPrice", aggregate: "sum"},
                        { field: "UnitsOnOrder", aggregate: "average" },
                        { field: "UnitsInStock", aggregate: "count" }
                    ]
                },//分组
                aggregate: [
                    { field: "ProductName", aggregate: "count" },
                    { field: "UnitPrice", aggregate: "sum" },
                    { field: "UnitsOnOrder", aggregate: "average" },
                    { field: "UnitsInStock", aggregate: "min" },
                    { field: "UnitsInStock", aggregate: "max" }
                ]//聚合
            },
            columns: [
                { width: 250, locked: true, field: "ProductName", title: "Product Name", aggregates: ["count"], footerTemplate: "Total Count: #=count#", groupFooterTemplate: "Count: #=count#" },
                { width: 250, field: "UnitPrice", title: "Unit Price",format: "{0:c}", aggregates: ["sum"] , footerTemplate: "Sum: #=sum#", groupFooterTemplate: "Sum: #=sum#" },
                { width: 250, field: "UnitsOnOrder", title: "Units On Order",editor: categoryDropDownEditor, aggregates: ["average"], footerTemplate: "Average: #=average#",
                    groupFooterTemplate: "Average: #=average#" },
                { width: 250, field: "UnitsInStock", title: "Units In Stock", aggregates: ["min", "max", "count"], footerTemplate: "Min: #= min # Max: #= max #",
                groupHeaderTemplate: "Units In Stock: #= value # (Count: #= count#)" },
                { command: ["edit", "destroy"], title: "&nbsp;", width: "250px" }
            ]//描述显示的列
        });
        function categoryDropDownEditor(container, options) {
                    $('<input required data-text-field="CategoryName" data-value-field="CategoryID" data-bind="value:' + options.field + '"/>')
                        .appendTo(container)
                        .kendoDropDownList({
                            autoBind: false,
                            dataSource: {
                                type: "odata",
                                transport: {
                                    read: "http://demos.telerik.com/kendo-ui/service/Northwind.svc/Categories"
                                }
                            }
                        });
                }//选项编辑需要编辑为true
    </script>
</div>
</body>
</html>