package io.github.nathanjrussell;

import io.github.nathanjrussell.BigCorpHR.ContactInfo;
import io.github.nathanjrussell.BigCorpHR.Employee;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ContactInfo personal = ContactInfo.builder()
                .firstName("John")
                .middleName("A.")
                .lastName("Doe")
                .phoneNumber("555-123-4567")
                .emailAddress("john.doe@example.com")
                .streetAddress("123 Main St")
                .city("Anytown")
                .state("CA")
                .zipCode("90210")
                .country("USA")
                .birthDate(LocalDate.of(1985, 5, 15))
                .build();

        ContactInfo emerg1 = ContactInfo.builder()
                .firstName("Jane")
                .lastName("Doe")
                .phoneNumber("555-987-6543")
                .emailAddress("jane.doe@example.com")
                .streetAddress("123 Main St")
                .city("Anytown")
                .state("CA")
                .zipCode("90210")
                .country("USA")
                .build();

        ContactInfo emerg2 = ContactInfo.builder()
                .firstName("Bob")
                .lastName("Smith")
                .phoneNumber("555-000-1111")
                .emailAddress("bob.smith@example.com")
                .streetAddress("456 Elm St")
                .city("Othertown")
                .state("CA")
                .zipCode("90001")
                .country("USA")
                .build();

        Employee johnDoe = Employee.builder()
                .employeeId(1234567)
                .personalContact(personal)
                .hireDate(LocalDate.of(2010, 6, 1))
                .emergContact1(emerg1)
                .emergContact2(emerg2)
                .build();

        System.out.println(johnDoe);

        // Access an emerg contact phone via the emergContact record
        System.out.println("Emergency 1 phone: " + johnDoe.emergContact1().phoneNumber());
    }
}