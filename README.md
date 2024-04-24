# Highest Common Factor Calculator

This project is a Spring Boot application that provides an API endpoint for calculating the highest common factor (HCF) of an array of integers.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed on your machine.
3. Navigate to the project directory.
4. Run `mvn spring-boot:run` to start the application.

## Usage

Once the application is running, you can use the provided API endpoint to calculate the HCF.

### API Endpoint http://localhost:3000/api/hcf

#### `POST /api/hcf`

Calculates the highest common factor (HCF) of an array of integers provided in the request body.

##### Request Body

```json
{
  "numbers": [integer1, integer2, ...]
}

numbers: An array of integers for which the HCF needs to be calculated.

### Response

200 OK: Returns the calculated HCF if successful.
400 Bad Request: Returns an error message if the request body is empty, the numbers array is null or empty, or if an invalid input is provided.

### Dependencies

This project depends on the following libraries:

Spring Boot
Lombok
SLF4J
These dependencies are managed using Maven.

# Address Printer

This Java project, AddressPrinter, is designed to process and format address data stored in JSON format. It provides functionalities to read address data from a file, format addresses for printing, filter and print addresses based on their types, and validate addresses for correctness.

## Usage
Reading JSON DataThe method readJsonDataFromFile() reads JSON data from a file located at the specified path (C:/Users/CC Sunninghill/IdeaProjects/nnw/src/main/resources/json/addresses.json) and returns it as a JSONArray.
Formatting AddressesThe method prettyPrintAddress(Address address) takes an Address object and generates a formatted string representation of the address.
Printing Addresses by TypeThe method printAddressesByType(String json, String addressType) accepts a JSON string containing addresses and a specific address type. It filters addresses of the given type and prints them.
Validating AddressesThe method validateAddress(Address address) checks the validity of a provided address. It verifies the postal code format, presence of country, city or town, at least one address line, and for South African addresses, the presence of province or state.

## How to Use
To use this project:

Ensure that the JSON file containing address data is located at the specified path.
Compile and run the AddressPrinter class.
The program will read the address data, print formatted addresses, filter and print addresses by type, and validate each address.

## Dependencies
This project relies on the following libraries:

io.micrometer.common.util.StringUtils for string manipulation.
org.json for JSON parsing.

## Note
Ensure that the JSON file path is correctly specified in the readJsonDataFromFile() method to read the address data successfully.
