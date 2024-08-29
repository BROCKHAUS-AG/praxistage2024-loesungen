import de.brockhaus.SiebDesEratosthenes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SiebDesEratosthenesTests {

    @Test
    void testBerechnePrimzahlen() {
        SiebDesEratosthenes siebDesEratosthenes = new SiebDesEratosthenes(100);
        List<Integer> primzahlen = siebDesEratosthenes.berechnePrimzahlen();
        List<Integer> erwartetePrimzahlen = new ArrayList<>();
        erwartetePrimzahlen.add(2);
        erwartetePrimzahlen.add(3);
        erwartetePrimzahlen.add(5);
        erwartetePrimzahlen.add(7);
        erwartetePrimzahlen.add(11);
        erwartetePrimzahlen.add(13);
        erwartetePrimzahlen.add(17);
        erwartetePrimzahlen.add(19);
        erwartetePrimzahlen.add(23);
        erwartetePrimzahlen.add(29);
        erwartetePrimzahlen.add(31);
        erwartetePrimzahlen.add(37);
        erwartetePrimzahlen.add(41);
        erwartetePrimzahlen.add(43);
        erwartetePrimzahlen.add(47);
        erwartetePrimzahlen.add(53);
        erwartetePrimzahlen.add(59);
        erwartetePrimzahlen.add(61);
        erwartetePrimzahlen.add(67);
        erwartetePrimzahlen.add(71);
        erwartetePrimzahlen.add(73);
        erwartetePrimzahlen.add(79);
        erwartetePrimzahlen.add(83);
        erwartetePrimzahlen.add(89);
        erwartetePrimzahlen.add(97);
        assertEquals(erwartetePrimzahlen, primzahlen);
    }
}
