package Tests.List;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.UpdateListUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class UpdateListTests extends BaseTests {
    @Test(priority = 1)
    @Description("Update the List in the board is created")
    @Story("List")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateList(){
        extractListIdFromBoard("0");
        createPayLoad.setListName("Mohamed Mostafa");
        given()
                .spec(requestSpecification)
                .pathParam("id",listID)
                .queryParam("name", createPayLoad.getListName())
        .when()
                .put(UpdateListUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo(createPayLoad.getListName()));
    }
}
