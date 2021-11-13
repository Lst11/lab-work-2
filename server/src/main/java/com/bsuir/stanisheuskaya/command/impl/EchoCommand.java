package com.bsuir.stanisheuskaya.command.impl;

import com.bsuir.stanisheuskaya.command.Command;
import com.bsuir.stanisheuskaya.service.DefaultServerConnection;
import com.bsuir.stanisheuskaya.util.AvailableToken;

import java.io.IOException;
import java.util.Arrays;

public class EchoCommand extends BaseCommand {

    public EchoCommand() {
        Arrays.stream(AvailableToken.values()).forEach(t -> getAvailableTokens().put(t.getName(), t.getRegex()));
    }

    @Override
    public void execute(DefaultServerConnection connection) {
        try {
            String content = getTokens().get(AvailableToken.CONTENT.getName());

            if (content != null) {
                executeEcho(content, connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Command build() {
        return new EchoCommand();
    }

    private void executeEcho(String content, DefaultServerConnection connection) throws IOException {
        connection.write(content);
    }
}
