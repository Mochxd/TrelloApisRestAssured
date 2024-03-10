package Test.CheckItem;

import Test.Base.BaseTests;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.CreateCheckItemUrl;
import static io.restassured.RestAssured.given;

public class CreateCheckItemTests extends BaseTests {
    @Test
    @Description("Create new Check item on checklist that is created")
    public void testCreateCheckItem(){
        extractChecklistId();
        createPayLoad.setCheckItemName("Verify the correct Functionality of the button");
        given().spec(requestSpecification)
                .pathParam("id",checklistID)
                .queryParam("name",createPayLoad.getCheckItemName())
                .contentType(ContentType.JSON)
                .when()
                .post(CreateCheckItemUrl)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
