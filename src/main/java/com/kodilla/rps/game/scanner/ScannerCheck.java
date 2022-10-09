package com.kodilla.rps.game.scanner;

import java.util.Scanner;

public class ScannerCheck {
    private final Scanner scanner = new Scanner(System.in);
    private String finalNumberWinRoundsToWinGameBeforeChecks = "";
    private String savedStringFromKeyboardLikeUserName = "";
    private int finalNumberWinRoundsToWinGame = 0;
    private String optionThatTheUserChooses = "";
    private String yOrNThatTheUserChoosesForEndTheGameOrRestart = "";

    public int getFinalNumberWinRoundsToWinGame() {
        return finalNumberWinRoundsToWinGame;
    }

    public String getSavedStringFromKeyboardLikeUserName() {
        return savedStringFromKeyboardLikeUserName;
    }

    public String getFinalNumberWinRoundsToWinGameBeforeChecks() {
        return finalNumberWinRoundsToWinGameBeforeChecks;
    }

    public String getOptionThatTheUserChooses() {
        return optionThatTheUserChooses;
    }

    public String getYOrNThatTheUserChoosesForEndTheGameOrRestart() {
        return yOrNThatTheUserChoosesForEndTheGameOrRestart;
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

    private void setSavedStringFromKeyboardLikeUserName() {
        this.savedStringFromKeyboardLikeUserName = scanner.nextLine();
    }

    public String takeUserName() {
        setSavedStringFromKeyboardLikeUserName();
        return getSavedStringFromKeyboardLikeUserName();
    }

    public boolean checkThatTheNumberOfWinsIsInt() {
        String temporaryString = getFinalNumberWinRoundsToWinGameBeforeChecks();
        return temporaryString.matches("[0-9]+");
    }

    public void changeFinalNumberWinRoundsToWinGameBeforeChecksToFinalNumberWinRoundsToWinGame() {
        setFinalNumberWinRoundsToWinGame(Integer.parseInt(getFinalNumberWinRoundsToWinGameBeforeChecks()));
    }

    public boolean checkIfNumberOfWinsIsBiggerThat0() {
        return getFinalNumberWinRoundsToWinGame() > 0;
    }

    public boolean checkAllConditionForNumberOfWinRoundsToWinTheGame() {
        if (checkThatTheNumberOfWinsIsInt()) {
            changeFinalNumberWinRoundsToWinGameBeforeChecksToFinalNumberWinRoundsToWinGame();
            if (!checkIfNumberOfWinsIsBiggerThat0()) {
                System.out.println("Podana liczba wygranych rund musi byc wieksza niz 0 prosze sprubuj ponownie ");
                return false;
            }
        } else {
            System.out.println("Wpisana wartosc moze posiadac tylko liczby prosze sprubowac ponownie ");
            return false;
        }
        return true;
    }

    public int takeNumberOfWinsAndGiveItToGameGui() {
        do {
            setFinalNumberWinRoundsToWinGameBeforeChecks();
        } while (!checkAllConditionForNumberOfWinRoundsToWinTheGame());

        return getFinalNumberWinRoundsToWinGame();
    }

    private void setOptionThatTheUserChooses() {
        this.optionThatTheUserChooses = scanner.nextLine();
    }

    public void setOptionThatTheUserChooses(String optionThatTheUserChooses) {
        this.optionThatTheUserChooses = optionThatTheUserChooses;
    }

    private void setYOrNThatTheUserChoosesForEndTheGameOrRestart() {
        this.yOrNThatTheUserChoosesForEndTheGameOrRestart = scanner.nextLine();
    }

    public void setYOrNThatTheUserChoosesForEndTheGameOrRestart(String tOrNThatTheUserChoosesForEndTheGameOrRestart) {
        this.yOrNThatTheUserChoosesForEndTheGameOrRestart = tOrNThatTheUserChoosesForEndTheGameOrRestart;
    }

    public boolean checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter() {
        return getOptionThatTheUserChooses().length() == 1;
    }

    public boolean ifTheUserChoosesIsIntFrom1To5() {
        return getOptionThatTheUserChooses().matches("[1-5]");
    }

    public boolean ifTheUserChoosesIsXOrN() {
        return getOptionThatTheUserChooses().matches("[xnXN]");
    }

    public boolean allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses() {
        if (checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter()) {
            if (!ifTheUserChoosesIsIntFrom1To5() && !ifTheUserChoosesIsXOrN()) {
                System.out.println("Wprowadzona opcja jest nie prawidlowa prosze sprubowac ponownie ");
                return false;
            }
        } else {
            System.out.println("Wprowadzona opcja jest nie prawidlowa sklada sie z wiecej niz jednego zanku prosze to poprawic");
            return false;
        }
        return true;
    }

    public String takeOptionThatTheUserChoosesAndGiveItToGui() {
        do {
            setOptionThatTheUserChooses();
        } while (!allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses());
        return getOptionThatTheUserChooses();
    }

    public boolean checkIfSizeTheUserChoosesIsYOrNHasOnlyOneLetter() {
        return getYOrNThatTheUserChoosesForEndTheGameOrRestart().length() == 1;
    }

    public boolean ifTheUserChoosesIsYOrN() {
        return getYOrNThatTheUserChoosesForEndTheGameOrRestart().matches("[ynYN]");
    }

    public boolean allConditionsAndFinalResultOfTheUserChoosesIsYOrN() {
        if (checkIfSizeTheUserChoosesIsYOrNHasOnlyOneLetter()) {
            if (!ifTheUserChoosesIsYOrN()) {
                System.out.println("Wprowadzona odpowiedz to nie jest litera Y lub N prosze o poprawienie ");
                return false;
            }
        } else {
            System.out.println("Zostalo wpisanych za duzo znakow prosze powtorzyc ");
            return false;
        }
        return true;
    }

    public String takeTheUserChoosesIsYOrNAndGiveItToGui() {
        do {
            setYOrNThatTheUserChoosesForEndTheGameOrRestart();
        } while (!allConditionsAndFinalResultOfTheUserChoosesIsYOrN());
        return getYOrNThatTheUserChoosesForEndTheGameOrRestart();
    }

    public boolean allConditionsAndFinalResultOfWhatUserChooseAtEndOfGame() {
        if (checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter()) {
            if (!ifTheUserChoosesIsXOrN()) {
                System.out.println("Wprowadzona opcja jest nie prawidlowa prosze sprubowac ponownie ");
                return false;
            }
        } else {
            System.out.println("Wprowadzona opcja jest nie prawidlowa sklada sie z wiecej niz jednego zanku prosze to poprawic");
            return false;
        }
        return true;
    }

    public String takeOptionWhatUserChooseAtEndOfGameAndGiveItToGui() {
        do {
            setOptionThatTheUserChooses();
        } while (!allConditionsAndFinalResultOfWhatUserChooseAtEndOfGame());
        return getOptionThatTheUserChooses();
    }
}
