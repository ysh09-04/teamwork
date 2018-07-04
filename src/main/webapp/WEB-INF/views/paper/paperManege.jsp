<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/paper/paperManage.js"></script>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/paper";
	var method;
	
	
    /*
      根据名字进行查询
    */
    function searchPaper() {
        $("#dg").datagrid('load', {
            "paperName" : $("#name").val()
        });
    }
    /*
           根据ID进行删除
    */
    function deletePaper() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            var paperId = selectedRows[i].paperId;
            if (paperId == 1) {
                $.messager.alert("系统提示", "操作失败!");
                return;
            }
            strIds.push(paperId);
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

    function openPaperAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加信息");
        method = "POST";
    }

    function savepaper() {
        var paperId = $("#paperId").val();
        var paperTotalScore = $("#paperTotalScore").val();
        var paperDescription = $("#paperDescription").val();
        var paperName = $("#paperName").val();
        var paperType = $("#paperType").val();
        var courseId = $("#courseId").val();
        
        var data = {
            "paperId" : paperId,
            "paperTotalScore" : paperTotalScore,
            "paperDescription" : paperDescription,
            "paperName" : paperName,
            "paperType" : paperType,
            "courseId" : courseId
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

    function openPaperModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm').form('load', row);
        $("#paperId").val(row.paperId);
        $("#paperTotalScore").val(row.paperTotalScore);
        $("#paperDescription").val(row.paperDescription);
        $("#paperName").val(row.paperName);
        $("#paperType").val(row.paperType);
        $("#courseId").val(row.courseId);
       
        method = "PUT";
    }

    function resetValue() {
        $("#paperTotalScore").val("");
        $("#paperDescription").val("");
        $("#paperName").val("");
        $("#paperType").val("");
        $("#courseId").combobox('setValue',"--请选择--");
        
    }

    function closePaperDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }
    
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a href="javascript:openPaperAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:openPaperModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deletePaper()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;考卷名：&nbsp;<input type="text" id="name" size="20"
                onkeydown="if(event.keyCode==13) searchPaper()" /> <a
                href="javascript:searchPaper()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>总分：</td>
					<td><input type="text" id="paperTotalScore" name="paperTotalScore"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="paperId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>描述：</td>
					<td><input type="text" id="paperDescription" name="paperDescription"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>考卷名：</td>
					<td><input type="text" id="paperName" name="paperName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
				<tr>
					<td>考卷类型：</td>
					<td><input type="text" id="paperType" name="paperType"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>课程名：</td>
					<td>
                        <select class='easyui-combobox' id="courseId" name='courseId'  >
                            <option>--请选择--</option>                      
                        </select>
                    </td>
				</tr>
				
				
			</table>
		</form>
	</div>

    <div id="dlg-buttons">
        <a href="javascript:savepaper()" class="easyui-linkbutton"
            iconCls="icon-ok">保存</a> <a href="javascript:closePaperDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>