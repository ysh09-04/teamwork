<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
            if (questionId == 1) {
                $.messager.alert("系统提示", "操作失败!");
                return;
            }
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

    function saveQuestion() {
        var questionId = $("#questionId").val();
        var questionType = $("#questionType").val();
        var questionContent = $("#questionContent").val();
        var chooseContent = $("#chooseContent").val();
        var answer = $("#answer").val();
        var answerAnalysis = $("#answerAnalysis").val();
        var questionSource = $("#questionSource").val();
        var examinationPointDescription = $("#examinationPointDescription").val();
        var titleAccuracy = $("#titleAccuracy").val();
        var questionSelectionToal = $("#questionSelectionToal").val();
        var questionValue = $("#questionValue").val();
        var questionBankId = $("#questionBankId").combobox('getValue');
        
        var data = {
            "questionId" : questionId,
            "questionType" : questionType,
            "questionContent" : questionContent,
            "chooseContent" : chooseContent,
            "answer" : answer,
            "answerAnalysis" : answerAnalysis,
            "questionSource" : questionSource,
            "examinationPointDescription" : examinationPointDescription,
            "titleAccuracy" : titleAccuracy,
            "questionSelectionToal" : questionSelectionToal,
            "questionValue" : questionValue,
            "questionBankId" : questionBankId
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

    function openQuestionModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm').form('load', row);
        $("#questionId").val(row.questionId);
        $("#questionType").val(row.questionType);
        $("#questionContent").val(row.questionContent);
        $("#chooseContent").val(row.chooseContent);
        $("#answer").val(row.answer);
        $("#answerAnalysis").val(row.answerAnalysis);
        $("#questionSource").val(row.questionSource);
        $("#examinationPointDescription").val(row.examinationPointDescription);
        $("#titleAccuracy").val(row.titleAccuracy);
        $("#questionSelectionToal").val(row.questionSelectionToal);
        $("#questionValue").val(row.questionValue);
        $("#questionBankId").combobox('select',row.question.questionBankId);
       
        method = "PUT";
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

    function closeQuestionDialog() {
        $("#dlg").dialog("close");
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
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>类型：</td>
					<td><input type="text" id="questionType" name="questionType"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="questionId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>题目内容：</td>
					<td><input type="text" id="questionContent" name="questionContent"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
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
				
				
				
				
			</table>
		</form>
	</div>

    <div id="dlg-buttons">
        <a href="javascript:saveQuestion()" class="easyui-linkbutton"
            iconCls="icon-ok">保存</a> <a href="javascript:closeQuestionDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>