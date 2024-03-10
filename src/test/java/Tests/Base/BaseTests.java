package Tests.Base;

import PayLoad.PayLoad;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

import static EndPoints.Urls.*;
import static io.restassured.RestAssured.given;

public class BaseTests {
    public static RequestSpecification requestSpecification;
    public PayLoad createPayLoad = new PayLoad();
    protected static String memberUsername = "mohamedmostafa375";
    public String boardIndex = "1";
    public String memberBoardID;
    public String listID;
    public String cardID;
    public String checklistID;
    public String checkItemID;
    public Header acceptHeader = new Header("Accept", "application/json");
    public Faker faker = new Faker();
    public static String boardID;

    @BeforeClass
    public void createTokenAndKey() {
        createPayLoad.setKey("e395ded0cb90e785b9d4767b1275ffff");
        createPayLoad.setToken("ATTA947f5bb1631f0fd05ec5ed96da117f48fb6ac518e169fa02bd0d0db04f008e848A48D17C");
        HashMap<String, String> keyAndToken = new HashMap<>();
        keyAndToken.put("key", createPayLoad.getKey());
        keyAndToken.put("token", createPayLoad.getToken());
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addQueryParams(keyAndToken)
                .build();
    }
    // Method to extract the Board IDs
    public void extractBoardIdFromMember() {
        memberBoardID =
                given()
                    .spec(requestSpecification)
                    .pathParam("id", memberUsername)
                    .header(acceptHeader)
                .when()
                    .get("/members/" + "{id}")
                .then()
                    .log().all()
                    .extract().path("idBoards[" + boardIndex + "]");
    }
    // Method to extract the List IDs
    public void extractListIdFromBoard(String listIndex) {
        extractBoardIdFromMember();
        listID =
                given()
                    .spec(requestSpecification)
                    .pathParam("id", memberBoardID)
                .when()
                    .get("/boards/{id}/lists")
                .then()
                    .extract().path("["+listIndex+"].id");
    }
    // Method to extract the Card IDs
    public void extractCardIdFromMember() {
        extractBoardIdFromMember();
        cardID =
                given()
                    .spec(requestSpecification)
                    .pathParam("id", memberBoardID)
                    .log().all()
                .when()
                    .get("/boards/{id}/cards")
                .then()
                    .extract().path("[0].id");
    }
    public void extractChecklistId() {
        extractCardIdFromMember();
        checklistID =
                given()
                        .spec(requestSpecification)
                        .pathParam("id",cardID)
                        .when()
                        .get(getChecklistUrl)
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract().path("[0].id");
    }
    public void extractCheckItemId() {
        extractChecklistId();
        checkItemID =
                 given().spec(requestSpecification)
                        .pathParam("id",checklistID)
                    .contentType(ContentType.JSON)
                        .when()
                        .get("checklists/{id}/checkItems")
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                    .extract().path("[0].id");
    }
}
