import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ZAHRA on 11/06/2017.
 */
public class Read {
    public static void main(String[] args) {
        JSONParser parser= new JSONParser();
        try{
            Object obj =parser.parse(new FileReader("C:\\Users\\ZAHRA\\Desktop\\info.txt"));
            JSONObject jsonObject= (JSONObject)obj;
            String x1=(String) jsonObject.get("x1");
            System.out.println("x1 is"+ x1);
            String x2=(String) jsonObject.get("x2");
            System.out.println("x2 is"+ x2);
            String height=(String)jsonObject.get("height");
            System.out.println("height is"+ height);
            String width=(String) jsonObject.get("width");
            System.out.println("width is"+ width);
            int x = Integer.parseInt(x1);
            System.out.println(x);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ParserException e ){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
