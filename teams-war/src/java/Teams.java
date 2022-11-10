import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Teams"})
public class Teams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile") != null){
            
            
            RequestDispatcher d=request.getRequestDispatcher("teams.jsp");
            d.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
}
