<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023/08/04
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save]
    만약 /save로 썼다면 "http://localhost:8080/save로 URL이 찍힘
     슬래시를 제외하고 썼다면 상대경로-->
    <form action="save" method="post">
        username: <input type="text" name="username"/>
        age: <input type="text" name="age"/>
        <button type="submit">전송</button>
    </form>
</head>
</body>
</html>
<!-- WEB-INF는 외부에서 이 경로로 호출 못함
꼭 컨트롤러를 거쳐서 호출할 수 있음 -->