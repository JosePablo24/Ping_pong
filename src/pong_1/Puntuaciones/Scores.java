/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_1.Puntuaciones;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Jose Pablo Sandoval
 */
public class Scores  {

    public static final int MAX_SCORES = 5;
    private ArrayList<Score> scoresList = new ArrayList();

    public ArrayList<Score> getScoresList() {
        return scoresList;
    }

    public void setScoresList(ArrayList<Score> scoresList) {
        this.scoresList = scoresList;
    }

    public void addScore(Score score) {
        scoresList.add(score);
        Collections.sort(scoresList);
        if(scoresList.size() > MAX_SCORES) {
            scoresList.remove(scoresList.size() - 1);
        }
    }

    public int getPosition(Score score) {
        return scoresList.indexOf(score);
    }
    
    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<scoresList.size(); i++) {
            Score score = scoresList.get(i);
            result += (i+1) + "º: " + score.getName() + ": " + score.getPoints() + "\n";
        }
        return result;
    }
       
}