package za.co.marlonmagonjo.nnw;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import za.co.marlonmagonjo.nnw.q2.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static za.co.marlonmagonjo.nnw.q2.AddressPrinter.printAddressesByType;

public class AddressPrinterTests {

    @Test
    public void test_readJsonDataFromFile_validJsonArray() {
        JSONArray jsonArray = AddressPrinter.readJsonDataFromFile();
        assertNotNull(jsonArray);
        assertTrue(jsonArray instanceof JSONArray);
    }

    @Test
    public void test_valid_address() {
        Address address = new Address();
        address.setType(new Type("1", "Physical Address"));
        address.setAddressLineDetail(new AddressLineDetail("123 Main St", "Apt 4B"));
        address.setCityOrTown("Cape Town");
        address.setProvinceOrState(new ProvinceOrState("CPT", "Western Cape"));
        address.setPostalCode("10001");
        address.setCountry(new Country("ZA", "South Africa"));

        String expected = "Type: Physical Address: 123 Main St - Apt 4B - Cape Town - Western Cape - 10001 - South Africa";
        String actual = AddressPrinter.prettyPrintAddress(address);

        assertEquals(expected, actual);
    }

    @Test
    public void test_printAddressesByType_validJsonAndValidType() {

        String json = "[{\"id\":\"1\",\"type\":{\"code\":\"1\",\"name\":\"Business Address\"},\"addressLineDetail\":{\"line1\":\"123 Main St\",\"line2\":\"Apt 4B\"},\"provinceOrState\":{\"code\":\"1\",\"name\":\"Limpopo\"},\"cityOrTown\":\"Polokwane\",\"country\":{\"code\":\"1\",\"name\":\"South Africa\"},\"postalCode\":\"12345\",\"lastUpdated\":\"2021-01-01\"},{\"id\":\"2\",\"type\":{\"code\":\"2\",\"name\":\"Home Address\"},\"addressLineDetail\":{\"line1\":\"456 Elm St\",\"line2\":\"\"},\"provinceOrState\":{\"code\":\"2\",\"name\":\"Limpopo\"},\"cityOrTown\":\"Polokwane\",\"country\":{\"code\":\"1\",\"name\":\"South Africa\"},\"postalCode\":\"67890\",\"lastUpdated\":\"2021-01-02\"}]";
        String addressType = "Business Address";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        printAddressesByType(json, addressType);

        String expectedOutput = "Type: Business Address: 123 Main St - Apt 4B - Polokwane - Limpopo - 12345 - South Africa";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void test_printAddressesByType_invalidJson() {

        String json = "[{\"id\":\"1\",\"type\":{\"code\":\"1\",\"name\":\"Business Address\"},\"addressLineDetail\":{\"line1\":\"123 Main St\",\"line2\":\"Apt 4B\"},\"provinceOrState\":{\"code\":\"1\",\"name\":\"Durban\"},\"cityOrTown\":\"Kwazulu Natal\",\"country\":{\"code\":\"1\",\"name\":\"South Africa\"},\"postalCode\":\"12345\",\"lastUpdated\":\"2021-01-01\"},{\"id\":\"2\",\"type\":{\"code\":\"2\",\"name\":\"Home Address\"},\"addressLineDetail\":{\"line1\":\"456 Elm St\",\"line2\":\"\"},\"provinceOrState\":{\"code\":\"2\",\"name\":\"Polokwane\"},\"cityOrTown\":\"Polokwane\",\"country\":{\"code\":\"1\",\"name\":\"South Africa\"},\"postalCode\":\"67890\",\"lastUpdated\":\"2021-01-02\"}]";
        String addressType = "Invalid Address Type";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        printAddressesByType(json, addressType);

        String expectedOutput = "";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
