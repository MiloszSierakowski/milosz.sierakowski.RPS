package com.kodilla.rps.game.gui;

import com.kodilla.rps.game.scanner.ScannerCheck;
import com.kodilla.rps.User;
import com.kodilla.rps.game.database.GameDataBase;

public class GameGui {
    private final GameDataBase gameDataBase;
    private final ScannerCheck scannerCheck = new ScannerCheck();

    public GameGui(GameDataBase gameDataBase) {
        this.gameDataBase = gameDataBase;
    }

    public void initialMessageAndSaveUserNameInDataBase() {
        System.out.println("Witam w grze Kamien-papier-norzyce przed rozpoczeciem gry prosze podac imie: ");
        String name = scannerCheck.takeUserName();
        gameDataBase.setUser(new User(name));
    }

    public void SecondInitialMessageWhereGreetingsUserAndSaveNumberOfNecessarySmallWinsToWinTheGameInDataBase() {
        System.out.println("Witam tym razem bardziej oficjalnie " + gameDataBase.getUser().getName() +
                " w naszej grze. Mam ostatnia prosbe przed rozpoczeciem gry podaj do ilu zwyciestw chcesz grac ");
        int numberOfWinRoundsToWinTheGame = scannerCheck.takeNumberOfWinsAndGiveItToGameGui();
        gameDataBase.setNumberOfSmallWinsToWinTheGame(numberOfWinRoundsToWinTheGame);
    }

    public void userOptionsExplanation() {
        System.out.println("Dobrze wiec czas na rozpoczecie gry, ale wyjasnijmy szybko zasady, wiec mozesz wybrac jedna z opcji \n" +
                "klawisz 1 - zagranie \"kamien\",\n" +
                "klawisz 2 - zagranie \"papier\",\n" +
                "klawisz 3 - zagranie \"nozyce\",\n" +
                "klawisz 4 - zagranie \"spock\",\n" +
                "klawisz 5 - zagranie \"jaszczurka\",\n" +
                "klawisz x - zakonczenie gry , \n" +
                "klawisz n - uruchomienie gry od nowa\n ");
        additionalExplanationHowToWinRound();
    }

    public void additionalExplanationHowToWinRound(){
        System.out.println("Z racji tego ze gra posiada pare dodatkowych zagran uznalismy ze stosownym bedzie je wszystkie wytlumaczyc \n " +
         "wiec wybor danego ruchu skutkuje: \n kamieni -> WYGRYWA z nozycami i jaszczorka ale PRZEGRYWA z papierem oraz spockiem REMIS kiedy przeciwnik da kamien \n " +
                "papier -> WYGRYWA z kamieniem i spockiem ale PRZEGRYWA z nozyczkami oraz jaszczorka REMIS kiedy przeciwnik da papier \n " +
                "nozyce -> WYGRYWA z papier i jaszczorka ale PRZEGRYWA z kamieniem oraz spockiem REMIS kiedy przeciwnik da nozyczki \n " +
                "spock -> WYGRYWA z nozycami i kamieniem ale PRZEGRYWA z papierem oraz jaszczurka REMIS kiedy przeciwnik da spocka \n " +
                "jaszczurka -> WYGRYWA z papierem i spockiem ale PRZEGRYWA z kamieniem oraz nozyczkami REMIS kiedy przeciwnik da jaszczurka \n ");
    }

    public void getUserSelection() {
        System.out.println("prosze wcisnac klawisz wyboru: ");
        String optionThatUserChoose = scannerCheck.takeOptionThatTheUserChoosesAndGiveItToGui();
        gameDataBase.setOptionThatUserChoose(optionThatUserChoose);
    }

    private void theUserChoosesToEndTheGameButIsUserSure() {
        if (gameDataBase.getOptionThatUserChoose().contains("x")) {
            System.out.println("Wybrana opcja zakonczy gre czy jestes tego pewny " +
                    "wcisnij i potwierdz enterem [Y/N] ");
            String temporaryString = scannerCheck.takeTheUserChoosesIsYOrNAndGiveItToGui();
            gameDataBase.setTheUserChoosesIsYOrN(temporaryString);
        }
    }

    private void theUserChoosesToResetTheGameButIsUserSure() {
        if (gameDataBase.getOptionThatUserChoose().contains("n")) {
            System.out.println("Wybrana opcja zresetuje gre czy jestes tego pewny " +
                    "wcisnij i potwierdz enterem [Y/N] ");
            String temporaryString = scannerCheck.takeTheUserChoosesIsYOrNAndGiveItToGui();
            gameDataBase.setTheUserChoosesIsYOrN(temporaryString);
        }
    }

    public void ifTheUserChooseNOrXAskHimToAcceptTheChoice() {
        theUserChoosesToEndTheGameButIsUserSure();
        theUserChoosesToResetTheGameButIsUserSure();
    }

    public static void whenUserChooseYesToEndGame() {
        System.out.println("Gra zostanie zakonczona ");
    }

    public static void whenUserChooseYesToResetTheGame() {
        System.out.println("Gra zostanie zresetowana ");
    }

    public static void whenUserChooseDoNotResetTheGameOrDoNotEndTheGame(GameDataBase gameDataBase) {
        if (!gameDataBase.isResetGame()) {
            System.out.println("Gra jest kontynuowana ");
        }
    }

    public static void whenIsDraw(String s) {
        System.out.println("Komputer wylosowal " + s + " wiec jest remis ");
    }

    public static void whenIsComputerWin(String s) {
        System.out.println("Komputer wylosowal " + s + " wiec wygrywa runde ");
    }

    public static void whenIsComputerLose(String s) {
        System.out.println("Komputer wylosowal " + s + " wiec przegrywa runde ");
    }

    public static void infoWhatUserChoose(String s, GameDataBase gameDataBase) {
        System.out.println("Urzytkownik " + gameDataBase.getUser().getName() + " wybral do zagrania " + s);
    }

    public static void resultOfRound(GameDataBase gameDataBase) {
        System.out.println("Wynik po rundzie numer " + (gameDataBase.getCurrentRound() + 1) + " jest " +
                gameDataBase.getCounterOfUserWins() + " wygranych dla " + gameDataBase.getUser().getName() +
                " oraz " + gameDataBase.getCounterOfComputerWins() + " wygranych dla komputera");
    }

    public void infoAboutNumberCurrentRound() {
        if (!gameDataBase.isResetGame()) {
            System.out.println("Rozpoczynamy runde " + (gameDataBase.getCurrentRound() + 1));
        }
    }

    public static void userWinTheGame(GameDataBase gameDataBase) {
        System.out.println("Gratulacje " + gameDataBase.getUser().getName() + " wygrales z komputerem Twoje punkty to: " +
                gameDataBase.getCounterOfUserWins() + " natomiast komputera " + gameDataBase.getCounterOfComputerWins());
    }

    public static void computerWinTheGame(GameDataBase gameDataBase) {
        System.out.println("Niestey " + gameDataBase.getUser().getName() + " przegrales z komputerem Twoje punkty to: " +
                gameDataBase.getCounterOfUserWins() + " natomiast komputera " +
                gameDataBase.getCounterOfComputerWins() + " sprobuj ponownie.");
    }

    public void askUserIfHeWontEndOrStartNewGame() {
        System.out.println("Wiec pozostaje pytanie czy chcesz zakonczyc gre?" +
                " wcisnij \"x\" jesli chcesz zakoczyc lub \"n\" jesli chcesz zagrac jeszcze raz ");
        String temporaryString = scannerCheck.takeOptionWhatUserChooseAtEndOfGameAndGiveItToGui();
        gameDataBase.setOptionThatUserChoose(temporaryString);
    }

    public void finalMassageOrNot() {
        if (!gameDataBase.isEndGame() && gameDataBase.isResetGame()) {
            askUserIfHeWontEndOrStartNewGame();
            ifTheUserChooseNOrXAskHimToAcceptTheChoice();
        }
    }
}
