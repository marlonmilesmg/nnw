package za.co.marlonmagonjo.nnw.q2;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressLineDetail {
    private String line1;
    private String line2;

    public AddressLineDetail(JSONObject json) {
        this.line1 = json.getString("line1");
        this.line2 = json.getString("line2");
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }
}
