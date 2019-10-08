package rsapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SearchEngine {
    ObjectMapper mapper = new ObjectMapper();
    Map<Integer, String> categoryLookupTable = new HashMap<>();

    public SearchEngine() {
        categoryLookupTable.put(0, "Miscellaneous");
        categoryLookupTable.put(9, "Familiars");
    }

    public Result searchItem(String name, String category) throws IOException {
        String url = "http://services.runescape.com/m=itemdb_rs/api/catalogue/items.json?category="+category+"&alpha="+name+"&page=1";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Map<String,Object> map = mapper.readValue(new URL(url), Map.class);
        Result result = mapper.convertValue(map, Result.class);
        return result;
    }
}
