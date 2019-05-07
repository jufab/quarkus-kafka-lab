package fr.pe.devoxx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class SenderResourceTest {

    @Mock
    SenderService senderService;

    @InjectMocks
    SenderResource senderResource;

    @BeforeEach
    void setUp() {
        senderResource = new SenderResource(senderService);
    }

    @Test
    void sendTextResource(){
        String messageToTest = "MonMessageTest";
        senderResource.sendText(messageToTest);
        verify(senderService).publishMessage(messageToTest);
    }
}