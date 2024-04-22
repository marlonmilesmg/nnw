package za.co.marlonmagonjo.nnw.q2;
import io.micrometer.common.util.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;


public class AddressPrinter {

    public static void main(String[] args) {
        JSONArray jsonArray = readJsonDataFromFile();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject addressJson = jsonArray.getJSONObject(i);
            Address address = new Address(addressJson);
            System.out.println(prettyPrintAddress(address));
        }

        System.out.println();
        System.out.println("=============>>>>>>>  Now Printing Address of a Certain Type ====================>>>>>>>>");
        printAddressesByType(jsonArray.toString(), "Business Address");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject addressJson = jsonArray.getJSONObject(i);
            Address address = new Address(addressJson);
            System.out.println();
            System.out.println("=============>>>>>>>  Now Validating Address ====================>>>>>>>>");
            String validationMessage = validateAddress(address);
            System.out.println(validationMessage);
        }
    }

    /**
     * Reads JSON data from a file and returns it as a JSONArray.
     *
     * @return The JSONArray containing the JSON data read from the file.
     * @throws JSONException if there is an error in parsing the JSON data.
     */
    public static JSONArray readJsonDataFromFile() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("C:/Users/CC Sunninghill/IdeaProjects/nnw/src/main/resources/json/addresses.json")));
            return new JSONArray(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Generates a formatted string representation of an address.
     *
     * @param address The Address object to be formatted.
     * @return A String containing the formatted address information.
     */
    public static String prettyPrintAddress(Address address) {
        StringBuilder builder = new StringBuilder();
        if(address.getType() != null) {
            builder.append("Type: ")
                   .append(address.getType().getName())
                   .append(": ");
        }
        if (address.getAddressLineDetail() != null) {
            builder.append(address.getAddressLineDetail().getLine1())
                   .append(" - ");
            if (address.getAddressLineDetail().getLine2() != null && !address.getAddressLineDetail().getLine2().isEmpty()) {
                builder.append(address.getAddressLineDetail().getLine2())
                       .append(" - ");
            }
        }
        builder.append(address.getCityOrTown())
               .append(" - ");
        if (address.getProvinceOrState() != null) {
            builder.append(address.getProvinceOrState().getName())
                   .append(" - ");
        }
        builder.append(address.getPostalCode())
               .append(" - ");
        if(address.getCountry() != null) {
            builder.append(address.getCountry().getName());
        }
        return builder.toString();
    }


    /**
     * Prints addresses of a specific type from a JSON string.
     *
     * @param json The JSON string containing addresses.
     * @param addressType The type of address to filter and print.
     */
    public static void printAddressesByType(String json, String addressType) {
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject addressJson = jsonArray.getJSONObject(i);
            Address address = new Address(addressJson);
            if (address.getType().getName().equals(addressType)) {
                System.out.println(prettyPrintAddress(address));
            }
        }
    }

    /**
     * Validates the provided address.
     *
     * @param address The address to be validated.
     * @return A String indicating the validation result:
     *         - "Address is valid." if the address passes validation.
     *         - A specific error message if the address fails validation.
     */
    public static String validateAddress(Address address) {
        if (!Pattern.matches("[A-Za-z0-9]+", address.getPostalCode())) {
            return "Address is invalid. Invalid postal code.";
        }

        if (StringUtils.isBlank(address.getCountry().getName())) {
            return "Address is invalid. Country is missing or empty.";
        }

        if (StringUtils.isBlank(address.getCityOrTown())) {
            return "Address is invalid. City or town is missing.";
        }

        if (address.getAddressLineDetail() == null ||
                (StringUtils.isBlank(address.getAddressLineDetail().getLine1()) &&
                        StringUtils.isBlank(address.getAddressLineDetail().getLine2()))) {
            return "Address is invalid. At least one address line must be provided.";
        }

        if (address.getCountry().getName().equals("South Africa")) {
            if (address.getProvinceOrState() == null || StringUtils.isBlank(address.getProvinceOrState().getName())) {
                return "Address is invalid. Province or state is missing for South Africa.";
            }
        }

        return "Address is valid.";
    }

}
