
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class All implements Matcher {
    private Matcher[] matchers;
    
    public All() {
        
    }
    
    public All(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    @Override
    public boolean matches(Player p) {
        return true;
    } 
}
