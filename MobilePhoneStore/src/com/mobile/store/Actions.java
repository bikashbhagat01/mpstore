package com.mobile.store;

public interface Actions {

	void addPhone();
	int deletePhone();
	int searchPhone(int criteria);
	void searchByCost(double start, double end);
	void displayAllPhone();
	void showDiscountedPrice();
	void showActions();
	
	
}
