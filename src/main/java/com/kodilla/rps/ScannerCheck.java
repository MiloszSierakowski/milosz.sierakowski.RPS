package com.kodilla.rps;

import java.util.Scanner;

public class ScannerCheck {
    private Scanner scanner = new Scanner(System.in);
    private String finalNumberWinRoundsToWinGameBeforeChecks = "";
    private String savedStringFromKeyboardLikeUserName = "";
    private int finalNumberWinRoundsToWinGame = 0;
    private String optionThatTheUserChooses = "";


    public int getFinalNumberWinRoundsToWinGame() {
        return finalNumberWinRoundsToWinGame;
    }

    public String getsavedStringFromKeyboardLikeUserName() {
        return savedStringFromKeyboardLikeUserName;
    }

    public String getFinalNumberWinRoundsToWinGameBeforeChecks() {
        return finalNumberWinRoundsToWinGameBeforeChecks;
    }

    public String getOptionThatTheUserChooses() {
        return optionThatTheUserChooses;
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
        boolean goodValue;

        do {
            setFinalNumberWinRoundsToWinGameBeforeChecks();
            goodValue = checkAllConditionForNumberOfWinRoundsToWinTheGame();
        } while (!goodValue);

        return getFinalNumberWinRoundsToWinGame();
    }

    private void setOptionThatTheUserChooses() {
        this.optionThatTheUserChooses = scanner.nextLine();
    }

    public void setOptionThatTheUserChooses(String optionThatTheUserChooses) {
        this.optionThatTheUserChooses = optionThatTheUserChooses;
    }

    public boolean checkedIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter() {
        return getOptionThatTheUserChooses().length() == 1;
    }

    public boolean ifTheValueOptionThatTheUserChoosesIsIntFrom1To3() {
        return getOptionThatTheUserChooses().matches("[1-3]");
    }

    public boolean ifTheValueOptionThatTheUserChoosesIsXOrN() {
        return getOptionThatTheUserChooses().matches("[xnXN]");
    }

    public boolean allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses() {
        boolean isOk = true;
        if (checkedIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter()) {
            if (!ifTheValueOptionThatTheUserChoosesIsIntFrom1To3() && !ifTheValueOptionThatTheUserChoosesIsXOrN()) {
                System.out.println("Wprowadzona opcja jest nie prawidlowa prosze sprubowac ponownie ");
                isOk = false;
            }
        } else {
            System.out.println("Wprowadzona opcja jest nie praqwidlowa sklada sie z wiecej niz jednego zanku prosze to poprawic");
            isOk = false;
        }
        return isOk;
    }

    public String takeOptionThatTheUserChoosesAndGiveItToGui() {
        do {
            setOptionThatTheUserChooses();
        } while (!allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses());
        return getOptionThatTheUserChooses();
    }

}
