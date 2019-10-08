package runescapecompanion;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rsapi.Item;
import rsapi.Result;
import rsapi.SearchEngine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App {
    private JPanel bgPanel;
    private JButton grandExchangeButton;
    private JButton bestiaryButton;
    private JTextArea searchItemTextArea;
    private JButton searchButton;
    private JComboBox searchItemCategoryComboBox;
    private JList list1;
    private JTable table1;
    private SearchEngine searchEngine = new SearchEngine();

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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Result result = searchEngine.searchItem(searchItemTextArea.getText(), Integer.toString(searchItemCategoryComboBox.getSelectedIndex()));
                    String[] strings = result.toStringArray();
                    list1.setListData(result.toStringArray());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("app");
        frame.setContentPane(new App().bgPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800,350);
    }
}
