<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/menu/sonMenu.js"></script>
<script type="text/javascript">
    var url = "${pageContext.request.contextPath}/sonMenu";
    var method;
    
    /*
      根据名字进行查询
    */
    function searchMenuName() {
        $("#dg").datagrid('load', {
            "menuName" : $("#searchMenuName").val()
        });
    }
    /*
           根据ID进行删除
    */
    function deleteSonMenu() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            var id = selectedRows[i].sonMenuId;
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
                    data : {ids:ids},
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

    function openUserAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
        method = "POST";
    }

    function saveSonMenu() {
        var menuName = $("#menuName").val();
        var muneDescribe = $("#muneDescribe").val();
        var icon = $("#icon").val();
        var muneUrl = $("#muneUrl").val();
        var sonMenuId = $("#sonMenuId").val();
        var fatherMenuId= $("#fatherMenuId").combobox('getValue');
        var data = {
            "sonMenuId" : sonMenuId,
            "menuName" : menuName,
            "muneDescribe" : muneDescribe,
            "icon" : icon,
            "muneUrl" : muneUrl,
            "fatherMenuId" : fatherMenuId
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

    function openUserModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm').form('load', row);
        $("#icon").val(row.icon);
        $("#muneDescribe").val(row.muneDescribe);
        $("#menuName").val(row.menuName);
        $("#muneUrl").val(row.muneUrl);
        $("#sonMenuId").val(row.sonMenuId);
        var fatherMenuId=row.fatherMenu.fatherMenuId;
        $("#fatherMenuId").combobox('select',fatherMenuId);
        method = "PUT";
    }

    function resetValue() {
        $("#menuName").val("");
        $("#icon").val("");
        $("#muneUrl").val("");
        $("#muneDescribe").val("");
        $("#fatherMenuId").combobox('getValue',"");
    }

    function closeUserDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }
    
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a href="javascript:openUserAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:openUserModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deleteSonMenu()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;用户名：&nbsp;<input type="text" id="searchMenuName" size="20"
                onkeydown="if(event.keyCode==13) searchUser()" /> <a
                href="javascript:searchMenuName()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
        style="width: 620px;height:250px;padding: 10px 20px" closed="true"
        buttons="#dlg-buttons">
        <form id="fm" method="post">
        <input type="hidden" id="sonMenuId" value="0">
            <table cellspacing="8px">
                <tr>
                    <td>菜单名：</td>
                    <td><input type="text" id="menuName" name="menuName"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>描述：</td>
                    <td><input type="text" id="muneDescribe" name="muneDescribe"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>图片：</td>
                    <td><input type="text" id="icon" name="icon"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                 <tr>
                    <td>路径：</td>
                    <td><input type="text" id="muneUrl" name="muneUrl"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>父目录：</td>
                    <td>
                        <select class='easyui-combobox' id="fatherMenuId" name='fatherMenuId'  >
                            <option value="" >--请选择--</option>                      
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
        <a href="javascript:saveSonMenu()" class="easyui-linkbutton"
            iconCls="icon-ok">保存</a> <a href="javascript:closeUserDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>