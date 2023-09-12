 package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// *은 어떤 하위에 무엇이 들어와도 이 서블릿은 무조건 호출
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();
    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap); // ModelView 반환

        String viewName = mv.getViewName();// 논리이름 ex) new-form
        MyView view = viewResolver(viewName);// 논리이름을 물리경로로 변환 ex) new-form을 받아오면 /WEB-INF/views/new-form.jsp로 변환

        // 만든 모델을 같이 넘겨줘야함
        view.render(mv.getModel(),request,response);
    }

    // 메소드 생성 단축키 ⌥ + ⌘ + m
    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        //paramMap
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator() //Http 서블릿에 있는 모든 파라미터 이름 가져와서 그 이름으로 반복
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        // 돌면서 결과값인 request에서 받아온 모든 파라미터를 paramName에 대입하고 paramMap에 put
        return paramMap;
    }
}
