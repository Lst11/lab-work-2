package com.bsuir.stanisheuskaya.parser.impl;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.exception.CommandNotFoundException;
import com.bsuir.stanisheuskaya.exception.WrongCommandFormatException;
import com.bsuir.stanisheuskaya.util.CommandType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParser extends BaseParser {
    private static final String CMD_TOKEN_REGEX = "(-([a-z]+)((?==)='([\\w .-:\\\\]+)')*)";
    private static final int TOKEN_NAME_GROUP_INDEX = 2;
    private static final int TOKEN_VALUE_GROUP_INDEX = 4;
    private Command command;

    public TokenParser(String commandName) throws CommandNotFoundException {
        this.command = CommandType.findCommand(commandName);
    }

    @Override
    public Command handle(String cmd) throws WrongCommandFormatException {
        Pattern pattern = Pattern.compile(CMD_TOKEN_REGEX);
        Matcher matcher = pattern.matcher(cmd);

        while (matcher.find()) {
            final String tokenName = matcher.group(TOKEN_NAME_GROUP_INDEX);
            final String tokenValue = matcher.group(TOKEN_VALUE_GROUP_INDEX);

            command.putToken(tokenName, tokenValue);
        }

        command.verifyTokens();
        return command;
    }
}