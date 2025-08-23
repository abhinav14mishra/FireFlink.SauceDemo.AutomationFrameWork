package sauceDemo.genericUtilities;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method relate to File Operations like Property
 * file, Excel file, Database file etc.
 * 
 * @author Abhinav Mishra
 */
public class FileUtility {

	/**
	 * This method reads data from Property File
	 * 
	 * @param Key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(Key);
		return value;
	}

	/**
	 * This method reads single data from Excel File
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		String value = WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}

	/**
	 * This method reads single data from Excel File by providing path
	 * 
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String path, String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		String value = WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}

	/**
	 * This method reads multiple data from Excel File
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */

	public List<String> readDataFromExcelFile(String sheet, int row, int... cell) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < cell.length; i++) {
			li.add(WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell[i]).toString());
		}
		return li;
	}

	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param startCell
	 * @param endCell
	 * @return
	 * @throws IOException
	 */

	public List<String> readDataFromExcelFile(String sheet, int row, int startCell, int endCell) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis); // create only once
		List<String> li = new ArrayList<>();

		for (int i = startCell; i <= endCell; i++) {
			li.add(wb.getSheet(sheet).getRow(row).getCell(i).toString());
		}

		wb.close(); // close the workbook
		fis.close(); // close the file stream
		return li;
	}

}
