package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1, String player2) {
        this.player1Name = player1;
        this.player2Name = player2;
    }

    public void winningPointToPlayer(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        
        // Check if there is a draw...
        if (player1Score == player2Score) {
            score = peekDrawScore(score);
        }

        // Check if one has advantage.
        else if (player1Score>=4 || player2Score>=4) {
            score = peekAdvantage(score);
        }

        // Otherwise, just check the overall results.
        else {
            score = peekOverallScore(score, tempScore);
        }
        return score;
    }
    
    public String peekDrawScore(String score) {
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
    
    public String peekAdvantage(String score) {
        int difference = player1Score-player2Score;
        
        if (difference==1)
            score ="Advantage player1";
        
        else if (difference ==-1)
            score ="Advantage player2";
        
        else if (difference>=2)
            score = "Win for player1";
        
        else
            score ="Win for player2";
        
        return score;
    }
    
    public String peekOverallScore(String score, int tempScore) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }

            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}