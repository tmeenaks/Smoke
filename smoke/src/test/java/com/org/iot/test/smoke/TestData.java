package com.org.iot.test.smoke;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.log4j.*;


public class TestData {
	final static Logger logger = Logger.getLogger(TestData.class);

	String FilePath="testdata.xls";


	/*	public String getRN() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(0);
		XSSFCell cell = row.getCell(1);
		String rn = cell.toString();
		return rn;


	}

	public String getCR() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(1);
		XSSFCell cell = row.getCell(1);	
		String cr = cell.toString();
		return cr;
	}

	public int getCNM() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(2);
		XSSFCell cell = row.getCell(1);
		int cnm=((int)Math.round(cell.getNumericCellValue()));
		return cnm;
	}

	public String getACP() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(3);
		XSSFCell cell = row.getCell(1);
		String acp = cell.toString();
		return acp;
	}

	public int getMNM() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(4);
		XSSFCell cell = row.getCell(1);
		String stvalue1 = cell.toString();
		int mnm=((int)Math.round(cell.getNumericCellValue()));
		return mnm;
	}

	public String getGN() throws IOException{
		FileInputStream fis1= new FileInputStream(FilePath);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sh1= wb1.getSheet("creategroup");
		XSSFRow row = sh1.getRow(0);
		XSSFCell cell = row.getCell(1);
		String gn = cell.toString();
		return gn;
	}*/

	public String getgroupcreateBody() throws IOException, InvalidFormatException{

		FileInputStream fis1= new FileInputStream(FilePath);
		//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		//XSSFSheet sh1= wb1.getSheet("creategroup");
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		String createGroupBody = cell.toString();
		return createGroupBody;		

	}


	public String getcontainercreateBody() throws IOException, InvalidFormatException{

		FileInputStream fis1= new FileInputStream(FilePath);
		//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		//XSSFSheet sh1= wb1.getSheet("creategroup");
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(0);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		String createContainerBody = cell.toString();
		return createContainerBody;		

	}
	public String getContainerName() throws IOException, InvalidFormatException{

		FileInputStream fis1= new FileInputStream(FilePath);
		//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		//XSSFSheet sh1= wb1.getSheet("creategroup");
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		String createContainerName = cell.toString();
		return createContainerName;		

	}

	public String getGroupName() throws IOException, InvalidFormatException{

		FileInputStream fis1= new FileInputStream(FilePath);
		//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		//XSSFSheet sh1= wb1.getSheet("creategroup");
		org.apache.poi.ss.usermodel.Workbook workbook;	
		workbook = WorkbookFactory.create(fis1);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
		String createGroupName = cell.toString();
		return createGroupName;		
	}

		public String getsubscreateBody_GRP() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(2);
			Row row = sheet.getRow(0);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String createsubscriptionBody = cell.toString();
			return createsubscriptionBody;		

		}
		
		public String getSubscriptionName_GRP() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(2);
			Row row = sheet.getRow(1);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String getsubsName = cell.toString();
			return getsubsName;		

		}
		
		
		public String getsubscreateBody_AE() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(3);
			Row row = sheet.getRow(0);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String createsubscriptionBodyAE = cell.toString();
			return createsubscriptionBodyAE;		

		}
		public String getSubscriptionName_AE() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(3);
			Row row = sheet.getRow(1);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String getsubsNameAE = cell.toString();
			return getsubsNameAE;		

		}
		
		public String getsubscreateBody_CNT() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(4);
			Row row = sheet.getRow(0);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String createsubscriptionBodyCNT = cell.toString();
			return createsubscriptionBodyCNT;		
	}
		public String getSubscriptionName_CNT() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(4);
			Row row = sheet.getRow(1);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String getsubsNameCNT = cell.toString();
			return getsubsNameCNT;		

		}	
		
		public String getupdateAEBody() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(5);
			Row row = sheet.getRow(0);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String updateAEBody = cell.toString();
			return updateAEBody;		
}
		
		public String getAEUpdatelabel() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(5);
			Row row = sheet.getRow(1);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String getupdateLabelAE = cell.toString();
			return getupdateLabelAE;		

		}	

		public String getupdateCNTBody() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(6);
			Row row = sheet.getRow(0);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String updateCNTBody = cell.toString();
			return updateCNTBody;		
}
		
		public String getCNTUpdatelabel() throws IOException, InvalidFormatException{

			FileInputStream fis1= new FileInputStream(FilePath);
			//XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
			//XSSFSheet sh1= wb1.getSheet("creategroup");
			org.apache.poi.ss.usermodel.Workbook workbook;	
			workbook = WorkbookFactory.create(fis1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(6);
			Row row = sheet.getRow(1);
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(1);
			String getupdateLabelCNT = cell.toString();
			return getupdateLabelCNT;		

		}	
		
}


