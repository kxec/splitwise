package com.example.splitwise.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandRegistry {

    private List<Command> commands;

    @Autowired
    public CommandRegistry(List<Command> commands)
    {

        this.commands = commands;
    }

    public void process(String input)
    {
        for(Command command : commands)
        {
            if(command.canExecute(input))
            {
                command.execute(input);
                return;
            }

        }

        throw new IllegalArgumentException("Unknown command: " + input);
    }

}
