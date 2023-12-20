package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		/*
		 * 
FORMATO DO PROGRAMA PARA TESTE
Entre os dados do contrato:
Numero: 8028
Data (dd/MM/yyyy): 25/06/2018
Valor do contrato: 600
Entre com o numero de parcelas: 3
Parcelas:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
		 */		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt); 
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, n);
		
		System.out.println("Parcelas:");
		for(Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		
		sc.close();
	}

}
