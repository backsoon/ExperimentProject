package com.hp.amss.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import javax.servlet.ServletException;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFPatternFormatting;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.commons.lang.StringUtils;

public class ExcelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			String templateFile= "/var/ngossfw/smp/template/VirtelaCIF1.XLSM";
//			String templateFile= "/var/ngossfw/smp/template/VirtelaQuotationRequestForm.XLS";
//			if (templateFile.toLowerCase().endsWith(CommonConstant.SUFFIX_XLSM)) {
//				System.out.println("xlsm");
//			} else if (templateFile.endsWith(CommonConstant.SUFFIX_XLS)) {
//				System.out.println("xls");
//	        }
//			FileInputStream fis = new FileInputStream("C:\\CIF.xls");
//			POIFSFileSystem fs = new POIFSFileSystem(fis);
//			HSSFWorkbook workbook = new HSSFWorkbook(fs);
//			CreationHelper creationHelper = workbook.getCreationHelper();
//			
////			HSSFCell cell = workbook.getSheetAt(1).getRow(12).getCell(4);
////			cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
////			cell.setCellFormula("HYPERLINK(\"" + "a@hp.com"+ "\",\"" + "a@hp.com"+ "\")");
//
//			
//			HSSFCell toCell = workbook.getSheetAt(1).getRow(12).getCell(4);
////			toCell.setCellValue(creationHelper.createRichTextString("a@hp.com"));
////			toCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
//			toCell.setCellFormula("HYPERLINK(\"" + "mailto:a@hp.com"+ "\",\"" + "a@hp.com"+ "\")");
//			
//			HSSFCellStyle linkStyle = workbook.createCellStyle();
//			linkStyle = toCell.getCellStyle();
//			
//			HSSFFont cellFont= workbook.createFont();
//			cellFont.setUnderline((byte) 1);
//			cellFont.setColor(HSSFColor.BLUE.index);
//			linkStyle.setFont(cellFont);
//			
//			//E11->E13
////			linkStyle = toCell.getCellStyle();
////			linkStyle.setFillBackgroundColor(HSSFColor.GREY_80_PERCENT.index);
//
////			String cellFormula = cell.getCellFormula();
////			int cellType = cell.getCellType();
//			
//			toCell.setCellStyle(linkStyle);
//			
////			workbook.getSheetAt(1)
////			.getRow(12)
////			.getCell(4).setCellType(cellType);
//			
//			//E38->E37
//			workbook.getSheetAt(1)
//			.getRow(36)
//			.getCell(4)
//			.setCellValue(
//					creationHelper.createRichTextString("b@hp.com"));
//			
//			linkStyle = workbook.getSheetAt(1)
//			.getRow(37)
//			.getCell(4).getCellStyle();
//			
//			workbook.getSheetAt(1)
//			.getRow(36)
//			.getCell(4).setCellStyle(linkStyle);
			
//			FileInputStream fis = new FileInputStream("C:\\VirtelaQuotationRequestForm.xls");
			FileInputStream fis = new FileInputStream("C:\\VirtelaCIF.xlsm");
			
//			POIFSFileSystem fs = new POIFSFileSystem(fis);
//			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			OPCPackage opc = OPCPackage.open(fis); 
			Workbook workbook = new XSSFWorkbook(opc);
			CreationHelper creationHelper = workbook.getCreationHelper();
			
			Cell stylecell1 = workbook.getSheetAt(1).getRow(10).getCell(4);
//			HSSFCell stylecell2 = workbook.getSheetAt(0).getRow(4).getCell(4);
//			HSSFCellStyle linkStyle = stylecell2.getCellStyle();
//			stylecell1.setCellStyle(linkStyle);
			String cellValue = "a@hp.com";
			stylecell1.setCellValue(creationHelper.createRichTextString(cellValue));

			 CreationHelper createHelper = workbook.getCreationHelper();  
			 Hyperlink link2 = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);  
			 link2.setAddress("mailto:\"(P) aaa.com (S) bbb.com\"");//(P) aaa.com (S) bbb.com
			stylecell1.setHyperlink(link2);
//			stylecell1.setCellFormula("HYPERLINK(\"" + "mailto:" + cellValue
//					+ "\",\"" + cellValue + "\")");
			
//			 //URL  
//			rows[0].createCell(0).setCellValue("URL Link");  
//			  
//			HSSFHyperlink link1 = createHelper.createHyperlink(HSSFHyperlink.LINK_URL);  
//			link1.setAddress("http://poi.apache.org/");  
//			rows[0].getCell(0).setHyperlink(link1);  
//			rows[0].getCell(0).setCellStyle(style);  
//			  
//			//Mail  
//			rows[1].createCell(0).setCellValue("Email Link");  
//			  
//			HSSFHyperlink link2 = createHelper.createHyperlink(HSSFHyperlink.LINK_EMAIL);  
//			link2.setAddress("mailto:poi@apache.org?subject=Hyperlinks");  
//			rows[1].getCell(0).setHyperlink(link2);  
//			rows[1].getCell(0).setCellStyle(style);  
//			  
//			//File  
//			rows[2].createCell(0).setCellValue("File Link");  
//			  
//			HSSFHyperlink link3 = createHelper.createHyperlink(HSSFHyperlink.LINK_FILE);  
//			link3.setAddress("link.xls");  
//			rows[2].getCell(0).setHyperlink(link3);  
//			rows[2].getCell(0).setCellStyle(style);  
//			  
//			//Workbook内  
//			rows[3].createCell(0).setCellValue("Worksheet Link");  
//			  
//			HSSFHyperlink link4 = createHelper.createHyperlink(HSSFHyperlink.LINK_DOCUMENT);  
//			link4.setAddress("sheetname1!A1");  
//			rows[3].getCell(0).setHyperlink(link4);  
//			rows[3].getCell(0).setCellStyle(style);  

			
//			HSSFWorkbook workbook1 = new HSSFWorkbook();
//			HSSFSheet sheet = workbook1.createSheet("Data Validation");
//			CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);
//			DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(new String[]{"10", "20", "30"});
//			DataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
//			dataValidation.setSuppressDropDownArrow(false);
//			sheet.addValidationData(dataValidation);
			
			
			
//			HSSFCell cell = workbook.getSheetAt(0).getRow(3).getCell(34);
//			cell.setCellValue(creationHelper.createRichTextString("AL"));
//			clearSpace(workbook);
//			workbook.getSheetAt(0).getRow(14).getCell(5).setCellFormula(null);
//	        workbook.getSheetAt(0).getRow(14).getCell(5).setCellValue("MO");
//	        workbook.getSheetAt(0).getRow(14).getCell(6).setCellValue(creationHelper.createRichTextString("200136"));
//			workbook.getSheetAt(0).getRow(14).getCell(7).setCellValue("USA");
			
			File file = new File("C:\\out.xlsm");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.flush();
			out.close();
			out = null;
			fis.close();
			fis = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    } 
	}
	
//    private static void makeHyperLink(final String linkData, final Cell
//    		cell, final String value) {
//    		         final Hyperlink link =
//    		createHelper.createHyperlink(Hyperlink.LINK_URL);
//    		         link.setAddress(linkData);
//    		         cell.setHyperlink(link);
//    		         cell.setCellStyle(hLinkStyle);
//    		         cell.setCellValue(value);
//    		     } 

//	private static void clearSpace(HSSFWorkbook workbook) {
//		HSSFCreationHelper creationHelper = workbook.getCreationHelper();
//		HSSFCell cell;
//		String value;
//		for(int i=1; i<52; i++) {
//			cell = workbook.getSheetAt(0).getRow(i).getCell(34);	
//			value = cell.getStringCellValue();
//			System.out.println("="+value+"=");
//			System.out.println("=="+StringUtils.trim(value)+"==");
//			cell.setCellValue(creationHelper.createRichTextString(StringUtils.trim(value)));
//		}
//	}
	
//	public void setMailStyle(Cell stylecell, String cellValue) {
//		 CreationHelper createHelper = workbook.getCreationHelper();  
//		 Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);  
//		if (StringUtils.isNotBlank(cellValue)) {
//			stylecell.setCellValue(createHelper.createRichTextString(cellValue));
//			String commString = "mailto:";
//			CellStyle linkStyle = stylecell.getCellStyle();
//			Font cellFont = this.workbook.createFont();
//			cellFont.setUnderline(Font.U_SINGLE);
//			cellFont.setColor(IndexedColors.BLUE.index);
//			linkStyle.setFont(cellFont);
//			link.setAddress(commString + cellValue);
//			stylecell.setHyperlink(link);
//			stylecell.setCellStyle(linkStyle);
//		} else {
//			stylecell.setCellValue(createHelper.createRichTextString(""));
//			// VirtelaQuotationRequestForm.xlsである場合のみ、初期値があるため
//			if (workbook instanceof HSSFWorkbook) {
//				stylecell.setHyperlink(link);
//			}
//		}
//	}
}
