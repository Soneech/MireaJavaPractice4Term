package org.soneech.practice6.builder;

public class User {
    private String firstName;  // required
    private String lastName;  // required
    private int age;  // optional
    private String email;  // optional
    private String phone;  // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("name: ").append(firstName).append("; ");
       stringBuilder.append("last name: ").append(lastName);

       if (age != 0) {
           stringBuilder.append("; age: ").append(age);
       }
       if (email != null) {
           stringBuilder.append("; email: ").append(email);
       }
       if (phone != null) {
           stringBuilder.append("; phone: ").append(phone);
       }

       return stringBuilder.toString();
    }

    public static class UserBuilder {
        private String firstName;  // required
        private String lastName;  // required
        private int age;  // optional
        private String email;  // optional
        private String phone;  // optional

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            User user = new User(this);
            if (userDataIsValid(user)) {
                return user;
            }
            return null;
        }

        private boolean userDataIsValid(User user) {
            if (!user.firstName.isEmpty() && !user.lastName.isEmpty()) {
                return true;
            }
            throw new IllegalArgumentException("first name and last name is empty!");
        }
    }
}
