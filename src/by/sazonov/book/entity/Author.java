package by.sazonov.book.entity;

public class Author {

    private String firstName;
    private String lastName;

    public Author() {

    }

    public Author(String firstName,String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " +lastName ;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((firstName==null)?0:firstName.hashCode()) + ((lastName==null)?0:lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        if (o==null || o.getClass()!=this.getClass()) {
            return false;
        }
        Author author = (Author)o;
        if (author.lastName != this.lastName || author.firstName !=this.firstName) {
            return false;
        }
        return true;
    }
}
