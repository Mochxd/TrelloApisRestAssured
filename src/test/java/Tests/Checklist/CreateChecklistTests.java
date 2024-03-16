package Tests.Checklist;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static EndPoints.Urls.CreateChecklistUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class CreateChecklistTests extends BaseTests {
    @Test
    @Description("Create new CheckList in the in the Card that is created")
    @Story("CheckLists")
    @Severity(SeverityLevel.BLOCKER)
    public void testCreateCheckListOnCard(){
        extractCardIdFromMember();
        createPayLoad.setCheckListName("Test Login Button");
        given().spec(requestSpecification)
                .pathParam("id",cardID)
                .queryParam("name",createPayLoad.getCheckListName())
                .contentType(ContentType.JSON)
        .when()
                .post(CreateChecklistUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo(createPayLoad.getCheckListName()));
    }
}
