package com.qa.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Base.BaseClass;

public class Utilities extends BaseClass
{
	public static Object[][] get_Data() throws IOException
	{   
		String FilePath = prop.getProperty("TestDataPath");
		String SheetName = prop.getProperty("TestDataSheetName");
		FileInputStream fis = new FileInputStream(FilePath);
		XSSFWorkbook DataBook = new XSSFWorkbook(fis);
		XSSFSheet DataSheet = DataBook.getSheet(SheetName);
		Object [][] TestData = new Object[DataSheet.getLastRowNum()][DataSheet.getRow(0).getLastCellNum()];
		for (int i=0;i<DataSheet.getLastRowNum();i++)
		{
			for(int j=0;j<DataSheet.getRow(0).getLastCellNum();j++)
			{
				TestData[i][j] = DataSheet.getRow(i+1).getCell(j).toString();
			}
		}
		DataBook.close();
		return TestData;
	}
	public static void get_Screenshot() throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot)driver;
		File OutputFile;
		File InputFile;
		String Filename = prop.getProperty("ScreenShotFile");
		String Filepath = prop.getProperty("ScreenShotPath");
		InputFile = screen.getScreenshotAs(OutputType.FILE);
		OutputFile = new File(Filepath+Filename+GetSystemDate()+".JPEG");
		FileUtils.copyFile(InputFile, OutputFile);
	}
	public static String GetSystemDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		Date date = new Date();
		String Sysdate = dateFormat.format(date);
		return Sysdate;
	}
	public static void upload_File() throws AWTException
	{
		Robot robot = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\Arijit Ghosh\\Desktop\\Profile.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void demo_Method()
	{
		System.out.println("This is demo method to check git repository");
	}

}
