package com.kodilla.rps.game.database;

import com.kodilla.rps.User;
import com.kodilla.rps.moves.GameFigures;
import java.util.ArrayList;
import java.util.List;


public class GameDataBase {
    private User user;
    private int numberOfSmallWinsToWinTheGame;
    private int counterOfComputerWins;
    private int counterOfUserWins;
    private int currentRound = 0;
    private boolean endGame = false;
    private boolean resetGame = false;
    private boolean afterChooseNAndGameIsEnd = false;

    private boolean allowToRunLogicOfRoundWin = true;
    private String optionThatUserChoose;
    private String theUserChoosesIsYOrN;
    private List<GameFigures> recordOfAllUserRounds = new ArrayList<>();
    private List<GameFigures> recordOfAllComputerRounds = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public int getNumberOfSmallWinsToWinTheGame() {
        return numberOfSmallWinsToWinTheGame;
    }

    public List<GameFigures> getRecordOfAllUserRounds() {
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

    public int getCounterOfComputerWins() {
        return counterOfComputerWins;
    }

    public int getCounterOfUserWins() {
        return counterOfUserWins;
    }

    public boolean isAfterChooseNAndGameIsEnd() {
        return afterChooseNAndGameIsEnd;
    }

    public boolean isAllowToRunLogicOfRoundWin() {
        return allowToRunLogicOfRoundWin;
    }

    public void setAllowToRunLogicOfRoundWin(boolean allowToRunLogicOfRoundWin) {
        this.allowToRunLogicOfRoundWin = allowToRunLogicOfRoundWin;
    }

    public void setAfterChooseNoAndGameIsEnd(boolean afterChooseNAndGameIsEnd) {
        this.afterChooseNAndGameIsEnd = afterChooseNAndGameIsEnd;
    }

    public void setCounterOfComputerWins() {
        this.counterOfComputerWins += 1;
    }

    public void setCounterOfComputerWins(int counterOfComputerWins) {
        this.counterOfComputerWins = counterOfComputerWins;
    }

    public void setCounterOfUserWins() {
        this.counterOfUserWins += 1;
    }

    public void setCounterOfUserWins(int counterOfUserWins) {
        this.counterOfUserWins = counterOfUserWins;
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

    public void setCurrentRound() {
        this.currentRound += 1;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumberOfSmallWinsToWinTheGame(int numberOfSmallWinsToWinTheGame) {
        this.numberOfSmallWinsToWinTheGame = numberOfSmallWinsToWinTheGame;
    }

    public void addUserMoveInThisRound(GameFigures e) {
        recordOfAllUserRounds.add(e);
    }

    public void addComputerMoveInThisRound(GameFigures e) {
        recordOfAllComputerRounds.add(e);
    }
}
