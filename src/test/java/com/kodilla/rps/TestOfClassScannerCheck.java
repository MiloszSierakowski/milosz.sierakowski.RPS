package com.kodilla.rps;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestOfClassScannerCheck {
    private ScannerCheck scannerCheck;

    @BeforeEach
    void setUp() {
        scannerCheck = new ScannerCheck();
    }

    @Nested
    class TestsOfMethodsVerifyingTheConditionsOfTheValueOfTheNumberOfWonRounds {

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
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBiggerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithBadValueEqualMinus10() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(-10);
            assertFalse(scannerCheck::checkIfNumberOfWinsIsBiggerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithGoodValueEqual1() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(1);
            assertTrue(scannerCheck::checkIfNumberOfWinsIsBiggerThat0);
        }

        @Test
        void TestMethodCheckIfNumberOfWinsIsBiggerThat0WithGoodValueEqual100() {
            scannerCheck.setFinalNumberWinRoundsToWinGame(100);
            assertTrue(scannerCheck::checkIfNumberOfWinsIsBiggerThat0);
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

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringLengthIsBiggerThatOne() {
            scannerCheck.setOptionThatTheUserChooses("wd");
            assertFalse(scannerCheck::checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringHasOneLetter() {
            scannerCheck.setOptionThatTheUserChooses("m");
            assertTrue(scannerCheck::checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfOptionThatTheUserChoosesIsLessThat2WhenStringHasZeroLetters() {
            scannerCheck.setOptionThatTheUserChooses("");
            assertFalse(scannerCheck::checkIfSizeOfOptionThatTheUserChoosesHasOnlyOneLetter);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsIntFrom1To3WhenInputIs1() {
            scannerCheck.setOptionThatTheUserChooses("1");
            assertTrue(scannerCheck::ifTheUserChoosesIsIntFrom1To3);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsIntFrom1To3WhenInputIs4() {
            scannerCheck.setOptionThatTheUserChooses("4");
            assertFalse(scannerCheck::ifTheUserChoosesIsIntFrom1To3);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsXOrNWhenInputIsX() {
            scannerCheck.setOptionThatTheUserChooses("x");
            assertTrue(scannerCheck::ifTheUserChoosesIsXOrN);
        }

        @Test
        void testOfMethodIfTheValueOptionThatTheUserChoosesIsXOrNWhenInputIsWrong() {
            scannerCheck.setOptionThatTheUserChooses("a");
            assertFalse(scannerCheck::ifTheUserChoosesIsXOrN);
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

    @Nested
    class TestsOfMethodsVerifyingTheConditionsOfTheUserChoosesIsYOrN {
        @Test
        void testOfMethodCheckIfSizeCheckTheUserChoosesIsYOrNHasOnlyOneLetterWhenStringLengthIsBiggerThatOne() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("wd");
            assertFalse(scannerCheck::checkIfSizeTheUserChoosesIsYOrNHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfCheckTheUserChoosesIsYOrNHasOnlyOneLetterWhenStringHasOneLetter() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("m");
            assertTrue(scannerCheck::checkIfSizeTheUserChoosesIsYOrNHasOnlyOneLetter);
        }

        @Test
        void testOfMethodCheckedIfSizeOfCheckTheUserChoosesIsYOrNHasOnlyOneLetterWhenStringHasZeroLetters() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("");
            assertFalse(scannerCheck::checkIfSizeTheUserChoosesIsYOrNHasOnlyOneLetter);
        }

        @Test
        void testOfMethodIfTheUserChoosesIsYOrNWhenInputIsY() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("y");
            assertTrue(scannerCheck::ifTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodIfTheUserChoosesIsYOrNWhenInputIsN() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("N");
            assertTrue(scannerCheck::ifTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodIfTheUserChoosesIsYOrNWhenInputIsX() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("X");
            assertFalse(scannerCheck::ifTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheUserChoosesIsYOrNWhenInputIsOkLikeN() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("n");
            assertTrue(scannerCheck::allConditionsAndFinalResultOfTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheUserChoosesIsYOrNWhenInputIsOkLikeY() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("Y");
            assertTrue(scannerCheck::allConditionsAndFinalResultOfTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheUserChoosesIsTYOrNWhenInputIsBadLikeXE() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("xe");
            assertFalse(scannerCheck::allConditionsAndFinalResultOfTheUserChoosesIsYOrN);
        }

        @Test
        void testOfMethodAllConditionsAndFinalResultOfTheUserChoosesIsYOrNWhenInputIsBadLikeX() {
            scannerCheck.setYOrNThatTheUserChoosesForEndTheGameOrRestart("X");
            assertFalse(scannerCheck::allConditionsAndFinalResultOfTheUserChoosesIsYOrN);
        }
    }

}
