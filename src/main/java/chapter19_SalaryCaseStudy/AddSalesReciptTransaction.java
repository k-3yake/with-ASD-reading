package chapter19_SalaryCaseStudy;

import java.math.BigDecimal;

import chapter19_SalaryCaseStudy.domain.SalesRecipt;
import chapter19_SalaryCaseStudy.domain.value.DateOnly;
import chapter19_SalaryCaseStudy.infla.BusinessExcepction;

public class AddSalesReciptTransaction {
	private Integer empId;
	private DateOnly date;
	private BigDecimal amount;


	public AddSalesReciptTransaction(Integer empId, DateOnly date,BigDecimal amount) {
		this.empId = empId;
		this.date = date;
		this.amount = amount;
	}

	public void exec() {
		if(PayrollDatabase.getEmployee(empId) == null)
			throw new BusinessExcepction("従業員が存在しません。empId=" + empId);
		if(!(PayrollDatabase.getEmployee(empId).getPaymentClassfication() instanceof CommistonedClassfication))
			throw new BusinessExcepction("歩合制の従業員ではありません。empId=" + empId);
		CommistonedClassfication commistoned = (CommistonedClassfication) PayrollDatabase.getEmployee(empId).getPaymentClassfication();
		commistoned.addSalesRecipt(new SalesRecipt(date,amount));
		
	}
}
