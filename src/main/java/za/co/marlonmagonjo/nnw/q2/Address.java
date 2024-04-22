package za.co.marlonmagonjo.nnw.q2;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String id;
    private Type type;
    private AddressLineDetail addressLineDetail;
    private ProvinceOrState provinceOrState;
    private String cityOrTown;
    private Country country;
    private String postalCode;
    private String lastUpdated;

    public Address(JSONObject json) {
        this.id = json.getString("id");
        JSONObject typeJson = json.getJSONObject("type");
        this.type = new Type(typeJson);
        if (json.has("addressLineDetail")) {
            JSONObject addressLineDetailJson = json.getJSONObject("addressLineDetail");
            this.addressLineDetail = new AddressLineDetail(addressLineDetailJson);
        }
        if (json.has("provinceOrState")) {
            JSONObject provinceOrStateJson = json.getJSONObject("provinceOrState");
            this.provinceOrState = new ProvinceOrState(provinceOrStateJson);
        }
        this.cityOrTown = json.getString("cityOrTown");
        JSONObject countryJson = json.getJSONObject("country");
        this.country = new Country(countryJson);
        this.postalCode = json.getString("postalCode");
        this.lastUpdated = json.getString("lastUpdated");
    }

    public Address(Type type, AddressLineDetail addressLineDetail, String cityOrTown, ProvinceOrState provinceOrState, Country country, String postalCode) {
    }


    public Type getType() {
        return type;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public ProvinceOrState getProvinceOrState() {
        return provinceOrState;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public Country getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
