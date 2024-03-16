package Tests.Checklist;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.getChecklistUrl;
import static io.restassured.RestAssured.given;
public class GetChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Get the CheckList in the Card that is created")
    @Story("CheckLists")
    @Severity(SeverityLevel.CRITICAL)
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
