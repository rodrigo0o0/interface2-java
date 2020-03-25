package model.services;

public class PaypalService implements PaymentService {

	@Override
	public double basicQuota (double amount, int value) {
		return amount * ((double)value /100);
	}

	@Override
	public double quota(double amount) {
		return amount * 0.02;
	}

}
