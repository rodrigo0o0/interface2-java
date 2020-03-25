package model.services;

public interface PaymentService {
	double basicQuota (double amount, int value);
	double quota(double amount);
}
