package Test.CheckItem;

import Test.Base.BaseTests;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteCheckItemUrl;
import static io.restassured.RestAssured.given;

public class DeleteCheckItemTests extends BaseTests {
    @Test
    @Description("Delete the Check item on checklist that is created")
    public void testGetCheckItem(){
        extractCheckItemId();
        given().spec(requestSpecification)
                .pathParam("id",checklistID)
                .pathParam("idCheckItem",checkItemID)
                .contentType(ContentType.JSON)
                .when()
                .delete(DeleteCheckItemUrl)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
