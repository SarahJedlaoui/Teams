package util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request {
    public static void forward(HttpServletRequest request,HttpServletResponse response,String url) throws ServletException, IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
