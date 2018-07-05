<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/user/userManage.js"></script>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/users";
	var method;
	
	function searchSUser() {
		$("#dg").datagrid('load', {
			"userName" : $("#name").val()
		});
	}

	function deleteSUser() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的数据！");
			return;
		}
		var strIds = [];
		for ( var i = 0; i < selectedRows.length; i++) {
			var id = selectedRows[i].userId;
			if (id == 1) {
				$.messager.alert("系统提示", "操作失败!");
				return;
			}
			strIds.push(id);
		}
		var ids = strIds.join(",");
		$.messager.confirm("系统提示", "您确认要删除这<font color=red>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
				$.ajax({
					type : "DELETE",//方法类型
					dataType : "json",//预期服务器返回的数据类型
					url : url + '/' + ids,//url
					data : {},
					success : function(result) {
						//console.log(result);//打印服务端返回的数据
						if (result.resultCode == 200) {
							$.messager.alert("系统提示", "数据已成功删除！");
							$("#dg").datagrid("reload");
						} else {
							$.messager.alert("系统提示", "数据删除失败！");
						}

						;
					},
					error : function() {
						$.messager.alert("ERROR！");
					}
				});
			}
		});

	}

	function openSUserAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
		method = "POST";
	}

	function saveSUser() {
	    var userId = $("#userId").val();
		var password = $("#password").val();
		var userName = $("#userName").val();
		var state = $("#state").val();
		var data = {
			"userId" : userId,
			"password" : password,
			"userName": userName,
			"state": state,
		}
		$.ajax({
			type : method,//方法类型
			dataType : "json",//预期服务器返回的数据类型
			url : url,//url
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(data),
			success : function(result) {
				//console.log(result);//打印服务端返回的数据
				if (result.resultCode == 200) {
					$.messager.alert("系统提示", "保存成功");
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
					resetValue();
				} else {
					$.messager.alert("系统提示", "操作失败");
					$("#dlg").dialog("close");
					resetValue();
				}
				;
			},
			error : function() {
				$.messager.alert("系统提示", "操作失败");
			}
		});
	}

	function openSUserModifyDialog() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length != 1) {
			$.messager.alert("系统提示", "请选择一条要编辑的数据！");
			return;
		}
		var row = selectedRows[0];
		if (row.tid == 1) {
			$.messager.alert("系统提示", "操作失败！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
		$('#fm').form('load', row);
		$("#userId").val(row.userId);
		$("#password").val(row.password);
		$("#userName").val(row.userName);
		$("#state").val(row.state);
		
		method = "PUT";
	}

	function resetValue() {
		$("#password").val("");
		$("#userName").val("");
		$("#state").val("");
	}

	function closeSUserDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
	
	
</script>
</head>
<body style="margin:1px;">
	<table id="dg"></table>
	<div id="tb">
		<div>
			<a href="javascript:openSUserAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openSUserModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteSUser()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;姓名：&nbsp;<input type="text" id="name" size="20"
				onkeydown="if(event.keyCode==13) searchSUser()" /> <a
				href="javascript:searchSUser()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="userName" name="userName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="userId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>密码：</td>
					<td><input type="password" id="password" name="password"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input type="state" id="state" name="state"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveSUser()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeSUserDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>