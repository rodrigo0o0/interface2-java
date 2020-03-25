package model.services;

import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public interface PaymentService {
	List<Installment> processInstallment(Contract contract);
}
