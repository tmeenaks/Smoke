/*Description: Random number generation class for avoiding conflict of having same name
Author: Meenak
Project:IoT
*/
package com.org.iot.test.smoke;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.log4j.*;

public class Rand{

	final static Logger logger = Logger.getLogger(Rand.class);
	TestData tdobj=new TestData();
	String FilePath="testdata.xls";
	
			
	Random randomno = new Random();
	int r= randomno.nextInt(100-10)+10;

	public void setRandomContainer() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Conatiner Name Call");
		String s=tdobj.getcontainercreateBody();
		logger.info("Container Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf(",");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced the Old Container Name with New Container Name Randomly"+set);
		logger.info("Storing the Container name for further Refernces");
		String ContainerName=set.substring(startIndex-4, endIndex-1).trim();
		logger.info(ContainerName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(ContainerName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();
		
		
}

	public void setRandomGroup() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Group Name Method Called");
		String s=tdobj.getgroupcreateBody();
		logger.info("Create Group Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf(",");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced Group Name:\t"+set);
		logger.info("Storing the Group name for further Refernces");
		String GroupName=set.substring(startIndex-5, endIndex-1).trim();
		logger.info(GroupName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(GroupName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();

}
	public void setRandomSubscription_GRP() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Subscription Name Method Called");
		String s=tdobj.getsubscreateBody_GRP();
		logger.info("Create subscription Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf(",");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced subscription Name:\t"+set);
		logger.info("Storing the subscription name for further Refernces");
		String subscriptionName=set.substring(startIndex-9, endIndex-1).trim();
		logger.info(subscriptionName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(2);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(subscriptionName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();

}
	public void setRandomSubscription_AE() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Subscription Name Method Called");
		String s=tdobj.getsubscreateBody_AE();
		logger.info("Create subscription Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf(",");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced subscription Name:\t"+set);
		logger.info("Storing the subscription name for further Refernces");
		String subscriptionName=set.substring(startIndex-6, endIndex-1).trim();
		logger.info(subscriptionName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(3);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(subscriptionName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();
}
	
	public void setRandomSubscription_CNT() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Subscription Name Method Called");
		String s=tdobj.getsubscreateBody_CNT();
		logger.info("Create subscription Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf(",");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced subscription Name:\t"+set);
		logger.info("Storing the subscription name for further Refernces");
		String subscriptionName=set.substring(startIndex-7, endIndex-1).trim();
		logger.info(subscriptionName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(4);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(subscriptionName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();
}
	
	public void setRandomAE_UPDATE_DATA() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random AE Update data method called");
		String s=tdobj.getupdateAEBody();
		logger.info("Create AE Update Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf("]");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced Update Label Name:\t"+set);
		logger.info("Storing the Update Label name for further Refernces");
		String updatelabelName=set.substring(startIndex-6, endIndex-1).trim();
		logger.info(updatelabelName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(5);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(updatelabelName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();
}
	
	public void setRandomCNT_UPDATE_DATA() throws InvalidFormatException, IOException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setting Random Conatiner Update data method called");
		String s=tdobj.getupdateCNTBody();
		logger.info("Create Container Update Body Fetched from the dataSheet:\t"+s);
		int startIndex = s.indexOf("_");
		logger.info("startindex"+startIndex);
		int endIndex = s.indexOf("]");
		logger.info("endindex"+endIndex);
		String rand= Integer.toString(r);
		logger.info("Random Number Generated:\t"+rand);
		String set=s.replaceFirst(s.substring(startIndex+1, endIndex-1), rand);
		logger.info("Replaced Update Label Name:\t"+set);
		logger.info("Storing the Update Label name for further Refernces");
		String updatelabelName=set.substring(startIndex-6, endIndex-1).trim();
		logger.info(updatelabelName);
		FileInputStream fis1= new FileInputStream(FilePath);
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(6);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		cell.setCellValue(set);
		Row row1 = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell1 = row1.getCell(1);
		cell1.setCellValue(updatelabelName);
		FileOutputStream outputStream = new FileOutputStream(new File(FilePath));
		outputStream.flush();
		workbook.write(outputStream);
		outputStream.close();
}
}
