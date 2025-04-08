package rip.ada.wcif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttemptResultTest {

    @Test
    public void shouldRenderSuccessfulResult() {
        assertEquals("0.12", new AttemptResult(12).toString());
        assertEquals("1.23", new AttemptResult(123).toString());
        assertEquals("1:01.01", new AttemptResult(6101).toString());
        assertEquals("1:23.45", new AttemptResult(8345).toString());
        assertEquals("9:59.99", new AttemptResult(59999).toString());
        assertEquals("10:00", new AttemptResult(60000).toString());
        assertEquals("1:00:00", new AttemptResult(360000).toString());
    }

    @Test
    public void shouldRenderSkippedAttempt() {
        assertEquals("Skipped", new AttemptResult(0).toString());
    }

    @Test
    public void shouldRenderDNF() {
        assertEquals("DNF", new AttemptResult(-1).toString());
    }

    @Test
    public void shouldRenderDNS() {
        assertEquals("DNS", new AttemptResult(-2).toString());
    }

    @Test
    public void shouldRenderMultiBlindResult() {
        assertEquals("60/66 1:00:00", new AttemptResult(450360006).toString());
        assertEquals("63/66 59:50", new AttemptResult(390359003).toString());
        assertEquals("61/67 59:56", new AttemptResult(440359606).toString());
        assertEquals("61/67 59:56", new AttemptResult(440359606).toString());
        assertEquals("2/2 0:43", new AttemptResult(970004300).toString());
    }

    @Test
    public void shouldRecogniseSuccessfulAttempt() {
        final AttemptResult attempt = new AttemptResult(100);
        assertTrue(attempt.isSuccess());
        assertFalse(attempt.isMbld());
        assertFalse(attempt.isSkipped());
        assertFalse(attempt.isDnf());
        assertFalse(attempt.isDns());
    }

    @Test
    public void shouldRecogniseSkippedAttempt() {
        final AttemptResult attempt = new AttemptResult(0);
        assertTrue(attempt.isSkipped());
        assertFalse(attempt.isMbld());
        assertFalse(attempt.isDnf());
        assertFalse(attempt.isDns());
        assertFalse(attempt.isSuccess());
    }

    @Test
    public void shouldRecogniseDnf() {
        final AttemptResult attempt = new AttemptResult(-1);
        assertTrue(attempt.isDnf());
        assertFalse(attempt.isSkipped());
        assertFalse(attempt.isMbld());
        assertFalse(attempt.isDns());
        assertFalse(attempt.isSuccess());
    }

    @Test
    public void shouldRecogniseDns() {
        final AttemptResult attempt = new AttemptResult(-2);
        assertTrue(attempt.isDns());
        assertFalse(attempt.isSkipped());
        assertFalse(attempt.isMbld());
        assertFalse(attempt.isDnf());
        assertFalse(attempt.isSuccess());
    }

}
