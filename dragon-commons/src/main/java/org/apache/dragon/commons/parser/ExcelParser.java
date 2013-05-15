package org.apache.dragon.commons.parser;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableWorkbook;

/**
 * ExcelParser: parser of excel, call <code>close</code> after call other methods
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2012/10/25
 * @since 1.0
 */
public class ExcelParser {

	//Local variables
	/**
	 * file path
	 */
	private String path = null;
	/**
	 * workbook for read
	 */
	private Workbook workbook = null;
	/**
	 * writableWorkbook for write
	 */
	private WritableWorkbook writableWorkbook = null;
	
	//Constructor
	/**
	 * Constructor a ExcelParse object with the specified path 
	 * 
	 * @param path
	 * @return
	 */
	public ExcelParser(String path){
		this.path = path;
	}
	
	/**
	 * return Workbook for read
	 */
	private Workbook getWorkbook() {
		if(this.workbook == null){
			try {
				this.workbook = Workbook.getWorkbook(new File(this.path));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return this.workbook;
	}
	
	/**
	 * return Workbook for write
	 */
	private WritableWorkbook getWritableWorkbook() {
		if(this.writableWorkbook == null){
			try {
				writableWorkbook = Workbook.createWorkbook(new File(this.path + ".bak"), this.workbook);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return writableWorkbook;
	}

	//Logic
	/**
	 * Returns the value of sheet/row/column
	 * 
	 * @param ri the index of row
	 * @param si the index of sheet
	 * @param ci the index of column
	 * @return the value of sheet/row/column
	 */
	public String getValue(int si, int ri, int ci){
		try{
			return this.getWorkbook().getSheets()[si].getCell(ci, ri).getContents();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Returns the value of sheet/row/column
	 * 
	 * @param ri the index of row
	 * @param si the index of sheet
	 * @param ci the index of column
	 * @param v the value of sheet/row/column
	 * @return the value of sheet/row/column
	 */
	public void setValue(int si, int ri, int ci, String v){
		try {
			//new cell
			WritableCell wc = new Label(ci, ri, v);
			//add cell to the sheet
			this.getWritableWorkbook().getSheets()[si].addCell(wc);
			//all cells modified/added. Now write out the workbook
			this.getWritableWorkbook().write();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * create sheet for the workbook
	 * 
	 * @param name sheet name
	 * @param index sheet position
	 */
	public void createSheet(String name, int index){
		try {
			//create sheet for the workbook
			this.getWritableWorkbook().createSheet(name, index);
			//all cells modified/added. Now write out the workbook
			this.getWritableWorkbook().write();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * remove sheet for the workbook
	 * 
	 * @param index sheet position
	 */
	public void removeSheet(int index){
		try {
			//create sheet for the workbook
			this.getWritableWorkbook().removeSheet(index);
			//all cells modified/added. Now write out the workbook
			this.getWritableWorkbook().write();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * release resources
	 */
	public void close(){
		if(this.workbook != null){
			this.workbook.close();
			this.workbook = null;
		}
		if(this.writableWorkbook != null){
			try {
				this.writableWorkbook.close();
			} catch (Exception e) {
				//do nothing
			}
			this.writableWorkbook = null;
		}
	}
	
}
