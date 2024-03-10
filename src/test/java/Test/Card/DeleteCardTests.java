package Test.Card;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteCardUrl;
import static io.restassured.RestAssured.given;

public class DeleteCardTests extends BaseTests {
    @Test()
    @Description("Delete the Card in the list")
    public void testDeleteCardFromBoard(){
        extractCardIdFromMember();
        createPayLoad.setCardName("Development");
        given()
                .spec(requestSpecification)
                .pathParam("id",cardID)
                .when()
                .delete(DeleteCardUrl)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
