package runescapecompanion;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rsapi.Result;
import rsapi.SearchEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App {
    private JPanel panel;
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;

    private void cena() throws IOException {
        String sURL = "http://services.runescape.com/m=itemdb_rs/api/catalogue/items.json?category=9&alpha=spirit%20ter&page=1"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        JsonObject rootobj2 = rootobj.getAsJsonObject();
        JsonArray items = rootobj2.getAsJsonArray("items");
        JsonElement firstItem = items.get(0);
        JsonObject name = firstItem.getAsJsonObject();
        String string = name.get("name").getAsString();
        System.out.println(string);


    }

    public App() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cena();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        SearchEngine searchEngine = new SearchEngine();
        Result result = searchEngine.searchItem("spirit",Integer.toString(9));
        System.out.println(result.toList().toString());



//        JFrame frame = new JFrame("app");
//        frame.setContentPane(new App().panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        System.out.println();
    }
}
