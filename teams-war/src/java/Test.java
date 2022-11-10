import beans.ProfileFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Test"})
public class Test extends HttpServlet {
    @EJB
    private ProfileFacade profileFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            entity.Profile p=profileFacade.findbyemail("hhhhhhhh");
            System.out.println(p != null);
    }

}
