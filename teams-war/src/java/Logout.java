import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session !=null){
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }else{
            PrintWriter out=response.getWriter();
            out.print("Error, you are already loged out");
        }
    }

}
