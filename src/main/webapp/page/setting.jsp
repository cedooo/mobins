<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.theme.min.css" type="text/css" />
	 
	<!-- jqGrid CSS -->
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/css/ui.jqgrid.css" type="text/css" /> 
	 
	<!-- The actual JQuery code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/js/jquery-1.11.0.min.js" ></script>
	<!-- The JQuery UI code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery-ui-1.11.0.custom/jquery-ui.min.js" ></script>
	<!-- The jqGrid language file code-->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/js/i18n/grid.locale-cn.js" ></script>
	<!-- The atual jqGrid code -->
	<script type="text/javascript" src="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/js/jquery.jqGrid.min.js" ></script>
	
	<!-- jquery validate -->
	
	<script src="<%=basePath%>js/dependency/jquery-validation-1.13.0/dist/jquery.validate.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/dependency/jquery-validation-1.13.0/dist/localization/messages_zh.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		function addHost( targetID){
			alert("添加主机：" + targetID);
			$("#list2" ).trigger("reloadGrid");
		}
		function editHost(tableID, hostID){
			$("#" + tableID ).jqGrid('editRow', hostID, true);
			//$("#" + tableID ).trigger("reloadGrid");
		}
		function savHost(tableID, hostID){
			$("#" + tableID ).jqGrid('editRow', hostID, true);
			//$("#" + tableID ).trigger("reloadGrid");
		}
		function editTarget(targetID){
			//alert("编辑目标" + targetID);
			$("#list2" ).jqGrid('editRow', targetID, true);
			//$("#list2" ).trigger("reloadGrid");
		}
		function saveTarget(targetID){
			//alert("编辑目标" + targetID);
			$("#list2" ).jqGrid('editRow', targetID, true);
			//$("#list2" ).trigger("reloadGrid");
		}
		function delHost(tableID, hostID){
			var confirmed = confirm("确认删除?");
			if(confirmed){
				//alert("删除目标" + hostID);
				//$("#" + tableID ).jqGrid('delRowData', hostID);
				$.ajax({
				  url: "<%=basePath%>setting/delHost.action?mobDestHostID="+hostID,
				  context: document.body
				}).done(function() {
					$("#" + tableID ).trigger("reloadGrid");
				});
			}
		}
		/*更新帐号信息  */
		function submitUserAndPasswd(){
			 //form["id=accform"].submit();
			// alert($("form#accform").valid());
			if($("form#accform").valid()==true){
  				document.getElementById("accform").submit();
			}else{
				
			}
		}
		var accpassdialog ;
		$(function(){
			accpassdialog = $( "#accpass" ).dialog({
		      autoOpen: false,
		      height: 200,
		      width: 350,
		      modal: true,
		      resizable: false,
		      buttons: {
		        "保存": submitUserAndPasswd,
		        "取消": function() {
		        	accpassdialog.dialog( "close" );
		        }
		      }
		    });
			
		});
		/*验证IP是否合法*/
 		var ipregex = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
	 	function ipconfirm(value, colname) {
	 		//alert(ipregex.test(value));
	 		if (!ipregex.test(value)) {
	 		   return [false,"IP地址不合法"];
	 		}else{ 
	 		   return [true,""];
	 		}
	 	}
		function refreshPasswd(gridID, hostID){
			//alert("更新密码" + gridID + hostID);
			var data = $("#" + gridID ).jqGrid('getRowData', hostID);
			$("#hostUser").val(data.hostUser);
			$("#mobDestHostID").val(data.mobDestHostID);
			accpassdialog.dialog( "open" );
		}
		$(function(){
			jQuery("#list2").jqGrid({
			   	url:'<%=basePath%>setting/targetList.action',
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '添加时间', '操作'],
			   	colModel:[
			   		{name:'targetID',index:'targetID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'targetName',index:'targetName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'targetNote',index:'targetNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},		
			   		{name:'targetAddTime',index:'targetAddTime',align:"center", width:55, sortable:false, hidden:true},
		   			{name:'act',index:'act', width:55,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   	],
			   	rowNum:10,
			   	rowList:[10,20,30],
			   	//sortname: 'id',
			   	autowidth:true,
			   	height: 240,
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
				 editurl: "<%=basePath%>setting/tagetEdit.action",
			     gridComplete: function(){
			    	var $grid = jQuery("#list2");
			 		var ids = $grid.jqGrid('getDataIDs');
			 		for(var i=0;i < ids.length;i++){
			 			var cl = ids[i];
			 			edit = "<input  type='button' value='编辑' onclick=\"editTarget('"+cl+"');\"  />"; 
			 			//add = "<input type='button' value='添加主机' onclick=\"addHost('"+cl+"');\"  />";
			 			add = '';
			 			save = "<input type='button' value='保存' onclick=\"jQuery('#list2').saveRow('"+cl+"');\"  />"; 
			 			$grid.jqGrid('setRowData',ids[i],{act:edit+save + add});
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
			 				{name:"targetID",index:"tar.targetID",width:200,align:"center", sortable:false, hidden:true},
			 				{name:"mobDestHostIP",index:"mobDestHostIP",width:70,align:"center", sortable:false,editable:true,editable:true,editrules:{ required:true,custom:true,custom_func:ipconfirm}},
			 				{name:"hostNote",index:"hostNote",width:80,align:"center", sortable:false,editable:true,editable:true,editrules:{ required:true}},
			 				{name:"hostType",index:"hostType",width:30,align:"center", sortable:false,editable:false, hidden:true, edittype:"select",editoptions:{value:"0:备机;1:主机"}},
			 				{name:"hostUser",index:"hostUser",width:70,align:"center", sortable:false,editable:false},
			 				{name:"hostPasswd",index:"hostPasswd",width:70,align:"center",sortable:false, hidden:true},
			 				{name:"hostAddTime",index:"hostAddTime",width:140,align:"center", sortable:false, hidden:true},
			 				{name:"hostDelTime",index:"hostDelTime",width:140,align:"center", sortable:false, hidden:true},
				   			{name:'act',index:'act', width:75,sortable:false,align:"center"}
			 			],
			 			multiselect:false,
			 			hoverrows:false,
			 			jsonReader : {
					        root:"listHost",
					        page: "pagging.page",
					        total: "pagging.total",
					        records: "pagging.records",
					        cell: "",
					        id: "0"
					     },
					 	editurl: "<%=basePath%>setting/hostEdit.action",
			 		   	rowNum:20,
					     gridComplete: function(){
						    	var $grid = jQuery("#"+subgrid_table_id);
						 		var ids = $grid.jqGrid('getDataIDs');
						 		for(var i=0;i < ids.length;i++){
						 			var cl = ids[i];
						 			edit = "<input  type='button' value='编辑' onclick=\"editHost('" + subgrid_table_id + "', '"+cl+"');\"  />"; 
						 			//del = "<input class='delBtn' type='button' value='删除' onclick=\"delHost('" + subgrid_table_id + "', '"+cl+"');\"  />";
						 			del='';
						 			save = "<input type='button' value='保存' onclick=\"jQuery('#"+subgrid_table_id + "').saveRow('"+cl+"');\"  />";
						 			refresh = "<input type='button' value='帐号密码' onclick=\"refreshPasswd('"+subgrid_table_id + "', '"+cl+"');\"  />";
						 			$grid.jqGrid('setRowData',ids[i],{act: edit+save+refresh+del});
						 		}	
						 	},
			 		   	//pager:  '#' + pager_id,
			 		   	sortname: 'num',
			 		    sortorder: "asc",
			 		    height: '100%'
			 		});
			 		//jQuery("#"+subgrid_table_id).jqGrid('navGrid','#' + pager_id,{edit:false,add:true,search:false,del:false});
			 	},
			 	subGridRowColapsed: function(subgrid_id, row_id) {
			 		// this function is called before removing the data
			 		//var subgrid_table_id;
			 		//subgrid_table_id = subgrid_id+"_t";
			 		//jQuery("#"+subgrid_table_id).remove();
			 	},
			   	//pager: '#nav',
	 			multiselect:false,
			    sortorder: "desc",
			    caption:"巡检目标"
			});
			jQuery("#list2").jqGrid('navGrid','#nav',{edit:false,add:true,del:false,search:false});
			
			$("#accform").validate({
			       rules: {
			        	mobDestHostID: {
						    required: true,
						    digits:true,
						    min:0
						   },
			        	hostUser : {
						    required: true,
						    minlength: 2
						   },
						   hostPasswd: {
					    	required: true,
					    	minlength: 5
					   },
					   confirm_password: {
					    required: true,
					    minlength: 5,
					    equalTo: "#password"
					   }
				  },
				   submitHandler: function(form) 
				   {      
				      $(form).ajaxSubmit();     
				   } 
			 });
		});
		
	</script>
	<style type="text/css">
		.delBtn{
			color: red;
		}
		body{
			padding:1% 1%;
			font-size: 66%;
		}
	</style>
	
  </head>
  
	<body>
		<button onclick="javascript:window.history.go(-1);">返回</button>
		<table id="list2"></table>
		<div id="nav"></div>
		<div id="accpass" title="更新帐号">
			<div>只能更新，不能查看.</div>
		  <form id="accform" action="<%=basePath%>setting/updateAP.action">
		  	<input type="hidden" id="mobDestHostID" name="mobDestHostID" value="" />
		      <label for="hostUser">帐号</label>
		      <input type="text" name="hostUser" id="hostUser" value=""  class="text ui-widget-content ui-corner-all">
		      <br />
		      <label for="hostPasswd">密码</label>
		      <input type="password" name="hostPasswd" id="password" value="" class="text ui-widget-content ui-corner-all">
		 		<br />
		      <label for="confirm_password">确认</label>
		      <input type="password"  id="confirm_password" name="confirm_password" value="" class="text ui-widget-content ui-corner-all">
		 
		      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
		  </form>
		</div>
	</body>
</html>
