<%--
  Created by IntelliJ IDEA
  User: seung
  Date: 2023/07/24
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response 사용 가능
    //jsp도 결국 서블릿으로 바뀌기 때문에 htㄴtp request, response 사용가능

    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("save-result.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <!--꺽새+퍼센트 부분은 java 코드이며 나머지 부분은 http response에 담김-->
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>
