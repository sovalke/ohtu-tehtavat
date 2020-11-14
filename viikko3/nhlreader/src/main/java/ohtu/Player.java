
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality(String n) {
        nationality = n;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setAssists(int amount) {
        assists = amount;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public void setGoals(int amount) {
        goals = amount;
    }
    
    public int getGoals() {
        return goals;
    }
    
    public void setPenalties(int amount) {
        penalties = amount;
    }
    
    public int getPenalties() {
        return penalties;
    }
    
    public void setTeam(String teamName) {
        team = teamName;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setGames(int amount) {
        games = amount;
    }
    
    public int getGames() {
        return games;
    }
    
    @Override
    public String toString() {
        return name + " team" + team + " nationality " + nationality + " goals " + goals + " assists " + assists;
    }
}
