package rsapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Item {
    @JsonProperty("icon")
    String icon;

    @JsonProperty("icon_large")
    String icon_large;

    @JsonProperty("id")
    int id;

    @JsonProperty("type")
    String type;

    @JsonProperty("typeIcon")
    String typeIcon;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("current")
    List<Current> current;

    @JsonProperty("today")
    List<Today> today;

    @JsonProperty("trend")
    String trend;

    @JsonProperty("price")
    String price;

    @JsonProperty("members")
    boolean members;
}
