package com.bsuir.stanisheuskaya.util;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.command.impl.DownloadCommand;
import com.bsuir.stanisheuskaya.command.impl.EchoCommand;
import com.bsuir.stanisheuskaya.command.impl.TimeCommand;
import com.bsuir.stanisheuskaya.command.impl.UploadCommand;
import com.bsuir.stanisheuskaya.exception.CommandNotFoundException;

public enum CommandType {
    ECHO("echo", "Echo server", new EchoCommand()),
    TIME("time", "Get server time", new TimeCommand()),
    DOWNLOAD("download", "Download file from server", new DownloadCommand()),
    UPLOAD("upload", "Upload file to server", new UploadCommand());

    private String commandName;
    private String description;
    private Command command;

    CommandType(String commandName, String description, Command command) {
        this.commandName = commandName;
        this.description = description;
        this.command = command;
    }

    public static Command findCommand(String commandName) throws CommandNotFoundException {
        for (CommandType type : CommandType.values()) {
            if (type.getName().equals(commandName)) {
                return type.getCommand();
            }
        }

        throw new CommandNotFoundException("Cannot find command by name[=" + commandName + "]");
    }

    public static boolean hasCommand(String commandName) {
        for (CommandType type : CommandType.values()) {
            if (type.getName().equals(commandName)) {
                return true;
            }
        }

        return false;
    }

    public String getName() {
        return commandName;
    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return command.build();
    }
}
