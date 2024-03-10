package Test.Checklist;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.getChecklistUrl;
import static io.restassured.RestAssured.given;

public class GetChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Get the CheckList in the Card that is created")
    public void testGetCheckListFromBoard(){
        extractCardIdFromMember();
        given()
                .spec(requestSpecification)
                .pathParam("id",cardID)
                .when()
                .get(getChecklistUrl)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
