package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private int orderId;
	private double totalPrice;
	private boolean status;
	private String deliveryLocation;
	private LocalDate date;
	private Customer customer;
	private Personel cashier;
	private List<OrderLine> orderLines;
	private Payment payment;

	public Order(Personel currPersonel) {
		this.date = LocalDate.now();
		cashier = currPersonel;
		orderLines = new LinkedList<>();
		deliveryLocation = "In-Store";
	}

	/**
	 * @param abstractProduct
	 * 
	 *                        This method checks if an Orderline with exits with the
	 *                        given argument. if not found, then it adds an new
	 *                        OrderLine to list: orderLines
	 * 
	 * @return Simulates finding an OrderLine, with true/false
	 */
	public boolean findOrderLineItemAndAdd(AbstractProduct abstractProduct) {
		boolean res = false;
		for (int i = 0; i < orderLines.size(); i++) {
			if (orderLines.get(i).getAbstractProduct().equals(abstractProduct)) {
				orderLines.get(i).increaseQtyByOne();
				res = true;
			}
		}

		if (!res) {
			OrderLine ol = new OrderLine(abstractProduct);
			addOrderLine(ol);
		}

		return res;
	}

	/**
	 * This method calculates the total price of the order.
	 * 
	 * @return TotalPrice
	 */

	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < orderLines.size(); i++) {
			total += orderLines.get(i).getPrice();
		}
		double discount = calculateDiscountOnCustomer(customer);
		total *= discount;

		totalPrice = total;
		return total;

	}

	/**
	 * This method calculate the discount the discount that a customer will receive
	 * when they make a purchase
	 * 
	 * @param customer
	 * @return discount
	 */
	private double calculateDiscountOnCustomer(Customer customer) {
		double discount = 1;
		if (customer != null) {
			if (customer.getDiscount() != 0) {
				discount = customer.getDiscount();
				discount = 1 - (discount / 100);

			}
		}
		return discount;
	}

	/**
	 * this Stringbuilder takes the product and the amount with the price and makes
	 * it a toString, that is used to print a ordre.
	 * 
	 * @return ToString
	 */

	public String printOrder() {
		StringBuilder ress = new StringBuilder();
		ress.append("Order: ");
		ress.append(orderId);

		for (OrderLine ol : orderLines) {
			ress.append("\nAmount: ");
			ress.append(ol.getAmount());
			ress.append("\t Product: ");
			ress.append(ol.getAbstractProduct().getDescription());
		}
		DecimalFormat df = new DecimalFormat("#.00");
		ress.append("\nTotal: ");
		ress.append(df.format(totalPrice));
		ress.append("\n\nServiced by <<");
		ress.append(cashier.getName());
		ress.append(">>");

		ress.append("\n");
		ress.append("Delivery address: ");
		ress.append(deliveryLocation);
		
		if(customer!= null && payment == Payment.INVOICE) {
			ress.append("\nCustomer Credit:");
			ress.append(Double.toString(customer.getCredit()));
		}

		return ress.toString();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setStatusToActive() {
		this.status = true;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);

	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

}