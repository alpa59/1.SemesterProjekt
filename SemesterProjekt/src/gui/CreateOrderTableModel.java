package gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.*;

public class CreateOrderTableModel extends AbstractTableModel {

	private static final String[] COL_NAMES = { "Qty", "Name", "Barcode", "Cost price", "Sales price", "Total" };
	private List<OrderLine> data;

	public CreateOrderTableModel(List<OrderLine> ol) {
		this.data = ol;
		if (this.data == null) {
			this.data = new ArrayList<>();
		}

	}

	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}

	@Override
	public int getRowCount() {

		return data.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderLine ol = data.get(rowIndex);
		String res = "";
		switch (columnIndex) {
		case 0:
			res = Integer.toString(ol.getAmount());
			break;
		case 1:
			res = ol.getAbstractProduct().getDescription();
			break;
		case 2:
			res = ol.getAbstractProduct().getBarcode();
			break;
		case 3:
			res = Double.toString(ol.getAbstractProduct().getPurchasePrice());
			break;
		case 4:
			res = Double.toString(ol.getAbstractProduct().getPrice());
			break;
		case 5:
			res = Double.toString(ol.getPrice());
			break;
		default:
			res = "<UNKOWN " + columnIndex + ">";
		}
		return res;
	}

	public OrderLine getDataAt(int rowIndex) {
		return data.get(rowIndex);
	}

	public void setData(List<OrderLine> data) {
		this.data = data;
		super.fireTableDataChanged();
	}

}
