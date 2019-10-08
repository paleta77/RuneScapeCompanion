package rsapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Today {
    @JsonProperty("trend")
    String trend;

    @JsonProperty("price")
    String price;

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
