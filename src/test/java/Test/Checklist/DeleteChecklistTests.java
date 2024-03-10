package Test.Checklist;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteChecklistUrl;
import static io.restassured.RestAssured.given;

public class DeleteChecklistTests extends BaseTests {
    @Test(priority = 1)
    @Description("Delete the Checklist that is created")
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
