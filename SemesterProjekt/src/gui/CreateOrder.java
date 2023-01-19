package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;

public class CreateOrder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblProducts;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtBarcode;

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
		setResizable(false);
		setBounds(100, 100, 708, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
			}
			{
				tblProducts = new JTable();
				panel.add(tblProducts);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				txtId = new JTextField();
				txtId.setText("Customer Id");
				GridBagConstraints gbc_txtId = new GridBagConstraints();
				gbc_txtId.insets = new Insets(0, 0, 5, 0);
				gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtId.gridx = 0;
				gbc_txtId.gridy = 0;
				panel.add(txtId, gbc_txtId);
				txtId.setColumns(10);
			}
			{
				txtName = new JTextField();
				txtName.setText("Name");
				GridBagConstraints gbc_txtName = new GridBagConstraints();
				gbc_txtName.insets = new Insets(0, 0, 5, 0);
				gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtName.gridx = 0;
				gbc_txtName.gridy = 1;
				panel.add(txtName, gbc_txtName);
				txtName.setColumns(10);
			}
			{
				txtEmail = new JTextField();
				txtEmail.setText("Email");
				GridBagConstraints gbc_txtEmail = new GridBagConstraints();
				gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
				gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEmail.gridx = 0;
				gbc_txtEmail.gridy = 2;
				panel.add(txtEmail, gbc_txtEmail);
				txtEmail.setColumns(10);
			}
			{
				txtPhone = new JTextField();
				txtPhone.setText("Phone");
				GridBagConstraints gbc_txtPhone = new GridBagConstraints();
				gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
				gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPhone.gridx = 0;
				gbc_txtPhone.gridy = 3;
				panel.add(txtPhone, gbc_txtPhone);
				txtPhone.setColumns(10);
			}
			{
				txtAddress = new JTextField();
				txtAddress.setText("Address");
				GridBagConstraints gbc_txtAddress = new GridBagConstraints();
				gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
				gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtAddress.gridx = 0;
				gbc_txtAddress.gridy = 4;
				panel.add(txtAddress, gbc_txtAddress);
				txtAddress.setColumns(10);
			}
			{
				JButton btnFindCustomer = new JButton("Find Customer");
				GridBagConstraints gbc_btnFindCustomer = new GridBagConstraints();
				gbc_btnFindCustomer.fill = GridBagConstraints.BOTH;
				gbc_btnFindCustomer.insets = new Insets(0, 0, 5, 0);
				gbc_btnFindCustomer.gridx = 0;
				gbc_btnFindCustomer.gridy = 5;
				panel.add(btnFindCustomer, gbc_btnFindCustomer);
			}
			{
				JButton btnCreateCustomer = new JButton("Create Customer");
				GridBagConstraints gbc_btnCreateCustomer = new GridBagConstraints();
				gbc_btnCreateCustomer.insets = new Insets(0, 0, 5, 0);
				gbc_btnCreateCustomer.fill = GridBagConstraints.BOTH;
				gbc_btnCreateCustomer.gridx = 0;
				gbc_btnCreateCustomer.gridy = 6;
				panel.add(btnCreateCustomer, gbc_btnCreateCustomer);
			}
			{
				JLabel lblNewLabel = new JLabel(" ");
				lblNewLabel.setToolTipText(" ");
				lblNewLabel.setBackground(new Color(0, 0, 0));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel.weightx = 3.0;
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 7;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				txtBarcode = new JTextField();
				txtBarcode.setText("Barcode");
				GridBagConstraints gbc_txtBarcode = new GridBagConstraints();
				gbc_txtBarcode.insets = new Insets(0, 0, 5, 0);
				gbc_txtBarcode.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBarcode.gridx = 0;
				gbc_txtBarcode.gridy = 12;
				panel.add(txtBarcode, gbc_txtBarcode);
				txtBarcode.setColumns(10);
			}
			{
				JButton btnScanItem = new JButton("Scan Product");
				GridBagConstraints gbc_btnScanItem = new GridBagConstraints();
				gbc_btnScanItem.fill = GridBagConstraints.BOTH;
				gbc_btnScanItem.gridx = 0;
				gbc_btnScanItem.gridy = 13;
				panel.add(btnScanItem, gbc_btnScanItem);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
