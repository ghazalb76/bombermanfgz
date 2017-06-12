/**
 * Created by dude on 6/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        Json json=new Json();
        JsonParse jsonParse=new JsonParse();
        json.make_block();
        json.parse();
     //   json.info();
        jsonParse.parsee();
        json.info();
        jsonParse.info_parse();
        GUI gui=new GUI(jsonParse.squares);
        gui.draaw(gui);
    }
}
