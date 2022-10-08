package com.kodilla.rps;

import com.kodilla.rps.game.logic.GameLogic;
import com.kodilla.rps.game.database.GameDataBase;
import org.junit.jupiter.api.*;


public class TestOfClassGameLogic {
    private GameDataBase gameDataBase;
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameDataBase = new GameDataBase();
        gameLogic = new GameLogic(gameDataBase);
    }

/*    @Test
    void testOfMethodWhatOptionUserChooseAndDecideWhatToDo(){
        gameDataBase.setOptionThatUserChoose("N");
        assertTrue(gameLogic::whatOptionUserChooseAndDecideWhatToDo);
    }*/

}
