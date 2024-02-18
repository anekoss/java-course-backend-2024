package edu.java.bot.commands.commandImpl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.commands.Command;
import edu.java.bot.commands.CommandExecutionStatus;
import edu.java.bot.printer.Printer;
import edu.java.bot.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static edu.java.bot.commands.CommandExecutionStatus.SUCCESS;

@Component
public class TrackCommand implements Command {
    private final CommandService commandService;

    @Autowired
    public TrackCommand(CommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "начать отслеживание ссылки";
    }

    @Override
    public String handle(Update update, Printer printer) {
        Long id = update.message().from().id();
        if (supports(update)) {
            return "Введите URL-ссылку, чтобы отслеживать обновления.";
        }
        String url = GET_TEXT_REQUEST.apply(update.message().text());
        String okResponse = "Cсылка успешно добавлена!";
        CommandExecutionStatus result = commandService.track(id, url);
        return result == SUCCESS ? okResponse : result.getMessage();
    }

}
