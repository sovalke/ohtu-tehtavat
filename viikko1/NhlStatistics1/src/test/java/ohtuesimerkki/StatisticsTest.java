package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUpTest(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
        
    }  
    
    @Test
    public void TeamTest() {
        stats.team("EDM");
        stats.team("Tiikerit");
    }
    
    @Test
    public void SearchTest() {
        stats.search("Semenko");
        stats.search("Litmanen");
    }
    
    @Test
    public void topScoreTest() {
        stats.topScorers(2);
    }
}
