package Tests.Board;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static EndPoints.Urls.UpdateBoardUrl;
import static io.restassured.RestAssured.given;

public class UpdateBoardTests extends BaseTests {
    @Test(priority = 1)
    @Description("Update the Board with valid name that is created")
    @Story("Board")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateBoard(){
        extractBoardIdFromMember();
        createPayLoad.setName("Product Backlog");
        given()
                .spec(requestSpecification)
                .pathParam("id",memberBoardID)
                .queryParam("name", createPayLoad.getName())
                .header(acceptHeader)
            .when()
                .put(UpdateBoardUrl)
            .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test(priority = 2)
    @Description("System Should not accept updating the board with Invalid Board ID")
    @Story("Board")
    @Severity(SeverityLevel.MINOR)
    public void testUpdateNonExistingBoard(){
        int nonExistingBoardId = -1;
        given()
                .spec(requestSpecification)
                .pathParam("id", nonExistingBoardId)
                .queryParam("name", "Updated Name")
                .header(acceptHeader)
        .when()
                .put(UpdateBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(400);
    }
    @Test(priority = 3)
    @Description("System Should not accept updating the board with an empty name")
    @jdk.jfr.Description("System Should not accept updating the board with Invalid Board ID")
    @Story("Board")
    @Severity(SeverityLevel.MINOR)
    public void testUpdateBoardWithEmptyName(){
        createPayLoad.setName("");
        given()
                .spec(requestSpecification)
                .pathParam("id",memberBoardID)
                .queryParam("name", createPayLoad.getName())
                .header(acceptHeader)
        .when()
                .put(UpdateBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(400);
    }
}
