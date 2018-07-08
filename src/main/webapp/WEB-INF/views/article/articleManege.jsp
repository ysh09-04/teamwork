<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/article/articleManage.js"></script>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/article";
	var method;
	
	
    /*
      根据内容进行查询
    */
    function searchArticle() {
        $("#dg").datagrid('load', {
            "articleTitle" : $("#name").val()
        });
    }
    /*
           根据ID进行删除
    */
    function deleteArticle() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            var articleId = selectedRows[i].articleId;
            strIds.push(articleId);
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

    function openArticleAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加信息");
        method = "POST";
    }
    function openArticleModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg2").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm2').form('load', row);
        $("#articleId2").val(row.articleId);
        $("#articleType2").val(row.articleType);
        $("#articleTitle2").val(row.articleTitle);
        $("#articleWriter2").val(row.articleWriter);
        $("#articleContent2").val(row.articleContent);
        $("#readNumber2").val(row.readNumber);
        $("#courseId2").combobox('select',row.course.courseId);
       
        method = "PUT";
    }

    function resetValue() {
        $("#articleType").val("");
        $("#articleTitle").val("");
        $("#articleWriter").val("");
        $("#articleContent").val("");
        $("#readNumber").val("");
        $("#courseId").combobox('setValue',"--请选择--");
        
    }

    function closeArticleDialog() {
        $("#dlg").dialog("close");
    }
     function closeArticleDialog2() {
        $("#dlg2").dialog("close");
    }
    
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a href="javascript:openArticleAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:openArticleModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deleteArticle()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;文章内容：&nbsp;<input type="text" id="name" size="20"
                onkeydown="if(event.keyCode==13) searchPaper()" /> <a
                href="javascript:searchArticle()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post" action="article/addArticle" enctype="multipart/form-data">
			<table cellspacing="8px">
				<tr>
					<td>文章类别：</td>
					<td><input type="text" id="articleType" name="articleType"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="articleId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>文章标题：</td>
					<td><input type="text" id="articleTitle" name="articleTitle"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" id="articleWriter" name="articleWriter"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
				<tr>
					<td>文章内容：</td>
					<td><input type="file" id="file" name="file"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>阅读数目：</td>
					<td><input type="text" id="readNumber" name="readNumber"
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
				<tr>
                    <td>
                        <input type="submit" value="添加">
                    </td>
                </tr>
			</table>
		</form>
	</div>

    <div id="dlg-buttons">
        <<a href="javascript:closeArticleDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
    
    <div id="dlg2" class="easyui-dialog"
        style="width: 620px;height:250px;padding: 10px 20px" closed="true"
        buttons="#dlg-buttons2">
        <form id="fm2" method="post" action="article/update" enctype="multipart/form-data">
            <table cellspacing="8px">
                <tr>
                    <td>文章类别：</td>
                    <td><input type="text" id="articleType2" name="articleType"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> <input type="hidden" id="articleId2" name="articleId" value="0">
                    </td>
                </tr>
                
                <tr>
                    <td>文章标题：</td>
                    <td><input type="text" id="articleTitle2" name="articleTitle"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>作者：</td>
                    <td><input type="text" id="articleWriter2" name="articleWriter"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                
                <tr>
                    <td>文章内容：</td>
                    <td><input type="file" id="file" name="file"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>阅读数目：</td>
                    <td><input type="text" id="readNumber2" name="readNumber"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>课程名：</td>
                    <td>
                        <select class='easyui-combobox' id="courseId2" name='courseId'  >
                            <option>--请选择--</option>                      
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="添加">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons2">
        <<a href="javascript:closeArticleDialog2()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>