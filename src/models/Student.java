package models;

import enums.Gender;

public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;

    public Student(){

    }

    public Student(Long studentId, String firstName, String lastName, String email, String password, Gender gender){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student: " +
                "\n\t\tСтуденттин ID'си:\t\t" + studentId +
                ",\n\t\tАты:\t\t\t\t\t" + firstName  +
                ",\n\t\tФамилиясы:\t\t\t\t" + lastName +
                ",\n\t\tЭлектрондук почтасы: \t"+ email +
                ",\n\t\tСыр созу: \t\t\t\t" + password +
                ",\n\t\tЖынысы:\t\t\t\t\t" + gender;
    }
}
