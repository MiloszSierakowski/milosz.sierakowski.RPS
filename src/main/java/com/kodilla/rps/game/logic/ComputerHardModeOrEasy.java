package com.kodilla.rps.game.logic;

import com.kodilla.rps.game.database.GameDataBase;
import com.kodilla.rps.moves.*;

import java.util.Random;

public class ComputerHardModeOrEasy {
    private final Random random = new Random();
    private int computerMove;
    private int valueHowBigChanceComputerHasToDrawInPercent = 25;
    private int valueHowBigChanceComputerHasToWinInPercent = 50;

    public int getValueHowBigChanceComputerHasToDrawInPercent() {
        return valueHowBigChanceComputerHasToDrawInPercent;
    }

    public int getValueHowBigChanceComputerHasToWinInPercent() {
        return valueHowBigChanceComputerHasToWinInPercent;
    }

    public void setValueHowBigChanceComputerHasToDrawInPercent(int valueHowBigChanceComputerHasToDrawInPercent) {
        this.valueHowBigChanceComputerHasToDrawInPercent = valueHowBigChanceComputerHasToDrawInPercent;
    }

    public void setValueHowBigChanceComputerHasToWinInPercent(int valueHowBigChanceComputerHasToWinInPercent) {
        this.valueHowBigChanceComputerHasToWinInPercent = valueHowBigChanceComputerHasToWinInPercent;
    }

    public int getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(int computerMove) {
        this.computerMove = computerMove;
    }

    private void giveRandomNumberFrom1To5() {
        setComputerMove(random.nextInt(5) + 1);
    }

    private void giveRandomNumberFrom1To100() {
        setComputerMove(random.nextInt(100) + 1);
    }

    private void computerEasyModeMakesMove(GameDataBase gameDataBase) {
        giveRandomNumberFrom1To5();
        switch (getComputerMove()) {
            case 1 -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case 2 -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case 3 -> gameDataBase.addComputerMoveInThisRound(new Scissors());
            case 4 -> gameDataBase.addComputerMoveInThisRound(new Spock());
            case 5 -> gameDataBase.addComputerMoveInThisRound(new Lizard());
        }
    }

    private boolean computerHardModeDidHeDraw() {
        return getComputerMove() <= getValueHowBigChanceComputerHasToDrawInPercent();
    }

    private boolean computerHardModeDidHeWin() {
        return getComputerMove() > getValueHowBigChanceComputerHasToDrawInPercent() &&
                getComputerMove() <= (getValueHowBigChanceComputerHasToDrawInPercent() + getValueHowBigChanceComputerHasToWinInPercent());
    }

    private boolean computerHardModeDidHeLose() {
        return getComputerMove() > (getValueHowBigChanceComputerHasToDrawInPercent() + getValueHowBigChanceComputerHasToWinInPercent());
    }

    private String resultOfComputerMove() {
        giveRandomNumberFrom1To100();
        if (computerHardModeDidHeDraw()) {
            return "Draw";
        }
        if (computerHardModeDidHeWin()) {
            return "Win";
        }
        if (computerHardModeDidHeLose()) {
            return "Lose";
        }
        return "Stop";
    }

    private void setWinMoveForComputerForRockLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Paper());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Spock());
        }
    }

    private void setLoseMoveForComputerForRockLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Scissors());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Lizard());
        }
    }

    private void computerHardModeMakesMoveVsRock(GameDataBase gameDataBase) {
        String s = resultOfComputerMove();
        switch (s) {
            case "Win" -> setWinMoveForComputerForRockLogic(gameDataBase);
            case "Lose" -> setLoseMoveForComputerForRockLogic(gameDataBase);
            case "Draw" -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void setWinMoveForComputerForPaperLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Scissors());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Lizard());
        }
    }

    private void setLoseMoveForComputerForPaperLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Rock());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Spock());
        }
    }

    private void computerHardModeMakesMoveVsPaper(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> setWinMoveForComputerForPaperLogic(gameDataBase);
            case "Lose" -> setLoseMoveForComputerForPaperLogic(gameDataBase);
            case "Draw" -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void setWinMoveForComputerForScissorsLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Rock());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Spock());
        }
    }

    private void setLoseMoveForComputerForScissorsLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Paper());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Lizard());
        }
    }

    private void computerHardModeMakesMoveVsScissors(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> setWinMoveForComputerForScissorsLogic(gameDataBase);
            case "Lose" -> setLoseMoveForComputerForScissorsLogic(gameDataBase);
            case "Draw" -> gameDataBase.addComputerMoveInThisRound(new Scissors());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void setWinMoveForComputerForSpockLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Paper());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Lizard());
        }
    }

    private void setLoseMoveForComputerForSpockLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Rock());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Scissors());
        }
    }

    private void computerHardModeMakesMoveVsSpock(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> setWinMoveForComputerForSpockLogic(gameDataBase);
            case "Lose" -> setLoseMoveForComputerForSpockLogic(gameDataBase);
            case "Draw" -> gameDataBase.addComputerMoveInThisRound(new Spock());
            case "Stop" -> System.out.println("Cos poszlo nie tak i wartosc " + computerMove + " jest spoza 1 do 100 ");
        }
    }

    private void setWinMoveForComputerForLizardLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Rock());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Scissors());
        }
    }

    private void setLoseMoveForComputerForLizardLogic(GameDataBase gameDataBase) {
        if (random.nextInt(2) == 0) {
            gameDataBase.addComputerMoveInThisRound(new Paper());
        } else {
            gameDataBase.addComputerMoveInThisRound(new Spock());
        }
    }

    private void computerHardModeMakesMoveVsLizard(GameDataBase gameDataBase) {
        switch (resultOfComputerMove()) {
            case "Win" -> setWinMoveForComputerForLizardLogic(gameDataBase);
            case "Lose" -> setLoseMoveForComputerForLizardLogic(gameDataBase);
            case "Draw" -> gameDataBase.addComputerMoveInThisRound(new Lizard());
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

    public void computerHardModeMakesMoveVsSpock(boolean hardMode, GameDataBase gameDataBase) {
        if (hardMode) {
            computerHardModeMakesMoveVsSpock(gameDataBase);
        } else {
            computerEasyModeMakesMove(gameDataBase);
        }
    }

    public void decideWithComputerModeUseForLizardLogic(boolean hardMode, GameDataBase gameDataBase) {
        if (hardMode) {
            computerHardModeMakesMoveVsLizard(gameDataBase);
        } else {
            computerEasyModeMakesMove(gameDataBase);
        }
    }

}
