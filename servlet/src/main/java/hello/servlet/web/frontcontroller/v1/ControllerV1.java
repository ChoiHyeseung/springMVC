package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public interface ControllerV1 {

    // 서블릿과 모양이 똑같음. 각 컨트롤러들은 이 인터페이스에 구현하고 프론트 컨트롤러는 이 인터페이스를 호출
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
