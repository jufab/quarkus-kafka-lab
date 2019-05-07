package it.fr.pe.devoxx;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class SenderResourceTestIT {

    @Test
    void sendText() {
        String messageToTest = "MonMessageTest";
        given()
                .param("textToSend",messageToTest)
                .when()
                .post("/sender")
                .then()
                .statusCode(204);
    }
}