package Tests.Card;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.GetCardUrl;
import static io.restassured.RestAssured.given;
public class GetCardTests extends BaseTests {
    @Test(priority = 1)
    @Description("Get the Card in the list")
    @Story("Card")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetCardFromBoard(){
        extractCardIdFromMember();
        given()
                .spec(requestSpecification)
                .pathParam("id",cardID)
                .header(acceptHeader)
        .when()
                .get(GetCardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
