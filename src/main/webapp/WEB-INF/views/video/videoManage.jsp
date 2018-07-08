<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/video/video.js"></script>
<script type="text/javascript">
    var url = "${pageContext.request.contextPath}/video";
    var method;
    
    /*
      根据名字进行查询
    */
    function searchvideoName() {
        $("#dg").datagrid('load', {
            "videoName" : $("#searchvideoName").val()
        });
    }
    /*
           根据ID进行删除
    */
    function deletevideo() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            var id = selectedRows[i].videoId;
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

    function openvideoAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
        method = "POST";
	}
	
    function openvideoModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg2").dialog("open").dialog("setTitle", "编辑用户信息");
        $('#fm2').form('load', row);
        $("#videoId2").val(row.videoId);
        $("#videoName2").val(row.videoName);
        $("#videoType2").val(row.videoType);
        $("#videoSynopsis2").val(row.videoSynopsis);
        $("#enabled2").val(row.enabled);
        $("#sortId2").val(row.sortId);
        $("#playNumber2").val(row.playNumber);
        $("#videoCategoryId2").combobox('select',row.videoCategory.videoCategoryId);
        method = "PUT";
    }

    function resetValue() {
        $("#videoName").val('');
        $("#videoType").val('');
        $("#videoUrl").val('');
        $("#videoSynopsis").val('');
        $("#enabled").val('');
        $("#sortId").val('');
        $("#playNumber").val('');
        $("#videoCategoryId").combobox('setVlaue','--请选择--');
    }

    function closevideoDialog() {
        $("#dlg").dialog("close");
    }
  function closevideoDialog2() {
        $("#dlg2").dialog("close");
    }
</script>
</head>
<body style="margin:1px;">
    <table id="dg"></table>
    <div id="tb">
        <div>
            <a href="javascript:openvideoAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">添加</a> <a
                href="javascript:openvideoModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deletevideo()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;用户名：&nbsp;<input type="text" id="searchvideoName" size="20"
                onkeydown="if(event.keyCode==13) searchUser()" /> <a
                href="javascript:searchvideoName()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>
<div id="dlg2" class="easyui-dialog"
        style="width: 620px;height:250px;padding: 10px 20px" closed="true"
        buttons="#dlg-buttons2">
        <form id="fm2" method="post" action="video/update" enctype="multipart/form-data">
        <input type="hidden" id="videoId2" name="videoId2" value="0">
            <table cellspacing="8px">
                <tr>
                    <td>视频类目名：</td>
                    <td><input type="text" id="videoName2" name="videoName2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频类型：</td>
                    <td><input type="text" id="videoType2" name="videoType2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>视频路径：</td>
                    <td><input type="file" id="videoUrl2" name="videoUrl2" 
                         class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频简介：</td>
                    <td><input type="text" id="videoSynopsis2" name="videoSynopsis2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>是否启用：</td>
                    <td><input type="text" id="enabled2" name="enabled2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>排序：</td>
                    <td><input type="text" id="sortId2" name="sortId2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>播放次数：</td>
                    <td><input type="text" id="playNumber2" name="playNumber2"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频类目名：</td>
                    <td>
                        <select class='easyui-combobox' id="videoCategoryId2" name='videoCategoryId2'  >
                            <option>--请选择--</option>                      
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="修改"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="dlg-buttons2">
         <a href="javascript:closevideoDialog2()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
    <div id="dlg" class="easyui-dialog"
        style="width: 620px;height:250px;padding: 10px 20px" closed="true"
        buttons="#dlg-buttons">
        <form id="fm" method="post" action="video/save" enctype="multipart/form-data">
        <input type="hidden" id="videoId" value="0">
            <table cellspacing="8px">
                <tr>
                    <td>视频类目名：</td>
                    <td><input type="text" id="videoName" name="videoName"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频类型：</td>
                    <td><input type="text" id="videoType" name="videoType"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>视频路径：</td>
                    <td><input type="file" id="videoUrl" name="videoUrl" 
                         class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频简介：</td>
                    <td><input type="text" id="videoSynopsis" name="videoSynopsis"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>是否启用：</td>
                    <td><input type="text" id="enabled" name="enabled"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>排序：</td>
                    <td><input type="text" id="sortId" name="sortId"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font></td>
                </tr>
                <tr>
                    <td>播放次数：</td>
                    <td><input type="text" id="playNumber" name="playNumber"
                        class="easyui-validatebox" required="true" />&nbsp;<font
                        color="red">*</font> 
                    </td>
                </tr>
                <tr>
                    <td>视频类目名：</td>
                    <td>
                        <select class='easyui-combobox' id="videoCategoryId" name='videoCategoryId'  >
                            <option>--请选择--</option>                      
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="添加"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
         <a href="javascript:closevideoDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
</body>
</html>