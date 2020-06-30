package com.opentext.bn.lens.cmd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Excel_Read {
	
/*

public List<String> getColHeaders() {
		ArrayList cols = new ArrayList();
		Row row = this.sheet.getRow(0);
		Iterator cell = row.cellIterator();

		while (cell.hasNext()) {
			Cell c = (Cell) cell.next();
			cols.add(this.getCellValueAsString(c));
		}

		this.closeWorkbook();
		return cols;
	} 

private void closeWorkbook() {
		try {
			this.inputStream.close();
		} catch (Exception arg1) {
			arg1.printStackTrace();
		}

	}


private String getCellValueAsString(Cell cell) {
		DataFormatter format = new DataFormatter();
		String s = format.formatCellValue(cell);
		this.closeWorkbook();
		return s;
	}
	
	
	
	public List<Map<String, String>> getColumnAndRowsAsMap() {
		ArrayList ret = new ArrayList();

		for (int row = 1; row <= this.rowCount(); ++row) {
			HashMap colrows = new HashMap();

			for (int col = 0; col < this.getColHeaders().size(); ++col) {
				colrows.put(this.getColHeaders().get(col),
						this.getCellValueAsString(row, (String) this.getColHeaders().get(col)));
			}

			ret.add(colrows);
		}

		return ret;
		
		
	}
	
	*/

}
