<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\1\16 0016
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
c
<html>
<%--web 路径问题
    以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
    不以/ 开始的相对路径，找资源，以服务器的路径为标准（http://localhost:3306）;需要加上项目名
    http://localhost:3306/SSM
--%>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>员工列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js\bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <H1>SSM-CRUD</H1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button  class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tr>
                            <th>${emp.empId}</th>
                            <th>${emp.empName}</th>
                            <th>${emp.gender == "M"?"男":"女"}</th>
                            <th>${emp.email}</th>
                            <th>${emp.department.deptName}</th>

                            <th>
                                <button class="btn btn-primary btn-sm">编辑
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                                <button class="btn btn-danger btn-sm">删除
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                </button>
                            </th>

                        </tr>
                    </c:forEach>


                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                当前记录数:${pageInfo.pageNum},总${pageInfo.pages}页,总${pageInfo.total}条记录
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=1">首页</a>
                        </li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${page_Num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <c:if test="${page_Num!=pageInfo.pageNum}">
                                <li><a href="${pageContext.request.contextPath}/emps?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">末页</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

    </div>
    <script>
        $(function (){
            var data = '${pageInfo}';
            console.log(data);
        })
    </script>
</body>
</html>
