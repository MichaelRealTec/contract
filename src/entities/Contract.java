package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Contract {
	// Atributos
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	// Métodos Getters e Setters
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}
	
	public List<Installment> getInstallments(){
		return installments;
	}
	
	// Método Construtor
	public Contract() {
		
	}
	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue; 
	}
}
