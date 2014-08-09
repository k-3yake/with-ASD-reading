package chapter19_SalaryCaseStudy.domain;


public class Employee {
	private Integer id;
	private String name;
	private PaymentClassfication paymentClassfication;
	private PaymentSchedule paymentSchedule;
	private PayMethod payMethod;
	
	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PaymentClassfication getPaymentClassfication() {
		return paymentClassfication;
	}

	public void setPaymentClassfication(PaymentClassfication paymentClassfication) {
		this.paymentClassfication = paymentClassfication;
	}

	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public PayMethod getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}
}
