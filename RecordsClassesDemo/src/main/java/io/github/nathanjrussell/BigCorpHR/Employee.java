package io.github.nathanjrussell.BigCorpHR;

import java.time.LocalDate;

/*
    Employee now composes ContactInfo records for personal and emergency contact information,
    and stores hireDate as a LocalDate.
 */
public record Employee(
        int employeeId,
        ContactInfo personalContact,
        LocalDate hireDate,
        ContactInfo emergContact1,
        ContactInfo emergContact2
) {

    // Compact canonical constructor: reuse validation on construction
    public Employee {
        validateEmployeeId(employeeId);
    }

    private static void validateEmployeeId(int employeeId) {
        if (employeeId < 1_000_000 || employeeId > 9_999_999) {
            throw new IllegalArgumentException("Employee ID must be a 7 digit positive integer.");
        }
    }

    /**
     * Fluent builder factory for Employee
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int employeeId;
        private ContactInfo personalContact;
        private LocalDate hireDate;
        private ContactInfo emergContact1;
        private ContactInfo emergContact2;

        public Builder() {}

        public Builder employeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder personalContact(ContactInfo personalContact) {
            this.personalContact = personalContact;
            return this;
        }

        public Builder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder emergContact1(ContactInfo emergContact1) {
            this.emergContact1 = emergContact1;
            return this;
        }

        public Builder emergContact2(ContactInfo emergContact2) {
            this.emergContact2 = emergContact2;
            return this;
        }

        public Employee build() {
            // validate required/format where appropriate
            validateEmployeeId(employeeId);
            return new Employee(employeeId, personalContact, hireDate, emergContact1, emergContact2);
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indentLevel) {
        StringBuilder sb = new StringBuilder();
        String indent = "\t".repeat(indentLevel);
        sb.append(indent).append("Employee ID: ").append(employeeId).append("\n");
        indentLevel += 1;
        indent = "\t".repeat(indentLevel);
        if (hireDate != null) {
            sb.append(indent).append("Hire Date: ").append(hireDate).append("\n");
        }
        if (personalContact != null) {
            sb.append(indent).append("Employee Contact Info:\n").append(personalContact.toString(indentLevel + 1));
        }

        if (emergContact1 != null) {
            sb.append(indent).append("Emergency Contact 1:\n").append(emergContact1.toString(indentLevel + 1));
        }
        if (emergContact2 != null) {
            sb.append(indent).append("Emergency Contact 2:\n").append(emergContact2.toString(indentLevel + 1));
        }
        return sb.toString();
    }

}
