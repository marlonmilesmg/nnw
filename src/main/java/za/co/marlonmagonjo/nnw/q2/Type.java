package za.co.marlonmagonjo.nnw.q2;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private String code;
    private String name;

    public Type(JSONObject json) {
        this.code = json.getString("code");
        this.name = json.getString("name");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
