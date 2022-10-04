package com.kodilla.rps.gameLogic;

import com.kodilla.rps.GameDataBase;
import com.kodilla.rps.moves.Paper;
import com.kodilla.rps.moves.Rock;
import com.kodilla.rps.moves.Scissors;

import java.util.Random;

public class ComputerHardModeOrEasy {


    private final Random random = new Random();
    private int computerMove;
    private int valueHowBigChanceComputerHasToDraftInPercent = 50;

    private int valueHowBigChanceComputerHasToWinInPercent = 25;

    public int getValueHowBigChanceComputerHasToDraftInPercent() {
        return valueHowBigChanceComputerHasToDraftInPercent;
    }

    public int getValueHowBigChanceComputerHasToWinInPercent() {
        return valueHowBigChanceComputerHasToWinInPercent;
    }

    public int getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(int computerMove) {
        this.computerMove = computerMove;
    }

    private void giveRandomNumberFrom1To3() {
        setComputerMove(random.nextInt(3) + 1);
    }

    private void giveRandomNumberFrom1To100() {
        setComputerMove(random.nextInt(100) + 1);
    }

    private void computerEasyModeMakesMove(GameDataBase gameDataBase) {
        giveRandomNumberFrom1To3();
        switch (getComputerMove()) {
            case 1 -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case 2 -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case 3 -> gameDataBase.addComputerMoveInThisRound(new Scissors());
        }
    }

    private boolean computerHardModeDidHeDraft() {
        return getComputerMove() <= getValueHowBigChanceComputerHasToDraftInPercent();
    }

    private boolean computerHardModeDidHeWin() {
        return getComputerMove() > getValueHowBigChanceComputerHasToDraftInPercent() &&
                getComputerMove() <= (getValueHowBigChanceComputerHasToDraftInPercent() + getValueHowBigChanceComputerHasToWinInPercent());
    }

    private boolean computerHardModeDidHeLose() {
        return getComputerMove() > (getValueHowBigChanceComputerHasToDraftInPercent() + getValueHowBigChanceComputerHasToWinInPercent());
    }

    private String resultOfComputerMove() {
        giveRandomNumberFrom1To100();
        if (computerHardModeDidHeDraft()) {
            return "Draft";
        }
        if (computerHardModeDidHeWin()) {
            return "Win";
        }
        if (computerHardModeDidHeLose()) {
            return "Lose";
        }
        return "Stop";
    }

    private void computerHardModeMakesMoveVsRock(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case "Lose" -> gameDataBase.addComputerMoveInThisRound(new Scissors());
            case "Draft" -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void computerHardModeMakesMoveVsPaper(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> gameDataBase.addComputerMoveInThisRound(new Scissors());
            case "Lose" -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case "Draft" -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void computerHardModeMakesMoveVsScissors(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case "Lose" -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case "Draft" -> gameDataBase.addComputerMoveInThisRound(new Scissors());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    public void decideWithComputerModeUseForRockLogic(boolean hardMode, GameDataBase gameDataBase) {
        if (hardMode) {
            computerHardModeMakesMoveVsRock(gameDataBase);
        } else {
            computerEasyModeMakesMove(gameDataBase);
        }
    }

    public void decideWithComputerModeUseForPaperLogic(boolean hardMode, GameDataBase gameDataBase) {
        if (hardMode) {
            computerHardModeMakesMoveVsPaper(gameDataBase);
        } else {
            computerEasyModeMakesMove(gameDataBase);
        }
    }

    public void decideWithComputerModeUseForScissorsLogic(boolean hardMode, GameDataBase gameDataBase) {
        if (hardMode) {
            computerHardModeMakesMoveVsScissors(gameDataBase);
        } else {
            computerEasyModeMakesMove(gameDataBase);
        }
    }

}
