package Test.Board;

import Test.Base.BaseTests;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static EndPoints.Urls.createBoardUrl;
import static io.restassured.RestAssured.given;

public class CreateBoardTests extends BaseTests {
    @BeforeTest
    @Description("Create the Data of the board(name - Description - setDefaultLists)")
    public void createData(){
        createPayLoad.setName(faker.name().name());
        createPayLoad.setDefaultLists(faker.bool().bool());
        createPayLoad.setDescription(faker.lorem().characters(100));
        createPayLoad.setDefaultLists(false);
    }
    @Test(priority = 1)
    @Description("Create new Board with Name and Description")
    public void testCreateBoard(){
        HashMap<String,String> queries = new HashMap<>();
        queries.put("name", createPayLoad.getName());
        queries.put("desc", createPayLoad.getDescription());
        queries.put("defaultLists", String.valueOf(createPayLoad.isDefaultLists()));
        boardID =
                given()
                    .spec(requestSpecification)
                    .queryParams(queries)
                    .contentType(ContentType.JSON)
                .when()
                    .post(createBoardUrl)
                .then()
                    .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .extract().path("id").toString();
        System.out.println(boardID);
    }
    @Test(priority = 2)
    @Description("System Should not accept Creating a new Board with get Request")
    public void testInvalidCreateBoardWithGetRequest(){
        given()
                .spec(requestSpecification)
                .queryParam("name","ITI Board")
                .contentType(ContentType.JSON)
        .when()
                .get(createBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(404);
    }
    @Test(priority = 3)
    @Description("System Should not accept creating new Board with empty name")
    public void testInvalidCreateBoardWithEmptyName(){
        given()
                .spec(requestSpecification)
                .queryParam("name","")
                .contentType(ContentType.JSON)
        .when()
                .post(createBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(400);
    }
}