package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	//tryhere code testing
	ExcelReader reader = new ExcelReader();

			@DataProvider(name = "tryHereData")
		    public Object[][] fetchData() throws InvalidFormatException, IOException {
		        String filePath = ConfigReader.getProperty("excelPath"); // Change this to your actual file path
		        String sheetName = "TryEditor";

		        List<Map<String, String>> testData = reader.getData(filePath, sheetName);   
		        Object[][] data = new Object[testData.size()][2];

		        for (int i = 0; i < testData.size(); i++) {
		            data[i][0] = testData.get(i).get("Input");      // Column Name from Excel
		            data[i][1] = testData.get(i).get("Expected Output");  // Column Name from Excel
		        }
		        return data;
		    }

}
