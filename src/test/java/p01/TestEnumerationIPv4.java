package p01;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestEnumerationIPv4 {
    @Test
    public void ipToLong() throws Exception {
        long actual = EnumerationIPv4.ipToLong("33.33.33.33");

        assertEquals(555819297L, actual);
    }

    @Test
    public void longToIp() throws Exception {
        String actual = EnumerationIPv4.longToIp(560872197L);

        assertEquals("33.110.59.5", actual);
    }

}