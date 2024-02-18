package edu.java.bot.commands.commandImpl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.commands.Command;
import edu.java.bot.commands.CommandManager;
import edu.java.bot.printer.Printer;
import edu.java.bot.service.CommandService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command {

    private final CommandService commandService;

    @Autowired
    public HelpCommand(CommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "вывести описание комманд";
    }

    @Override
    public String handle(@NotNull Update update, @NotNull Printer printer) {
        if (CommandManager.getCommandDescription() == null || CommandManager.getCommandDescription().isEmpty()) {
            return "В данный момент нет доступных комманд.";
        }
        StringBuilder response =
            new StringBuilder().append(printer.boldText("Список доступных команд:")).append(printer.nextLine());
        CommandManager.getCommandDescription()
            .forEach((key, value) -> response.append(printer.commandDescriptionText(key, value)));
        return response.toString();
    }

}
