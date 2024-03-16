package Tests.Board;

import Tests.Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllMemberBoardsTests extends BaseTests {
    @Test
    @Description("Get all members and their id")
    @Story("Board")
    @Severity(SeverityLevel.BLOCKER)
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
