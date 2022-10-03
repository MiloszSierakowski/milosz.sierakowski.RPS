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

    public void whenUserChooseYesToEndGame(){
        System.out.println("Gra zostanie zakonczona bez podania wyniku ");
    }

    public void whenUserChooseNoToEndGame(){
        System.out.println("Gra jest kontynuowana ");
    }

    public void whenUserChooseYesToResetTheGame(){
        System.out.println("Gra zostanie zresetowana ");
    }

    public void whenUserChooseNoToResetTheGame(){
        System.out.println("Gra jest kontynuowana ");
    }
}
