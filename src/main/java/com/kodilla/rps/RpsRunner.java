package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        GameDataBase gameDataBase = new GameDataBase();
        GameGui gameGui = new GameGui(gameDataBase);
        GameLogic gameLogic = new GameLogic(gameDataBase);

        gameGui.initialMessageAndSaveUserNameInDataBase();
        gameGui.SecondInitialMessageWhereGreetingsUserAndSaveNumberOfNecessarySmallWinsToWinTheGameInDataBase();
        gameGui.userOptionsExplanation();
        gameGui.getUserSelection();

        gameDataBase.setEndGame(true);

        do {







        } while (!gameDataBase.isEndGame());

    }
}
