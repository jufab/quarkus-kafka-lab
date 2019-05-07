package fr.pe.devoxx;

import io.reactivex.Flowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class ReceiverResourceTest {

    Publisher<String> publisher;

    @InjectMocks
    ReceiverResource receiverResource;

    @BeforeEach
    void setUp() {
        publisher = Flowable.fromIterable(Arrays.asList("Hello", "RxJava"));
        receiverResource = new ReceiverResource(publisher);
    }

    @Test
    void getMessages() {
        assertEquals(publisher,receiverResource.getMessages());
    }
}