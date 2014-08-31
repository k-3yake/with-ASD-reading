package chapter19_SalaryCaseStudy.domain.model;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.model.affilation.Affilation;
import chapter19_SalaryCaseStudy.domain.model.paymentclassfication.PaymentClassfication;
import chapter19_SalaryCaseStudy.domain.model.paymentschedule.PaymentSchedule;
import chapter19_SalaryCaseStudy.domain.model.paymethod.PayMethod;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.domain.value.Money;



public class Employee {
	private Integer id;
	private String name;
	private String address;
	private PaymentClassfication paymentClassfication;
	private PaymentSchedule paymentSchedule;
	private PayMethod payMethod;
	private Affilation affilation;
	
	public Employee(Integer id) {
		this.id = id;
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

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}

	public Affilation getAffilation() {
		return affilation;
	}

	public void setAffilation(Affilation affilation) {
		this.affilation = affilation;
	}

	public Money salary() {
		return getPaymentClassfication().calculatePay();
	}
	

	public boolean isPaydate(DateOnly payDate) {
		return paymentSchedule.isPayDate(payDate);
	}
}
