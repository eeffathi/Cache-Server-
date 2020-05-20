<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eddy
  Date: 20/07/19
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.cycle.all.min.js" />"></script>
    <script src="<c:url value="/resources/js/mustache.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>

<script type="text/javascript">
    var p = ${jsonstring};
</script>

<body>

    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a id="prev_btn" class="page-link" href="#" tabindex="-1">قبلی</a>
            </li>
            <li class="page-item">
                <a id="next_btn" class="page-link" href="#">بعدی</a>
            </li>
        </ul>
    </nav>

    <div id="productbox" class="container">
        <div id="carousel1"></div>
    </div>

    <script id="productstpl" type="text/template">
        {{#products}}
        <div class="container-fluid">
            <img src="{{iconThumbNail}}" style="margin: 1px; alignment: center;" class="img-thumbnail" alt="Photo of {{title}}"/>

            <ul class="list-group">
                <li class="list-group-item">{{title}} <span style="float: right" class="badge">نام تایتل</span></li>
                <li class="list-group-item">{{appCategoryName}} <span style="float: right" class="badge">نام کتگوری برنامه</span></li>
                <li class="list-group-item">{{shortDescription}} <span style="float: right" class="badge">شرح برنامه</span></li>

                <li class="list-group-item">{{isDeleted}} <span style="float: right" class="badge">پاک شده</span></li>
                <li class="list-group-item">{{publishState}} <span style="float: right" class="badge">وضعیت انتشار</span></li>
                <li class="list-group-item">{{targetSDK}} <span style="float: right" class="badge">target SDK</span></li>
                <li class="list-group-item">{{minSDK}} <span style="float: right" class="badge">minimum SDK</span></li>
                <li class="list-group-item">{{fileSize}} <span style="float: right" class="badge">حجم فایل</span></li>
                <li class="list-group-item">{{osId}} <span style="float: right" class="badge">osID</span></li>
                <li class="list-group-item">{{averageRateIndex}} <span style="float: right" class="badge">شاخص متوسط</span></li>
                <li class="list-group-item">{{bulk}} <span style="float: right" class="badge">bulk</span></li>
                <li class="list-group-item">{{number_installs}} <span style="float: right" class="badge">تعداد نصب شده ها</span></li>
                <li class="list-group-item">{{downLoadLink}} <span style="float: right" class="badge"> لینک دانلود</span></li>
                <li class="list-group-item">{{osTypeId}} <span style="float: right" class="badge">os type ID</span></li>
                <li class="list-group-item">{{osTypeName}} <span style="float: right" class="badge">os type name</span></li>
                <li class="list-group-item">{{appCategoryID}} <span style="float: right" class="badge">app category ID</span></li>
                <li class="list-group-item">{{developer}} <span style="float: right" class="badge">نام توسعه دهنده</span></li>
                <li class="list-group-item">{{versionName}} <span style="float: right" class="badge"> نام ورژن</span></li>
                <li class="list-group-item">{{versionCode}} <span style="float: right" class="badge">کد ورژن</span></li>
                <li class="list-group-item">{{osName}} <span style="float: right" class="badge">os name</span></li>
                <li class="list-group-item">{{packageName}} <span style="float: right" class="badge">نام پکیج</span></li>
                <li class="list-group-item">{{keyword}} <span style="float: right" class="badge">keyword</span></li>
                <li class="list-group-item">{{icon}} <span style="float: right" class="badge"> لینک آیکون</span></li>
                <li class="list-group-item">{{id}} <span style="float: right" class="badge">id</span></li>

                <li class="list-group-item">
                    <span style="font-size: 1.02em" class="badge">permissionDetails</span>
                    <ul class="list-group">
                        {{#permissionDetails}}
                            <li class="list-group-item">
                                {{.}}
                            </li>
                        {{/permissionDetails}}
                    </ul>
                </li>

                <li class="list-group-item">
                    <span style="font-size: 1.02em" class="badge">lastModifyDate</span>
                    <ul class="list-group">
                        {{#lastModifyDate}}
                        <li class="list-group-item">{{dateTimeLong}} <span style="float: right" class="badge">dateTimeLong</span></li>
                        <li class="list-group-item">{{time}} <span style="float: right" class="badge">time</span></li>
                        <li class="list-group-item">
                            <span style="font-size: 1.02em" class="badge">dayDate</span>
                            <ul class="list-group">
                                {{#dayDate}}
                                <li class="list-group-item">{{year}} <span style="float: right" class="badge">year</span></li>
                                <li class="list-group-item">{{month}} <span style="float: right" class="badge">month</span></li>
                                <li class="list-group-item">{{date}} <span style="float: right" class="badge">date</span></li>
                                <li class="list-group-item">{{valid}} <span style="float: right" class="badge">valid</span></li>
                                <li class="list-group-item">{{day}} <span style="float: right" class="badge">day</span></li>
                                {{/dayDate}}
                            </ul>
                        </li>

                        <li class="list-group-item">
                            <span style="font-size: 1.02em" class="badge">dayTime</span>
                            <ul class="list-group">
                                {{#dayTime}}
                                <li class="list-group-item">{{dayTime}} <span style="float: right" class="badge">dayTime</span></li>
                                <li class="list-group-item">{{hour}} <span style="float: right" class="badge">hour</span></li>
                                <li class="list-group-item">{{minute}} <span style="float: right" class="badge">minute</span></li>
                                <li class="list-group-item">{{second}} <span style="float: right" class="badge">second</span></li>
                                {{/dayTime}}
                            </ul>
                        </li>
                        {{/lastModifyDate}}
                    </ul>
                </li>



                <li class="list-group-item">
                    <span style="font-size: 1.02em" class="badge">creationDateTime</span>
                    <ul class="list-group">
                        {{#creationDateTime}}
                        <li class="list-group-item">{{dateTimeLong}} <span style="float: right" class="badge">dateTimeLong</span></li>
                        <li class="list-group-item">{{time}} <span style="float: right" class="badge">time</span></li>
                        <li class="list-group-item">
                            <span style="font-size: 1.02em" class="badge">dayDate</span>
                            <ul class="list-group">
                                {{#dayDate}}
                                <li class="list-group-item">{{year}} <span style="float: right" class="badge">year</span></li>
                                <li class="list-group-item">{{month}} <span style="float: right" class="badge">month</span></li>
                                <li class="list-group-item">{{date}} <span style="float: right" class="badge">date</span></li>
                                <li class="list-group-item">{{valid}} <span style="float: right" class="badge">valid</span></li>
                                <li class="list-group-item">{{day}} <span style="float: right" class="badge">day</span></li>
                                {{/dayDate}}
                            </ul>
                        </li>

                        <li class="list-group-item">
                            <span style="font-size: 1.02em" class="badge">dayTime</span>
                            <ul class="list-group">
                                {{#dayTime}}
                                <li class="list-group-item">{{dayTime}} <span style="float: right" class="badge">dayTime</span></li>
                                <li class="list-group-item">{{hour}} <span style="float: right" class="badge">hour</span></li>
                                <li class="list-group-item">{{minute}} <span style="float: right" class="badge">minute</span></li>
                                <li class="list-group-item">{{second}} <span style="float: right" class="badge">second</span></li>
                                {{/dayTime}}
                            </ul>
                        </li>
                        {{/creationDateTime}}
                    </ul>
                </li>
            </ul>
        </div>
        {{/products}}
    </script>


    <script type="text/javascript">

        $(document).ready(function () {


            var template = $('#productstpl').html();
            var html = Mustache.to_html(template, p);
            $('#carousel1').html(html);

            $('#carousel1').cycle({
                fx: 'shuffle',
                pause: 1,
                next: '#next_btn',
                prev: '#prev_btn',
                speed: 500,
                timeout: 10000
            });

        }); //function

    </script>

</body>
</html>


<%--***************************************
******************************************************************************************************
******************************************************************************************************
*******************************************--%>

<%--<table border="1" style="width: 100%">--%>
<%--  <tr>--%>
<%--    <td>isDeleted</td>--%>
<%--    <td>publishState</td>--%>
<%--    <td>targetSDK</td>--%>
<%--    <td>minSDK</td>--%>
<%--    <td>deleted</td>--%>

<%--    <td>dateTimeLong OF LastModifyDate</td>--%>
<%--    <td>year OF LastModifyDate</td>--%>
<%--    <td>month OF LastModifyDate</td>--%>
<%--    <td>date OF LastModifyDate</td>--%>
<%--    <td>valid OF LastModifyDate</td>--%>
<%--    <td>day OF LastModifyDate</td>--%>
<%--    <td>dayTime OF LastModifyDate</td>--%>
<%--    <td>hour OF LastModifyDate</td>--%>
<%--    <td>minute OF LastModifyDate</td>--%>
<%--    <td>second OF LastModifyDate</td>--%>
<%--    <td>time OF LastModifyDate</td>--%>
<%--    &lt;%&ndash;<td>Null OF LastModifyDate</td>&ndash;%&gt;--%>

<%--    <td>fileSize</td>--%>
<%--    <td>osId</td>--%>
<%--    <td>averageRateIndex</td>--%>
<%--    <td>bulk</td>--%>
<%--    <td>number_installs</td>--%>
<%--    <td>downLoadLink</td>--%>
<%--    <td>iconThumbNail</td>--%>
<%--    <td>osTypeId</td>--%>
<%--    <td>osTypeName</td>--%>
<%--    <td>appCategoryName</td>--%>
<%--    <td>appCategoryID</td>--%>
<%--    <td>permissionDetails</td>--%>

<%--    <td>dateTimeLong OF creationDateTime</td>--%>
<%--    <td>year OF creationDateTime</td>--%>
<%--    <td>month OF creationDateTime</td>--%>
<%--    <td>date OF creationDateTime</td>--%>
<%--    <td>valid OF creationDateTime</td>--%>
<%--    <td>day OF creationDateTime</td>--%>
<%--    <td>dayTime OF creationDateTime</td>--%>
<%--    <td>hour OF creationDateTime</td>--%>
<%--    <td>minute OF creationDateTime</td>--%>
<%--    <td>second OF creationDateTime</td>--%>
<%--    <td>time OF creationDateTime</td>--%>
<%--    &lt;%&ndash;<td>Null OF creationDateTime</td>&ndash;%&gt;--%>

<%--    <td>title</td>--%>
<%--    <td>developer</td>--%>
<%--    <td>versionName</td>--%>
<%--    <td>versionCode</td>--%>
<%--    <td>osName</td>--%>
<%--    <td>packageName</td>--%>
<%--    <td>shortDescription</td>--%>
<%--    <td>keyword</td>--%>
<%--    <td>icon</td>--%>
<%--    <td>id</td>--%>
<%--  </tr>--%>

<%--  <c:forEach items="${requestScope.list}" var="p">--%>
<%--    <tr>--%>
<%--      <td>${p.isDeleted}</td>--%>
<%--      <td>${p.publishState}</td>--%>
<%--      <td>${p.targetSDK}</td>--%>
<%--      <td>${p.minSDK}</td>--%>
<%--      <td>${p.deleted}</td>--%>

<%--      <td>${p.lastModifyDate.dateTimeLong}</td>--%>
<%--      <td>${p.lastModifyDate.dayDate.year}</td>--%>
<%--      <td>${p.lastModifyDate.dayDate.month}</td>--%>
<%--      <td>${p.lastModifyDate.dayDate.date}</td>--%>
<%--      <td>${p.lastModifyDate.dayDate.valid}</td>--%>
<%--      <td>${p.lastModifyDate.dayDate.day}</td>--%>
<%--      <td>${p.lastModifyDate.dayTime.dayTime}</td>--%>
<%--      <td>${p.lastModifyDate.dayTime.hour}</td>--%>
<%--      <td>${p.lastModifyDate.dayTime.minute}</td>--%>
<%--      <td>${p.lastModifyDate.dayTime.second}</td>--%>
<%--      <td>${p.lastModifyDate.time}</td>--%>
<%--        &lt;%&ndash;<td>${p.lastModifyDate.Null}</td>&ndash;%&gt;--%>

<%--      <td>${p.fileSize}</td>--%>
<%--      <td>${p.osId}</td>--%>
<%--      <td>${p.averageRateIndex}</td>--%>
<%--      <td>${p.bulk}</td>--%>
<%--      <td>${p.number_installs}</td>--%>
<%--      <td>${p.downLoadLink}</td>--%>
<%--      <td>${p.iconThumbNail}</td>--%>
<%--      <td>${p.osTypeId}</td>--%>
<%--      <td>${p.osTypeName}</td>--%>
<%--      <td>${p.appCategoryName}</td>--%>
<%--      <td>${p.appCategoryID}</td>--%>
<%--      <td>${p.permissionDetails}</td>--%>

<%--      <td>${p.creationDateTime.dateTimeLong}</td>--%>
<%--      <td>${p.creationDateTime.dayDate.year}</td>--%>
<%--      <td>${p.creationDateTime.dayDate.month}</td>--%>
<%--      <td>${p.creationDateTime.dayDate.date}</td>--%>
<%--      <td>${p.creationDateTime.dayDate.valid}</td>--%>
<%--      <td>${p.creationDateTime.dayDate.day}</td>--%>
<%--      <td>${p.creationDateTime.dayTime.dayTime}</td>--%>
<%--      <td>${p.creationDateTime.dayTime.hour}</td>--%>
<%--      <td>${p.creationDateTime.dayTime.minute}</td>--%>
<%--      <td>${p.creationDateTime.dayTime.second}</td>--%>
<%--      <td>${p.creationDateTime.time}</td>--%>
<%--        &lt;%&ndash;<td>${p.creationDateTime.Null}</td>&ndash;%&gt;--%>

<%--      <td>${p.title}</td>--%>
<%--      <td>${p.developer}</td>--%>
<%--      <td>${p.versionName}</td>--%>
<%--      <td>${p.versionCode}</td>--%>
<%--      <td>${p.osName}</td>--%>
<%--      <td>${p.packageName}</td>--%>
<%--      <td>${p.shortDescription}</td>--%>
<%--      <td>${p.keyword}</td>--%>
<%--      <td>${p.icon}</td>--%>
<%--      <td>${p.id}</td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--</table>--%>
