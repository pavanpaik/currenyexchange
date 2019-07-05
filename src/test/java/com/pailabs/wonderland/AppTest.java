package com.pailabs.wonderland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void parseAndExecuteDataset() {

        assertEquals("2", App.parseDatasetAndExecute("150 100 50 20 10 5"));
        assertEquals("error", App.parseDatasetAndExecute("151 100 50 20 10 5"));
        assertEquals("3", App.parseDatasetAndExecute("170 100 50 20 10 5"));
        assertEquals("4", App.parseDatasetAndExecute("180 100 50 20 10 5"));
        assertEquals("5", App.parseDatasetAndExecute("185 100 50 20 10 5"));
        assertEquals("error", App.parseDatasetAndExecute("186 100 50 20 10 5"));
    }
}
