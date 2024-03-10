package Tests.Board;

import Tests.Base.BaseTests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllMemberBoardsTests extends BaseTests {
    @Test
    @Description("Get all members and their id")
    public void getAllMemberBoards(){
        given()
                .spec(requestSpecification)
                .pathParam("id", memberUsername)
                .header(acceptHeader)
        .when()
                .get("/members/"+"{id}")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
