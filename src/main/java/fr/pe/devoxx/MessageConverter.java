package fr.pe.devoxx;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConverter {

    @Incoming("pe-message-read")
    @Outgoing("une-data-stream")
    @Broadcast
    public String processToUpperCase(String message) {
        return message.toUpperCase();
    }
}
