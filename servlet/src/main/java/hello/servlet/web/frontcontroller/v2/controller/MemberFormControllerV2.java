package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        MyView에 적었으므로 생성자를 사용하면됨, 중복된 코드 제거
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 이 경로로 이동할 것
        dispatcher.forward(request, response);
        */

        /*
        한 줄로 합치기 : ⌘ + ⌥ + N
        MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
        return myView;
         */
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
