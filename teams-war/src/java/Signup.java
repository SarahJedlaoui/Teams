import beans.ProfileFacade;
import java.io.IOException;
import javaBeans.ErrorBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Profile;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import util.*;
@WebServlet(urlPatterns = {"/Signup"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 4, // 4 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Signup extends HttpServlet {
    @EJB 
    private ProfileFacade profileFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Auth.ifauthforward(request, response,"/profile.jsp");
        Auth.ifnotauthforward(request, response,"/signup.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String password=request.getParameter("password");
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        String passwordConf=request.getParameter("passwordConfirmation");
        if(password.equals("") || fname.equals("") || lname.equals("") || email.equals("") || passwordConf.equals("")){
            ErrorBean eb=new ErrorBean();
            eb.setError(true);
            eb.setErrormsg("fill all the fields");
            request.setAttribute("error", eb);
            Request.forward(request,response,"/signup.jsp");
        }else{
            Profile exists=profileFacade.findbyemail(email);
            if( exists!= null){
                ErrorBean eb=new ErrorBean();
                eb.setErrormsg("this email is already used");
                eb.setError(true);
                request.setAttribute("error", eb);
                RequestDispatcher d=request.getRequestDispatcher("/signup.jsp");
                d.forward(request, response);
            }else{
                if(password.equals(passwordConf)){
                    Profile userprofile=new Profile();
                    userprofile.setEmail(email);
                    userprofile.setFname(fname);
                    userprofile.setLname(lname);
                    userprofile.setPassword(password);
                    userprofile.setTeamCollection(null);
                    userprofile.setMsgCollection(null);
                    userprofile.setMsgCollection1(null);
                    userprofile.setTeamCollection1(null);
                    String userid=util.Utils.randomString(8);
                    System.out.println(userid);
                    while(profileFacade.find(userid) != null){
                        userid=util.Utils.randomString(8);
                    }
                    userprofile.setId(userid);
                
                
                    String imagelink=util.Utils.saveimage(request.getPart("image"));
                    userprofile.setImage(imagelink);
                    System.out.println(imagelink);
                    profileFacade.create(userprofile);
                    HttpSession session=request.getSession();
                    javaBeans.Profile p=new javaBeans.Profile();
                    p.setEmail(userprofile.getEmail());
                    p.setFname(userprofile.getFname());
                    p.setLname(userprofile.getLname());
                    p.setImage(userprofile.getImage());
                    p.setId(userprofile.getId());
                    session.setAttribute("profile",p);
                    response.sendRedirect(request.getContextPath()+ "/Profile");
                }else{
                    ErrorBean eb=new ErrorBean();
                    eb.setError(true);
                    eb.setErrormsg("check your password");
                    request.setAttribute("error", eb);
                    RequestDispatcher d=request.getRequestDispatcher("/signup.jsp");
                    d.forward(request, response);
                }
            }
        }
    }
}
