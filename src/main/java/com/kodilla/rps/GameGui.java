package com.kodilla.rps;

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
        gameDataBase.setNumberOfSmalWinsToWinTheGame(numberOfWinRoundsToWinTheGame);
    }

    public void userOptionsExplanation() {
        System.out.println("Dobrze wiec czas na rozpoczecie gry, ale wyjasnijmy szybko zasady, wiec mozesz wybrac jedna z opcji \n" +
                "klawisz 1 - zagranie \"kamien\",\n" +
                "klawisz 2 - zagranie \"papier\",\n" +
                "klawisz 3 - zagranie \"nozyce\",\n" +
                "klawisz x - zakonczenie gry , \n" +
                "klawisz n - uruchomienie gry od nowa");
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
            System.out.println("Wybrana opcja zakonczy gre czy jestes tego pewny " +
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
        System.out.println("Gra zostanie zakonczona bez podania wyniku ");
    }

    public static void whenUserChooseNoToEndGame() {
        System.out.println("Gra jest kontynuowana ");
    }

    public static void whenUserChooseYesToResetTheGame() {
        System.out.println("Gra zostanie zresetowana ");
    }

    public static void whenUserChooseNoToResetTheGame() {
        System.out.println("Gra jest kontynuowana ");
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

    public static void resultOfRound(GameDataBase gameDataBase){
        System.out.println("Wynik po rundzie numer " + (gameDataBase.getCurrentRound()+1) + " jest " +
                gameDataBase.getCounterOfUserWins() + " wygranych dla " + gameDataBase.getUser().getName() +
                " oraz " + gameDataBase.getCounterOfComputerWins() + " wygranych dla komputera");
    }

    public static void infoAboutNumberCurrentRound(GameDataBase gameDataBase){
        System.out.println("Rozpoczynamy runde " + (gameDataBase.getCurrentRound()+1));
    }

    public static void userWinTheGame(GameDataBase gameDataBase){
        System.out.println("Gratulacje " + gameDataBase.getUser().getName() + " wygrales z komputerem Twoje punkty to: " +
                gameDataBase.getCounterOfComputerWins() + " natomiast komputera " + gameDataBase.getCounterOfComputerWins());
    }
    public static void computerWinTheGame(GameDataBase gameDataBase){
        System.out.println("Niestey " + gameDataBase.getUser().getName() + " przegrales z komputerem Twoje punkty to: " +
                gameDataBase.getCounterOfComputerWins() + " natomiast komputera " +
                gameDataBase.getCounterOfComputerWins() + " Sprubuj ponownie.");
    }
}
