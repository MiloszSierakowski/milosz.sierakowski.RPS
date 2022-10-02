package com.kodilla.rps;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestOfClassScannerCheck {

    @Nested
    class TestsOfMethodsVerifyingTheConditionsOfTheValueOfTheNumberOfWonRounds {
        private ScannerCheck scannerCheck;

        @BeforeEach
        void setUp() {
            scannerCheck = new ScannerCheck();
        }

        @Test
        void TestMethodCheckThatTheNumberOfWinsIsIntWithBadValue() {
            scannerCheck.setSavedStringFromKeyboardUsedLikeNumberOfWins("n3");
            assertThrows(KeyboardInputUnexpectedValueException.class, scannerCheck::checkThatTheNumberOfWinsIsInt);
        }

        @Test
        void TestMethodCheckThatTheNumberOfWinsIsIntWithGoodValue() {
            scannerCheck.setSavedStringFromKeyboardUsedLikeNumberOfWins("2");
            assertDoesNotThrow(scannerCheck::checkThatTheNumberOfWinsIsInt);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithBadValueEqual0() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(0);
            assertThrows(KeyboardInputUnexpectedValueException.class, scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithBadValueEqualMinus10() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(-10);
            assertThrows(KeyboardInputUnexpectedValueException.class, scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithGoodValueEqual1() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(1);
            assertDoesNotThrow(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithGoodValueEqual100() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(100);
            assertDoesNotThrow(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithGoodValue() {
            scannerCheck.setSavedStringFromKeyboardUsedLikeNumberOfWins("1");
            assertTrue(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithBadValueNotInt() {
            scannerCheck.setSavedStringFromKeyboardUsedLikeNumberOfWins("hfsaidf");
            assertFalse(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithBadValueOutOfRange() {
            scannerCheck.setSavedStringFromKeyboardUsedLikeNumberOfWins("0");
            assertFalse(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }
    }

}
