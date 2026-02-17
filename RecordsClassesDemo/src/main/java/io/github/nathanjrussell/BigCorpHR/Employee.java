package io.github.nathanjrussell.BigCorpHR;

import java.time.LocalDate;


// Employee class with all fields and validation methods
public class Employee {
    private final  int employeeId;

    private final  String firstName;
    private final  String middleName;
    private final  String lastName;
    private final  String phoneNumber;
    private final  String emailAddress;
    private final  String streetAddress;
    private final  String city;
    private final  String state;
    private final  String zipCode;
    private final  String country;

    //birthday
    private final  int birthYear;
    private final  int birthMonth;
    private final  int birthDay;

    //hire date
    private final  int hireYear;
    private final  int hireMonth;
    private final  int hireDay;

    //emergency contact 1
    private final  String emergContFirstName;
    private final  String emergContLastName;
    private final  String emergContPhoneNumber;
    private final  String emergContEmailAddress;
    private final  String emergContStreetAddress;
    private final  String emergContCity;
    private final  String emergContState;
    private final  String emergContZipCode;
    private final  String emergContCountry;

    //emergency contact 2
    private final  String emergCont2FirstName;
    private final  String emergCont2LastName;
    private final  String emergCont2PhoneNumber;
    private final  String emergCont2EmailAddress;
    private final  String emergCont2StreetAddress;
    private final  String emergCont2City;
    private final  String emergCont2State;
    private final  String emergCont2ZipCode;
    private final  String emergCont2Country;

    
    /* 
    Notice the constructor has a significant number of parameters.
    This can be difficult to use in code even with an IDE providing hints and ordering.
    In real applications this can lead to subtle bugs that are hard to track down.
     */
    
    public Employee(int employeeId, String firstName, String middleName, String lastName, String phoneNumber, String emailAddress,
                    String streetAddress, String city, String state, String zipCode, String country,
                    int birthYear, int birthMonth, int birthDay,
                    int hireYear, int hireMonth, int hireDay,
                    String emergContFirstName, String emergContLastName, String emergContPhoneNumber,
                    String emergContEmailAddress, String emergContStreetAddress, String emergContCity,
                    String emergContState, String emergContZipCode, String emergContCountry,
                    String emergCont2FirstName, String emergCont2LastName, String emergCont2PhoneNumber,
                    String emergCont2EmailAddress, String emergCont2StreetAddress, String emergCont2City,
                    String emergCont2State, String emergCont2ZipCode , String emergCont2Country) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.hireYear = hireYear;
        this.hireMonth = hireMonth;
        this.hireDay = hireDay;
        this.emergContFirstName = emergContFirstName;
        this.emergContLastName = emergContLastName;
        this.emergContPhoneNumber = emergContPhoneNumber;
        this.emergContEmailAddress = emergContEmailAddress;
        this.emergContStreetAddress = emergContStreetAddress;
        this.emergContCity = emergContCity;
        this.emergContState = emergContState;
        this.emergContZipCode = emergContZipCode;
        this.emergContCountry = emergContCountry;
        this.emergCont2FirstName = emergCont2FirstName;
        this.emergCont2LastName = emergCont2LastName;
        this.emergCont2PhoneNumber = emergCont2PhoneNumber;
        this.emergCont2EmailAddress = emergCont2EmailAddress;
        this.emergCont2StreetAddress = emergCont2StreetAddress;
        this.emergCont2City = emergCont2City;
        this.emergCont2State = emergCont2State;
        this.emergCont2ZipCode = emergCont2ZipCode;
        this.emergCont2Country = emergCont2Country;
    }

    
    /*
    Notice all the validation methods are inside the employee class.
    These may be reused in other places.  It may be better to move these to a separate utility class.
     */
    private void validateEmployeeId(int employeeId) {
        if (employeeId < 1_000_000 || employeeId > 9_999_999) {
            throw new IllegalArgumentException("Employee ID must be a 9 digit positive integer.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Phone number must be in the format XXX-XXX-XXXX.");
        }
    }

    private void validateEmailAddress(String emailAddress) {
        if (!emailAddress.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email address format.");
        }
    }

    private void validateZipCode(String zipCode) {
        if (!zipCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Zip code must be a 5 digit number.");
        }
    }

    private void validateBirthDate(int year, int month, int day) {
        //use current year for validation
        if (year < 1900 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year must be between 1900 and the current year.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month - value must be between 1 and 12.");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day of month.");
        }
        //use LocalDate to validate month and day
        try {
            LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Date.");
        }
    }
    
    /*
    Now we create all the getters for the fields.  
    Notice we do not have setters because we want to make the employee class immutable.  
    This means once an employee is created, it cannot be changed.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getHireYear() {
        return hireYear;
    }

    public int getHireMonth() {
        return hireMonth;
    }

    public int getHireDay() {
        return hireDay;
    }

    public String getEmergContFirstName() {
        return emergContFirstName;
    }

    public String getEmergContLastName() {
        return emergContLastName;
    }

    public String getEmergContPhoneNumber() {
        return emergContPhoneNumber;
    }

    public String getEmergContEmailAddress() {
        return emergContEmailAddress;
    }

    public String getEmergContStreetAddress() {
        return emergContStreetAddress;
    }

    public String getEmergContCity() {
        return emergContCity;
    }

    public String getEmergContState() {
        return emergContState;
    }

    public String getEmergContZipCode() {
        return emergContZipCode;
    }

    public String getEmergContCountry() {
        return emergContCountry;
    }

    public String getEmergCont2FirstName() {
        return emergCont2FirstName;
    }

    public String getEmergCont2LastName() {
        return emergCont2LastName;
    }

    public String getEmergCont2PhoneNumber() {
        return emergCont2PhoneNumber;
    }

    public String getEmergCont2EmailAddress() {
        return emergCont2EmailAddress;
    }

    public String getEmergCont2StreetAddress() {
        return emergCont2StreetAddress;
    }

    public String getEmergCont2City() {
        return emergCont2City;
    }

    public String getEmergCont2State() {
        return emergCont2State;
    }

    public String getEmergCont2ZipCode() {
        return emergCont2ZipCode;
    }

    public String getEmergCont2Country() {
        return emergCont2Country;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(employeeId).append("\n");
        sb.append("Name: ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append("\n");
        sb.append("Phone: ").append(phoneNumber).append("\n");
        sb.append("Email: ").append(emailAddress).append("\n");
        sb.append("Address: ").append(streetAddress).append(", ").append(city).append(", ").append(state).append(" ").append(zipCode).append(", ").append(country).append("\n");
        sb.append("Birth Date: ").append(birthYear).append("-").append(birthMonth).append("-").append(birthDay).append("\n");
        sb.append("Hire Date: ").append(hireYear).append("-").append(hireMonth).append("-").append(hireDay).append("\n");
        sb.append("Emergency Contact 1: ").append(emergContFirstName).append(" ").append(emergContLastName).append(", Phone: ").append(emergContPhoneNumber).append(", Email: ").append(emergContEmailAddress).append(", Address: ").append(emergContStreetAddress).append(", ").append(emergContCity).append(", ").append(emergContState).append(" ").append(emergContZipCode).append(", ").append(emergContCountry).append("\n");
        sb.append("Emergency Contact 2: ").append(emergCont2FirstName).append(" ").append(emergCont2LastName).append(", Phone: ").append(emergCont2PhoneNumber).append(", Email: ").append(emergCont2EmailAddress).append(", Address: ").append(emergCont2StreetAddress).append(", ").append(emergCont2City).append(", ").append(emergCont2State).append(" ").append(emergCont2ZipCode).append(", ").append(emergCont2Country).append("\n");
        return sb.toString();
    }


}
