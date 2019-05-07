package fr.pe.devoxx;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/sender")
public class SenderResource {

    SenderService senderService;

    public SenderResource() {}

    @Inject
    public SenderResource(SenderService senderService) {
        this.senderService = senderService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void sendText(@FormParam("textToSend") String textToSend) {
        senderService.publishMessage(textToSend);
    }

}
