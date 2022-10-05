package com.kodilla.rps;

import com.kodilla.rps.gameLogic.GameLogic;

public class RpsRunner {
    public static void main(String[] args) {
        boolean endGame;
        do {
            GameDataBase gameDataBase = new GameDataBase();
            GameGui gameGui = new GameGui(gameDataBase);
            GameLogic gameLogic = new GameLogic(gameDataBase);

            gameGui.initialMessageAndSaveUserNameInDataBase();
            gameGui.SecondInitialMessageWhereGreetingsUserAndSaveNumberOfNecessarySmallWinsToWinTheGameInDataBase();
            gameGui.userOptionsExplanation();

            do {

                gameGui.getUserSelection();
                gameGui.ifTheUserChooseNOrXAskHimToAcceptTheChoice();
                gameLogic.whatOptionUserChooseAndDecideWhatToDo();
                gameLogic.resultOfRoundAndGoToNextRound();
                gameLogic.checkIfIsNotEndOfGame();
                gameGui.infoAboutNumberCurrentRound();

            } while (!gameDataBase.isResetGame());

            do {
                gameGui.finalMassageOrNot();
                gameLogic.checkWhatUserWhatToDoAfterEndOfGame();
                endGame = gameDataBase.isEndGame();
            } while (!gameDataBase.isAfterChooseNAndGameIsEnd());

        } while (!endGame);

        System.out.println("Dzieki za gre ");

    }
}
