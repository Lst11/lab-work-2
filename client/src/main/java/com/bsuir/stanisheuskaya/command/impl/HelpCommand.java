package com.bsuir.stanisheuskaya.command.impl;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.util.CommandType;

import java.util.HashMap;

public class HelpCommand extends BaseCommand {
    @Override
    public void execute() {
        HashMap<String, String> commands = new HashMap<>();

        for (CommandType type : CommandType.values()) {
            commands.put(type.getName(), type.getDescription());
        }

        System.out.println("The most commonly used client commands are:");
        commands.forEach((k, v) -> {
            System.out.println("  " + k + " - " + v);
        });
    }

    @Override
    public Command build() {
        return new HelpCommand();
    }
}
