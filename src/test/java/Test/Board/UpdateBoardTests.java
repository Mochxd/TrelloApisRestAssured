package Test.Board;

import Test.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.UpdateBoardUrl;
import static io.restassured.RestAssured.given;

public class UpdateBoardTests extends BaseTests {
    @Test(priority = 1)
    @Description("Update the Board that is created")
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
