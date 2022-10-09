package com.kodilla.rps;

import com.kodilla.rps.game.database.GameDataBase;
import com.kodilla.rps.moves.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOfClassGameData {
    public GameDataBase gameDataBase;

    @BeforeEach
    void setUp() {
        gameDataBase = new GameDataBase();
    }

    @Test
    void testOfMethodAddUserMoveInThisRound() {
        gameDataBase.addUserMoveInThisRound(new Rock());
        assertEquals(1, gameDataBase.getRecordOfAllUserRounds().size());
    }

    @Test
    void testOfMethodAddComputerMoveInThisRound() {
        gameDataBase.addComputerMoveInThisRound(new Rock());
        assertEquals(1, gameDataBase.getRecordOfAllComputerRounds().size());
    }
}
