package com.bsuir.stanisheuskaya.parser;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.exception.CommandNotFoundException;
import com.bsuir.stanisheuskaya.exception.WrongCommandFormatException;

public interface Parser {
    Command parse(String command) throws WrongCommandFormatException, CommandNotFoundException;
}
