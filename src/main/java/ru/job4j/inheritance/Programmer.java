package ru.job4j.inheritance;

public class Programmer extends Profession {
    private String programLang;

    public Programmer(String programLang, boolean degree) {
        super(degree);
        this.programLang = programLang;
    }
}
