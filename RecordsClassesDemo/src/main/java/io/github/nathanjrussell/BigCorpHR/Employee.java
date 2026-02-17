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

    private void validateEmployeeId(int employeeId) {
        if (employeeId < 1_000_000 || employeeId > 9_999_999) {
            throw new IllegalArgumentException("Employee ID must be a 7 digit positive integer.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(employeeId).append("\n");
        if (personalContact != null) {
            sb.append(personalContact.toString());
        }
        if (hireDate != null) {
            sb.append("Hire Date: ").append(hireDate).append("\n");
        }
        if (emergContact1 != null) {
            sb.append("Emergency Contact 1:\n").append(emergContact1.toString());
        }
        if (emergContact2 != null) {
            sb.append("Emergency Contact 2:\n").append(emergContact2.toString());
        }
        return sb.toString();
    }

}
