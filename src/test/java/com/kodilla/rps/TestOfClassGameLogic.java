package com.kodilla.rps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestOfClassGameLogic {
    private GameDataBase gameDataBase;
    private GameLogic gameLogic;

    @BeforeEach
    void setUp(){
        gameDataBase = new GameDataBase();
        gameLogic = new GameLogic(gameDataBase,new GameGui(gameDataBase));
    }

/*    @Test
    void testOfMethodWhatOptionUserChooseAndDecideWhatToDo(){
        gameDataBase.setOptionThatUserChoose("N");
        assertTrue(gameLogic::whatOptionUserChooseAndDecideWhatToDo);
    }*/

}
