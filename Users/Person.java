package Users;

/*
 * This class represents a Person 
 * All people (objects of the Person class) has a non empty first and last name, gender amd an id
*/
public class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String id;

    public Person(String firstName, String lastName, String gender, String id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public boolean equals(Person other) {
        return this.id.equals(other.id);
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getId() {
        return this.id;
    }

}