package Tests.List;

import Tests.Base.BaseTests;

import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static EndPoints.Urls.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class CreateListTests extends BaseTests {
    @BeforeTest
    public void createData(){
        createPayLoad.setListName(faker.name().name());
    }
    @Test(priority = 1)
    @Description("Create new List in the board is created")
    public void testCreateList() {
        extractBoardIdFromMember();
         given()
                .spec(requestSpecification)
                .queryParam("name",createPayLoad.getListName())
                .queryParam("idBoard",memberBoardID)
                .contentType(ContentType.JSON)
        .when()
                .post(createListUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo(createPayLoad.getListName()))
                .assertThat().body("idBoard",equalTo(memberBoardID))
                .assertThat().contentType(ContentType.JSON)
                .extract().path("id");
    }
}
