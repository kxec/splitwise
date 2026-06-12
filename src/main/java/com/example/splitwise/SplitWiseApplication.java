package com.example.splitwise;

import com.example.splitwise.command.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {


    private CommandRegistry commandRegistry;

    @Autowired
    public SplitWiseApplication(CommandRegistry commandRegistry)
    {
        this.commandRegistry = commandRegistry;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scn = new Scanner(System.in);

        while(true)
        {
            String input = scn.nextLine();

            if(input.equals("quit")) {
                System.out.println("Good Bye");
                break;
            }

            else
            {
                commandRegistry.process(input);
            }
        }
    }
}
