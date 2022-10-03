package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class GameDataBase {
    private User user;
    private int numberOfSmalWinsToWinTheGame;
    private int currentRound = 0;
    private boolean endGame = false;
    private boolean resetGame = false;
    private String optionThatUserChoose;
    private String theUserChoosesIsYOrN;
    private List<GameFigures> recordOfAllUserRounds = new ArrayList<>();
    private List<GameFigures> recordOfAllComputerRounds = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public int getNumberOfSmalWinsToWinTheGame() {
        return numberOfSmalWinsToWinTheGame;
    }

    public List<GameFigures> getrecordOfAllUserRounds() {
        return recordOfAllUserRounds;
    }

    public List<GameFigures> getRecordOfAllComputerRounds() {
        return recordOfAllComputerRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public String getOptionThatUserChoose() {
        return optionThatUserChoose;
    }

    public String getTheUserChoosesIsYOrN() {
        return theUserChoosesIsYOrN;
    }

    public boolean isResetGame() {
        return resetGame;
    }

    public void setResetGame(boolean resetGame) {
        this.resetGame = resetGame;
    }

    public void setTheUserChoosesIsYOrN(String theUserChoosesIsYOrN) {
        this.theUserChoosesIsYOrN = theUserChoosesIsYOrN.toLowerCase();
    }

    public void setOptionThatUserChoose(String optionThatUserChoose) {
        this.optionThatUserChoose = optionThatUserChoose.toLowerCase();
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumberOfSmalWinsToWinTheGame(int numberOfSmalWinsToWinTheGame) {
        this.numberOfSmalWinsToWinTheGame = numberOfSmalWinsToWinTheGame;
    }

    public void addUserMoveInThisRound(GameFigures e) {
        recordOfAllUserRounds.add(e);
    }

    public void addComputerMoveInThisRound(GameFigures e) {
        recordOfAllComputerRounds.add(e);
    }


}
