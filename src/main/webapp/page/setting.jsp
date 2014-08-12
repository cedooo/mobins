<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>巡检配置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="巡检配置">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- JQuery CSS -->
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.theme.css" type="text/css" />
	 
	<!-- jqGrid CSS -->
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/src/css/ui.jqgrid.css" type="text/css" /> 
	 
	<!-- The actual JQuery code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery-1.11.1.js" ></script>
	<!-- The JQuery UI code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.min.js" ></script>
	<!-- The jqGrid language file code-->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/src/i18n/grid.locale-cn.js"  ></script>
	<!-- The atual jqGrid code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/src/jquery.jqGrid.js"  ></script>
	
	<script type="text/javascript">
		function addHost( targetID){
			alert("添加主机：" + targetID);
			$("#list2" ).trigger("reloadGrid");
		}
		function editHost(tableID, hostID){
			$("#" + tableID ).jqGrid('editRow', hostID, true);
			//$("#" + tableID ).trigger("reloadGrid");
		}
		function editTarget(targetID){
			//alert("编辑目标" + targetID);
			$("#list2" ).jqGrid('editRow', targetID, true);
			//$("#list2" ).trigger("reloadGrid");
		}
		function delHost(tableID, hostID){
			var confirmed = confirm("确认删除?");
			if(confirmed){
				alert("删除目标" + hostID);
				$("#" + tableID ).trigger("reloadGrid");
			}
		}
		$(function(){
			jQuery("#list2").jqGrid({
			   	url:'<%=basePath%>setting/targetList.action',
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '添加时间', '操作'],
			   	colModel:[
			   		{name:'targetID',index:'targetID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'targetName',index:'targetName', width:80,align:"center", sortable:false,editable:true},
			   		{name:'targetNote',index:'targetNote', width:80,align:"center", sortable:false,editable:true},		
			   		{name:'targetAddTime',index:'targetAddTime',align:"center", width:55, sortable:false},
		   			{name:'act',index:'act', width:55,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   	],
			   	rowNum:10,
			   	rowList:[10,20,30],
			   	//pager: '#pager2',
			   	//sortname: 'id',
			   	autowidth:true,
			   	//height: 300,
			   	rownumbers: false,
			    viewrecords: true,
				subGrid : true,
			    jsonReader : {
			        root:"listTarget",
			        page: "pagging.page",
			        total: "pagging.total",
			        records: "pagging.records",
			        cell: "",
			        id: "0"
			     },
			     gridComplete: function(){
			    	var $grid = jQuery("#list2");
			 		var ids = $grid.jqGrid('getDataIDs');
			 		for(var i=0;i < ids.length;i++){
			 			var cl = ids[i];
			 			add = "<input  type='button' value='编辑' onclick=\"editTarget('"+cl+"');\"  />"; 
			 			edit = "<input type='button' value='添加主机' onclick=\"addHost('"+cl+"');\"  />"; 
			 			$grid.jqGrid('setRowData',ids[i],{act:add+edit});
			 		}	
			 	},
			     subGridRowExpanded: function(subgrid_id, row_id) {
			 		// we pass two parameters
			 		// subgrid_id is a id of the div tag created whitin a table data
			 		// the id of this elemenet is a combination of the "sg_" + id of the row
			 		// the row_id is the id of the row
			 		// If we wan to pass additinal parameters to the url we can use
			 		// a method getRowData(row_id) - which returns associative array in type name-value
			 		// here we can easy construct the flowing
			 		
			 		var subgrid_table_id, pager_id;
			 		subgrid_table_id = subgrid_id+"_t";
			 		pager_id = "p_"+subgrid_table_id;
			 		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			 		jQuery("#"+subgrid_table_id).jqGrid({
			 			url:"<%=basePath%>setting/hostList.action?targetID=" + row_id,
			 			datatype: "json",
			 			colNames: ['编号','目标ID','IP','备注','类型','巡检帐号','密码','添加时间','删除时间', '操作'],
					   	autowidth:true,
			 			colModel: [
			 				{name:"mobDestHostID",index:"mobDestHostID",align:"center", width:40,key:true, sortable:false, hidden:true},
			 				{name:"targetID",index:"targetID",width:200,align:"center", sortable:false, hidden:true},
			 				{name:"mobDestHostIP",index:"mobDestHostIP",width:70,align:"center", sortable:false,editable:true},
			 				{name:"hostNote",index:"hostNote",width:80,align:"center", sortable:false,editable:true},
			 				{name:"hostType",index:"hostType",width:30,align:"center", sortable:false,editable:true},
			 				{name:"hostUser",index:"hostUser",width:70,align:"center", sortable:false,editable:true},
			 				{name:"hostPasswd",index:"hostPasswd",width:70,align:"center",sortable:false, hidden:true},
			 				{name:"hostAddTime",index:"hostAddTime",width:140,align:"center", sortable:false},
			 				{name:"hostDelTime",index:"hostDelTime",width:140,align:"center", sortable:false, hidden:true},
				   			{name:'act',index:'act', width:55,sortable:false,align:"center"}
			 			],
			 			jsonReader : {
					        root:"listHost",
					        page: "pagging.page",
					        total: "pagging.total",
					        records: "pagging.records",
					        cell: "",
					        id: "0"
					     },
					 	editurl: "server.php",
			 		   	rowNum:20,
					     gridComplete: function(){
						    	var $grid = jQuery("#"+subgrid_table_id);
						 		var ids = $grid.jqGrid('getDataIDs');
						 		for(var i=0;i < ids.length;i++){
						 			var cl = ids[i];
						 			add = "<input  type='button' value='编辑' onclick=\"editHost('" + subgrid_table_id + "', '"+cl+"');\"  />"; 
						 			edit = "<input class='delBtn' type='button' value='删除' onclick=\"delHost('" + subgrid_table_id + "', '"+cl+"');\"  />"; 
						 			$grid.jqGrid('setRowData',ids[i],{act: add+edit});
						 		}	
						 	},
			 		   	//pager: pager_id,
			 		   	sortname: 'num',
			 		    sortorder: "asc",
			 		    height: '100%'
			 		});
			 		//jQuery("#"+subgrid_table_id).jqGrid('navGrid',"#"+pager_id,{edit:false,add:false,del:false})
			 	},
			 	subGridRowColapsed: function(subgrid_id, row_id) {
			 		// this function is called before removing the data
			 		//var subgrid_table_id;
			 		//subgrid_table_id = subgrid_id+"_t";
			 		//jQuery("#"+subgrid_table_id).remove();
			 	},
			    sortorder: "desc",
			    caption:"巡检目标"
			});
			//jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
		});
	</script>
	<style type="text/css">
		.delBtn{
			color: red;
		}
	</style>
  </head>
  
  <body>
	<table id="list2"></table>
	<!-- <div id="pager2"></div> -->
  </body>
</html>
