import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName OrderServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/5/10 17:38
 * @Version 2020.1
 **/
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //身份校验
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.sendRedirect(req.getContextPath()+"/main.html");
        }else {
            PrintWriter pw = resp.getWriter();
            pw.println("<h2>已经登陆，可以访问订单</h2>");
            pw.flush();
        }
    }
}
