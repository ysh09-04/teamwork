<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>角色管理</title>
<script src="js/common.js"></script>
<script src="js/order/order.js"></script>
</head>

<body style="margin:1px;">
	<!-- datagrid -->
	<table id="dg"></table>
	
	<!-- toolbar -->
	<div id="tb">
		<div>
			<a href="javascript:add()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">未发货</a> <a
				href="javascript:edit()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">已发货</a> <a
				href="javascript:del()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">确认收货</a>
		</div>
		<%--<div>
			&nbsp;权限名称：&nbsp;<input type="text" id="s_title" size="20"
				onkeydown="if(event.keyCode==13) searchMenu()" /> <a
				href="javascript:searchMenu()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	--%></div>
	<!-- dialog -->
	<div id="dlg" class="easyui-dialog" style="width: 620px;height:250px;padding: 10px 20px" closed="true" >
		<form id="add_form" method="post">
			<input type="hidden" name='questionBankId' id='questionBankId' />
			<table cellspacing="8px">
				<tr>
					<td>题库名称：</td>
					<td><input type="text" id="questionBankName" name="questionBankName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font></td>
						</tr>
						<tr>
						<td>题库描述：</td>
                    <td><input type="text" id="questionBankDescribe" name="questionBankDescribe"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                        </tr>
                        <tr>
                        <td>浏览次数：</td>
                    <td><input type="text" id="visitTimes" name="visitTimes"
                        class="easyui-validatebox" required="true" readonly="readonly"  />&nbsp;<font
                        color="red" >*</font></td>
                        </tr>
                        <tr>
                        
                        <td>购买次数：</td>
                    <td><input type="text" id="purchaseTimes" name="purchaseTimes"
                        class="easyui-validatebox" required="true" readonly="readonly"  />&nbsp;<font
                        color="red" >*</font></td>                       
                        </tr>
                        <tr>
					<td>课程名:</td>
					<td>
                        <select class='easyui-combobox' id="courseId" name='courseId'  >
                            <option>--请选择--</option>
                                                
                        </select>
                    </td>
				</tr>
				
					
					<%--<td>角色</td>
					<td>
						<select id='role' class="easyui-combobox" name='role'>
							<option value="9" selected="selected">普通管理员</option>
							<option value="99">系统管理员</option>
						</select>
					</td>
				--%>
			</table>
		</form>
	</div>
	<!-- 授权菜单Dlg -->
	<div id="menudlg" class="easyui-dialog" style="width: 620px;height:250px;padding: 10px 20px" closed="true">
		<div id="menus"></div>
	</div>

</body>
</html>
