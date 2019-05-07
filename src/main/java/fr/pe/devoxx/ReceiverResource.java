package fr.pe.devoxx;

import io.smallrye.reactive.messaging.annotations.Stream;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/receiver")
public class ReceiverResource {

    Publisher<String> messages;

    public ReceiverResource() {
    }

    @Inject
    public ReceiverResource(@Stream("une-data-stream") Publisher<String> messages) {
        this.messages = messages;
    }

    @Path("/stream")
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> getMessages() {
        return messages;
    }
}
