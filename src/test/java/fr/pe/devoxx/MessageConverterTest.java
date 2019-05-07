package fr.pe.devoxx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageConverterTest {

    MessageConverter messageConverter;

    @BeforeEach
    void setUp() {
        messageConverter = new MessageConverter();
    }

    @Test
    void processToUpperCase() {
        String monMessage = "Mon Message";
        String retour = messageConverter.processToUpperCase(monMessage);
        assertEquals(retour,monMessage.toUpperCase());
    }
}