package util;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.ServletException; 
import javax.servlet.http.Part;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Utils {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomString(int count){
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
             int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
    return builder.toString();
    }
    
    
    
    public static String saveimage(Part filepart) throws MalformedURLException, IOException, ServletException{
        String url="https://image-hosting-api.herokuapp.com/addimage";
        if(filepart == null){
            return "https://image-hosting-api.herokuapp.com/getimage?id=61a263bbd107bd8d7aceb096";
        }
        try{
            filepart.write("tmp.jpg");
            MediaType mediatype=MediaType.parse("image/jpg");
            File file=new File("C:\\Users\\amine\\AppData\\Roaming\\NetBeans\\8.0.2\\config\\GF_4.1\\domain1\\generated\\jsp\\teams\\teams-war_war\\tmp.jpg");
            RequestBody req = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("image","pic.jpg", RequestBody.create(mediatype,file)).build();
             okhttp3.Request request = new okhttp3.Request.Builder().url(url).post(req).build();
             OkHttpClient client = new OkHttpClient();
             Response response = client.newCall(request).execute();
             return "https://image-hosting-api.herokuapp.com/getimage?id=" +  response.body().string();
        }catch(Exception e){
            return null;
        }
    }
    
    
}
