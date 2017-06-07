import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.simple.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import org.json.simple.JSONValue;

public class Server {
    public static void main(String[] args) {

    ServerSocket serverSocket = null;
    Socket socket = new Socket();

        try {
        serverSocket = new ServerSocket(255);
    } catch (IOException ex) { System.out.println("Can't setup server on this port number. "); }
        try {
        System.out.println("connecting");
        socket = serverSocket.accept();
        System.out.println("connected");}
        catch (IOException ex) { System.out.println("Can't accept client connection. "); }

        makeJson();

}
public  static void makeJson(){
    String name = "zahra",age="19";
    String name2="ghazale",age2="19";
    JSONObject obj=new JSONObject();

    obj.put("name",name);
    obj.put("age",age);
    JSONArray objA= new JSONArray();
    objA.add(obj);
    obj=new JSONObject();
    obj.put("name",name2);
    obj.put("age",age2);
    Client client= new Client(objA);
    client.getJson(objA);


}}
