import beans.ProfileFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/UpdatePassword"})
public class UpdatePassword extends HttpServlet {
    @EJB
    private ProfileFacade profileFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        javaBeans.Profile userprofile=(javaBeans.Profile)request.getSession().getAttribute("profile");
        if(userprofile != null){
          entity.Profile user=profileFacade.find(userprofile.getId());
          if(user.getPassword().equals(request.getParameter("old"))){
              user.setPassword(request.getParameter("new"));
              profileFacade.edit(user);
              response.sendRedirect(request.getContextPath() + "/Profile");
          }else{
              PrintWriter out=response.getWriter();
              out.print("not auth");
          }
        }else{
            PrintWriter out=response.getWriter();
            out.print("not auth");
        }
    }
}
