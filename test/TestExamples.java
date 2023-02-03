package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExamples {
    @Test
    @DisplayName("Test Junit is working")
    public void TestWorking() {
        assertEquals("java", "java");
    }
}

