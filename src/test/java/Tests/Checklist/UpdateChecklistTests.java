package Tests.Checklist;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.UpdateChecklistUrl;
import static io.restassured.RestAssured.given;
public class UpdateChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Update the Checklist that is created")
    @Story("CheckLists")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateChecklist(){
        extractChecklistId();
        createPayLoad.setName("Test Sign up Button");
        given()
                .spec(requestSpecification)
                .pathParam("id", checklistID)
                .queryParam("name", createPayLoad.getName())
        .when()
                .put(UpdateChecklistUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
