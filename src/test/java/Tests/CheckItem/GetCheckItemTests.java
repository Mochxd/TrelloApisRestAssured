package Tests.CheckItem;

import Tests.Base.BaseTests;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.getCheckItemUrl;
import static io.restassured.RestAssured.given;
public class GetCheckItemTests extends BaseTests {
    @Test
    @Description("Get the Check item on checklist that is created")
    public void testGetCheckItem(){
        extractCheckItemId();
        given().spec(requestSpecification)
                .pathParam("id",checklistID)
                .pathParam("idCheckItem",checkItemID)
                .contentType(ContentType.JSON)
        .when()
                .get(getCheckItemUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
