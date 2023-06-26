package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
// /hello가 오면 서블릿 실행
public class HelloServlet extends HttpServlet {
    //서블릿은 httpservlet을 상속 받아야함

    // ctrl + O 메소드 불러오기
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); //soutm
        System.out.println("request = " + request); //구현체들
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);
        //?username=choi는 쿼리 파라미터


        //응답메시지에 데이터가 담겨 나감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //헤더 정보에 들어감
        response.getWriter().write("hello " + username); //http 메시지 바디에 데이터가 들어감
    } // 서블릿이 호출되면 service 메소드 호출

}
