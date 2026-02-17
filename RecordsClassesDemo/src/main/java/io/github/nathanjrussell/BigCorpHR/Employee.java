package io.github.nathanjrussell.BigCorpHR;

import java.time.LocalDate;

/*
    Notice this is effectively the same class as the original Employee class.
    The only difference is that this is a record instead of a traditional class.
    The record provides a compact syntax for defining a class that is primarily used to store data.
    Record classes automatically generate constructor, getter methods, equals(), hashCode(), and toString() methods based on the fields defined in the record header (parameters).
 */
public record Employee(
        int employeeId,
        String firstName,
        String middleName,
        String lastName,
        String phoneNumber,
        String emailAddress,
        String streetAddress,
        String city,
        String state,
        String zipCode,
        String country,
        int birthYear,
        int birthMonth,
        int birthDay,
        int hireYear,
        int hireMonth,
        int hireDay,
        String emergContFirstName,
        String emergContLastName,
        String emergContPhoneNumber,
        String emergContEmailAddress,
        String emergContStreetAddress,
        String emergContCity,
        String emergContState,
        String emergContZipCode,
        String emergContCountry,
        String emergCont2FirstName,
        String emergCont2LastName,
        String emergCont2PhoneNumber,
        String emergCont2EmailAddress,
        String emergCont2StreetAddress,
        String emergCont2City,
        String emergCont2State,
        String emergCont2ZipCode,
        String emergCont2Country) {
    /*
    Notice the constructor has a significant number of parameters.
    This can be difficult to use in code even with an IDE providing hints and ordering.
    In real applications this can lead to subtle bugs that are hard to track down.
     */


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
