package com.bsuir.stanisheuskaya.command;

import com.bsuir.stanisheuskaya.exception.WrongCommandFormatException;

import java.util.Map;

public interface Command {
    void execute();

    void putToken(String name, String value);

    Map<String, String> getTokens();

    void verifyTokens() throws WrongCommandFormatException;

    Command build();

    void validateTokens() throws WrongCommandFormatException;

    boolean validateToken(String tokenValue, String regex);

    void setCommand(String command);
}
