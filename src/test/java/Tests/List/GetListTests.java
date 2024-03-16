package Tests.List;

import Tests.Base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.GetListUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class GetListTests extends BaseTests {
    @Test(priority = 1)
    @Description("Get the list in the board that is created")
    @Story("List")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetListFromBoard(){
        extractListIdFromBoard("0");
        given()
                .spec(requestSpecification)
                .pathParam("id",listID)
        .when()
                .get(GetListUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("id",equalTo(listID));
    }
}
