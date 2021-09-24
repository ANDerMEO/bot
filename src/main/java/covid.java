import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class covid {
    //документ, в котором будет храниться страница
    private Document document;

    public covid() {
        connect();
    }

    //подключаемся к странице
    private  void connect(){
        try{
            document = Jsoup.connect("https://koronainfo.ru/belarus").get();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //смотрим сколько лайков
    public String getCases(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.cases > div.total");
        return elements.text();
    }

    public String getCasesToday(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.cases > div.today > span");
        return elements.text();
    }

    public String getActive(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.active > div.total");
        return elements.text();
    }

    public String getRecovered(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.recovered > div.total");
        return elements.text();
    }

    public String getRecoveredToday(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.recovered > div.today > span");
        return elements.text();
    }

    public String getDeaths(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.deaths > div.total");
        return elements.text();
    }

    public String getDeathsToday(){
        Elements elements = document.select("body > div.container.page-container > article > div.statistic-block > div.statistic-block-item.deaths > div.today > span");
        return elements.text();
    }

}