import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author 张洋
 * @Date 2020/5/10 16:32
 * @Version 2020.1
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码及响应编码,响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //假如请求数据为username=xxx&password=xxx
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("servletpath:"+req.getServletPath()+",contextpath:"+req.getContextPath());
        System.out.printf("username=%s,password=%s\n",username,password);
        //PrintWriter pw = resp.getWriter();
        if ("abc".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
            //pw.println("<p>登录成功</p>");
            HttpSession session = req.getSession();
            session.setAttribute("user","username="+username);
            resp.sendRedirect(req.getContextPath()+"/main.html");
            //resp.sendRedirect("https://www.baidu.com");

        }else {
            //pw.println("<p>用户名或密码错误，登录失败</p>");
            req.getRequestDispatcher("/errors.html").forward(req,resp);
        }
        //pw.flush();
    }

}
