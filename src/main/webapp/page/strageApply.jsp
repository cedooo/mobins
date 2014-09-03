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
		
		$(function(){
			jQuery("#listTargetApply").jqGrid({
			   	url:'<%=basePath%>setting/targetList.action',
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '添加时间', '操作', '是否启用'],
			   	colModel:[
			   		{name:'targetID',index:'targetID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'targetName',index:'targetName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'targetNote',index:'targetNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},		
			   		{name:'targetAddTime',index:'targetAddTime',align:"center", width:55, sortable:false, hidden:true},
		   			{name:'act',index:'act', width:35,sortable:false,align:"center", hidden:true},
	 				{name:"targetInsValid",index:"targetInsValid",width:140,align:"center", sortable:false, hidden:true}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   	],
			   	rowNum:10,
			   	//rowList:[2, 10,20,30],
			   	//sortname: 'id',
			   	autowidth:true,
			   	height: 300,
			   	rownumbers: true,
			    viewrecords: true,
				subGrid : true,
			    jsonReader : {
			        root:"listTarget",
			        page: "searchCondition.pagging.page",
			        total: "searchCondition.pagging.total",
			        records: "searchCondition.pagging.records",
			     },
				 editurl: "<%=basePath%>setting/tagetEdit.action",
			     gridComplete: function(){
				 },
			     subGridRowExpanded: function(subgrid_id, row_id) {
			 		var subgrid_table_id;//, pager_id;
			 		subgrid_table_id = subgrid_id+"_t";
			 		pager_id = "p_"+subgrid_table_id;
			 		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
			 		jQuery("#"+subgrid_table_id).jqGrid({
			 			url:"<%=basePath%>setting/hostList.action?targetID=" + row_id,
			 			datatype: "json",
			 			colNames: ['编号','目标ID','IP','备注','类型','巡检帐号','密码','添加时间','删除时间', '操作', '巡检有效'],
					   	autowidth:true,
			 			colModel: [
			 				{name:"mobDestHostID",index:"mobDestHostID",align:"center", width:40,key:true, sortable:false, hidden:true},
			 				{name:"targetID",index:"tar.targetID",width:200,align:"center", sortable:false, hidden:true},
			 				{name:"mobDestHostIP",index:"mobDestHostIP",width:70,align:"center", sortable:false,editable:true,editable:true},
			 				{name:"hostNote",index:"hostNote",width:80,align:"center", sortable:false,editable:true,editable:true,editrules:{ required:true}},
			 				{name:"hostType",index:"hostType",width:30,align:"center", sortable:false,editable:false, hidden:true, edittype:"select",editoptions:{value:"0:备机;1:主机"}},
			 				{name:"hostUser",index:"hostUser",width:70,align:"center", sortable:false,editable:false},
			 				{name:"hostPasswd",index:"hostPasswd",width:70,align:"center",sortable:false, hidden:true},
			 				{name:"hostAddTime",index:"hostAddTime",width:140,align:"center", sortable:false, hidden:true},
			 				{name:"hostDelTime",index:"hostDelTime",width:140,align:"center", sortable:false, hidden:true},
				   			{name:'act',index:'act', width:35,sortable:false,align:"center", hidden:true},
			 				{name:"inspectValid",index:"inspectValid",width:140,align:"center", sortable:false, hidden:true}
			 			],
					   	rownumbers: true,
			 			multiselect:false,
			 			hoverrows:false,
			 			jsonReader : {
					        root:"listHost",
					        page: "searchCondition.pagging.page",
					        total: "searchCondition.pagging.total",
					        records: "searchCondition.pagging.records",
					     },
					 	editurl: "<%=basePath%>setting/hostEdit.action?targetID=" + row_id,
			 		   	rowNum:5,
					   	//rowList:[5, 10,20,30],
					     gridComplete: function(){
						 	},
						 onSelectRow: function(hostID){
							 var $grid = jQuery("#listStrageApply");
							 $grid.setGridParam({
								   	url:'<%=basePath%>setting/listStrageWithHost.action?hostID=' + hostID
						 		})
						 		.trigger("reloadGrid");	
							 g_hostID = hostID;
							
						 },
			 		   	pager:  '#' + pager_id,
			 		   	sortname: 'num',
			 		    sortorder: "asc",
			 		    height: '100%'
			 		});
			 		jQuery("#"+subgrid_table_id).navGrid('#' + pager_id,
			 				{del:false,search:false,edit:false,add:false,addtext:'添加&nbsp;',addtitle:'添加主机',deltext:'删除 &nbsp;',deltitle:'删除主机'},{},{closeAfterAdd: true})
			 				;//.navButtonAdd("#"+pager_id,{caption:"添加主机", buttonicon:"ui-icon-plus", onClickButton:null, position: "last", title:"", cursor: "pointer"});
			 	},
			 	subGridRowColapsed: function(subgrid_id, row_id) {
			 		// this function is called before removing the data
			 		//var subgrid_table_id;
			 		//subgrid_table_id = subgrid_id+"_t";
			 		//jQuery("#"+subgrid_table_id).remove();
			 	},
			   	pager: '#navTargetApply',
	 			multiselect:false,
			    sortorder: "desc",
			    caption:"巡检目标"
			});
			jQuery("#listTargetApply").jqGrid('navGrid','#navTargetApply',
					{edit:false,add:false,del:false,addtext:'添加&nbsp;',addtitle:'添加目标',deltext:'删除 &nbsp;',deltitle:'删除目标',search:false},{},{closeAfterAdd: true});
			
		});
		var g_hostID = 0;
		$(function(){
			var $grid = jQuery("#listStrageApply");
			$grid.jqGrid({
				   	//url:'<%=basePath%>setting/listStrageWithHost.action',
					datatype: "json",
				   	colNames:[ '编号','名称', '备注', '添加时间', '操作','是否有效', '应用'],
				   	colModel:[
				   		{name:'strageID',index:'strageID', width:20,align:"center", sortable:false, key:true, hidden:true},
				   		{name:'strageName',index:'strageName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
				   		{name:'strageNote',index:'strageNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true,maxlength:2}},		
				   		{name:'strageAddTime',index:'strageAddTime',align:"center", width:55, sortable:false, hidden:true},
			   			{name:'act',index:'act', width:35,sortable:false,align:"center",hidden:true},
				   		{name:'strageValid',index:'strageValid',align:"center", width:55, sortable:false, hidden:true},
				   		{name:'hostApplyValid',index:'hostApplyValid',align:"center", width:55, sortable:false, hidden:true}
				   		//{name:'targetDelTime',index:'targetDelTime', width:90}
				   	],
				   	/* [{"strageAddTime":"2014-07-31 15:26:32","strageDelTime":null,"strageID":"1","strageName":"目标巡检策略-测试","strageNote":"添加测试用","strageValid":"1"}],
				   	"strageSearchCondition":{"pagging":{"page":"1","records":null,"rows":"10","total":null}}} */
				   	rowNum:10,
				   	//rowList:[10,20,30],
				   	//sortname: 'id',
				   	autowidth:true,
				   	//height: 220,
				   	rownumbers: true,
				    viewrecords: true,
					//subGrid : true,
				    jsonReader : {
				        root:"listStrage",
				        page: "strageSearchCondition.pagging.page",
				        total: "strageSearchCondition.pagging.total",
				        records: "strageSearchCondition.pagging.records",
				     },
				     gridComplete: function(){
				    	 var $grid = jQuery("#listStrageApply");
						 jQuery("#gbox_listStrageApply th input[type=checkbox]").hide();
				 		var ids = $grid.jqGrid('getDataIDs');
				 		for(var i=0;i < ids.length;i++){
							var strage = $grid.jqGrid('getRowData', ids[i]);
							//alert(targetItem.valid);
							if(strage.hostApplyValid=='true'){
								//alert(true);
						 		$grid.jqGrid('setSelection', ids[i], function(){});
							}else{
								///alert('wr');
							}
				 		}
				     },
				 	onCellSelect: function(id) {},
				 	onSelectRow: function(aRowids,status){
		 			   //alert("!!!");
				 		var strageID = aRowids;
				 		valid = status?"Y":"N";
				 		//alert(strageID + aRowids + status);
				 		 $.ajax({
				                url:"<%=basePath%>setting/updateStrageApply.action",
				                data:{
				                	"strageApplyHost.mobDestHostID" : g_hostID,
				                	"strageApplyHost.strageID" : strageID,
				                	"valid" : valid,
				                	
				                },
				                dataType:"json",
				                type: "POST",
				                error:function(data){
				                    alert(data);
				                },
				                success:function(data){
				                    if(data.operSuccess){
				                    }else{
				        				alert("操作失败");
				                    }
				                }
				            });
				 	},
				   	pager: '#strageApplyNav',
		 			multiselect:true,
				    sortorder: "desc",
				    caption:"策略",
				});
				jQuery("#listStrageApply").jqGrid('navGrid','#strageApplyNav',
						{edit:false,add:false,del:false,refresh:false,addtext:'添加&nbsp;',addtitle:'添加策略',deltext:'删除 &nbsp;',deltitle:'删除策略',search:false},
						{},
						{closeAfterAdd: true}
					);
	});
		
	</script>
	
  </head>
  
	<body>
	  	<table id="listTargetApply"></table>
		<div id="navTargetApply"></div>
		<table id="listStrageApply"></table>
		<div id="strageApplyNav"></div>
	</body>
</html>
