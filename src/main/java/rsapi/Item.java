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

    public String getIcon() {
        return icon;
    }

    public String getIcon_large() {
        return icon_large;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Current> getCurrent() {
        return current;
    }

    public List<Today> getToday() {
        return today;
    }

    public String getTrend() {
        return trend;
    }

    public String getPrice() {
        return current.get(0).getPrice();
    }

    public boolean isMembers() {
        return members;
    }
}
