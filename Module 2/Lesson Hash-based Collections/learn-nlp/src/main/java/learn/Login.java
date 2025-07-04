package learn;

import java.util.Objects;

public class Login {

    private final String emailAddress;
    private final String firstName;
    private final String lastName;

    public Login(String emailAddress, String firstName, String lastName) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(emailAddress, login.emailAddress) &&
                Objects.equals(firstName, login.firstName) &&
                Objects.equals(lastName, login.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, firstName, lastName);
    }
}

/*
Key                     ->   Hash Code -> Value
--------------------------------------------------------
cspacey0@myspace.com    ->  1078095303 -> ["Carita","Spacey","cspacey0@myspace.com"]
sbretherick1@va.gov     ->   -81315448 -> ["Sammy","Bretherick","sbretherick1@va.gov"]
zcripwell2@dot.gov      ->   555922429 -> ["Zia","Cripwell","zcripwell2@dot.gov"]
spyatt3@marketwatch.com ->  1154077780 -> ["Sianna","Pyatt","spyatt3@marketwatch.com"]
oranahan4@bing.com      -> -2106962877 -> ["Odelinda","Ranahan","oranahan4@bing.com"]

System.out.println("cspacey0@myspace.com".hashCode());
System.out.println("sbretherick1@va.gov".hashCode());
System.out.println("zcripwell2@dot.gov".hashCode());
System.out.println("spyatt3@marketwatch.com".hashCode());
System.out.println("oranahan4@bing.com".hashCode());

*/