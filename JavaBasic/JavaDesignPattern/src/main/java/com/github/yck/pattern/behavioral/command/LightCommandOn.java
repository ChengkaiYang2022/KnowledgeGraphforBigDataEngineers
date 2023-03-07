package com.github.yck.pattern.behavioral.command;

public class LightCommandOn implements Command {
    private LightReceiver lightReceiver;
    public LightCommandOn(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }
    @Override
    public void execute() {
        lightReceiver.plugin();lightReceiver.open();

    }

    @Override
    public void undo() {
        lightReceiver.close();lightReceiver.plugOff();

    }
}