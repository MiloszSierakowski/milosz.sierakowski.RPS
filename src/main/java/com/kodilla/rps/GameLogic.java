package com.kodilla.rps;

import com.kodilla.rps.moves.*;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private final GameDataBase gameDataBase;

    public GameLogic(GameDataBase gameDataBase) {
        this.gameDataBase = gameDataBase;
    }

    public void whatOptionUserChooseAndDecideWhatToDo() {
        String s = gameDataBase.getOptionThatUserChoose();
        switch (s) {
            case "1" -> gameDataBase.addUserMoveInThisRound(new Rock());
            case "2" -> gameDataBase.addUserMoveInThisRound(new Paper());
            case "3" -> gameDataBase.addUserMoveInThisRound(new Scissors());
            case "x" -> printMessageToUserAndMakeActionDependsIfHeWantsEndTheGameOrNo();
            case "n" -> printMessageToUserAndMakeActionDependsIfHeWantsResetTheGameOrNo();
        }
    }

    public void printMessageToUserAndMakeActionDependsIfHeWantsEndTheGameOrNo() {
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")) {
            GameGui.whenUserChooseYesToEndGame();
            gameDataBase.setEndGame(true);
            gameDataBase.setResetGame(true);
        } else {
            GameGui.whenUserChooseNoToEndGame();
        }
    }

    public void printMessageToUserAndMakeActionDependsIfHeWantsResetTheGameOrNo() {
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")) {
            GameGui.whenUserChooseYesToResetTheGame();
            gameDataBase.setResetGame(true);
        } else {
            GameGui.whenUserChooseNoToResetTheGame();
        }
    }

    private void computerMakesMove() {
        Random random = new Random();
        int computerMove = random.nextInt(3) + 1;
        switch (computerMove) {
            case 1 -> gameDataBase.addComputerMoveInThisRound(new Rock());
            case 2 -> gameDataBase.addComputerMoveInThisRound(new Paper());
            case 3 -> gameDataBase.addComputerMoveInThisRound(new Scissors());
        }
    }

    private String takeComputerMove() {
        computerMakesMove();
        List<GameFigures> listWithComputerMovements = gameDataBase.getRecordOfAllComputerRounds();
        int actualRound = gameDataBase.getCurrentRound();
        return listWithComputerMovements.get(actualRound).getClass().getSimpleName();
    }

    private String takeUserMove() {
        List<GameFigures> listWithUserMovements = gameDataBase.getRecordOfAllUserRounds();
        int actualRound = gameDataBase.getCurrentRound();
        return listWithUserMovements.get(actualRound).getClass().getSimpleName();
    }

    private void logicForRockClass() {
        String s = takeComputerMove();
        switch (s) {
            case "Rock" -> GameGui.whenIsDraw(s);
            case "Paper" -> {
                gameDataBase.setCounterOfComputerWins();
                GameGui.whenIsComputerWin(s);
            }
            case "Scissors" -> {
                gameDataBase.setCounterOfUserWins();
                GameGui.whenIsComputerLose(s);
            }
        }
    }

    private void logicForPaperClass() {
        String s = takeComputerMove();
        switch (s) {
            case "Paper" -> GameGui.whenIsDraw(s);
            case "Scissors" -> {
                gameDataBase.setCounterOfComputerWins();
                GameGui.whenIsComputerWin(s);
            }
            case "Rock" -> {
                gameDataBase.setCounterOfUserWins();
                GameGui.whenIsComputerLose(s);
            }
        }
    }

    private void logicForScissorsClass() {
        String s = takeComputerMove();
        switch (s) {
            case "Paper" -> {
                gameDataBase.setCounterOfUserWins();
                GameGui.whenIsComputerLose(s);
            }
            case "Scissors" -> GameGui.whenIsDraw(s);
            case "Rock" -> {
                gameDataBase.setCounterOfComputerWins();
                GameGui.whenIsComputerWin(s);
            }
        }
    }

    private void takeUserMovementInThisRoundAndPassItFurther() {
        String s = takeUserMove();
        GameGui.infoWhatUserChoose(s, gameDataBase);
        switch (s) {
            case "Rock" -> logicForRockClass();
            case "Paper" -> logicForPaperClass();
            case "Scissors" -> logicForScissorsClass();
        }
    }

    private void runTheProgramIfValueIsNotNull(){
        if (!gameDataBase.getRecordOfAllUserRounds().isEmpty()){
            takeUserMovementInThisRoundAndPassItFurther();
            GameGui.resultOfRound(gameDataBase);
            gameDataBase.setCurrentRound();
            GameGui.infoAboutNumberCurrentRound(gameDataBase);
        }
    }

    public void resultOfRoundAndGoToNextRound() {
        runTheProgramIfValueIsNotNull();
    }

}
