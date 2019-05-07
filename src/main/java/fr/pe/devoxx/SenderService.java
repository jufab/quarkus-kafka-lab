package fr.pe.devoxx;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SenderService {

    Emitter<String> emitter;

    public SenderService() {
    }

    @Inject
    public SenderService(@Stream("pe-message") Emitter<String> emitter) {
        this.emitter = emitter;
    }

    public void publishMessage(String message) {
        emitter.send(message);
    }

}
