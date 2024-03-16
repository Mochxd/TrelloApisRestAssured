package Tests.Checklist;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteChecklistUrl;
import static io.restassured.RestAssured.given;
public class DeleteChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Delete the Checklist that is created")
    @Story("CheckLists")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteChecklist(){
        extractChecklistId();
        given()
                .spec(requestSpecification)
                .pathParam("id", checklistID)
        .when()
                .delete(DeleteChecklistUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
