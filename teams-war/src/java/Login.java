import beans.ProfileFacade;
import entity.Profile;
import java.io.IOException;
import javaBeans.ErrorBean;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @EJB
    private ProfileFacade profileFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile") != null){
            response.sendRedirect(request.getContextPath() + "/Profile");
        }else{
            RequestDispatcher d=request.getRequestDispatcher("/login.jsp");
            d.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
                Profile userProfile=profileFacade.login(request.getParameter("username"),request.getParameter("password"));
                if(userProfile != null){
                    HttpSession session= request.getSession();
                    javaBeans.Profile p=new javaBeans.Profile();
                    p.setEmail(userProfile.getEmail());
                    p.setFname(userProfile.getFname());
                    p.setLname(userProfile.getLname());
                    p.setImage(userProfile.getImage());
                    p.setId(userProfile.getId());
                    session.setAttribute("profile",p);
                    response.sendRedirect(request.getContextPath() + "/Profile");
                }else{
                    ErrorBean eb=new ErrorBean();
                    eb.setErrormsg("invalid username or password");
                    eb.setError(true);
                    request.setAttribute("result",eb);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
                
            }catch(Exception e){
                RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
    }
}