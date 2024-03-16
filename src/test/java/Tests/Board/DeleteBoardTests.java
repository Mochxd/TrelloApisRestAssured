package Tests.Board;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteBoardUrl;
import static io.restassured.RestAssured.given;

public class DeleteBoardTests extends BaseTests {
    @Test()
    @Description("Delete the Board that is created")
    @Story("Board")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteBoard(){
        extractBoardIdFromMember();
        given()
                .spec(requestSpecification)
                .pathParam("id",memberBoardID)
                .header(acceptHeader)
        .when()
                .delete(DeleteBoardUrl)
        .then()
                .assertThat().statusCode(200);
    }
}
