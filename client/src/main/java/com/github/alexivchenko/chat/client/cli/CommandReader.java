package com.github.alexivchenko.chat.client.cli;

import com.github.alexivchenko.chat.client.cli.commands.CommandInterpreter;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Alex Ivchenko
 */
public class CommandReader extends Thread {
    private final Scanner scanner;
    private final CommandInterpreter interpreter;

    public CommandReader(CommandInterpreter interpreter, InputStream is) {
        this.interpreter = interpreter;
        scanner = new Scanner(is);
    }

    @Override
    public void run() {
        while (true) {
            interpreter.interpret(scanner.nextLine());
        }
    }
}
