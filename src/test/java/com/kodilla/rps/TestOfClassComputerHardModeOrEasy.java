package com.kodilla.rps;

import com.kodilla.rps.game.database.GameDataBase;
import com.kodilla.rps.game.logic.ComputerHardModeOrEasy;
import com.kodilla.rps.game.logic.GameLogic;
import com.kodilla.rps.moves.Paper;
import com.kodilla.rps.moves.Rock;
import com.kodilla.rps.moves.Scissors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOfClassComputerHardModeOrEasy {
    private GameDataBase gameDataBase;
    private ComputerHardModeOrEasy computerHardModeOrEasy;
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameDataBase = new GameDataBase();
        gameDataBase.setUser(new User("milosz"));
        computerHardModeOrEasy = new ComputerHardModeOrEasy();
        gameLogic = new GameLogic(gameDataBase, computerHardModeOrEasy);
    }

    @Test
    void testIfComputerInHardModeWinEveryTime() {
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToDrawInPercent(0);
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToWinInPercent(100);
        gameDataBase.addUserMoveInThisRound(new Rock());
        gameLogic.resultOfRoundAndGoToNextRound();
        assertAll(
                () -> assertEquals(1, gameDataBase.getCounterOfComputerWins()),
                () -> assertEquals(0, gameDataBase.getCounterOfUserWins())
        );
    }

    @Test
    void testIfComputerInHardModeDrawEveryTime() {
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToDrawInPercent(100);
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToWinInPercent(0);
        gameDataBase.addUserMoveInThisRound(new Paper());
        gameLogic.resultOfRoundAndGoToNextRound();
        assertAll(
                () -> assertEquals(0, gameDataBase.getCounterOfComputerWins()),
                () -> assertEquals(0, gameDataBase.getCounterOfUserWins())
        );
    }

    @Test
    void testIfComputerInHardModeLooseEveryTime() {
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToDrawInPercent(0);
        computerHardModeOrEasy.setValueHowBigChanceComputerHasToWinInPercent(0);
        gameDataBase.addUserMoveInThisRound(new Scissors());
        gameLogic.resultOfRoundAndGoToNextRound();
        assertAll(
                () -> assertEquals(0, gameDataBase.getCounterOfComputerWins()),
                () -> assertEquals(1, gameDataBase.getCounterOfUserWins())
        );
    }

}
