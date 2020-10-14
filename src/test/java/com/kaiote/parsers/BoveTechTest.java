package com.kaiote.parsers;

import com.kaiote.parsers.data.Meter;
import com.kaiote.parsers.enums.CommunicationProtocol;
import com.kaiote.parsers.enums.MeterType;
import com.kaiote.parsers.enums.ValveState;
import com.kaiote.parsers.exceptions.MessageLengthException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * BoveTest
 */
public class BoveTechTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BoveTechTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BoveTechTest.class);
    }

    /**
     * Rigourous Test :-)
     * 
     * @throws MessageLengthException
     */
    public void testApp() throws MessageLengthException {
        Meter actual = new BoveTech("6812563413016801020000d3", "242352", CommunicationProtocol.SIGFOX, MeterType.BECOX)
                .getMeter();
        String[] alerts = { null };
        Meter expected = new Meter(null, "242352", "6812563413016801020000d3", MeterType.BECOX,
                CommunicationProtocol.SIGFOX, 360, 1.3345612E7, alerts, ValveState.VALVERROR);
        // System.out.println(expected.toString());
        assertEquals(expected.getMeterHex(), actual.getMeterHex());
        assertEquals(expected.getMeterReading(), actual.getMeterReading());
        assertEquals(expected.getSendingInterVal(), actual.getSendingInterVal());
        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getValveState(), actual.getValveState());
        assertTrue(true);
    }
}