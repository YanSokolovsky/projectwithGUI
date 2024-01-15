package org.mlfm.tests;

import org.junit.jupiter.api.Test;
import org.mlfm.filemanagement.readers.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {

    @Test
    void read() {
        JSONReader reader = new JSONReader("D:\\testing\\input.json");
        ArrayList<String> arr = reader.read();
        assertEquals(arr.get(0), "123.56 + 34.45 * 4 + (34 -43) * 3 - 2 ^ 4");
        assertEquals(arr.get(1), "(1 - 2)+(  1 + 3)+(4  *    4)+(3 - 2)+( 0 + 0)+(123 / 123)");
        assertEquals(arr.get(2), "(((((((((((1 + 1) + 1) + 1) + 1) + 1)))) + 1)))");
    }
}