package Test.Card;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.GetCardUrl;
import static EndPoints.Urls.UpdateCardUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateCardTests extends BaseTests {
    @Test()
    @Description("Update the Card in the list")
    public void testUpdateCardFromBoard(){
        extractCardIdFromMember();
        createPayLoad.setCardName("Development");
        given()
                .spec(requestSpecification)
                .pathParam("id",cardID)
                .queryParam("name",createPayLoad.getCardName())
                .header(acceptHeader)
                .when()
                .put(UpdateCardUrl)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo(createPayLoad.getCardName()));
    }
}
