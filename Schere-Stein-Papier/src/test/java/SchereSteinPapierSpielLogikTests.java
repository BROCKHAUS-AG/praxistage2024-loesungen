import de.brockhaus.SchereSteinPapierSpielLogik;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SchereSteinPapierSpielLogikTests {

    // Test Methode bestimmeGewinnerString
    @Test
    void testBestimmeGewinner() {
        assertEquals("Unentschieden!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("STEIN", "STEIN"));
        assertEquals("Du gewinnst!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("STEIN", "SCHERE"));
        assertEquals("Roboter gewinnt!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("STEIN", "PAPIER"));
        assertEquals("Du gewinnst!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("PAPIER", "STEIN"));
        assertEquals("Roboter gewinnt!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("PAPIER", "SCHERE"));
        assertEquals("Du gewinnst!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("SCHERE", "PAPIER"));
        assertEquals("Roboter gewinnt!", SchereSteinPapierSpielLogik.bestimmeGewinnerString("SCHERE", "STEIN"));
    }

    // Test Methode bestimmeErgebnisString
    @Test
    void testBestimmeErgebnisString() {
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("STEIN", "STEIN").matches(".*STEIN.*STEIN.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("STEIN", "SCHERE").matches(".*STEIN.*SCHERE.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("STEIN", "PAPIER").matches(".*STEIN.*PAPIER.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("PAPIER", "STEIN").matches(".*PAPIER.*STEIN.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("PAPIER", "SCHERE").matches(".*PAPIER.*SCHERE.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("SCHERE", "PAPIER").matches(".*SCHERE.*PAPIER.*"));
        assertTrue(SchereSteinPapierSpielLogik.bestimmeErgebnisString("SCHERE", "STEIN").matches(".*SCHERE.*STEIN.*"));
    }

    // Test Methode istGewinnerSpieler
    @Test
    void testIstGewinnerSpieler() {
        assertTrue(SchereSteinPapierSpielLogik.istGewinnerSpieler("STEIN", "SCHERE"));
        assertTrue(SchereSteinPapierSpielLogik.istGewinnerSpieler("PAPIER", "STEIN"));
        assertTrue(SchereSteinPapierSpielLogik.istGewinnerSpieler("SCHERE", "PAPIER"));
        assertFalse(SchereSteinPapierSpielLogik.istGewinnerSpieler("STEIN", "PAPIER"));
        assertFalse(SchereSteinPapierSpielLogik.istGewinnerSpieler("PAPIER", "SCHERE"));
        assertFalse(SchereSteinPapierSpielLogik.istGewinnerSpieler("SCHERE", "STEIN"));
    }
}
