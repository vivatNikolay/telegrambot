package project.bots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBot = new TelegramBotsApi();

        TravelBot bot = new TravelBot();
        try{
            telegramBot.registerBot(bot);
        } catch (TelegramApiRequestException e){
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }
}
