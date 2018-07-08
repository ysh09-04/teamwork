<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/userCourse/userCourse.js"></script>
<script type="text/javascript">
    /*
      根据名字进行查询
    */
    function searchVideoCategoryName() {
        $("#dg").datagrid('load', {
            "userName" : $("#searchuserName").val()
        });
    }

    function update() {
        var selectedRows = $("#dg").datagrid('getSelections');
        var row = selectedRows[0];
        var userCourseId = row.userCourseId;
        var courseState = row.courseState;
        var data = {
            "userCourseId" : userCourseId,
            "courseState" : courseState,
        }
        $.ajax({
            type : 'post',//方法类型
            dataType : "json",//预期服务器返回的数据类型
            url : 'UserCourse/update',//url
            contentType : "application/json; charset=utf-8",
            data : JSON.stringify(data),
            success : function(result) {
                //console.log(result);//打印服务端返回的数据
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#dlg").dialog("close");
                    $("#dg").datagrid("reload");
                } else {
                    $.messager.alert("系统提示", "操作失败");
                    $("#dlg").dialog("close");
                }
                ;
            },
            error : function() {
                $.messager.alert("系统提示", "操作失败");
            }
        });
    }

    

    
    
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a
                href="javascript:update()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改状态</a>
        </div>
        <div>
            &nbsp;用户名：&nbsp;<input type="text" id="searchuserName" size="20"
                onkeydown="if(event.keyCode==13) searchUser()" /> <a
                href="javascript:searchVideoCategoryName()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

</body>
</html>