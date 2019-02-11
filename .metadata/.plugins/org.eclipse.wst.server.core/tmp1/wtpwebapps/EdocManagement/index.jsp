<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	
	<div class="container">
    <!--显示表格数据-->
    <div class="row">
        <div class="col-md-push-12">
            <table class="table  table-hover emp_table" >
                <tbody>
                    <tr>
                        <input type="checkbox" id="Box_all">
                        <td>文档编号</td>
                        <td>文档名称</td>
                        <td>文档摘要</td>
                        <td>上传人</td>
                        <td>上传时间</td>
                        <td>操作 </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

	
	<script type="text/javascript">
	 
	 
	$(function(){
		
		$.ajax({
            url:"${path}/getAll.do",
            type:"get",
            success:function (result) {
                console.log(result);//将后台返回的数据打印出来
            

            }
        });
	})
	    
	        
	    

	  
		
	</script>

</body>
</html>