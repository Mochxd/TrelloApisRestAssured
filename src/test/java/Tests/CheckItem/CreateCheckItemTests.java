package Tests.CheckItem;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static EndPoints.Urls.CreateCheckItemUrl;
import static io.restassured.RestAssured.given;
public class CreateCheckItemTests extends BaseTests {
    @Test
    @Description("Create new Check item on checklist that is created")
    @Story("CheckItems")
    @Severity(SeverityLevel.BLOCKER)
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
