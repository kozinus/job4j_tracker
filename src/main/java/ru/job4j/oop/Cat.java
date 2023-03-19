package ru.job4j.oop;

public class Cat {

    private String food;
    private String nick;

    public void show() {
        System.out.println("There are " + this.nick + "'s food.");
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String newNick) {
        this.nick = newNick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("gav");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("black");
        black.show();
    }
}