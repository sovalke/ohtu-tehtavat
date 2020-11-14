package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        ArrayList<Player> list = new ArrayList<>();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Oliot:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                list.add(player);
            }
            
        }   
        Collections.sort(list);
        Collections.reverse(list);
        for (Player player : list) {
            System.out.println(player);
        }
    }
  
}