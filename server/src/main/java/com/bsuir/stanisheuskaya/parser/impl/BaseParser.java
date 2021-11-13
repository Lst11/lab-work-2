package com.bsuir.stanisheuskaya.parser.impl;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.exception.CommandNotFoundException;
import com.bsuir.stanisheuskaya.exception.WrongCommandFormatException;
import com.bsuir.stanisheuskaya.parser.Parser;

abstract class BaseParser implements Parser {
    public abstract Command handle(String cmd) throws WrongCommandFormatException, CommandNotFoundException;

    public Command parse(String cmd) throws WrongCommandFormatException, CommandNotFoundException {
        return handle(cmd);
    }
}
