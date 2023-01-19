package gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.*;

public class CreateOrderTableModel extends AbstractTableModel {

	private static final String[] COL_NAMES = { "Qty", "Name", "Barcode", "Cost price", "Sales price" };
	private List<AbstractProduct> data;

	public CreateOrderTableModel(List<AbstractProduct> data) {
		this.data = data;
		if (this.data == null) {
			this.data = new ArrayList<>();
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		AbstractProduct ap = data.get(rowIndex);
		String res = "";
		switch (columnIndex) {
		case 0:
			res = ap.getDescription();
			break;
		case 1:
			res = "" + ap.getBarcode();
			break;

		default:
			res = "<UNKOWN " + columnIndex + ">";
		}
		return res;
	}

	public AbstractProduct getDataAt(int rowIndex) {
		return data.get(rowIndex);
	}

	public void setData(List<AbstractProduct> data) {
		this.data = data;
		super.fireTableDataChanged();
	}

}
