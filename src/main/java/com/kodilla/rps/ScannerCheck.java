package com.kodilla.rps;

import java.util.Scanner;

public class ScannerCheck {
    private Scanner scanner = new Scanner(System.in);
    private String savedStringFromKeyboardUsedLikeNumberOfWins = "";
    private String savedStringFromKeyboardLikeUserName = "";
    private int realValue = 0;

    public int getRealValue() {
        return realValue;
    }

    public String getsavedStringFromKeyboardLikeUserName() {
        return savedStringFromKeyboardLikeUserName;
    }

    public String getSavedStringFromKeyboardUsedLikeNumberOfWins() {
        return savedStringFromKeyboardUsedLikeNumberOfWins;
    }

    public void setRealValue(int realValue) {
        this.realValue = realValue;
    }

    public void setSavedStringFromKeyboardUsedLikeNumberOfWins() {
        this.savedStringFromKeyboardUsedLikeNumberOfWins = scanner.nextLine();
    }

    public void setSavedStringFromKeyboardUsedLikeNumberOfWins(String string) {
        this.savedStringFromKeyboardUsedLikeNumberOfWins = string;
    }

    public void setsavedStringFromKeyboardLikeUserName() {
        this.savedStringFromKeyboardLikeUserName = scanner.nextLine();
    }

    public String takeUserName() {
        setsavedStringFromKeyboardLikeUserName();
        return getsavedStringFromKeyboardLikeUserName();
    }

    public void checkIfNumberOfWinsIsInt() throws KeyboardInputUnexpectedValueException {
        try {
            String testedString = getSavedStringFromKeyboardUsedLikeNumberOfWins();
            setRealValue(Integer.parseInt(testedString));
        } catch (NumberFormatException e) {
            throw new KeyboardInputUnexpectedValueException("Wpisana wartosc nie jest liczba ");
        }
    }

    public void checkIfNumberOfWinsIsBigerThat0() throws KeyboardInputUnexpectedValueException {
        if (getRealValue() <= 0) {
            throw new KeyboardInputUnexpectedValueException("Wartosc zwyciestw jest zero albo mniejsza od zera a tak nie mozna ");
        }
    }

    public boolean checkAllConditionForNumberOfWinRoundsToWinTheGame() {
        boolean allConditionsOK = true;

        try {
            checkIfNumberOfWinsIsInt();
        } catch (KeyboardInputUnexpectedValueException e) {
            allConditionsOK = false;
            System.out.println("Podana wartosc to nie liczba prosze sprobowac jeszcze raz ");
        }

        if (allConditionsOK) {
            try {
                checkIfNumberOfWinsIsBigerThat0();
            } catch (KeyboardInputUnexpectedValueException k) {
                allConditionsOK = false;
                System.out.println("Wpisana liczba zwyciestw musi byc wieksza niz 0 prosze sprubowac jeszcze raz ");
            }
        }

        return allConditionsOK;
    }

    public int takeNumberOfWinsAndGiveItToGameGui() {
        int numberOfWinsNesessaryToWin = 0;
        boolean goodValue;

        do {
            setSavedStringFromKeyboardUsedLikeNumberOfWins();
            goodValue = checkAllConditionForNumberOfWinRoundsToWinTheGame();
        } while (!goodValue);

        return numberOfWinsNesessaryToWin;
    }

}
