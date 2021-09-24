
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Timer;
import java.util.TimerTask;


public class Bot extends TelegramLongPollingBot {
    covid covid = new covid();
    private long chat_id;
    
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();
        sendMessage.setText(input(update.getMessage().getText()));

        try{
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }



    @Override
    public String getBotUsername() {
        return "@CrpB_bot";
    }

    @Override
    public String getBotToken() {
        return "1992862774:AAFNOm4BkeDE0RQevHN__YLbXwzbhJCjmsg";
    }

    public String input(String msg){
        if(msg.contains("/start")){
            return getInfoCOVID();
        }
        return "Для получения новой информации введите /start";
    }
    public String getInfoCOVID(){


        String info = "Всего случаев: " + covid.getCases()
                + "\n(сегодня " + covid.getCasesToday() + ")"
                + "\n\nЗаражено: " + covid.getActive()
                + "\n\nВыздоровело: " + covid.getRecovered()
                + "\n(cегодня " + covid.getRecoveredToday() + ")"
                + "\n\nУмерло: " + covid.getDeaths()
                + "\n(сегодня " + covid.getDeathsToday() + ")";

        return info;
    }

}
