package model.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.InstallmentService;
import model.services.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter contract data:");
		System.out.print("Number : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy)");
		String date = sc.nextLine();
		System.out.print("Contract value : ");
		double value = sc.nextDouble();
		System.out.print("Enter number of installments : ");
		int installments = sc.nextInt();
		Contract contract = new Contract(number,sdf.parse(date),value);
		InstallmentService is = new InstallmentService(new PaypalService());
		is.processContract(contract, installments);
		List <Installment>installmentsList = contract.getInstallments();
		System.out.println("Installments : ");
		for (Installment install : installmentsList) {
			System.out.print(install);
		}
		
		
		
		
		sc.close();
	}
}
