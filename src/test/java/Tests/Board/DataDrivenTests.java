package Tests.Board;

import Tests.Base.BaseTests;
import Utilities.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

import static EndPoints.Urls.createBoardUrl;
import static io.restassured.RestAssured.given;

public class DataDrivenTests extends BaseTests {
    @Test(priority = 1, dataProvider = "allData", dataProviderClass = DataProviders.class)
    @Description("creating new Board with External Data in the Excel Sheet")
    @Story("Board")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateBoardWithExternalData(String name, String desc, String defaultLists){
        boolean list = Boolean.parseBoolean(defaultLists);
        given()
                .spec(requestSpecification)
                .queryParam("name", name)
                .queryParam("desc", desc)
                .queryParam("defaultLists", list)
                .contentType(ContentType.JSON)
        .when()
                .post(createBoardUrl)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON);
    }
}
