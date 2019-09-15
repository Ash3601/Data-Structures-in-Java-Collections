package EmployeeClass;
import java.util.Objects;
public class Employee {
	private String firstName;
	private String lastName;
	private int id;

	// Setting up the constructor
	public Employee (String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id; 
	}

	// Creating getters and setters
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public void setId (int id) {
		this.id = id;
	}	

	public String getFirstName (String firstName) {
		return this.firstName;
	}

	public String getLastName (String lastName) {
		return this.lastName;
	}

	public int getId (int id) {
		return this.id;
	}

	@Override
	public String toString () {
		return "Employee {" + 
		"firstName='" + firstName + '\'' +
		", lastName='" + lastName + '\'' +
		", id='" + id + '\'' +
		'}';

	}

	// Implementing the equals method for contains problem
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.lastName);
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}