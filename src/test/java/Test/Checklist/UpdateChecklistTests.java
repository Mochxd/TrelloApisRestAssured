package Test.Checklist;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.UpdateChecklistUrl;
import static io.restassured.RestAssured.given;

public class UpdateChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Update the Checklist that is created")
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
