package io.github.nathanjrussell;

import io.github.nathanjrussell.BigCorpHR.Employee;

public class Main {
    public static void main(String[] args) {
        /*
        Notice how clumsy and error-prone this constructor appears.
        There are nearly 30 parameters that have to be passed in the correct order with the correct types.
        A change in the Employee class constructor requires onerous changes to all code associated with creating Employee objects.
        The code is difficult to read and understand.
        */
        Employee johnDoe = new Employee(
                1234567,
                "John", "A.", "Doe", "555-123-4567", "john.doe@example.com",
                "123 Main St", "Anytown", "CA", "90210", "USA",
                1985, 5, 15,
                2010, 6, 1,
                "Jane", "Doe", "555-987-6543", "jane.doe@example.com", "123 Main St", "Anytown", "CA", "90210", "USA",
                "Bob", "Smith", "555-000-1111", "bob.smith@example.com", "456 Elm St", "Othertown", "CA", "90001", "USA"
        );

        System.out.println(johnDoe);

        /*
        What if we just wanted to get the phone number for emergency contact 1?
        Even if we defined specific getter methods for each field, it would be difficult
        to construct meaningful contact information for emergency contact 1.
         */
        System.out.println(johnDoe.emergContPhoneNumber());
    }
}