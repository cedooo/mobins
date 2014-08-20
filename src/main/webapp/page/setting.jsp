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
	<!-- JQuery CSS -->
	<%@ include file="/page/them.jsp" %>
	<!-- jqGrid CSS -->
	<link rel="stylesheet" href="<%=basePath%>js/dependency/jquery.jqGrid-4.6.0/css/ui.jqgrid.css" type="text/css" /> 
	 
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
		}
		function savHost(tableID, hostID){
			$("#" + tableID ).jqGrid('editRow', hostID, true);
		}
		function editTarget(targetID){
			$("#list2" ).jqGrid('editRow', targetID, true);
		}
		function saveTarget(targetID){
			$("#list2" ).jqGrid('editRow', targetID, true);
		}
		function delHost(tableID, hostID){
			var confirmed = confirm("确认删除?");
			if(confirmed){
				//alert("删除目标" + hostID);
				$.ajax({
				  url: "<%=basePath%>setting/delHost.action?mobDestHostID="+hostID,
				  context: document.body
				}).done(function() {
					$("#" + tableID ).trigger("reloadGrid");
				});
			}
		}
		var accpassdialog;
		$(function(){
			accpassdialog = $( "#accpass" ).dialog({
		      autoOpen: false,
		      //height: 200,
		      //width: 350,
		      draggable: false,
		      modal: true,
		      resizable: false,
		    });
			
		});
		/*验证IP是否合法*/
 		var ipregex = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
	 	function ipconfirm(value, colname) {
	 		if (!ipregex.test(value)) {
	 		   return [false,"IP地址不合法"];
	 		}else{ 
	 		   return [true,""];
	 		}
	 	}
		function refreshPasswd(gridID, hostID){
			var data = $("#" + gridID ).jqGrid('getRowData', hostID);
			$("#hostUser").val(data.hostUser);
			$("#mobDestHostID").val(data.mobDestHostID);
			$("#mobDestHostIP").val(data.mobDestHostIP);
			$("#password").val("");
			$("#confirm_password").val("");
			$("#testBtn").val("测试").removeAttr("disabled");
			$("form#accform input[type='submit']").hide();
			accpassdialog.dialog( "open" );
		}
		function accPwdTest(){
			if($("form#accform").valid()==true){
				//var editAction = "<%=basePath%>setting/updateAP.action";
				//var validAction = "<%=basePath%>setting/accValid.action";
				var $form = $("form#accform");
				 $.ajax({
		                url:"<%=basePath%>setting/accValid.action",
		                data:$form .serialize(),
		                dataType:"json",
		                type: "POST",
		                error:function(data){
		                    alert(data);
		                },
		                success:function(data){
		                    if(data.result.success){
		        				$("#testBtn").val("通过").attr("disabled","disabled");
		        				$("form#accform input[type='submit']").show();
		                    }else{
		        				$("#testBtn").val("不通过");
		                    }
		                }
		            });
			}
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
		   			{name:'act',index:'act', width:35,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   	],
			   	rowNum:10,
			   	rowList:[10,20,30],
			   	//sortname: 'id',
			   	autowidth:true,
			   	//height: 240,
			   	rownumbers: true,
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
			 			//edit = "<input class='actBtn edit' type='button' value='编辑' onclick=\"editTarget('"+cl+"');\"  />"; 
			 			edit = "<span class=\"act ui-icon ui-icon-pencil\"  title='编辑' onclick=\"editTarget('"+cl+"');\"></span>"; 
			 			//add = "<input type='button' value='添加主机' onclick=\"addHost('"+cl+"');\"  />";
			 			add = '';
			 			//save = "<input class='actBtn save' type='button' value='保存' onclick=\"jQuery('#list2').saveRow('"+cl+"');\"  />"; 
			 			save = "<span class=\"act ui-icon ui-icon-disk\"  title='保存'   onclick=\"jQuery('#list2').saveRow('"+cl+"');\" ></span>";
			 			$grid.jqGrid('setRowData',ids[i],{act:edit+save + add});
			 		}	
			 	},
			     subGridRowExpanded: function(subgrid_id, row_id) {
			 		var subgrid_table_id;//, pager_id;
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
				   			{name:'act',index:'act', width:35,sortable:false,align:"center"}
			 			],
					   	rownumbers: true,
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
						 			//edit = "<input  class='actBtn edit' type='button' value='编辑' onclick=\"editHost('" + subgrid_table_id + "', '"+cl+"');\"  />"; 
						 			edit = "<span class=\"act ui-icon ui-icon-pencil\" title='编辑' onclick=\"editHost('" + subgrid_table_id + "', '"+cl+"');\"></span>"; 
						 			//del = "<input class='delBtn' type='button' value='删除' onclick=\"delHost('" + subgrid_table_id + "', '"+cl+"');\"  />";
						 			del='';
						 			//save = "<input class='actBtn save' type='button' value='保存' onclick=\"jQuery('#"+subgrid_table_id + "').saveRow('"+cl+"');\"  />";
						 			save = "<span class=\"act ui-icon ui-icon-disk\"  title='保存'  onclick=\"jQuery('#"+subgrid_table_id + "').saveRow('"+cl+"');\" ></span>";
						 			//refresh = "<input type='button' class='actBtn refresh' value='帐号密码' onclick=\"refreshPasswd('"+subgrid_table_id + "', '"+cl+"');\"  />";
						 			refresh = "<span class=\"act ui-icon ui-icon-person\"  title='帐号密码'  onclick=\"refreshPasswd('"+subgrid_table_id + "', '"+cl+"');\"  ></span>";
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
			    caption:"巡检目标",
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
				  submitHandler: function(form) {      
					  $(form).submit(function(){
				            $.ajax({
				                url:"<%=basePath%>setting/updateAP.action",
				                data:$(form).serialize(),
				                dataType:"json",
				                type: "POST",
				                error:function(data){
				                    alert(data);
				                },
				                success:function(data){
				                    if(data.updateAPSuccess){
				                    	alert("更新成功");
				            			accpassdialog.dialog( "close" );
				                    }else{
				            			accpassdialog.dialog( "close" );
				                    }
				                },
				                timeout:function(data){
				                	alert("超时了");
				                }
				            });
				        });        
				   } 
			 });
		});

		$(function(){
			$( ".backBtn" ).button({
			      //text: false,
			      icons: {
			        primary: "ui-icon-arrowreturnthick-1-w"
			      }
			    });
			$("#testBtn").button({
				icons: {
			        primary: "ui-icon-arrowreturnthick-1-w"
			      }
			});
			$("input[type='submit']").button({
				icons: {
			        primary: "ui-icon-disk"
			      }
			});
			$("input.close").button({
				icons: {
			        primary: "ui-icon-closethick"
			      }
			});
		});

		//策略
		
		function editStrage(strageID){
			$("#listStrage" ).jqGrid('editRow', strageID, true);
		}
		$(function(){
			jQuery("#listStrage").jqGrid({
			   	url:'<%=basePath%>setting/listStrage.action',
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '添加时间', '操作'],
			   	colModel:[
			   		{name:'strageID',index:'strageID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'strageName',index:'strageName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'strageNote',index:'strageNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true,maxlength:2}},		
			   		{name:'strageAddTime',index:'strageAddTime',align:"center", width:55, sortable:false, hidden:true},
		   			{name:'act',index:'act', width:35,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   	],
			   	/* [{"strageAddTime":"2014-07-31 15:26:32","strageDelTime":null,"strageID":"1","strageName":"目标巡检策略-测试","strageNote":"添加测试用","strageValid":"1"}],
			   	"strageSearchCondition":{"pagging":{"page":"1","records":null,"rows":"10","total":null}}} */
			   	rowNum:5,
			   	rowList:[5, 10,20,30],
			   	//sortname: 'id',
			   	autowidth:true,
			   	height: 220,
			   	rownumbers: true,
			    viewrecords: true,
				//subGrid : true,
			    jsonReader : {
			        root:"listStrage",
			        page: "strageSearchCondition.pagging.page",
			        total: "strageSearchCondition.pagging.total",
			        records: "strageSearchCondition.pagging.records",
			     },
				 editurl: "<%=basePath%>setting/strageEdit.action",
			     gridComplete: function(){
			    	var $grid = jQuery("#listStrage");
			 		var ids = $grid.jqGrid('getDataIDs');
			 		for(var i=0;i < ids.length;i++){
			 			var cl = ids[i];
			 			//edit = "<input class='actBtn edit' type='button' value='编辑' onclick=\"editTarget('"+cl+"');\"  />"; 
			 			edit = "<span class=\"act ui-icon ui-icon-pencil\"  title='编辑' onclick=\"editStrage('"+cl+"');\"></span>"; 
			 			//add = "<input type='button' value='添加主机' onclick=\"addHost('"+cl+"');\"  />";
			 			add = '';
			 			//save = "<input class='actBtn save' type='button' value='保存' onclick=\"jQuery('#list2').saveRow('"+cl+"');\"  />"; 
			 			save = "<span class=\"act ui-icon ui-icon-disk\"  title='保存'   onclick=\"jQuery('#listStrage').saveRow('"+cl+"');\" ></span>";
			 			$grid.jqGrid('setRowData',ids[i],{act:edit+save + add});
			 		}	

					var strageIDs = jQuery("#listStrage").jqGrid('getDataIDs');
					var strageID = 0;
					if(strageIDs.length>0){
						strageID = strageIDs[0];
					}
					loadStrageItem(strageID);
					jQuery("#listStrage")
					.jqGrid('setSelection', strageID);
					var strage = jQuery("#listStrage").jqGrid('getRowData', strageID);
					var strageName = strage.strageName; 
					jQuery("#listStrageItem").jqGrid('setCaption', strageName + '-检查项目' );
			 	},
			 	onCellSelect: function(id) {
					jQuery("#listStrageItem").jqGrid('setCaption', '检查项目');		
					var strage = jQuery("#listStrage").jqGrid('getRowData', id);
					var strageName = strage.strageName; 
					var isInputMatch = /^<input.*/.test(strageName);
					if(!isInputMatch){
						jQuery("#listStrageItem").jqGrid('setCaption', strageName + '-检查项目' );
					}else{
						jQuery("#listStrageItem").jqGrid('setCaption', '编辑中...-检查项目' );
					}
			 	},
			 	onSelectRow: function(id){
			 		jQuery("#listStrageItem").setGridParam({
					   	url:'<%=basePath%>setting/listInspectionItem.action?strageID='+ id
			 		}).trigger("reloadGrid");				   	
			 	},
			   	pager: '#strageNav',
	 			multiselect:false,
			    sortorder: "desc",
			    caption:"策略",
			});
			jQuery("#listStrage").jqGrid('navGrid','#strageNav',{edit:false,add:false,del:false,search:false});
			
		});
		//策略项目
		function loadStrageItem(strageID){
			jQuery("#listStrageItem").jqGrid({
			   	url:'<%=basePath%>setting/listInspectionItem.action?strageID='+ strageID,
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '巡检类型'],
			   	colModel:[
			   		{name:'inspectionItemID',index:'inspectionItemID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'itemName',index:'itemName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'inspectionItemNote',index:'inspectionItemNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},		
			   		{name:'inspectionType',index:'inspectionType',align:"center", width:55, sortable:false, hidden:false},
		   			//{name:'act',index:'act', width:35,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   		//{"inspectionItemID":"1","inspectionItemNote":"ping www.baidu.com, 测试外网IP。","inspectionType":"硬件巡检","itemName":"检查网络连接是否可用"}
			   	],
			   	rowNum:10,
			   	rowList:[10,20,30],
			   	//sortname: 'id',
			   	autowidth:true,
			   	height: 220,
			   	rownumbers: true,
			    viewrecords: true,
				subGrid : true,
			    jsonReader : {
			        root:"listInspectionItem",
			        page: "condition.pagging.page",
			        total: "condition.pagging.total",
			        records: "condition.pagging.records",
			        cell: "",
			        id: "0"
			     },
				 editurl: "<%=basePath%>setting/tagetEdit.action",
			     gridComplete: function(){
			    /* 	var $grid = jQuery("#listStrageItem");
			 		var ids = $grid.jqGrid('getDataIDs');
			 		for(var i=0;i < ids.length;i++){
			 			var cl = ids[i];
			 			edit = "<span class=\"act ui-icon ui-icon-pencil\"  title='编辑' onclick=\"editTarget('"+cl+"');\"></span>"; 
			 			add = '';
			 			save = "<span class=\"act ui-icon ui-icon-disk\"  title='保存'   onclick=\"jQuery('#list2').saveRow('"+cl+"');\" ></span>";
			 			$grid.jqGrid('setRowData',ids[i],{act:edit+save + add});
			 		}	 */
			 		
			 	},
			     subGridRowExpanded: function(subgrid_id, row_id) {
			 		var subgrid_table_id;//, pager_id;
			 		subgrid_table_id = subgrid_id+"_t";
			 		pager_id = "p_"+subgrid_table_id;
			 		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			 		jQuery("#"+subgrid_table_id).jqGrid({
			 			url:"<%=basePath%>setting/listInspectionPoint.action?searchCondition.inspectionItemID=" + row_id,
			 			datatype: "json",
			 			colNames: ['编号','巡检项ID','巡检点名称','操作','备注','编码','排序','权重'],
					   	autowidth:true,
					   	rownumbers: true,
			 			colModel: [
			 				{name:"inspectionPointID",index:"inspectionPointID",align:"center", width:40,key:true, sortable:false, hidden:true},
			 				{name:"inspectionItemID",index:"inspectionItemID",width:100,align:"center", sortable:false, hidden:true},
			 				{name:"checkPointName",index:"checkPointName",width:70,align:"center", sortable:false,editable:true,editable:true,editrules:{ required:true}},
			 				{name:"operCommand",index:"operCommand",width:120,align:"center", sortable:false,editable:false, hidden:false, edittype:"select",editoptions:{value:"0:备机;1:主机"}},
			 				{name:"operNote",index:"operNote",width:120,align:"center", sortable:false,editable:false},
			 				{name:"inspectionCode",index:"inspectionCode",width:70,align:"center",sortable:false, hidden:true},
			 				{name:"sortNum",index:"sortNum",width:20,align:"center", sortable:false, hidden:true},
			 				{name:"exceptionWeight",index:"exceptionWeight",width:20,align:"center", sortable:false, hidden:true},
				   			//{name:'act',index:'act', width:35,sortable:false,align:"center"}
			 				//{"checkPointName":"测试连接外网","exceptionWeight":"2","inspectionCode":"PING-BAIDU","inspectionItemID":"1",
			 					//"inspectionPointID":"1","keyRegex":".*(\\d+)% packet loss.*","matchType":"2","operCommand":"ping baidu.com -c 5 -i 0.3",
			 					//"operNote":"ping 百度","resultFormat":"丢包率为%s%%,%s","sortNum":"1","valCompareMax":"10.00","valCompareMin":"0.00"}
			 			],
			 			multiselect:false,
			 			hoverrows:false,
			 			jsonReader : {
					        root:"listInspectionPoint",
					        page: "pagging.page",
					        total: "pagging.total",
					        records: "pagging.records",
					        cell: "",
					        id: "0"
					     },
					 	editurl: "<%=basePath%>setting/hostEdit.action",
			 		   	rowNum:20,
					     gridComplete: function(){
						    
						 	},
			 		   	//pager:  '#' + pager_id,
			 		   	//sortname: 'num',
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
			   	pager: '#strageItemNav',
	 			multiselect:false,
			    sortorder: "desc",
			    caption:"检查项目",
			});
			jQuery("#listStrageItem").jqGrid('navGrid','#strageItemNav',{refresh:true,edit:false,add:false,del:false,search:false});
			
		};
	</script>
	<style type="text/css">
		.delBtn{
			color: red;
		}
		.act{
			float:left;
			margin-left:5px;
		}
		.act:hover{
			cursor:pointer;
		}
		body{
			padding:1% 1%;
			font-size: 66%;
		}
	</style>
	
  </head>
  
	<body>
		<button class="backBtn" onclick="javascript:window.history.go(-1);">返回</button>
		<table id="list2"></table>
		<div id="nav"></div>
		<div style="float:left;width:33%;">
			<table id="listStrage"></table>
			<div id="strageNav"></div>
		</div>
		<div style="float:right;width:67%;">
			<table id="listStrageItem"></table>
			<div id="strageItemNav"></div>
		</div>
		<div id="accpass" title="更新帐号密码">
		  <form id="accform" action="<%=basePath%>setting/updateAP.action" method="post">
		  	<input type="hidden" id="mobDestHostID" name="mobDestHostID" value="" />
		  	<input type="hidden" id="mobDestHostIP" name="mobDestHostIP" value="" />
		      <label for="hostUser">帐号</label>
		      <input type="text" name="hostUser" id="hostUser" value=""  class="text ui-widget-content ui-corner-all">
		      <br />
		      <label for="hostPasswd">密码</label>
		      <input type="password" name="hostPasswd" id="password" value="" class="text ui-widget-content ui-corner-all">
		 		<br />
		      <label for="confirm_password">确认</label>
		      <input type="password"  id="confirm_password" name="confirm_password" value="" class="text ui-widget-content ui-corner-all">
		      <hr />
		 	 <input onclick="accPwdTest()" id="testBtn" type="button" value="测试"/>
		 	 <input type="submit" value="保存">
		 	 <input class="close" type="button" onclick="accpassdialog.dialog('close');" value="关闭" />
		  </form>
		</div>
	</body>
</html>
