public class Person {
    private final String firstName;
    private final String lastName;
    private final String primarySpeciality;

    public Person (String firstName, String lastName, String primarySpeciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primarySpeciality = primarySpeciality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPrimarySpeciality() {
        return primarySpeciality;
    }

    public String toString() {
        return String.format("%s %s - %s", firstName, lastName, primarySpeciality);
    }
}
