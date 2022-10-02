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
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithBadValueEqual0() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(0);
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithBadValueEqualMinus10() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(-10);
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithGoodValueEqual1() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(1);
            assertTrue(scannerCheck::checkIfNumberOfWinsIsBigerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithGoodValueEqual100() {
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

    @Nested
    class TestsOfMethodsVerifyingTheConditionsOfTheOptionThatTheUserChooses {
        private ScannerCheck scannerCheck;

        @BeforeEach
        void setUp() {
            scannerCheck = new ScannerCheck();
        }

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringLengthIsBiggerThatOne() {
            scannerCheck.setOptionThatTheUserChooses("wd");
            assertFalse(scannerCheck::checkedIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringHasOneLetter() {
            scannerCheck.setOptionThatTheUserChooses("m");
            assertTrue(scannerCheck::checkedIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringHasZeroLetters() {
            scannerCheck.setOptionThatTheUserChooses("");
            assertFalse(scannerCheck::checkedIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsIntFrom1To3WhenInputIs1() {
            scannerCheck.setOptionThatTheUserChooses("1");
            assertTrue(scannerCheck::ifTheValueOptionThatTheUserChoosesIsIntFrom1To3);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsIntFrom1To3WhenInputIs4() {
            scannerCheck.setOptionThatTheUserChooses("4");
            assertFalse(scannerCheck::ifTheValueOptionThatTheUserChoosesIsIntFrom1To3);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsXOrNWhenInputIsX() {
            scannerCheck.setOptionThatTheUserChooses("x");
            assertTrue(scannerCheck::ifTheValueOptionThatTheUserChoosesIsXOrN);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsXOrNWhenInputIsWrong() {
            scannerCheck.setOptionThatTheUserChooses("a");
            assertFalse(scannerCheck::ifTheValueOptionThatTheUserChoosesIsXOrN);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheValueOptionThatTheUserChoosesWhenInputIsWrongLengthOfStringBiggerThat2() {
            scannerCheck.setOptionThatTheUserChooses("a2");
            assertFalse(scannerCheck::allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheValueOptionThatTheUserChoosesWhenInputIsWrong() {
            scannerCheck.setOptionThatTheUserChooses("a");
            assertFalse(scannerCheck::allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheValueOptionThatTheUserChoosesWhenInputIsOk() {
            scannerCheck.setOptionThatTheUserChooses("3");
            assertTrue(scannerCheck::allConditionsAndFinalResultOfTheValueOptionThatTheUserChooses);
        }

    }

}
