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
		function validStrageIns(strageID, valid){
			if(valid){
				//启用巡检
				 $.ajax({
		                url:"<%=basePath%>setting/strageInsValid.action",
		                data:{
		                	"strage.strageID" : strageID,
		                	"strage.strageValid" : "Y"
		                },
		                dataType:"json",
		                type: "POST",
		                error:function(data){
		                    alert(data);
		                },
		                success:function(data){
		                    if(data.operSuccess){
		        				alert("操作成功");
			                    jQuery("#listStrage").trigger("reloadGrid");
		                    }else{
		        				alert("操作失败");
		                    }
		                }
		            });
			}else {
				//停用巡检
				 $.ajax({
		                url:"<%=basePath%>setting/strageInsValid.action",
		                data:{
		                	"strage.strageID" : strageID,
		                	"strage.strageValid" : "N"
		                },
		                dataType:"json",
		                type: "POST",
		                error:function(data){
		                    alert(data);
		                },
		                success:function(data){
		                    if(data.operSuccess){
		        				alert("操作成功");
			                    jQuery("#listStrage").trigger("reloadGrid");
		                    }else{
		        				alert("操作失败");
		                    }
		                }
		            });
			}
		}
		$(function(){
			initStrageItems();
			jQuery("#listStrage").jqGrid({
			   	url:'<%=basePath%>setting/listStrage.action',
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '添加时间', '操作','是否有效'],
			   	colModel:[
			   		{name:'strageID',index:'strageID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'strageName',index:'strageName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'strageNote',index:'strageNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true,maxlength:2}},		
			   		{name:'strageAddTime',index:'strageAddTime',align:"center", width:55, sortable:false, hidden:true},
		   			{name:'act',index:'act', width:35,sortable:false,align:"center"},
			   		{name:'strageValid',index:'strageValid',align:"center", width:55, sortable:false, hidden:true}
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
			 			
			 			onoff_play = "ui-icon-play\"  title='启动巡检' onclick=\"validStrageIns("  + ids[i]  + "," + true + ")\"";
			 			onoff_pause = "ui-icon-pause\"  title='停止巡检' onclick=\"validStrageIns(" + ids[i]  + "," + false + ")\"";
						var host = jQuery("#listStrage").jqGrid('getRowData', ids[i]);
						//alert(target.targetInsValid + (target.targetInsValid=="Y"));
			 			onoff = "<span class=\"act ui-icon " + (host.strageValid=="Y"?onoff_pause:onoff_play) + " ></span>";
						
			 			$grid.jqGrid('setRowData',ids[i],{act:edit+save + add + onoff});
			 			//如果有效，这选中
			 			
			 		}	

					var strageIDs = jQuery("#listStrage").jqGrid('getDataIDs');
					var strageID = 0;
					if(strageIDs.length>0){
						strageID = strageIDs[0];
					}

			 		jQuery("#listStrageItem").setGridParam({
					   	url:'<%=basePath%>setting/listInspectionItem.action?strageID='+ strageID
			 		}).trigger("reloadGrid");	
					//loadStrageItem(strageID);
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
			 		})
			 		.jqGrid('setGridParam',{
				 			 onSelectRow: function(aRowids,status){}
			 		})
			 		.trigger("reloadGrid");				   	
			 	},
			   	pager: '#strageNav',
	 			multiselect:false,
			    sortorder: "desc",
			    caption:"策略",
			});
			jQuery("#listStrage").jqGrid('navGrid','#strageNav',
					{edit:false,add:true,del:true,addtext:'添加&nbsp;',addtitle:'添加策略',deltext:'删除 &nbsp;',deltitle:'删除策略',search:false},
					{},
					{closeAfterAdd: true}
				);
			
		});

		//策略项目
		function initStrageItems(){
			jQuery("#listStrageItem").jqGrid({
			   	//url:'<%=basePath%>setting/listInspectionItem.action?strageID='+ strageID,
				datatype: "json",
			   	colNames:[ '编号','名称', '备注', '巡检类型','有效'],
			   	colModel:[
			   		{name:'inspectionItemID',index:'inspectionItemID', width:20,align:"center", sortable:false, key:true, hidden:true},
			   		{name:'itemName',index:'itemName', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},
			   		{name:'inspectionItemNote',index:'inspectionItemNote', width:80,align:"center", sortable:false,editable:true,editrules:{required:true}},		
			   		{name:'inspectionType',index:'inspectionType',align:"center", width:55, sortable:false, hidden:false},
		   			//{name:'act',index:'act', width:35,sortable:false,align:"center"}
			   		//{name:'targetDelTime',index:'targetDelTime', width:90}
			   		//{"inspectionItemID":"1","inspectionItemNote":"ping www.baidu.com, 测试外网IP。","inspectionType":"硬件巡检","itemName":"检查网络连接是否可用"}
	 				{name:"valid",index:"valid",width:20,align:"center", sortable:false, hidden:true},
			   	],
			   	rowNum:10,
			   	//rowList:[10,20,30],
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
			 		strageID = jQuery("#listStrage").jqGrid('getGridParam','selrow');
			 		console.log("策略ID=" + strageID + ",巡检点ID=" + row_id);
			 		jQuery("#"+subgrid_table_id).jqGrid({
			 			url:"<%=basePath%>setting/listInspectionPoint.action?searchCondition.inspectionItemID=" + row_id + "&searchCondition.inspectionStrageID=" + strageID ,
			 			datatype: "json",
			 			colNames: ['编号','巡检项ID','巡检点名称','操作','备注','编码','排序','权重','操作','最大值阀值','最小阀值','异常级别'],
					   	autowidth:true,
					   	rownumbers: true,
			 			colModel: [
			 				{name:"inspectionPointID",index:"inspectionPointID",align:"center", width:40,key:true, sortable:false, hidden:true},
			 				{name:"inspectionItemID",index:"inspectionItemID",width:100,align:"center", sortable:false, hidden:true},
			 				{name:"checkPointName",index:"checkPointName",width:50,align:"center", sortable:false,editable:true,editable:true,editrules:{ required:true}},
			 				{name:"operCommand",index:"operCommand",width:80,align:"center", sortable:false,editable:false, hidden:false, edittype:"select",editoptions:{value:"0:备机;1:主机"}},
			 				{name:"operNote",index:"operNote",width:80,align:"center", sortable:false,editable:false},
			 				{name:"inspectionCode",index:"inspectionCode",width:70,align:"center",sortable:false, hidden:true},
			 				{name:"sortNum",index:"sortNum",width:20,align:"center", sortable:false, hidden:true},
			 				{name:"exceptionWeight",index:"exceptionWeight",width:20,align:"center", sortable:false, hidden:true},
				   			{name:'act',index:'act', width:75,sortable:false,align:"center"},
				   			{name:'valCompareMax',index:'valCompareMax', width:35,sortable:false,align:"center", hidden:true},
				   			{name:'valCompareMin',index:'valCompareMin', width:35,sortable:false,align:"center", hidden:true},
				   			{name:'exceptionWeight',index:'exceptionWeight', width:155,sortable:false,align:"center", hidden:true}
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
					    	 //alert(subgrid_id);
					    	 var $grid = $("#"+subgrid_table_id);
					 		var ids = $grid.jqGrid('getDataIDs');
					 		
					 		for(var i=0;i < ids.length;i++){
					 			var cl = ids[i];
								var point =  $grid.jqGrid('getRowData', cl);
								console.log("巡检点ID = " + cl);
						 		var alarmWeight = point.exceptionWeight;
						 		var seleID = subgrid_table_id + "-alarm-sele-"+i;
						 		console.log("select id = " + seleID);
						 		//告警级别选择
					 			var alarmSelect = "异常告警：<select id=" + seleID + ">";
					 			alarmSelect += "<option value='0' " + (0==alarmWeight?"selected='selected' ":" ") + ">不告警</option>";
					 			alarmSelect += "<option value='1' " + (1==alarmWeight?"selected='selected' ":" ") + ">未知</option>";
					 			alarmSelect += "<option value='2' " + (2==alarmWeight?"selected='selected' ":" ") + ">警告</option>";
					 			alarmSelect += "<option value='3' " + (3==alarmWeight?"selected='selected' ":" ") + ">次要</option>";
					 			alarmSelect += "<option value='4' " + (4==alarmWeight?"selected='selected' ":" ") + ">主要</option>";
					 			alarmSelect += "<option value='5' " + (5==alarmWeight?"selected='selected' ":" ") + ">严重</option>";
					 			alarmSelect += "</select>";
					 			//阀值范围
					 			var holdID = subgrid_table_id + "-slider-range";
						 		var maxV = point.valCompareMax;
						 		var minV = point.valCompareMin;
					 			var holdRange = ((maxV||minV)?"<div><span></span><span></span>-<span></span>":"") + "</div><div id='" + holdID + "'></div>";
						 		
					 			$grid.jqGrid('setRowData',cl,{act:alarmSelect + holdRange});

			 			       console.log("pointID = " + cl);
			 			       var strageID = jQuery("#listStrage").jqGrid( "getGridParam" , "selrow" );
					 			$("#"  + seleID).change(function(event){
					 				var selected = $(this).val();
					 				var pointID = $(this).parents("tr[role='row']").attr("id");
					 				console.log("巡检点ID=" + pointID +  ",策略ID=" + strageID +"告警级别：" + selected);
					 				 $.ajax({
							                url:"<%=basePath%>sethold/refreshHold.action",
							                data:{
							                	"alarmHold.alarmLevel" : selected,
							                	"alarmHold.holdStrageID" : strageID,
							                	"alarmHold.inspectionPointID" : pointID
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
					 			});
					 			var pointID = cl; 
						 		var maxAllow = 100;
						 		if(point.inspectionCode =='FILE-NR'){
						 			maxAllow = 10000;
						 		}
						 		if(maxV||minV){
						 			var $preText = $( "#" + holdID ).prev();
						 			$preText.children("span:eq(0)").text("正常范围:");
					 			 	$( "#" + holdID ).slider({
					 			      range: true,
					 			      min: 0,
					 			      max: maxAllow,
					 			      values: [ minV, maxV ],
					 			      slide: function( event, ui ) {
					 			        if(maxV){
							 			 	$preText.children("span:eq(1)").html( ui.values[ 0 ]);
					 			        }
					 			        if(minV){
							 			 	$preText.children("span:eq(2)").html( ui.values[ 1 ]);
					 			        }
					 			      },
					 			     change: function( event, ui ) {
						 			        if(maxV){
								 			 	$preText.children("span:eq(1)").html( ui.values[ 0 ]);
						 			        }
						 			        if(minV){
								 			 	$preText.children("span:eq(2)").html( ui.values[ 1 ]);
						 			        }
						 			        
						 			       console.log("巡检点ID = " + pointID + ",策略ID = " + strageID);
						 			      $.ajax({
								                url:"<%=basePath%>sethold/refreshHold.action",
								                data:{
								                	"alarmHold.valueMax" : ui.values[ 1 ],
								                	"alarmHold.valueMin" :  ui.values[ 0 ],
								                	"alarmHold.holdStrageID" : strageID,
								                	"alarmHold.inspectionPointID" : pointID,
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
							 			}
					 			    });			
				 			        if(maxV){
						 			 	$preText.children(":eq(1)").text($( "#" + holdID ).slider( "values" )[0]);
				 			        }
				 			        if(minV){
						 			 	$preText.children(":eq(2)").text($( "#" + holdID ).slider( "values" )[1]);
				 			        }
						 		}//end if(maxV||minV){
					 			
					 		}	
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
			     gridComplete: function(){
			    	 jQuery("#gbox_listStrageItem th input[type=checkbox]").hide();

				    	var $grid = jQuery("#listStrageItem");
				 		var ids = $grid.jqGrid('getDataIDs');
				 		for(var i=0;i < ids.length;i++){
							var targetItem = $grid.jqGrid('getRowData', ids[i]);
							//alert(targetItem.valid);
							if(targetItem.valid=='true'){
								//alert(true);
						 		$grid.jqGrid('setSelection', ids[i], function(){});
							}else{
								///alert('wr');
							}
				 		}
				 		$grid.jqGrid('setGridParam',{
				 			 onSelectRow: function(aRowids,status){
					 			   //alert("!!!");
							 		var strageID = 0;
							 		strageID = jQuery("#listStrage").jqGrid('getGridParam','selrow');
							 		valid = status?"Y":"N";
							 		//alert(strageID + aRowids + status);
							 		 $.ajax({
							                url:"<%=basePath%>setting/updateInspectionItemApply.action",
							                data:{
							                	"itemApply.inspectionItemID" : aRowids,
							                	"itemApply.strageID" : strageID,
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
							 	}
				 		});
				 	},
		 		  
			   	pager: '#strageItemNav',
	 			multiselect:true,
			    sortorder: "desc",
			    caption:"检查项目",
			});
			jQuery("#listStrageItem").navGrid('#strageItemNav',{refresh:true,edit:false,add:false,del:false,search:false,refresh:false})
	 			;//.navButtonAdd("#strageItemNav",{caption:"更新&nbsp;", buttonicon:"ui-icon-circle-arrow-n", onClickButton:addInspectionItem, position: "last", title:"更新巡检项", cursor: "pointer"}); 
			
		};
	</script>
	
  </head>
  
	<body>
		<table id="listStrage"></table>
		<div id="strageNav"></div>
		<table id="listStrageItem"></table>
		<div id="strageItemNav"></div>
		
	</body>
</html>
