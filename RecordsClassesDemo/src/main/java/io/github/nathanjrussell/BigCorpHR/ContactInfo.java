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

    /**
     * Returns a new Builder instance for fluent construction of a ContactInfo record.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Fluent builder for ContactInfo.
     */
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
        private LocalDate birthDate;

        public Builder() {}

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder streetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public ContactInfo build() {
            return new ContactInfo(
                    firstName,
                    middleName,
                    lastName,
                    phoneNumber,
                    emailAddress,
                    streetAddress,
                    city,
                    state,
                    zipCode,
                    country,
                    birthDate
            );
        }
    }
}
