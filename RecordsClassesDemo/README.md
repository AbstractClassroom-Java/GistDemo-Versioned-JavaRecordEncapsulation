# Java Record Classes and Builder Patterns — RecordsClassesDemo

This repository demonstrates progressive refactorings that move from traditional mutable classes to Java `record` types and finally to builder-assisted construction for clearer, safer, and more maintainable data modeling.

This repo is the working codebase associated with the earlier gist and is laid out as a small, focused demonstration project. It contains three small, related examples that together show how to:

- Use Java `record` types to implement immutable value objects
- Encapsulate contact and employee information into small records
- Add fluent `Builder` classes to records so construction is readable, flexible, and validated

Repository layout (relevant files)

- `src/main/java/io/github/nathanjrussell/Main.java` — demo runner. Builds `ContactInfo` and `Employee` instances using the fluent builders and prints them.
- `src/main/java/io/github/nathanjrussell/BigCorpHR/ContactInfo.java` — a `record` that stores name, phone, email, address fields and `java.time.LocalDate birthDate`. Includes a nested static `Builder` for fluent construction and a `toString(int indent)` helper used by `Employee`.
- `src/main/java/io/github/nathanjrussell/BigCorpHR/Employee.java` — a `record` that composes `ContactInfo` for `personalContact`, `emergContact1`, and `emergContact2`, and stores the `hireDate` as `LocalDate`. It provides a nested static `Builder` and validation for `employeeId`.

Quick rationale

- Records reduce boilerplate for immutable value objects (fields, accessors, equals/hashCode, canonical constructor).
- Large constructors become error-prone and hard to read — builders let you set named properties in any order and centralize validation.
- Separating `ContactInfo` from `Employee` demonstrates composition: small focused types are easier to test and reuse.

What changed in the code (brief review)

- `ContactInfo`:
  - A compact `record` with components: `firstName, middleName, lastName, phoneNumber, emailAddress, streetAddress, city, state, zipCode, country, LocalDate birthDate`.
  - A static nested `Builder` with fluent setters and `.build()` returning a `ContactInfo` instance.
  - A `toString(int indentLevel)` method to produce indented, readable output for nested printing.

- `Employee`:
  - A `record` with components: `employeeId (int), ContactInfo personalContact, LocalDate hireDate, ContactInfo emergContact1, ContactInfo emergContact2`.
  - A compact canonical constructor that validates `employeeId` (throws IllegalArgumentException if invalid).
  - A static nested `Builder` providing fluent `.employeeId(...).personalContact(...).hireDate(...).emergContact1(...).emergContact2(...).build()`.
  - `toString()` delegates to the nested `ContactInfo.toString(indent)` helpers and prints `hireDate`.

- `Main`:
  - Uses `ContactInfo.builder()` and `Employee.builder()` to construct the example `johnDoe` instance, then prints it and demonstrates accessing nested fields (for example: `johnDoe.emergContact1().phoneNumber()`).

Example usage (taken from `Main.java`)

```java
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

Employee e = Employee.builder()
    .employeeId(1234567)
    .personalContact(personal)
    .hireDate(LocalDate.of(2010, 6, 1))
    .emergContact1(emerg1)
    .emergContact2(emerg2)
    .build();

System.out.println(e);
System.out.println("Emergency 1 phone: " + e.emergContact1().phoneNumber());
```

Run the demo locally

From the repository root:

```bash
mvn -DskipTests package
java -cp target/classes io.github.nathanjrussell.Main
```

Branch mapping (how this repo maps to the original gist progression)

- `bare_bones` (conceptual): Classic class-based encapsulation (explicit fields, constructors, getters) — represented conceptually in earlier revisions.
- `record_version` (conceptual): Refactor to `record` types to remove boilerplate and provide concise immutable types.
- `nested_records` (conceptual): Extract `ContactInfo` as a nested/sibling record and use `LocalDate` for birth/hire dates.
- `class_builders` (conceptual): Add fluent `Builder` classes to support flexible and readable construction while preserving immutability of the final `record` objects.
- `polished` / `main`: The current working state (this repository) — records + builder patterns + modular `toString` helpers for readable console output.

Learning goals

- Compare manual encapsulation with Java `record` types.
- Explore composition of small records vs. large monolithic data objects.
- See how builders improve construction clarity and validation while keeping final objects immutable.
- Practice moving from constructor-heavy code to builder-based construction for better maintainability.

Notes, tips, and next steps

- Validation: Simple validation is included for `employeeId`. Consider moving more detailed validation (phone format, email format, zip code) into dedicated validator utilities or into the builder before calling `.build()`.
- Tests: Add a couple of unit tests that construct `ContactInfo` and `Employee` with both valid and invalid data to show validation behavior.
- DSL-style builders: Builders can be extended with convenience methods (e.g., `fromExisting(ContactInfo)`) or static factory methods if you need immutability with copy/update semantics.

If you'd like, I can also:
- Sync this README to your original gist directly (if you provide the gist URL),
- Add a short CONTRIBUTING.md explaining the branch/semver strategy used for the lesson,
- Add unit tests demonstrating builder validation.

---

If you want any phrasing adjusted to sound more like lecture notes or a step-by-step tutorial for students, tell me which tone you prefer (concise summary / lecture-style narrative / hands-on lab with exercises) and I'll update the README accordingly.
