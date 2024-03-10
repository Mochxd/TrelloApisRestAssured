package Tests.Card;

import Tests.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.GetCardUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetCardTests extends BaseTests {
    @Test(priority = 1)
    @Description("Get the Card in the list")
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
