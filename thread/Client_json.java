import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import org.json.simple.JSONValue;
/**
 * Created by ZAHRA on 31/05/2017.
 */
public  class Client {
    JSONArray array;
    public  Client(JSONArray a){
       array =a;
        getJson(array);
    }

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scan = new Scanner(System.in);
        String ip = "127.0.0.1";
        try {
            socket = new Socket(ip, 255);
        } catch (IOException e) {
            e.printStackTrace();
        }




            }
            public static void getJson(JSONArray objA){
              //  System.out.println("hi");
               JSONObject obj = new JSONObject();
                for (int i=0 ; i<objA.size();i++){
                    System.out.println(objA.get(i));

                }
            }}
