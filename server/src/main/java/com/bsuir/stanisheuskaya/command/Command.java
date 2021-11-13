package com.bsuir.stanisheuskaya.command;

import com.bsuir.stanisheuskaya.exception.WrongCommandFormatException;
import com.bsuir.stanisheuskaya.service.DefaultServerConnection;

import java.util.Map;

public interface Command {
    void execute(DefaultServerConnection connection);

    void putToken(String name, String value);

    Map<String, String> getTokens();

    void verifyTokens() throws WrongCommandFormatException;

    Command build();
}
