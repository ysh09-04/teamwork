$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'product/datagrid',
						title : '用户管理',
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'productId',
									title : '编号',
									width : 80,
									align: 'center'
								},
								{
									field : 'productName',
									title : '商品名',
									width : 150,
									align: 'center'
								},
								{
									field : 'productDescription',
									title : '描述',
									width : 300,
									align: 'center'
								},
								{
									field : 'productPrice',
									title : '价格',
									width : 100,
									align: 'center'
								},
								{
									field : "productEffectiveDate",
									title : "有效日期",
									width : 200,
									align: 'center'
								}, 
								{
									field : 'enabled',
									title : '是否启用',
									width : 100,
									align: 'center'
								},
								{
									field : 'browseNumber',
									title : '浏览次数',
									width : 80,
									align: 'center'
								},
								{
									field : 'purchaseTimes',
									title : '购买次数',
									width : 80,
									align: 'center'
								},
								{
									field : "category",
									title : "类别",
									width : 150,
									align: 'center'
								} 
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})