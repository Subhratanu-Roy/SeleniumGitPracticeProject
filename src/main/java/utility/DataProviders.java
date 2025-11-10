package utility;

import org.testng.annotations.DataProvider;

import base.Base;

public class DataProviders extends Base {

	String sheetname = "Data";

	@DataProvider(name = "allData")
	public Object[][] getData() {
		//ExcelUtility excelUtility = new ExcelUtility(properties.getProperty("testdatapath"));
		int totalRows = excelUtility.getTotalNoOfRows(sheetname); // 3
		int totalCols = excelUtility.getTotalNoOfCols(sheetname); // 2
		System.out.println("Rows: " + totalRows + " and " + "Cols: " + totalCols);
		Object[][] data = new Object[totalRows][totalCols];
		for (int row = 1; row <= totalRows; row++) {
			for (int col = 0; col < totalCols; col++) {
				data[row - 1][col] = excelUtility.getCellData(sheetname, row, col);

			}
		}

		return data;

	}

}
