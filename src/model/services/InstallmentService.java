package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class InstallmentService {
	
	private PaymentService paymentService;
	
	public InstallmentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int installments) {
		double totalValue = contract.getTotalValue();
		Date date = contract.getDate();
		for(int i = 1; i <= installments; i++) {
			double quotaMonthly = totalValue / installments;
			quotaMonthly +=  paymentService.basicQuota(quotaMonthly, i);
			System.out.println("basic quota # "+ i + " : " + paymentService.basicQuota(quotaMonthly, i));
			quotaMonthly += paymentService.quota(quotaMonthly);
			System.out.println("quota # "+ i + " : " + paymentService.quota(quotaMonthly));
			Date monthly = addMonth(date, i);
			contract.addInstallment(new Installment(monthly, quotaMonthly));
			
			
			
		}
		
	}
	
	private Date addMonth(Date date, int months) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		date = cal.getTime();
		
		return date;
	}
	
	
}
