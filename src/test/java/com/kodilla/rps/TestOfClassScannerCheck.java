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
            scannerCheck.setFinalNumberWinRoundsToWinGameBeforeChecks("n5");
            assertFalse(scannerCheck::checkThatTheNumberOfWinsIsInt);
        }

        @Test
        void TestMethodCheckThatTheNumberOfWinsIsIntWithGoodValue() {
            scannerCheck.setFinalNumberWinRoundsToWinGameBeforeChecks("2");
            assertTrue(scannerCheck::checkThatTheNumberOfWinsIsInt);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithBadValueEqual0() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(0);
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithBadValueEqualMinus10() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(-10);
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithGoodValueEqual1() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(1);
            assertTrue(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBigerThat0WithGoodValueEqual100() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(100);
            assertTrue(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithGoodValue() {
            scannerCheck.setFinalNumberWinRoundsToWinGameBeforeChecks("1");
            assertTrue(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithBadValueNotInt() {
            scannerCheck.setFinalNumberWinRoundsToWinGameBeforeChecks("hfsaidf");
            assertFalse(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }

        @Test
        void TestMethodCheckAllConditionForNumberOfWinRoundsToWinTheGameWithBadValueOutOfRange() {
            scannerCheck.setFinalNumberWinRoundsToWinGameBeforeChecks("0");
            assertFalse(scannerCheck.checkAllConditionForNumberOfWinRoundsToWinTheGame());
        }
    }

}
