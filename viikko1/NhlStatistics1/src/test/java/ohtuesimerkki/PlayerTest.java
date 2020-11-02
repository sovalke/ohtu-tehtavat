
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    Player p;
    Player p2;
    double vertailuTarkkuus = 0.0001;
    
    public PlayerTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Player("Testaaja", "Testitiimi", 4, 5);
        p2 = new Player("Testaaja 2", "Testitiimi", 9, 11);
    }
    
    @Test
    public void assistTest() {
        assertEquals(5, p.getAssists(), vertailuTarkkuus);
        p.setAssists(6);
        assertEquals(6, p.getAssists(), vertailuTarkkuus);
    }
    
    @Test
    public void goalsTest() {
        assertEquals(4, p.getGoals(), vertailuTarkkuus);
        p.setGoals(5);
        assertEquals(5, p.getGoals(), vertailuTarkkuus);
    }
    
    @Test
    public void nameTest() {
        assertEquals("Testaaja", p.getName());
        p.setName("Testaajan kaveri");
        assertEquals("Testaajan kaveri", p.getName());
    }
    
    @Test
    public void teamTest() {
        assertEquals("Testitiimi", p.getTeam());
        p.setTeam("Kärpät");
        assertEquals("Kärpät", p.getTeam());
    }
    
    @Test
    public void compareTest() {
        p.compareTo(p2);
    }
    
    @Test
    public void toStringTest() {
        p.toString();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
