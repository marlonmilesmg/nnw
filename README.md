# Highest Common Factor Calculator

This project is a Maven application that provides an implementation for calculating the highest common factor (HCF) of an array of integers.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed on your machine.
3. Navigate to the project directory.


## Usage

To use the HighestCommonFactor class, simply create an instance of the class and call the highestCommonFactor method, passing the array of numbers as an argument.

# Address Printer

This Java project, AddressPrinter, is designed to process and format address data stored in JSON format. It provides functionalities to read address data from a file, format addresses for printing, filter and print addresses based on their types, and validate addresses for correctness.

## Usage
1. Reading JSON DataThe method readJsonDataFromFile() reads JSON data from a file located at the specified path (C:/Users/CC Sunninghill/IdeaProjects/nnw/src/main/resources/json/addresses.json) and returns it as a JSONArray.
2. Formatting AddressesThe method prettyPrintAddress(Address address) takes an Address object and generates a formatted string representation of the address.
3. Printing Addresses by TypeThe method printAddressesByType(String json, String addressType) accepts a JSON string containing addresses and a specific address type. It filters addresses of the given type and prints them.
4. Validating AddressesThe method validateAddress(Address address) checks the validity of a provided address. It verifies the postal code format, presence of country, city or town, at least one address line, and for South African addresses, the presence of province or state.

## How to Use
To use this project:

1. Ensure that the JSON file containing address data is located at the specified path.
2. Compile and run the AddressPrinter class.
3. The program will read the address data, print formatted addresses, filter and print addresses by type, and validate each address.

## Dependencies
This project relies on the following libraries:

- io.micrometer.common.util.StringUtils for string manipulation.
- org.json for JSON parsing.

## Note
Ensure that the JSON file path is correctly specified in the readJsonDataFromFile() method to read the address data successfully.

# Project Tests
Ensure that you update your tests if you make any changes in your code implementation and run them successfully with maven test
```maven test
mvn test

