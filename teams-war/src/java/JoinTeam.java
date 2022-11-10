import beans.ProfileFacade;
import beans.TeamFacade;
import entity.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/JoinTeam"})
public class JoinTeam extends HttpServlet {
    @EJB
    private ProfileFacade profileFacade;
    @EJB
    private TeamFacade teamFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        if(request.getSession().getAttribute("profile") != null){
            RequestDispatcher d=request.getRequestDispatcher("/jointeam.jsp");
            d.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name=request.getParameter("name");
        String code=request.getParameter("code");
        System.out.println(name);
        System.out.println(code);
        if(request.getSession().getAttribute("profile") != null){
            if(name.equals("") || code.equals("")){
            javaBeans.ErrorBean eb=new javaBeans.ErrorBean();
            eb.setError(true);
            eb.setErrormsg("all feilds are required");
            request.setAttribute("error", eb);
            RequestDispatcher d=request.getRequestDispatcher("/jointeam.jsp");
            d.forward(request, response);
        }else{
            Team t=teamFacade.find(code);
            if(t != null && name.equals(t.getName())){
                Collection members=t.getProfileCollection();
                javaBeans.Profile p=(javaBeans.Profile) request.getSession().getAttribute("profile");
                entity.Profile cuser=profileFacade.find(p.getId());
                members.add(cuser);
                t.setProfileCollection(members);
                teamFacade.edit(t);
                javaBeans.ErrorBean eb=new javaBeans.ErrorBean();
                eb.setError(true);
                eb.setErrormsg("joined team");
                request.setAttribute("error", eb);
                RequestDispatcher d=request.getRequestDispatcher("/jointeam.jsp");
                d.forward(request, response);
            }else{
                javaBeans.ErrorBean eb=new javaBeans.ErrorBean();
                eb.setError(true);
                eb.setErrormsg("incorrect input");
                request.setAttribute("error", eb);
                RequestDispatcher d=request.getRequestDispatcher("/jointeam.jsp");
                d.forward(request, response);
            }
        }
        }else{
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
}
