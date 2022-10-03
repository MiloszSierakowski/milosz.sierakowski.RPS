package com.kodilla.rps;

public class GameLogic {
    private final GameDataBase gameDataBase;
    private final GameGui gameGui;

    public GameLogic(GameDataBase gameDataBase, GameGui gameGui) {
        this.gameDataBase = gameDataBase;
        this.gameGui = gameGui;
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

    public void printMessageToUserAndMakeActionDependsIfHeWantsEndTheGameOrNo(){
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")){
            gameGui.whenUserChooseYesToEndGame();
            gameDataBase.setEndGame(true);
            gameDataBase.setResetGame(true);
        }else {
            gameGui.whenUserChooseNoToEndGame();
        }
    }

    public void printMessageToUserAndMakeActionDependsIfHeWantsResetTheGameOrNo(){
        if (gameDataBase.getTheUserChoosesIsYOrN().contains("y")){
            gameGui.whenUserChooseYesToResetTheGame();
            gameDataBase.setResetGame(true);
        }else {
            gameGui.whenUserChooseNoToResetTheGame();
        }
    }

}
