package it.fr.pe.devoxx;

import fr.pe.devoxx.SenderService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class ReceiverResourceTestIT {

    @Inject
    SenderService senderService;

    @Test
    void getMessages() {
        senderService.publishMessage("Hello");
        given()
                .when()
                .get("/receiver/stream")
                .then()
                .statusCode(200);
    }

    /*@Test
    void getMessagesAvecMessage() {
        senderService.publishMessage("Hello");
        given()
                .when()
                .get("/receiver/stream")
                .then()
                .statusCode(200)
                .content(containsString("HELLO"));
    }*/
}