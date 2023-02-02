 package com.project.Bean;

public class BalanceSheetBean {
private String incomes;
private Double Inc_amount;
private String expenses;
private Double Exp_amount;
public String getIncomes() {
	return incomes;
}
public void setIncomes(String incomes) {
	this.incomes = incomes;
}
public Double getInc_amount() {
	return Inc_amount;
}
public void setInc_amount(Double inc_amount) {
	Inc_amount = inc_amount;
}
public String getExpenses() {
	return expenses;
}
public void setExpenses(String expenses) {
	this.expenses = expenses;
}
public Double getExp_amount() {
	return Exp_amount;
}
public void setExp_amount(Double exp_amount) {
	Exp_amount = exp_amount;
}
@Override
public String toString() {
	return "BalanceSheetBean [incomes=" + incomes + ", Inc_amount=" + Inc_amount + ", expenses=" + expenses
			+ ", Exp_amount=" + Exp_amount + "]";
}



}
