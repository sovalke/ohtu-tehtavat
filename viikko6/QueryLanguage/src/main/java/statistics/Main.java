package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        Matcher m = new And(new HasAtLeast(5, "goals"),
                new HasAtLeast(5, "assists"),
                new PlaysIn("PHI")
        );

        // All
        System.out.println(stats.matches(new All()).size());

        // HasAtLeast
        System.out.println("HasAtLeast");
        Matcher m2 = new And(new Not(new HasAtLeast(1, "goals")), new PlaysIn("NYR"));
        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }

        //HasFewerThan
        System.out.println("HasFewerThan");
        Matcher m3 = new And(new HasFewerThan(1, "goals"), new PlaysIn("NYR"));
        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }
        
        // Or
        System.out.println("Or");
        Matcher m4 = new Or( new HasAtLeast(40, "goals"), new HasAtLeast(60, "assists")); 
        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }
        
        System.out.println("THE REST");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
