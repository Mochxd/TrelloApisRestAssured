package Tests.Board;

import Tests.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.GetBoardUrl;
import static io.restassured.RestAssured.given;
public class GetBoardTests extends BaseTests {
    @Test()
    @Description("Get the Board that is created")
    public void testGetBoard(){
        extractBoardIdFromMember();
        given()
                .spec(requestSpecification)
                .pathParam("id",memberBoardID)
                .header(acceptHeader)
        .when()
                .get(GetBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test()
    @Description("System Should not accept updating the board with Invalid Board ID")
    public void testGetInvalidIdOfBoard(){
        given()
                .spec(requestSpecification)
                .pathParam("id","m")
                .header(acceptHeader)
        .when()
                .get(GetBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(400);
    }
}
