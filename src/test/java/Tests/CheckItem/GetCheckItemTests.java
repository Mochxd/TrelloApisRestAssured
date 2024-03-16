package Tests.CheckItem;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

import static EndPoints.Urls.getCheckItemUrl;
import static io.restassured.RestAssured.given;
public class GetCheckItemTests extends BaseTests {
    @Test
    @Description("Get the Check item on checklist that is created")
    @Story("Check Items")
    @Severity(SeverityLevel.BLOCKER)
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
