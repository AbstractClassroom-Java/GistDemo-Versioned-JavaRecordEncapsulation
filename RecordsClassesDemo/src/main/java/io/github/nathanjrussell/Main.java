package io.github.nathanjrussell;

import io.github.nathanjrussell.BigCorpHR.ContactInfo;
import io.github.nathanjrussell.BigCorpHR.Employee;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ContactInfo personal = new ContactInfo(
                "John",
                "A.",
                "Doe",
                "555-123-4567",
                "john.doe@example.com",
                "123 Main St",
                "Anytown",
                "CA",
                "90210",
                "USA",
                LocalDate.of(1985, 5, 15)
        );

        ContactInfo emerg1 = new ContactInfo(
                "Jane",
                null,
                "Doe",
                "555-987-6543",
                "jane.doe@example.com",
                "123 Main St",
                "Anytown",
                "CA",
                "90210",
                "USA",
                null
        );

        ContactInfo emerg2 = new ContactInfo(
                "Bob",
                null,
                "Smith",
                "555-000-1111",
                "bob.smith@example.com",
                "456 Elm St",
                "Othertown",
                "CA",
                "90001",
                "USA",
                null
        );

        Employee johnDoe = new Employee(
                1234567,
                personal,
                LocalDate.of(2010, 6, 1),
                emerg1,
                emerg2
        );

        System.out.println(johnDoe);

        // Access an emerg contact phone via the emergContact record
        System.out.println("Emergency 1 phone: " + johnDoe.emergContact1().phoneNumber());
    }
}