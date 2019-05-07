package fr.pe.devoxx;

import io.smallrye.reactive.messaging.annotations.Emitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SenderServiceTest {

    @InjectMocks
    SenderService senderService;

    @Mock
    Emitter<String> emitter;

    @BeforeEach
    void setUp() {
        senderService = new SenderService(emitter);
    }

    @Test
    void verifieLEmissionDeLEvenement(){
        String event = "myEvent";
        senderService.publishMessage(event);
        verify(emitter).send(event);
    }

}