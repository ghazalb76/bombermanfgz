import jdk.nashorn.internal.runtime.ParserException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * Created by mohammadrezamousavi on 5/27/17.
 */
public class Client implements Runnable {
    InputStream is;
    Thread t;
    Socket socket = null;
    boolean flag=true;
    Receive receive;
    Send send;
    Graphic gui;
    public Client(Graphic gui) {
        this.gui=gui;
        try {
            socket=new Socket("localhost",8081);
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        send=new Send(gui,socket);
        receive=new Receive(is,socket);
        t = new Thread(this);
        t.start();
        send.send();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        while(true) {
            receive.receive();
            gui.setChanges(receive.parse.numberOfPlayers,receive.parse.squares,receive.parse.numberOfPresentsInt,receive.parse.posPresent,receive.parse.presentTypes,receive.parse.numberOfPlayers,receive.parse.posPlayerint,receive.parse.healthPlayerInt,receive.parse.scoreString,receive.parse.time,receive.parse.direction,receive.parse.thebombInt_xy1,receive.parse.thebombInt_xy2);
            if(receive.parse.numberOfPlayers==3)
                gui.setOtherChanges(receive.parse.thebombInt_xy3);
            else if(receive.parse.numberOfPlayers==4)
                gui.setNewChanges(receive.parse.thebombInt_xy3,receive.parse.thebombInt_xy4);
            do{
                gui.draaw(gui);
                flag=false;
            }while (flag);
            gui.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}