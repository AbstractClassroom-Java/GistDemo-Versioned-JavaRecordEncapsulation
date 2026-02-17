package io.github.nathanjrussell.BigCorpHR;

import java.time.LocalDate;

public record ContactInfo(
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
        LocalDate birthDate
) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (firstName != null) sb.append(firstName);
        if (middleName != null && !middleName.isBlank()) sb.append(" ").append(middleName);
        if (lastName != null && !lastName.isBlank()) sb.append(" ").append(lastName);
        if (sb.length() > 0) sb.append("\n");

        if (phoneNumber != null) sb.append("Phone: ").append(phoneNumber).append("\n");
        if (emailAddress != null) sb.append("Email: ").append(emailAddress).append("\n");

        if (streetAddress != null || city != null || state != null || zipCode != null || country != null) {
            if (streetAddress != null) sb.append("Address: ").append(streetAddress);
            if (city != null) sb.append(", ").append(city);
            if (state != null) sb.append(", ").append(state);
            if (zipCode != null) sb.append(" ").append(zipCode);
            if (country != null) sb.append(", ").append(country);
            sb.append("\n");
        }

        if (birthDate != null) sb.append("Birth Date: ").append(birthDate).append("\n");
        return sb.toString();
    }
}
