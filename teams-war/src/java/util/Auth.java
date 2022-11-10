package util;
import javaBeans.Profile;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Auth {
    public static void ifauthforward(HttpServletRequest request, HttpServletResponse response,String forwardlocation){
        try{
            Profile userProfile = (Profile) request.getSession().getAttribute("profile");
            if(userProfile != null){
                System.out.println("auth");
                RequestDispatcher dispatcher=request.getRequestDispatcher(forwardlocation);
                dispatcher.forward(request, response);
            }
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    public static void ifnotauthforward(HttpServletRequest request, HttpServletResponse response,String forwardlocation){
        try{
            
            Profile userProfile=(Profile) request.getSession().getAttribute("profile");
            if(userProfile == null){
                System.out.println("not auth");
                RequestDispatcher dispatcher=request.getRequestDispatcher(forwardlocation);
                dispatcher.forward(request, response);//replace forward with redirect
            }
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
