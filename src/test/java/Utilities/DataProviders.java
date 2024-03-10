package Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
public class DataProviders {
    @DataProvider(name="allData")
    public Object[][] BoardData() throws IOException {
        // Extend the pass for the file
        String excelPath = "C:\\Users\\zas\\TrelloApisRestAssured\\src\\test\\TestData\\BoardData.xlsx";
        ExcelFileUtilities xl = new ExcelFileUtilities(excelPath);
        int rowNum = xl.getRowCount("sheet1");
        int colCount = xl.getCellCount("sheet1",0);
        String data[][] = new String[rowNum][colCount];
        for (int i = 1; i<=rowNum; i++){
            for (int j = 0; j<colCount; j++){
                data[i-1][j] = xl.getCellData("sheet1", i, j);
            }
        }
        return data;
    }
}
