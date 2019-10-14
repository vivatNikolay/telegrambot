package project.bots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import project.bots.model.CitiesRepo;

@Component
@Configurable
public class TravelBot extends TelegramLongPollingBot {

    @Autowired
    private CitiesRepo citiesRepo;

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText(input(update.getMessage().getText()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "@TravelBotik_bot";
    }

    @Override
    public String getBotToken() {
        return "888571639:AAG5iAbCzFzjCtVUmA-X9iiSX6-X5lCCnck";
    }

    private String input(String city) {
        String msg;
        try{
            msg = citiesRepo.findByCity(city).get().getMessage();
        } catch (Exception e){
            msg = "Такого города нет в БД";
        }
        return msg;
    }

}
