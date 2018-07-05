<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>角色管理</title>
<script src="js/common.js"></script>
<script src="js/shop_content/shop_content.js"></script>
</head>

<body style="margin:1px;">
    <!-- datagrid -->
    <table id="dg"></table>
    
    <!-- toolbar -->
    <div id="tb">
        <div>
            <a href="javascript:addPage()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:editPage()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:del()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
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
            <input type="hidden" id="productContentID" value="0"/>
            <table cellspacing="8px">
                
                    
                      <tr>
                    <td>产品名:</td>
                    <td>
                        <select class='easyui-combobox' id="productId" name='productId'  >
                            <option>--请选择--</option>
                                                
                        </select>
                    </td>
                </tr>
               
                <tr>
                    <td>类型:</td>
                    <td>
                        <select class='easyui-combobox' id="type" name="type" >
                            <option>--请选择--</option>
                            <option value="视频类目">--视频类目--</option>
                            <option value="试卷">--试卷--</option>
                            <option value="题库">--题库--</option>                                                                         
                        </select>
                    </td>
                </tr>
                  <tr>
                    <td>产品内容:</td>
                    <td>
                        <select class='easyui-combobox' id="contentId" name='contentId'  >
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
