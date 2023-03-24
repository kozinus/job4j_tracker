package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Козин Кирилл Юрьевич");
        student.setGroup("12");
        student.setEntryDate("16.02.23");
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getEntryDate());
    }
}
