<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css" >
img{
    height:164.4px;
    wight:100%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/question/questionManage.js"></script>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/question";
	var method;
	
	
    /*
      根据类型进行查询
    */
    function searchQuestion() {
        $("#dg").datagrid('load', {
            "questionType" : $("#name").val()
        });
    }
    /*
           根据ID进行删除
    */
    function deleteQuestion() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            var questionId = selectedRows[i].questionId;
            strIds.push(questionId);
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

    function openQuestionAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加信息");
        method = "POST";
    }

   
    function openQuestionModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg2").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm2').form('load', row);
        $("#questionId2").val(row.questionId);
        $("#questionType2").val(row.questionType);
        var str=row.questionContent.split('<');
        var str2=row.questionContent.split('>');
        $("#content1").val(str[0]);
        $("#content2").val(str2[1]);
        $("#chooseContent2").val(row.chooseContent);
        $("#answer2").val(row.answer);
        $("#answerAnalysis2").val(row.answerAnalysis);
        $("#questionSource2").val(row.questionSource);
        $("#examinationPointDescription2").val(row.examinationPointDescription);
        $("#titleAccuracy2").val(row.titleAccuracy);
        $("#questionSelectionToal2").val(row.questionSelectionToal);
        $("#questionValue2").val(row.questionValue);
        $("#questionBankId2").combobox('select',row.questionBank.questionBankId);
    }

    function resetValue() {
        $("#questionType").val("");
        $("#questionContent").val("");
        $("#chooseContent").val("");
        $("#answer").val("");
        $("#answerAnalysis").val("");
        $("#questionSource").val("");
        $("#examinationPointDescription").val("");
        $("#titleAccuracy").val("");
        $("#questionSelectionToal").val("");
        $("#questionValue").val("");
        $("#questionBankId").combobox('setValue',"--请选择--");
	}
	function resetValue() {
		$("#questionType2").val("");
		$("#content1").val("");
        $("#content2").val("");
		$("#chooseContent2").val("");
		$("#answer2").val("");
		$("#answerAnalysis2").val("");
		$("#questionSource2").val("");
		$("#examinationPointDescription2").val("");
		$("#titleAccuracy2").val("");
		$("#questionSelectionToal2").val("");
		$("#questionValue2").val("");
		$("#questionBankId2").combobox('setValue', "--请选择--");
	}
	function closeQuestionDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }
     function closeQuestionDialog2() {
        $("#dlg2").dialog("close");
        resetValue();
    }
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a href="javascript:openQuestionAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:openQuestionModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deleteQuestion()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;类型：&nbsp;<input type="text" id="name" size="20"
                onkeydown="if(event.keyCode==13) searchQuestion()" /> <a
                href="javascript:searchQuestion()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post" enctype="multipart/form-data" action="question/add">
			<table cellspacing="8px">
				<tr>
					<td>类型：</td>
					<td><input type="text" id="questionType" name="questionType"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="questionId" value="0">
					</td>
				</tr>
				
				<tr>
                    <td>内容1：</td>
                    <td><input type="text" id="content" name="before"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>图片：</td>
                    <td><input type="file" id="image" name="image"
                        class="easyui-validatebox"   style="height: 50px"/>&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>内容2：</td>
                    <td><input type="text" id="content" name="after"
                        class="easyui-validatebox" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                </tr>
					<td>选择内容：</td>
					<td><input type="text" id="chooseContent" name="chooseContent"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
				<tr>
					<td>答案：</td>
					<td><input type="text" id="answer" name="answer"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>答案解析：</td>
					<td><input type="text" id="answerAnalysis" name="answerAnalysis"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>题目来源：</td>
					<td><input type="text" id="questionSource" name="questionSource"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>考点描述：</td>
					<td><input type="text" id="examinationPointDescription" name="examinationPointDescription"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
				<tr>
					<td>题目准确数：</td>
					<td><input type="text" id="titleAccuracy" name="titleAccuracy"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>题目可选择数目：</td>
					<td><input type="text" id="questionSelectionToal" name="questionSelectionToal"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>题目分值：</td>
					<td><input type="text" id="questionValue" name="questionValue"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
				<tr>
					<td>题库名字：</td>
					<td>
                        <select class='easyui-combobox' id="questionBankId" name='questionBankId'  >
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
            <a href="javascript:closeQuestionDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
    
    <div id="dlg2" class="easyui-dialog"
        style="width: 620px;height:250px;padding: 10px 20px" closed="true"
        buttons="#dlg-buttons2">
        <form id="fm2" method="post" enctype="multipart/form-data" action="question/update">
            <table cellspacing="8px">
                <tr>
                    <td>类型：</td>
                    <td><input type="text" id="questionType2" name="questionType"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> <input type="hidden" id="questionId2" name="questionId" value="0">
                    </td>
                </tr>
                
                <tr>
                    <td>内容1：</td>
                    <td><input type="text" id="content1" name="before"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>图片：</td>
                    <td><input type="file" id="image2" name="image"
                        class="easyui-validatebox"   style="height: 50px"/>&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>内容2：</td>
                    <td><input type="text" id="content2" name="after"
                        class="easyui-validatebox" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                </tr>
                    <td>选择内容：</td>
                    <td><input type="text" id="chooseContent2" name="chooseContent"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                
                <tr>
                    <td>答案：</td>
                    <td><input type="text" id="answer2" name="answer"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>答案解析：</td>
                    <td><input type="text" id="answerAnalysis2" name="answerAnalysis"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>题目来源：</td>
                    <td><input type="text" id="questionSource2" name="questionSource"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>考点描述：</td>
                    <td><input type="text" id="examinationPointDescription2" name="examinationPointDescription"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                
                <tr>
                    <td>题目准确数：</td>
                    <td><input type="text" id="titleAccuracy2" name="titleAccuracy"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>题目可选择数目：</td>
                    <td><input type="text" id="questionSelectionToal2" name="questionSelectionToal"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>题目分值：</td>
                    <td><input type="text" id="questionValue2" name="questionValue"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                
                <tr>
                    <td>题库名字：</td>
                    <td>
                        <select class='easyui-combobox' id="questionBankId2" name='questionBankId'  >
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
            <a href="javascript:closeQuestionDialog2()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>