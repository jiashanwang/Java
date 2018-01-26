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
    <style>
        #pageNav li{
            cursor:pointer;
        }
    </style>
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
            <button  class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="table">

                </tbody>
                <%--<c:forEach items="${pageInfo.list}" var="emp">--%>
                    <%--<tr>--%>
                        <%--<th>${emp.empId}</th>--%>
                        <%--<th>${emp.empName}</th>--%>
                        <%--<th>${emp.gender == "M"?"男":"女"}</th>--%>
                        <%--<th>${emp.email}</th>--%>
                        <%--<th>${emp.department.deptName}</th>--%>

                        <%--<th>--%>
                            <%--<button class="btn btn-primary btn-sm">编辑--%>
                                <%--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>--%>
                            <%--</button>--%>
                            <%--<button class="btn btn-danger btn-sm">删除--%>
                                <%--<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>--%>
                            <%--</button>--%>
                        <%--</th>--%>

                    <%--</tr>--%>
                <%--</c:forEach>--%>


            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6" id="page_info_area">
            当前记录数:,总页,总 条记录
        </div>
        <div class="col-md-6" id="page_nav_area">
            <nav aria-label="Page navigation" id="pageNav">
                <%--<ul class="pagination">--%>
                    <%--<li id="first">--%>
                        <%--<a href="${pageContext.request.contextPath}/emps?pn=1">首页</a>--%>
                    <%--</li>--%>
                    <%--<c:if test="${pageInfo.hasPreviousPage}">--%>
                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">--%>
                                <%--<span aria-hidden="true">&laquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>

                    <%--<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">--%>
                        <%--<c:if test="${page_Num == pageInfo.pageNum}">--%>
                            <%--<li class="active"><a href="#">${page_Num}</a></li>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${page_Num!=pageInfo.pageNum}">--%>
                            <%--<li><a href="${pageContext.request.contextPath}/emps?pn=${page_Num}">${page_Num}</a></li>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<c:if test="${pageInfo.hasNextPage}">--%>
                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum + 1}" aria-label="Next">--%>
                                <%--<span aria-hidden="true">&raquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>
                    <%--<li id="last">--%>
                        <%--<a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">末页</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            </nav>
        </div>
    </div>

    <!-- 员工添加的模态框 -->
    <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="empName_input" class="col-sm-2 control-label">empName</label>
                            <div class="col-sm-10">
                                <input type="text" name="empName" class="form-control" id="empName_input" placeholder="empName">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email_add_input" class="col-sm-2 control-label">email</label>
                            <div class="col-sm-10">
                                <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@atguigu.com">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email_add_input" class="col-sm-2 control-label">gender</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="gender1_add_input" value="M" checked="true"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                                </label>
                            </div>


                        </div>
                        <div class="form-group">
                            <label for="dept_add_select" class="col-sm-2 control-label">department</label>
                            <div class="col-sm-10">
                                <%--部门提交--%>
                                <select class="form-control" name="dId" id="dept_add_select">
                                    <%--<option>1</option>--%>
                                    <%--<option>2</option>--%>
                                    <%--<option>3</option>--%>
                                    <%--<option>4</option>--%>
                                    <%--<option>5</option>--%>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="empSave">保存</button>
                </div>
            </div>
        </div>
    </div>


</div>
<script>
    $(function (){
        var totalRecord ;
       function getData(n){
           $.ajax({
               type:'GET',
               url:"${pageContext.request.contextPath}/emps",
               data:"pn=" + n,
               success:function (result){
                   build_emps_table(result);
                   build_page_info(result)
                   build_page_nav(result)
               },
               error:function (error){
               }
           })
       };

       getData(1);
       // 解析table表格
       function build_emps_table(result){
           $("#table").empty();
           var emps= result.extend.pageInfo.list;
           $.each(emps,function (index,item){
               var empIdTd = $("<td></td>").append(item.empId);
               var empNameId =$("<td></td>").append(item.empName);
               var gender = item.gender=="M"?"男":"女";
               var genderTd = $("<td></td>").append(gender);
               var emailTd = $("<td></td>").append(item.email);
               var deptNameTd = $("<td></td>").append(item.department.deptName);
               var btn1 = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span>编辑</span>").addClass("glyphicon glyphicon-pencil"));
               var btn2 = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span>删除</span>").addClass("glyphicon glyphicon-pencil"));
                var btnTd = $("<td></td>").append(btn1).append(btn2);

               var tr = $("<tr></tr>").append(empIdTd).append(empNameId).append(genderTd).append(emailTd).append(deptNameTd).append(btnTd);

               $("#table").append(tr);

           })
       };
       // 解析显示分页信息
        function build_page_info(result){
            var str = "当前记录数"+result.extend.pageInfo.pageNum + " :,总" +result.extend.pageInfo.pageSize+"页,总" +result.extend.pageInfo.total+" 条记录"
            totalRecord =  result.extend.pageInfo.total;
            $("#page_info_area").text(str);

        }
       //解析导航条
       function build_page_nav(result){
            $("#pageNav").empty();
            var ul = $("<ul></ul>").addClass("pagination");

           if(result.extend.pageInfo.hasPreviousPage){
               var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
               var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
           }else {
               var prePageLi = $("<li class='disabled'></li>").append($("<a></a>").append("&laquo;"));
               var firstPageLi = $("<li class='disabled'></li>").append($("<a></a>").append("首页").attr("href","#"));
           }
           if(result.extend.pageInfo.hasNextPage){
               var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
               var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
           }else{
                var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
               var nextPageLi = $("<li class='disabled'></li>").append($("<a></a>").append("&raquo;"));
           }

            ul.append(firstPageLi).append(prePageLi);
            $.each(result.extend.pageInfo.navigatepageNums,function (i,item){
                var numLi = $("<li></li>").append($("<a></a>").append(item));
                if(result.extend.pageInfo.pageNum == item){
                   numLi.addClass("active");
                }
                numLi.click(function (){
                    getData(item);
                })

                ul.append(numLi);
            });
            ul.append(nextPageLi).append(lastPageLi);
            $("#pageNav").append(ul);
            firstPageLi.click(function (){
                getData(1);
            })
           prePageLi.click(function(){
               if(!$(this).hasClass("disabled")){
                   getData(result.extend.pageInfo.pageNum -1);
               }
           })
           nextPageLi.click(function (){
               if(!$(this).hasClass("disabled")){
                    getData(result.extend.pageInfo.pageNum +1);
               }
           })
            lastPageLi.click(function (){
                getData(result.extend.pageInfo.pages);
            })
       }

       // 点击新增 -- 》弹出
        $("#emp_add_modal_btn").click(function (){
            // 先清除之前所有的
            $("#empAddModal form")[0].reset();
            $("#dept_add_select").empty();
            // 发送ajax请求，查出部门信息，显示在下拉列表中
            getDept();
            $("#empAddModal").modal({
                backdrop:"static"
            })
        })

        function getDept(){

           $.ajax({
               type:"GET",
               url:"${pageContext.request.contextPath}/depts",
               success:function (result){
                   var list = result.extend.depts
                   $.each(list,function (i,item){
                       var option = $("<option></optin>").append(item.deptName).attr("value",item.deptId);
                       $("#dept_add_select").append(option);
                   })


                   console.log(result);
               },
               error:function (error){
                   console.log(error);
               }
           })
        }
         var enameFlag;
        var emailFlag;
        // 校验表单数据
        function validate_add_form(){
            debugger;
            // 1.拿到要校验的用户名和邮箱
            var empName = $("#empName_input").val().trim();
            // 用户名校验规则
            var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]+$)/;

            if(!regName.test(empName)){
//                $("#empName_input").parent().addClass("has-error");
//                $("#empName_input").next("span").text("用户名错误")
                show_validat_msg("#empName_input","error","用户名错误");
                enameFlag == 0;

                return;


            }else{
//                $("#empName_input").parent().addClass("has-success");
                show_validat_msg("#empName_input","success","");
                enameFlag == 1;
            }

            // 校验邮箱信息
            var email = $('#email_add_input').val().trim();
            // 邮箱校验规则
            var regEmail = /^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
//            var regEmail = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;

            if(!regEmail.test(email))
            {
                show_validat_msg("#email_add_input","error","邮箱错误");
                emailFlag == 0;
                return;
            }else
            {
//                $("#email_add_input").parent().addClass("has-error");
                show_validat_msg("#email_add_input","success","");
                emailFlag == 1;
            }
        };

        // 显示校验的提示信息
        function show_validat_msg(ele,status,msg){
            $(ele).parent().removeClass("has-success has-error");
            if("success" == status){
                $(ele).parent().addClass("has-success");
                $(ele).next("span").text(msg);
            }else if("error" == status){
                $(ele).parent().addClass("has-error");
                $(ele).next("span").text(msg);
            }
        }

        // 保存
        $("#empSave").click(function (){
            //  1,将填入的数据提交给数据库
            // 1.1 先对提交给服务器的数据进行校验
//            if(!validate_add_form()){
//                return false;
//            }
            validate_add_form();
            if(!enameFlag || !emailFlag){
                return ;
            }
            // 再次判断如果用户名有重复，就不发送请求
            if($(this).attr("ajax_va") == "error"){
                return false;
            };
            // 2.发送ajax 请求保存员工
            console.log($("#empAddModal form").serialize());
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/emp",
                data:$("#empAddModal form").serialize(),
                success:function (result){
                   alert(result.msg);
                   if(result.code == 100){
                       // 手动关闭模态框
                       $("#empAddModal").modal("hide");
                       //2 ,来到最后一页，显示刚才保存的数据，发送ajax请求
                        getData(totalRecord);

                   }else {
                       // 显示失败的信息
                       console.log(result);
                       if(undefined!=result.extend.errorFields.email){
                           // 显示邮箱错误信息
                           show_validat_msg("#email_add_input","error",result.extend.errorFields.email);

                       }else if(undefined !=result.extend.errorFields.empName){
                           // 显示员工名字的错误信息
                           show_validat_msg("#empName_input","error",result.extend.errorFields.email);

                       }
                   }

                },
                error:function (error){
                    console.log(error);
                }
            })

        });

        //  校验用户名是否重复
        $("#empName_input").on("change",function (){
            //  发送ajax 请求，校验用户名是否可用
            var name =$(this).val();
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/checkuser",
                data:"empName=" + name,
                success:function(result){
                    if(result.code == 100){
                        show_validat_msg("#empName_input","success","用户名可用");
                        $("#empSave").attr("ajax_va","success");
                    }else {
                        show_validat_msg("#empName_input","error","用户名不可用");
                         $("#empSave").attr("ajax_va","error");
                    }
                    console.log(result);
                },
                error:function (error){
                    console.log(error);
                }
            })

        })
    })
</script>
</body>
</html>
