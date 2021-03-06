package baminsurances.api;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidationTest {
    @Test
    public void testIsValidGender() {
        assertTrue(Validation.isValidGender('M'));
        assertTrue(Validation.isValidGender('F'));
        assertFalse(Validation.isValidGender('x'));
        assertFalse(Validation.isValidGender('m'));
    }
    
    @Test
    public void testIsValidBirthNo() {
        assertTrue(Validation.isValidBirthNo("16041599395"));
        assertTrue(Validation.isValidBirthNo("27023521208"));
        assertTrue(Validation.isValidBirthNo("08088072503"));
        assertFalse(Validation.isValidBirthNo("16041599391"));
    }
    
    @Test
    public void testBirthNoIsOnValidFormat() {
        assertTrue(Validation.birthNoIsOnValidFormat("11111111111"));
        assertFalse(Validation.birthNoIsOnValidFormat("abc"));
        assertFalse(Validation.birthNoIsOnValidFormat("1212121212"));
        assertFalse(Validation.birthNoIsOnValidFormat("abcdefghijk"));
    }
    
    @Test
    public void testBirthNoHasValidControllNos() {
        assertTrue(Validation.birthNoHasValidControllNos("16041599395"));
        assertFalse(Validation.birthNoHasValidControllNos("16041599391"));
        assertTrue(Validation.birthNoHasValidControllNos("08088072503"));
        assertTrue(Validation.birthNoHasValidControllNos("12074199400"));
        assertTrue(Validation.birthNoHasValidControllNos("04109310730"));
    }
    
    @Test
    public void testIsValidFirstName() {
        assertTrue(Validation.isValidFirstName("Hans"));
        assertTrue(Validation.isValidFirstName("Hans-Olav"));
        assertTrue(Validation.isValidFirstName("Hans Olav"));
        assertTrue(Validation.isValidFirstName("Bjørg-Ålæug"));
        assertFalse(Validation.isValidFirstName("Hans Olav Henke"));
        assertFalse(Validation.isValidFirstName("hans-Olav"));
        assertFalse(Validation.isValidFirstName("Hans-olav"));
        assertFalse(Validation.isValidFirstName("H"));
        assertFalse(Validation.isValidFirstName(""));
    }
    
    @Test
    public void testIsValidLastName() {
        assertTrue(Validation.isValidLastName("Stoltenberg"));
        assertTrue(Validation.isValidLastName("He"));
        assertFalse(Validation.isValidLastName("he"));
        assertFalse(Validation.isValidLastName("Hansen1"));
        assertFalse(Validation.isValidLastName("Ole Jan"));
    }
    
    @Test
    public void testIsValidZipCode() {
        assertTrue(Validation.isValidZipCode("0166"));
        assertTrue(Validation.isValidZipCode("0000"));
        assertFalse(Validation.isValidZipCode("016"));
        assertFalse(Validation.isValidZipCode("abcd"));
        assertFalse(Validation.isValidZipCode("01661"));
    }
    
    @Test
    public void testIsValidTelephoneNo() {
        assertTrue(Validation.isValidTelephoneNo("00110011"));
        assertTrue(Validation.isValidTelephoneNo("87651234"));
        assertFalse(Validation.isValidTelephoneNo("8765123"));
        assertFalse(Validation.isValidTelephoneNo("876512341"));
        assertFalse(Validation.isValidTelephoneNo("abcdefgh"));
        assertFalse(Validation.isValidTelephoneNo(""));
    }
    
    @Test
    public void testIsValidStreetAddress() {
        assertTrue(Validation.isValidStreetAddress("Pilestredet 35"));
        assertTrue(Validation.isValidStreetAddress("Ørneveien 12B"));
        assertTrue(Validation.isValidStreetAddress("Heer terrasse 3"));
        assertTrue(Validation.isValidStreetAddress("Heer terrasse 3A"));
        assertTrue(Validation.isValidStreetAddress("Pilestredet"));
        assertFalse(Validation.isValidStreetAddress("Ørneveien 12BA"));
    }
    
    @Test
    public void testIsValidRegistrationNo() {
        assertTrue(Validation.isValidCarRegistrationNo("AA11111"));
        assertTrue(Validation.isValidCarRegistrationNo("XE58123"));
        assertFalse(Validation.isValidCarRegistrationNo("XÆ58123"));
        assertFalse(Validation.isValidCarRegistrationNo("XE1341"));
        assertFalse(Validation.isValidCarRegistrationNo("XEE1341"));
        assertFalse(Validation.isValidCarRegistrationNo("X131341"));
    }
    
    @Test
    public void testConsistsOnlyOfNumbers() {
        assertTrue(Validation.consistsOnlyOfNumbers("0166"));
        assertTrue(Validation.consistsOnlyOfNumbers("0000"));
        assertTrue(Validation.consistsOnlyOfNumbers("1"));
        assertFalse(Validation.consistsOnlyOfNumbers("x"));
        assertFalse(Validation.consistsOnlyOfNumbers("123x123"));
        assertFalse(Validation.consistsOnlyOfNumbers(""));
    }
    
    @Test
    public void testIsOfLength() {
        assertTrue(Validation.isOfLength("Ole", 3));
        assertTrue(Validation.isOfLength("0166", 4));
        assertFalse(Validation.isOfLength("016", 4));
        assertFalse(Validation.isOfLength("Ole", 2));
    }
    
    @Test
    public void consistsOnlyOfLetters() {
        assertTrue(Validation.consistsOnlyOfLetters("Apple"));
        assertTrue(Validation.consistsOnlyOfLetters("A"));
        assertFalse(Validation.consistsOnlyOfLetters("Appl3"));
        assertFalse(Validation.consistsOnlyOfLetters(""));
    }
}
