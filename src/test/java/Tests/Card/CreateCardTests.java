package Tests.Card;

import Tests.Base.BaseTests;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static EndPoints.Urls.createCardUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateCardTests extends BaseTests {
    @Test
    @Description("Create new card in the list that is created")
    public void testCreateCard(){
        extractListIdFromBoard("0");
        createPayLoad.setListName("Home Page");
        given().spec(requestSpecification)
                .queryParam("idList",listID)
                .queryParam("name",createPayLoad.getListName())
                .header(acceptHeader)
                .contentType(ContentType.JSON)
        .when()
                .post(createCardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo(createPayLoad.getListName()));
    }
}
