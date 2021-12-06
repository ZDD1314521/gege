package edu.soft2.print;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Ink {
    @Value("彩色")
    public void setType(String type) {
        this.type = type;
    }

    String type;
}
