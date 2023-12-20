package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	//Atributos
	private OnlinePaymentService onlinePaymentService;
	
	//Método Construtor
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	//Método
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;  // basicQuota = cotaBasica equivale ao valor total da divida dividido pela quantidade de parcelas;
				
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i); //dueDate = data do vencimento + 1 mês (plusMonths acrescenta o valor ao mês);
			double interest = onlinePaymentService.interest(basicQuota, i);              // interest = Juros
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);        // fee = Taxa;
			double quota = basicQuota + interest + fee;
			
			// Adicionar os dados como objeto Installment para armazenar cada contrato na lista 
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
		
	}
}
