package com.github.yck.pattern.structural.decorator.colorboard2;

public class Client {
    public static void main(String[] args) {

        System.out.println("  ============ ");
        new BlueLine(new BlackLine(new RedLine(new Rectangle()))).draw();
        System.out.println("  ============ ");
        new RedLine(new BlackDot(new BlackLine(new Triangle()))).draw();
        System.out.println("  ============ ");
        new BlackDot(new BlueLine(new BlackLine(new Circle()))).draw();

    }
}