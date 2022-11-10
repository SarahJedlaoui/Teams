import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile")!=null){
            javaBeans.Profile user=(javaBeans.Profile) request.getSession().getAttribute("profile");
            System.out.println(user.getImage());
            RequestDispatcher d=request.getRequestDispatcher("/profile.jsp");
            d.forward(request, response);
        }
        if(request.getSession().getAttribute("profile")==null){
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }
}