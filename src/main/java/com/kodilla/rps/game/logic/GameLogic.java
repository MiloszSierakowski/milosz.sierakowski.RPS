package com.kodilla.rps.game.logic;

import com.kodilla.rps.game.database.GameDataBase;
import com.kodilla.rps.game.gui.GameGui;
import com.kodilla.rps.moves.*;

import java.util.List;

public class GameLogic {
    private final GameDataBase gameDataBase;
    private boolean hardMode = true;

    public boolean isHardMode() {
        return hardMode;
    }

    private final ComputerHardModeOrEasy computerHardModeOrEasy;

    public GameLogic(GameDataBase gameDataBase) {
        this.gameDataBase = gameDataBase;
        this.computerHardModeOrEasy = new ComputerHardModeOrEasy();
    }

    public GameLogic(GameDataBase gameDataBase, ComputerHardModeOrEasy computerHardModeOrEasy) {
        this.gameDataBase = gameDataBase;
        this.computerHardModeOrEasy = computerHardModeOrEasy;
    }


    private boolean ifOptionUserChooseIsEmptyOrNull() {
        return !gameDataBase.getOptionThatUserChoose().isEmpty() && gameDataBase.getOptionThatUserChoose() != null;
    }

    public void whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic() {
        gameDataBase.setAllowToRunLogicOfRoundWin(true);
        if (ifOptionUserChooseIsEmptyOrNull()) {
            String s = gameDataBase.getOptionThatUserChoose();
            switch (s) {
                case "1" -> gameDataBase.addUserMoveInThisRound(new Rock());
                case "2" -> gameDataBase.addUserMoveInThisRound(new Paper());
                case "3" -> gameDataBase.addUserMoveInThisRound(new Scissors());
                case "4" -> gameDataBase.addUserMoveInThisRound(new Spock());
                case "5" -> gameDataBase.addUserMoveInThisRound(new Lizard());
                case "x" -> printMessageToUserAndMakeActionDependsIfHeWantsEndTheGameOrNo();
                case "n" -> printMessageToUserAndMakeActionDependsIfHeWantsResetTheGameOrNo();
            }
        }
    }

    private void printMessageToUserAndMakeActionDependsIfHeWantsEndTheGameOrNo() {
        gameDataBase.setAllowToRunLogicOfRoundWin(false);
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")) {
            GameGui.whenUserChooseYesToEndGame();
            gameDataBase.setEndGame(true);
            gameDataBase.setResetGame(true);
            gameDataBase.setAfterChooseNoAndGameIsEnd(true);
        } else {
            GameGui.whenUserChooseDoNotResetTheGameOrDoNotEndTheGame(gameDataBase);
        }
    }

    private void printMessageToUserAndMakeActionDependsIfHeWantsResetTheGameOrNo() {
        gameDataBase.setAllowToRunLogicOfRoundWin(false);
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")) {
            GameGui.whenUserChooseYesToResetTheGame();
            gameDataBase.setResetGame(true);
            gameDataBase.setAfterChooseNoAndGameIsEnd(true);
        } else {
            GameGui.whenUserChooseDoNotResetTheGameOrDoNotEndTheGame(gameDataBase);
        }
    }

    private boolean checkIfRecordOfAllComputerRoundsIsEmptyOrInActualRoundIsNull(int actualRound) {
        return !gameDataBase.getRecordOfAllComputerRounds().isEmpty() && gameDataBase.getRecordOfAllComputerRounds().get(actualRound) != null;
    }

    private String takeComputerMove() {
        int actualRound = gameDataBase.getCurrentRound();
        if (checkIfRecordOfAllComputerRoundsIsEmptyOrInActualRoundIsNull(actualRound)) {
            List<GameFigures> listWithComputerMovements = gameDataBase.getRecordOfAllComputerRounds();
            return listWithComputerMovements.get(actualRound).getName();
        } else return "List is empty or in actual round computer move is null";
    }

    private boolean checkIfRecordOfAllUserRoundsIsEmptyOrInActualRoundIsNull(int actualRound) {
        return !gameDataBase.getRecordOfAllUserRounds().isEmpty() && gameDataBase.getRecordOfAllUserRounds().get(actualRound) != null;
    }

    private String takeUserMove() {
        int actualRound = gameDataBase.getCurrentRound();
        if (checkIfRecordOfAllUserRoundsIsEmptyOrInActualRoundIsNull(actualRound)) {
            List<GameFigures> listWithUserMovements = gameDataBase.getRecordOfAllUserRounds();
            return listWithUserMovements.get(actualRound).getName();
        } else return "List is empty or in actual round computer move is null";
    }

    private void setWinRoundForComputer(String s) {
        gameDataBase.setCounterOfComputerWins();
        GameGui.whenIsComputerWin(s);
    }

    private void setWinRoundForUser(String s) {
        gameDataBase.setCounterOfUserWins();
        GameGui.whenIsComputerLose(s);
    }

    private void logicForRock() {
        computerHardModeOrEasy.decideWithComputerModeUseForRockLogic(isHardMode(), gameDataBase);
        String s = takeComputerMove();
        switch (s) {
            case "Kamien" -> GameGui.whenIsDraw(s);
            case "Papier", "Spock" -> setWinRoundForComputer(s);
            case "Nozyczki", "Jaszczurka" -> setWinRoundForUser(s);
        }
    }

    private void logicForPaper() {
        computerHardModeOrEasy.decideWithComputerModeUseForPaperLogic(isHardMode(), gameDataBase);
        String s = takeComputerMove();
        switch (s) {
            case "Papier" -> GameGui.whenIsDraw(s);
            case "Nozyczki", "Jaszczurka" -> setWinRoundForComputer(s);
            case "Kamien", "Spock" -> setWinRoundForUser(s);
        }
    }

    private void logicForScissors() {
        computerHardModeOrEasy.decideWithComputerModeUseForScissorsLogic(isHardMode(), gameDataBase);
        String s = takeComputerMove();
        switch (s) {
            case "Nozyczki" -> GameGui.whenIsDraw(s);
            case "Kamien", "Spock" -> setWinRoundForComputer(s);
            case "Papier", "Jaszczurka" -> setWinRoundForUser(s);
        }
    }

    private void logicForSpock() {
        computerHardModeOrEasy.computerHardModeMakesMoveVsSpock(isHardMode(), gameDataBase);
        String s = takeComputerMove();
        switch (s) {
            case "Spock" -> GameGui.whenIsDraw(s);
            case "Papier", "Jaszczurka" -> setWinRoundForComputer(s);
            case "Kamien", "Nozyczki" -> setWinRoundForUser(s);
        }
    }

    private void logicForLizard() {
        computerHardModeOrEasy.decideWithComputerModeUseForLizardLogic(isHardMode(), gameDataBase);
        String s = takeComputerMove();
        switch (s) {
            case "Jaszczurka" -> GameGui.whenIsDraw(s);
            case "Kamien", "Nozyczki" -> setWinRoundForComputer(s);
            case "Papier", "Spock" -> setWinRoundForUser(s);
        }
    }

    private void takeUserMovementInThisRoundAndPassItFurther() {
        String s = takeUserMove();
        GameGui.infoWhatUserChoose(s, gameDataBase);
        switch (s) {
            case "Kamien" -> logicForRock();
            case "Papier" -> logicForPaper();
            case "Nozyczki" -> logicForScissors();
            case "Spock" -> logicForSpock();
            case "Jaszczurka" -> logicForLizard();
        }
    }

    private void runTheLogicResponsibleForCheckingWhoWonTheRoundIfGameAllowToRunLogic() {
        if (gameDataBase.isAllowToRunLogicOfRoundWin()) {
            takeUserMovementInThisRoundAndPassItFurther();
            GameGui.resultOfRound(gameDataBase);
            gameDataBase.setCurrentRound();
        }
    }

    public void resultOfRoundAndGoToNextRound() {
        runTheLogicResponsibleForCheckingWhoWonTheRoundIfGameAllowToRunLogic();
    }

    public void checkIfIsNotEndOfGame() {
        int endGame = gameDataBase.getNumberOfSmallWinsToWinTheGame();
        int userWin = gameDataBase.getCounterOfUserWins();
        int computerWin = gameDataBase.getCounterOfComputerWins();
        setEndTheGameIfThisIsTheEnd(endGame, userWin, computerWin);
    }

    private boolean playerWinTheGame(int endGame, int userWin) {
        if (endGame == userWin) {
            GameGui.userWinTheGame(gameDataBase);
            return true;
        }
        return false;
    }

    private boolean computerWinTheGame(int endGame, int computerWins) {
        if (endGame == computerWins) {
            GameGui.computerWinTheGame(gameDataBase);
            return true;
        }
        return false;
    }

    private void setEndTheGameIfThisIsTheEnd(int endGame, int userWin, int computerWins) {
        if (playerWinTheGame(endGame, userWin)) {
            gameDataBase.setResetGame(true);
        }
        if (computerWinTheGame(endGame, computerWins)) {
            gameDataBase.setResetGame(true);
        }
    }

    public void checkWhatUserWhatToDoAfterEndOfGame() {
        if (!gameDataBase.isEndGame() && gameDataBase.isResetGame()) {
            whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
        }
    }
}
