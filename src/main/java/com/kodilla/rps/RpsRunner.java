package com.kodilla.rps;

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

                endGame = gameDataBase.isEndGame();
            } while (!gameDataBase.isResetGame());

        } while (!endGame);

        System.out.println("Dzieki za gre ");

    }
}
