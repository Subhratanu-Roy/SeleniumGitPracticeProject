package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	Log log = new Log();
	String path = null;

	public ExcelUtility(String path) {
		try {
			this.path = path;
			fis = new FileInputStream(new File(path));
			wb = new XSSFWorkbook(fis);
			log.info("Excel file loaded successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCellData(String sheetname, int rowno, int colno) {
		sheet = wb.getSheet(sheetname);
		XSSFCell cell = sheet.getRow(rowno).getCell(colno);
		CellType cellType = null;
		if (cell != null)
			cellType = cell.getCellType();
		String data = null;
		if (cellType == CellType.STRING) {
			data = cell.getStringCellValue();
		} else if (cellType == CellType.NUMERIC) {
			data = String.valueOf(cell.getNumericCellValue());
		} else
			data = "";

		return data;

	}

	public void setCellData(String sheetname, int rowno, int colno, String value) {
		sheet = wb.getSheet(sheetname);
		XSSFRow row = sheet.getRow(rowno);
		if (row == null)
			row = sheet.createRow(rowno);

		XSSFCell cell = sheet.getRow(rowno).getCell(colno);
		if (cell == null) {
			// row = sheet.getRow(rowno);
			cell = row.createCell(colno);

		}
		cell.setCellValue(value);
		try {
			fos = new FileOutputStream(new File(path));
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getTotalNoOfCols(String sheetname) {
		XSSFSheet sheet = wb.getSheet(sheetname);
		int totalCol = sheet.getRow(0).getLastCellNum();
		return totalCol;

	}

	public int getTotalNoOfRows(String sheetname) {
		XSSFSheet sheet = wb.getSheet(sheetname);
		return sheet.getLastRowNum();

	}

}
