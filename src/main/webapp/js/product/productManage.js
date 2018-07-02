$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'product/datagrid',
						title : '用户管理',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'productId',
									title : '编号',
									checkbox : true
								},
								{
									field : 'productName',
									title : '商品名',
									width : 50
								},
								{
									field : 'productDescription',
									title : '描述',
									width : 100
								},
								{
									field : 'productPrice',
									title : '价格',
									width : 50,
								},
								{
									field : "productEffectiveDate",
									title : "有效日期",
									width : 100,
								}, 
								{
									field : 'enabled',
									title : '是否启用',
									width : 100
								},
								{
									field : 'browseNumber',
									title : '浏览次数',
									width : 50
								},
								{
									field : 'purchaseTimes',
									title : '购买次数',
									width : 50,
								},
								{
									field : "category",
									title : "类别",
									width : 50,
								} 
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})