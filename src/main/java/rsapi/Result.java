package rsapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Result {
    @JsonProperty("total")
    int total;

    @JsonProperty("items")
    List<Item> items;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Item item: items){
            stringBuilder.append(item.name+"\n");
        }
        return stringBuilder.toString();
    }

    public List<String> toList(){
        ArrayList<String> list = new ArrayList<String>();
        for(Item item: items){
            list.add(item.name);
        }
        return list;
    }
}
