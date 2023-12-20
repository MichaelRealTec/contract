package entities;
//import
import java.time.LocalDate;


public class Installment {
	//Atributos
	private LocalDate date;
	private Double amount;
	
	//Métodos
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setAmount(Double amount) {
		
	}
	
	public Double getAmount() {
		return amount;
	}
	
	// Construtor
	public Installment() {
		
	}
	
	public Installment(LocalDate date, Double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	
}
