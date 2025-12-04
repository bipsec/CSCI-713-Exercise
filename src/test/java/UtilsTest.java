import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    // Test checkName method
    @Test
    void testCheckNameValidName() {
        assertTrue(Utils.checkName("Alice"));
        assertTrue(Utils.checkName("Bob"));
        assertTrue(Utils.checkName("John Doe"));
    }

    @Test
    void testCheckNameEmptyString() {
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameNull() {
        assertFalse(Utils.checkName(null));
    }

    @Test
    void testCheckNameSingleCharacter() {
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameWhitespaceOnly() {
        // Note: " " has length > 0, so it returns true
        // This might be a bug depending on requirements
        assertTrue(Utils.checkName(" "));
    }

    @Test
    void testCheckNameLongString() {
        String longName = "A".repeat(1000);
        assertTrue(Utils.checkName(longName));
    }

    // Test isValidAge method
    @Test
    void testIsValidAgePositiveAge() {
        assertTrue(Utils.isValidAge(1));
        assertTrue(Utils.isValidAge(25));
        assertTrue(Utils.isValidAge(100));
    }

    @Test
    void testIsValidAgeZero() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeNegative() {
        assertFalse(Utils.isValidAge(-1));
        assertFalse(Utils.isValidAge(-100));
    }

    @Test
    void testIsValidAgeVeryLarge() {
        // Note: Bug in implementation - allows age > 120
        assertTrue(Utils.isValidAge(121));
        assertTrue(Utils.isValidAge(200));
        assertTrue(Utils.isValidAge(1000));
    }

    @Test
    void testIsValidAgeBoundaryValues() {
        assertTrue(Utils.isValidAge(120));
        assertTrue(Utils.isValidAge(Integer.MAX_VALUE));
    }

    @Test
    void testIsValidAgeExactlyZero() {
        // Test the exact boundary at zero
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void testIsValidAgeJustBelowZero() {
        // Test just below the boundary
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void testIsValidAgeJustAboveZero() {
        // Test just above the boundary
        assertTrue(Utils.isValidAge(1));
    }

    @Test
    void testCheckNameWithNullAndLengthCheck() {
        // Test the compound condition: name != null && name.length() > 0
        // This helps catch mutations that change && to ||
        assertFalse(Utils.checkName(null));
        assertFalse(Utils.checkName(""));
    }

    @Test
    void testCheckNameExactLengthOne() {
        // Test exactly length 1 (boundary case for length > 0)
        assertTrue(Utils.checkName("A"));
    }

    @Test
    void testCheckNameLengthTwo() {
        assertTrue(Utils.checkName("AB"));
    }

    @Test
    void testCheckNameWithSpecialCharacters() {
        assertTrue(Utils.checkName("!@#$%"));
        assertTrue(Utils.checkName("Test-Name_123"));
    }

    @Test
    void testCheckNameWithUnicode() {
        assertTrue(Utils.checkName("测试"));
        assertTrue(Utils.checkName("José"));
    }

    @Test
    void testIsValidAgeWithVariousPositiveValues() {
        assertTrue(Utils.isValidAge(1));
        assertTrue(Utils.isValidAge(18));
        assertTrue(Utils.isValidAge(65));
        assertTrue(Utils.isValidAge(99));
    }

    @Test
    void testIsValidAgeWithVariousNegativeValues() {
        assertFalse(Utils.isValidAge(-1));
        assertFalse(Utils.isValidAge(-10));
        assertFalse(Utils.isValidAge(-100));
        assertFalse(Utils.isValidAge(Integer.MIN_VALUE));
    }
}
