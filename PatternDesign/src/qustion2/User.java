package qustion2;

import lombok.Data;

@Data
public class User {
    private String name;
    private String formatImage;

    public User(String name, String formatImage) {
        this.name = name;
        this.formatImage = formatImage;
    }
}
