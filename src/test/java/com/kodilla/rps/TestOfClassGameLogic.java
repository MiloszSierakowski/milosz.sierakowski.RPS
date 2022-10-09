package com.kodilla.rps;

import com.kodilla.rps.game.logic.GameLogic;
import com.kodilla.rps.game.database.GameDataBase;
import com.kodilla.rps.moves.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestOfClassGameLogic {
    private GameDataBase gameDataBase;
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameDataBase = new GameDataBase();
        gameDataBase.setUser(new User("milosz"));
        gameLogic = new GameLogic(gameDataBase);
    }

    @Nested
    class TestOfWhatUserChooseToDo {
        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUse1() {
            gameDataBase.setOptionThatUserChoose("1");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertEquals(new Rock().getName(), gameDataBase.getRecordOfAllUserRounds().get(0).getName());
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUse2() {
            gameDataBase.setOptionThatUserChoose("2");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertEquals(new Paper().getName(), gameDataBase.getRecordOfAllUserRounds().get(0).getName());
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUse3() {
            gameDataBase.setOptionThatUserChoose("3");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertEquals(new Scissors().getName(), gameDataBase.getRecordOfAllUserRounds().get(0).getName());
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUse4() {
            gameDataBase.setOptionThatUserChoose("4");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertEquals(new Spock().getName(), gameDataBase.getRecordOfAllUserRounds().get(0).getName());
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUse5() {
            gameDataBase.setOptionThatUserChoose("5");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertEquals(new Lizard().getName(), gameDataBase.getRecordOfAllUserRounds().get(0).getName());
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUseXAndY() {
            gameDataBase.setOptionThatUserChoose("x");
            gameDataBase.setTheUserChoosesIsYOrN("y");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertAll(
                    () -> assertTrue(gameDataBase.isEndGame()),
                    () -> assertTrue(gameDataBase.isResetGame()),
                    () -> assertTrue(gameDataBase.isAfterChooseNAndGameIsEnd()),
                    () -> assertFalse(gameDataBase.isAllowToRunLogicOfRoundWin())
            );
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUseXAndN() {
            gameDataBase.setOptionThatUserChoose("x");
            gameDataBase.setTheUserChoosesIsYOrN("n");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertAll(
                    () -> assertFalse(gameDataBase.isEndGame()),
                    () -> assertFalse(gameDataBase.isResetGame()),
                    () -> assertFalse(gameDataBase.isAfterChooseNAndGameIsEnd()),
                    () -> assertFalse(gameDataBase.isAllowToRunLogicOfRoundWin())
            );
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUseNAndY() {
            gameDataBase.setOptionThatUserChoose("n");
            gameDataBase.setTheUserChoosesIsYOrN("y");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertAll(
                    () -> assertTrue(gameDataBase.isResetGame()),
                    () -> assertTrue(gameDataBase.isAfterChooseNAndGameIsEnd()),
                    () -> assertFalse(gameDataBase.isAllowToRunLogicOfRoundWin())
            );
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenUserUseNAndN() {
            gameDataBase.setOptionThatUserChoose("n");
            gameDataBase.setTheUserChoosesIsYOrN("n");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertAll(
                    () -> assertFalse(gameDataBase.isResetGame()),
                    () -> assertFalse(gameDataBase.isAfterChooseNAndGameIsEnd()),
                    () -> assertFalse(gameDataBase.isAllowToRunLogicOfRoundWin())
            );
        }

        @Test
        void testOfMethodWhatOptionUserChooseAndDecideWhatToDoWhenOptionThatUserChooseIsEmpty() {
            gameDataBase.setOptionThatUserChoose("");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            assertAll(
                    () -> assertFalse(gameDataBase.isEndGame()),
                    () -> assertFalse(gameDataBase.isResetGame()),
                    () -> assertFalse(gameDataBase.isAfterChooseNAndGameIsEnd()),
                    () -> assertTrue(gameDataBase.isAllowToRunLogicOfRoundWin()),
                    () -> assertEquals(0, gameDataBase.getRecordOfAllUserRounds().size())
            );
        }
    }

    @Nested
    class TestOfRoundWinLogicInDifferentSituations {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenThereIsNoPermissionForRunRoundWinLogic() {
            gameDataBase.setAllowToRunLogicOfRoundWin(false);
            gameLogic.resultOfRoundAndGoToNextRound();
            assertAll(
                    () -> assertEquals(0, gameDataBase.getCounterOfUserWins()),
                    () -> assertEquals(0, gameDataBase.getCounterOfComputerWins()),
                    () -> assertEquals(0, gameDataBase.getRecordOfAllUserRounds().size()),
                    () -> assertEquals(0, gameDataBase.getRecordOfAllComputerRounds().size())
            );
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserChooseOptionXAndN() {
            gameDataBase.setOptionThatUserChoose("x");
            gameDataBase.setTheUserChoosesIsYOrN("n");
            gameLogic.whatOptionUserChooseAndDecideWhatToDoAndGivePermissionToRunLogic();
            gameLogic.resultOfRoundAndGoToNextRound();
            assertAll(
                    () -> assertEquals(0, gameDataBase.getCounterOfUserWins()),
                    () -> assertEquals(0, gameDataBase.getCounterOfComputerWins()),
                    () -> assertEquals(0, gameDataBase.getRecordOfAllUserRounds().size()),
                    () -> assertEquals(0, gameDataBase.getRecordOfAllComputerRounds().size())
            );
        }

    }

    @Nested
    class TestOfRoundWinLogicForRockMove {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingRockAndWhenComputerIsUsingScissors() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Rock());
            gameDataBase.addComputerMoveInThisRound(new Scissors());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingRockAndWhenComputerIsUsingLizard() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Rock());
            gameDataBase.addComputerMoveInThisRound(new Lizard());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingRockAndWhenComputerIsUsingPaper() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Rock());
            gameDataBase.addComputerMoveInThisRound(new Paper());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingRockAndWhenComputerIsUsingSpock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Rock());
            gameDataBase.addComputerMoveInThisRound(new Spock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenIsDraft() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Rock());
            gameDataBase.addComputerMoveInThisRound(new Rock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

    }

    @Nested
    class TestOfRoundWinLogicForPaperMove {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingPaperAndWhenComputerIsUsingRock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Paper());
            gameDataBase.addComputerMoveInThisRound(new Rock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingPaperAndWhenComputerIsUsingSpock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Paper());
            gameDataBase.addComputerMoveInThisRound(new Spock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingPaperAndWhenComputerIsUsingScissors() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Paper());
            gameDataBase.addComputerMoveInThisRound(new Scissors());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingPaperAndWhenComputerIsUsingLizard() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Paper());
            gameDataBase.addComputerMoveInThisRound(new Lizard());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenIsDraft() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Paper());
            gameDataBase.addComputerMoveInThisRound(new Paper());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

    }

    @Nested
    class TestOfRoundWinLogicForScissorsMove {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingScissorsAndWhenComputerIsUsingPaper() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Scissors());
            gameDataBase.addComputerMoveInThisRound(new Paper());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingScissorsAndWhenComputerIsUsingLizard() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Scissors());
            gameDataBase.addComputerMoveInThisRound(new Lizard());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingScissorsAndWhenComputerIsUsingRock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Scissors());
            gameDataBase.addComputerMoveInThisRound(new Rock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingScissorsAndWhenComputerIsUsingSpock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Scissors());
            gameDataBase.addComputerMoveInThisRound(new Spock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenIsDraft() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Scissors());
            gameDataBase.addComputerMoveInThisRound(new Scissors());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

    }

    @Nested
    class TestOfRoundWinLogicForLizardMove {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingLizardAndWhenComputerIsUsingPaper() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Lizard());
            gameDataBase.addComputerMoveInThisRound(new Paper());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingLizardAndWhenComputerIsUsingSpock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Lizard());
            gameDataBase.addComputerMoveInThisRound(new Spock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingLizardAndWhenComputerIsUsingRock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Lizard());
            gameDataBase.addComputerMoveInThisRound(new Rock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingLizardAndWhenComputerIsUsingScissors() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Lizard());
            gameDataBase.addComputerMoveInThisRound(new Scissors());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenIsDraft() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Lizard());
            gameDataBase.addComputerMoveInThisRound(new Lizard());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

    }

    @Nested
    class TestOfRoundWinLogicForSpockMove {

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingSpockAndWhenComputerIsUsingScissors() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Spock());
            gameDataBase.addComputerMoveInThisRound(new Scissors());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserWinUsingSpockAndWhenComputerIsUsingRock() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Spock());
            gameDataBase.addComputerMoveInThisRound(new Rock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(1, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingSpockAndWhenComputerIsUsingPaper() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Spock());
            gameDataBase.addComputerMoveInThisRound(new Paper());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenUserLooseUsingSpockAndWhenComputerIsUsingLizard() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Spock());
            gameDataBase.addComputerMoveInThisRound(new Lizard());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(1, gameDataBase.getCounterOfComputerWins());
        }

        @Test
        void testOfMethodResultOfRoundAndGoToNextRoundWhenIsDraft() {
            gameDataBase.setUser(new User("milosz"));
            gameDataBase.addUserMoveInThisRound(new Spock());
            gameDataBase.addComputerMoveInThisRound(new Spock());
            gameLogic.resultOfRoundAndGoToNextRound();
            assertEquals(0, gameDataBase.getCounterOfUserWins());
            assertEquals(0, gameDataBase.getCounterOfComputerWins());
        }

    }

    @Test
    void TestOfMethodCheckIfIsNotEndOfGameWhenUserWin() {
        gameDataBase.setNumberOfSmallWinsToWinTheGame(2);
        gameDataBase.setCounterOfComputerWins(0);
        gameDataBase.setCounterOfUserWins(2);
        gameLogic.checkIfIsNotEndOfGame();
        assertTrue(gameDataBase.isResetGame());
    }

    @Test
    void TestOfMethodCheckIfIsNotEndOfGameWhenComputerWin() {
        gameDataBase.setNumberOfSmallWinsToWinTheGame(2);
        gameDataBase.setCounterOfComputerWins(2);
        gameDataBase.setCounterOfUserWins(1);
        gameLogic.checkIfIsNotEndOfGame();
        assertTrue(gameDataBase.isResetGame());
    }

    @Test
    void TestOfMethodCheckIfIsNotEndOfGameWhenItIsNotEnd() {
        gameDataBase.setNumberOfSmallWinsToWinTheGame(2);
        gameDataBase.setCounterOfComputerWins(0);
        gameDataBase.setCounterOfUserWins(1);
        gameLogic.checkIfIsNotEndOfGame();
        assertFalse(gameDataBase.isResetGame());
    }
}
