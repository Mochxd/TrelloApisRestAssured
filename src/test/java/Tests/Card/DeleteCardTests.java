package Tests.Card;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteCardUrl;
import static io.restassured.RestAssured.given;

public class DeleteCardTests extends BaseTests {
    @Test()
    @Description("Delete the Card in the list")
    @Story("Card")
    @Severity(SeverityLevel.CRITICAL)
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
