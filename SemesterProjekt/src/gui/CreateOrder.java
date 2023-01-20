package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.OrderCtrl;
import ctrl.ProductCtrl;
import model.AbstractProduct;
import model.Customer;
import model.OrderLine;
import model.Payment;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class CreateOrder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtBarcode;
	private OrderCtrl oc;
	private CreateOrderTableModel cotm;
	private List<OrderLine> ol;
	private JTable tblOrderLine;
	private JTextField txtTotal;
	private JToggleButton tglBtnPayment;
	private JToggleButton tglBtnDelivery;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateOrder dialog = new CreateOrder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrder() {
		setTitle("Sales Managment System");
		setResizable(false);
		setBounds(100, 100, 708, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					tblOrderLine = new JTable();
					scrollPane.setViewportView(tblOrderLine);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JLabel lblNewLabel_2 = new JLabel("Total:");
					panel_1.add(lblNewLabel_2);
				}
				{
					txtTotal = new JTextField();
					txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
					txtTotal.setEditable(false);
					panel_1.add(txtTotal);
					txtTotal.setColumns(10);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Customer Id:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 0;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtId = new JTextField();
				GridBagConstraints gbc_txtId = new GridBagConstraints();
				gbc_txtId.insets = new Insets(0, 0, 5, 0);
				gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtId.gridx = 1;
				gbc_txtId.gridy = 0;
				panel.add(txtId, gbc_txtId);
				txtId.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Name:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 1;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtName = new JTextField();
				GridBagConstraints gbc_txtName = new GridBagConstraints();
				gbc_txtName.insets = new Insets(0, 0, 5, 0);
				gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtName.gridx = 1;
				gbc_txtName.gridy = 1;
				panel.add(txtName, gbc_txtName);
				txtName.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Email:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 2;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtEmail = new JTextField();
				GridBagConstraints gbc_txtEmail = new GridBagConstraints();
				gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
				gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEmail.gridx = 1;
				gbc_txtEmail.gridy = 2;
				panel.add(txtEmail, gbc_txtEmail);
				txtEmail.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Phone:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 3;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtPhone = new JTextField();
				GridBagConstraints gbc_txtPhone = new GridBagConstraints();
				gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
				gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPhone.gridx = 1;
				gbc_txtPhone.gridy = 3;
				panel.add(txtPhone, gbc_txtPhone);
				txtPhone.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Address:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 4;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtAddress = new JTextField();
				GridBagConstraints gbc_txtAddress = new GridBagConstraints();
				gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
				gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtAddress.gridx = 1;
				gbc_txtAddress.gridy = 4;
				panel.add(txtAddress, gbc_txtAddress);
				txtAddress.setColumns(10);
			}
			{
				JButton btnFindCustomer = new JButton("Find Customer");
				btnFindCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						findCustomerClicked();
					}
				});
				GridBagConstraints gbc_btnFindCustomer = new GridBagConstraints();
				gbc_btnFindCustomer.fill = GridBagConstraints.BOTH;
				gbc_btnFindCustomer.insets = new Insets(0, 0, 5, 0);
				gbc_btnFindCustomer.gridx = 1;
				gbc_btnFindCustomer.gridy = 5;
				panel.add(btnFindCustomer, gbc_btnFindCustomer);
			}
			{
				JLabel lblNewLabel_6 = new JLabel(" ");
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel_6.gridx = 1;
				gbc_lblNewLabel_6.gridy = 6;
				panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
			}
			{
				JLabel lblNewLabel = new JLabel(" ");
				lblNewLabel.setToolTipText(" ");
				lblNewLabel.setBackground(new Color(0, 0, 0));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel.weightx = 3.0;
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 7;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Payment Type:");
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 8;
				panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
			}
			{
				tglBtnPayment = new JToggleButton("In store");
				tglBtnPayment.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						togglePaymentClicked();
					}
				});
				GridBagConstraints gbc_tglBtnPayment = new GridBagConstraints();
				gbc_tglBtnPayment.fill = GridBagConstraints.BOTH;
				gbc_tglBtnPayment.insets = new Insets(0, 0, 5, 0);
				gbc_tglBtnPayment.gridx = 1;
				gbc_tglBtnPayment.gridy = 8;
				panel.add(tglBtnPayment, gbc_tglBtnPayment);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Delivery:");
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 0;
				gbc_lblNewLabel_7.gridy = 9;
				panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
			}
			{
				tglBtnDelivery = new JToggleButton("In-store");
				tglBtnDelivery.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						toggleDeliveryClicked();
					}
				});
				GridBagConstraints gbc_tglBtnDelivery = new GridBagConstraints();
				gbc_tglBtnDelivery.fill = GridBagConstraints.BOTH;
				gbc_tglBtnDelivery.insets = new Insets(0, 0, 5, 0);
				gbc_tglBtnDelivery.gridx = 1;
				gbc_tglBtnDelivery.gridy = 9;
				panel.add(tglBtnDelivery, gbc_tglBtnDelivery);
			}
			{
				JLabel lblNewLabel_5 = new JLabel(" ");
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel_5.gridx = 1;
				gbc_lblNewLabel_5.gridy = 10;
				panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
			}
			{
				JButton btnScanItem = new JButton("Scan Product");
				btnScanItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						scanProductClicked();
					}
				});
				{
					JLabel lblNewLabel_4 = new JLabel(" ");
					GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
					gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
					gbc_lblNewLabel_4.gridx = 1;
					gbc_lblNewLabel_4.gridy = 11;
					panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Barcode:");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel_1.gridx = 0;
					gbc_lblNewLabel_1.gridy = 12;
					panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
				}
				{
					txtBarcode = new JTextField();
					txtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_txtBarcode = new GridBagConstraints();
					gbc_txtBarcode.insets = new Insets(0, 0, 5, 0);
					gbc_txtBarcode.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtBarcode.gridx = 1;
					gbc_txtBarcode.gridy = 12;
					panel.add(txtBarcode, gbc_txtBarcode);
					txtBarcode.setColumns(10);
					txtBarcode.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							scanProductClicked();
						}
					});

				}
				GridBagConstraints gbc_btnScanItem = new GridBagConstraints();
				gbc_btnScanItem.fill = GridBagConstraints.BOTH;
				gbc_btnScanItem.gridx = 1;
				gbc_btnScanItem.gridy = 13;
				panel.add(btnScanItem, gbc_btnScanItem);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelCliked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init();
	}

	private void toggleDeliveryClicked() {
		if (tglBtnDelivery.isSelected()) {
			tglBtnDelivery.setText("Address");
			String address = JOptionPane.showInputDialog("Type delivery address:");
			oc.chooseDeliveryAddress(address);
		} else {
			tglBtnDelivery.setText("In-store");
			oc.chooseDeliveryAddress("In-store");
		}
	}

	private void togglePaymentClicked() {
		if (tglBtnPayment.isSelected()) {
			tglBtnPayment.setText("Credit");
			oc.choosePayment(Payment.INVOICE);
		} else {
			tglBtnPayment.setText("In-store");
			oc.choosePayment(Payment.INSTORE);
		}
	}

	private void confirmClicked() {
		Boolean pay = oc.checkCreditAndPay();
		if(pay == false) {
			JOptionPane.showMessageDialog(this, "In-store payment");
		}
		oc.confirmOrder();
		System.out.println(oc.printOrder());
		cancelCliked();
	}

	private void cancelCliked() {
		super.setVisible(false);
		super.dispose();
	}

	private void findCustomerClicked() {
		String phone = JOptionPane.showInputDialog("Customer's phone number");
		Customer c = oc.findCustomerByNumber(phone);

		if (c != null) {
			txtId.setText(c.getCustomerID());
			txtId.setEditable(false);

			txtAddress.setText(c.getAddress());
			txtAddress.setEditable(false);

			txtName.setText(c.getName());
			txtName.setEditable(false);

			txtEmail.setText(c.getEmail());
			txtEmail.setEditable(false);

			txtPhone.setText(phone);
			txtPhone.setEditable(false);

			tglBtnPayment.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Customer not found");
		}
	}

	private void scanProductClicked() {
		try {
			oc.scanProductAndAddToOrder(txtBarcode.getText());
			ol = oc.getOrderLines();
			cotm.setData(ol);
			txtBarcode.setText("");

			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			String total = decimalFormat.format(oc.calculateTotal());
			txtTotal.setText(total);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Item not found");
		}

	}

	private void init() {
		oc = new OrderCtrl();
		oc.createOrder();
		// TODO change null
		ol = null;
		cotm = new CreateOrderTableModel(ol);
		tblOrderLine.setModel(cotm);
		displayMembers();
		tglBtnPayment.setEnabled(false);
	}

	private void displayMembers() {
		// TODO Auto-generated method stub

	}

}
