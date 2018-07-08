$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'video/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'videoId',
			title : '编号',
			width : 100,
			align: 'center'
		}, {
			field : 'videoType',
			title : '视频类型',
			width : 100,
			align: 'center'
		}, {
			field : 'videoName',
			title : '视频名字',
			width : 100,
			align: 'center'
		}, {
			field : 'videoUrl',
			title : '视频路径',
			width : 350,
			align: 'center'
		}, {
			field : 'videoSynopsis',
			title : '视频简介',
			width : 200,
			align: 'center'
		}, {
			field : 'enabled',
			title : '是否启动',
			width : 100,
			align: 'center'
		}, {
			field : 'sortId',
			title : '排名',
			width : 100,
			align: 'center'
		}, {
			field : 'playNumber',
			title : '播放次数',
			width : 100,
			align: 'center'
		}, {
			field : 'videoCategory.videoCategoryName',
			title : '视频类目名',
			width : 100,
			align: 'center'
		} 
		 ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
		$.ajax({
			type:'post',
			url:'videoCategory/findAll',
			dataType : "json", 
			success:function(result){
				$('#videoCategoryId').combobox({
				      data : result,
				      valueField:'videoCategoryId',
				      textField:'videoCategoryName'
				     });
			},
		});
});