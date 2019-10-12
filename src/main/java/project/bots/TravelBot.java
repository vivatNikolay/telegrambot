package project.bots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import project.bots.model.CitiesRepo;

@Component
@Configurable
public class TravelBot extends TelegramLongPollingBot {

    @Autowired
    private CitiesRepo citiesRepo;

    /*private static volatile TelegramLongPollingBot INSTANCE = null;

    private TravelBot(){
    }

    public static TelegramLongPollingBot getInstance() {
        TelegramLongPollingBot travelBot = INSTANCE;
        if (travelBot == null) {
            synchronized (TravelBot.class) {
                travelBot = INSTANCE;
                if (travelBot == null) {
                    INSTANCE = travelBot = new TravelBot();
                }
            }
        }

        return travelBot;
    }*/

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

    public String input(String msg) {
        try {
            return search(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return "Такого города нет в базе";
        }
    }

    public String search(String city){
        String msg;
        try{
            msg = citiesRepo.findById(2).get().getMessage();
//            System.out.println(" ___ " + citiesRepo.findByCity(city).get());
        } catch (NullPointerException e){
            msg = "Такого города нет в БД";
            System.out.println("___");
        }
        return msg;
    }

}
