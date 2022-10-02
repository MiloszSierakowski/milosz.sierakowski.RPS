package com.kodilla.rps;

import java.util.Scanner;

public class ScannerCheck {
    private Scanner scanner = new Scanner(System.in);
    private String finalNumberWinRoundsToWinGameBeforeChecks = "";
    private String savedStringFromKeyboardLikeUserName = "";
    private int finalNumberWinRoundsToWinGame = 0;

    private String optionThatTheUserChoosesBeforeChecks = "";

    public int getFinalNumberWinRoundsToWinGame() {
        return finalNumberWinRoundsToWinGame;
    }

    public String getsavedStringFromKeyboardLikeUserName() {
        return savedStringFromKeyboardLikeUserName;
    }

    public String getFinalNumberWinRoundsToWinGameBeforeChecks() {
        return finalNumberWinRoundsToWinGameBeforeChecks;
    }

    public String getOptionThatTheUserChoosesBeforeChecks() {
        return optionThatTheUserChoosesBeforeChecks;
    }

    public void setFinalNumberWinRoundsToWinGame(int finalNumberWinRoundsToWinGame) {
        this.finalNumberWinRoundsToWinGame = finalNumberWinRoundsToWinGame;
    }

    private void setFinalNumberWinRoundsToWinGameBeforeChecks() {
        this.finalNumberWinRoundsToWinGameBeforeChecks = scanner.nextLine();
    }

    public void setFinalNumberWinRoundsToWinGameBeforeChecks(String string) {
        this.finalNumberWinRoundsToWinGameBeforeChecks = string;
    }

    private void setsavedStringFromKeyboardLikeUserName() {
        this.savedStringFromKeyboardLikeUserName = scanner.nextLine();
    }

    public String takeUserName() {
        setsavedStringFromKeyboardLikeUserName();
        return getsavedStringFromKeyboardLikeUserName();
    }

    public boolean checkThatTheNumberOfWinsIsInt() {
        String temporaryString = getFinalNumberWinRoundsToWinGameBeforeChecks();
        return temporaryString.matches("[0-9]+");
    }

    public void changefinalNumberWinRoundsToWinGameBeforeChecksTofinalNumberWinRoundsToWinGame() {
            setFinalNumberWinRoundsToWinGame(Integer.parseInt(getFinalNumberWinRoundsToWinGameBeforeChecks()));
    }

    public boolean checkIfNumberOfWinsIsBigerThat0() {
        return getFinalNumberWinRoundsToWinGame() > 0;
    }

    public boolean checkAllConditionForNumberOfWinRoundsToWinTheGame() {
        boolean allConditionsOK = checkThatTheNumberOfWinsIsInt();

        if (allConditionsOK) {
            changefinalNumberWinRoundsToWinGameBeforeChecksTofinalNumberWinRoundsToWinGame();

            if (!checkIfNumberOfWinsIsBigerThat0()) {
                System.out.println("Podana liczba wygranych rund musi byc wieksza niz 0 prosze sprubuj ponownie ");
                allConditionsOK = false;
            }

        } else {
            System.out.println("Wpisana wartość moze posiadac tylko liczby prosze sprubowac ponownie ");
        }

        return allConditionsOK;
    }

    public int takeNumberOfWinsAndGiveItToGameGui() {
        int numberOfWinsNesessaryToWin = 0;
        boolean goodValue;

        do {
            setFinalNumberWinRoundsToWinGameBeforeChecks();
            goodValue = checkAllConditionForNumberOfWinRoundsToWinTheGame();
        } while (!goodValue);

        return numberOfWinsNesessaryToWin;
    }

    private void setOptionThatTheUserChoosesBeforeChecks() {
        this.optionThatTheUserChoosesBeforeChecks = scanner.nextLine();
    }

    public void setOptionThatTheUserChoosesBeforeChecks(String optionThatTheUserChoosesBeforeChecks) {
        this.optionThatTheUserChoosesBeforeChecks = optionThatTheUserChoosesBeforeChecks;
    }

    public boolean IfTheValueOptionThatTheUserChoosesBeforeChecksIsInt()  {
        boolean isOk = true;


        return isOk;
    }
}
