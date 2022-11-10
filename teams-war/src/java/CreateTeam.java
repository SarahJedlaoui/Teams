import beans.ProfileFacade;
import beans.TeamFacade;
import entity.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javaBeans.ErrorBean;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import util.Auth;
import util.Utils;
@WebServlet(urlPatterns = {"/CreateTeam"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class CreateTeam extends HttpServlet {
    @EJB
    private TeamFacade teamFacade;
    @EJB
    private ProfileFacade profileFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile") ==null){
            response.sendRedirect(request.getContextPath() + "/Login");
        }
        Auth.ifauthforward(request, response,"/createteam.jsp");
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile")==null){
            response.sendRedirect(request.getContextPath() + "/Login");
        }else{
            String name=request.getParameter("name");
            String isprivate=request.getParameter("isprivate");
            if(name.equals("") || isprivate.equals("")){
                System.out.print("name==null or isprivate == null");
                ErrorBean eb=new ErrorBean();
                eb.setError(true);
                eb.setErrormsg("all the fields are required");
                System.out.print("1");
                request.setAttribute("error", eb);
                System.out.print("2");
                RequestDispatcher d=request.getRequestDispatcher("/createteam.jsp");
                d.forward(request, response);
                System.out.print("3");
            }else{
                System.out.print("4");
                boolean isprivatebool=false;
                if(isprivate.equals("on")){
                    isprivatebool=true;
                }
                String code=Utils.randomString(8);
                while(teamFacade.find(code) != null){
                    code=Utils.randomString(8);
                }
                Part image=request.getPart("image");
                String imagelink=util.Utils.saveimage(image);
                Team newteam=new Team();
                javaBeans.Profile adminprofile=(javaBeans.Profile) request.getSession().getAttribute("profile");
                entity.Profile admin=profileFacade.find(adminprofile.getId());
                Collection<entity.Profile>  c=new ArrayList<entity.Profile>();
                c.add(admin);
                newteam.setCode(code);
                newteam.setImage(imagelink);
                newteam.setIsprivate(isprivatebool);
                newteam.setName(name);
                newteam.setAdminid(admin);
                newteam.setProfileCollection(c);
                teamFacade.create(newteam);
                javaBeans.ErrorBean eb=new javaBeans.ErrorBean();
                eb.setError(true);
                eb.setErrormsg("team created");
                request.setAttribute("error", eb);
                RequestDispatcher d=request.getRequestDispatcher("/createteam.jsp");
                d.forward(request, response);
            }
        }
    }
}
