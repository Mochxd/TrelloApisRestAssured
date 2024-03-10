package Tests.Board;

import Tests.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.DeleteBoardUrl;
import static io.restassured.RestAssured.given;

public class DeleteBoardTests extends BaseTests {
    @Test()
    @Description("Delete the Board that is created")
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
