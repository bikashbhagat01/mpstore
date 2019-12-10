package com.mobile.store;
import java.util.*;
public class Driver implements Actions {
	
	final static String LINEBREAK = "\n============\n";
	static Scanner sc = new Scanner(System.in);
		//Implement Buffered Reader for accepting strings with spaces
	private MobilePhone phone = new MobilePhone();
	private TreeMap<Long,MobilePhone> inventory = new TreeMap<Long,MobilePhone>();

	Driver(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver d = new Driver();
		
		boolean exCode = false;
		
		while(exCode == false){
			
			d.showActions();
			int choice = sc.nextInt();

			switch(choice){
			case 1:
				d.addPhone();
				break;
			case 2:
				d.deletePhone();
				break;
			case 3:
				System.out.println("Enter Criteria for search : ");
				
				boolean intExCode = false;
				while(intExCode == false) {
				System.out.println("1. Brand \n2. OS \n3.Cost \n0.Exit SearchMode");
				
				int criteria = sc.nextInt();
				
				if (!(criteria == 1 || criteria == 2 || criteria == 3 || criteria == 4))
					System.out.println("Incorrect criteria set. Please enter correct criteria.");
				else 
					if (criteria == 0)
						intExCode = true;
				else	
					d.searchPhone(criteria);
				}
				break;
			case 4:
				System.out.println("Enter Initial Amount > press Enter > then Final Cost");
				d.searchByCost(sc.nextDouble(), sc.nextDouble());
				break;
				
			case 5:
				System.out.println("Displaying Complete Inventory");
				d.displayAllPhone();
				break;
				
			case 6:
				System.out.println("Display Discounted Prices with all inventory");
				d.showDiscountedPrice();
				break;
				
			case 0:
				exCode = true;
				break;	
			default:
				System.out.println("Incorrect Option Entered");
				break;
			}
		}
		
		System.out.println("Exit Successful");
	
	}

	
	public void addPhone() {
		// TODO Auto-generated method stub
		
		this.phone.setMobileID();

		System.out.println("Enter details for new phone with generated ID : " + phone.getMobileID());
		
		System.out.println("Enter Brand : ");
		this.phone.setBrand(sc.next());

		System.out.println("Enter Cost : ");
		this.phone.setCost(sc.nextDouble());

		System.out.println("Enter Camera : ");
		this.phone.setCamera(sc.nextDouble());

		System.out.println("Enter Storage : ");
		this.phone.setStorage(sc.nextInt());
		
		System.out.println("Enter Type : ");
		this.phone.setType(sc.next());
		
		inventory.put(this.phone.getMobileID(), new MobilePhone(phone));
		
		System.out.println("Updated new phone entry");
		
	}

	@Override
	public int deletePhone() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Phone ID to remove :");
		int id = sc.nextInt();
		
		if (inventory.containsKey(id)){
			inventory.remove(id);
			System.out.println("Entry with id :" + id + "removed.");
			return id;
		}
		else {
			System.out.println("No entry with id : " + id + "found.");
			return -1;
		}		
		
	}

	@Override
	public int searchPhone(int criteria) {
		// TODO Auto-generated method stub
		
		
		if(criteria == 1) {
				
				System.out.println("Enter Search brand : " );
				String searchBrand = sc.next();
				boolean flag = false;
				for (Map.Entry<Long,MobilePhone>  n : inventory.entrySet()){
				
					if (n.getValue().getBrand().equalsIgnoreCase(searchBrand.trim())){
						System.out.println(n.getValue());
						flag = true;
					}
					System.out.println(LINEBREAK);				
			}
				if (!flag){
					System.out.println("No items found with brand : " + searchBrand);
					return -1;
				}
		}
		
		if(criteria == 2){
			System.out.println("Enter Search OS : [ ios | android | windows ]");
			
			String searchOs = sc.next();
			boolean flag = false;
			
			for(Map.Entry<Long, MobilePhone> n : inventory.entrySet()){
				
				if(n.getValue().getType().equalsIgnoreCase(searchOs.trim()))
				{
					System.out.println(n.getValue());
					flag = true;
				}
				System.out.println(LINEBREAK);				
			}
			if (!flag){
				System.out.println("No items found with OS : " + searchOs);
				return -1;
			}
		}

		if(criteria == 3){
			System.out.println("Enter Search Cost : ");
			
			double searchCost = sc.nextDouble();
			boolean flag = false;
			
			for(Map.Entry<Long, MobilePhone> n : inventory.entrySet()){
				
				if(n.getValue().getCost() == searchCost)
				{
					System.out.println(n.getValue());
					flag = true;
				}
				System.out.println(LINEBREAK);				
			}
			if (!flag){
				System.out.println("No items found with Exact Cost : " + searchCost);
				return -1;
			}
		}
		return 0;
			
	}

	@Override
	public void searchByCost(double start, double end) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		for(Map.Entry<Long, MobilePhone> n : inventory.entrySet()){
			
			if(n.getValue().getCost() <= start && n.getValue().getCost() >= end )
			{
				System.out.println(n.getValue());
				flag = true;
			}
			System.out.println(LINEBREAK);				
		}
		if (!flag){
			System.out.println("No items found within Cost Range : " + start + " <-> " + end);
		}
		
	}

	@Override
	public void displayAllPhone() {
		// TODO Auto-generated method stub
		
		for (Map.Entry<Long,MobilePhone>  n : inventory.entrySet()){
			System.out.println(n.getKey()+ " " + n.getValue());
			System.out.println(LINEBREAK);				
		}
		
	}

	@Override
	public void showDiscountedPrice() {		
		
		for (Map.Entry<Long,MobilePhone>  n : inventory.entrySet()){
			
			System.out.println(n.getKey()+ " " + n.getValue());
			double extra = 0;

			if(n.getValue().getBrand().equalsIgnoreCase("apple") && n.getValue().getCost() >= 25000){
				System.out.printf("Discounted Price = %.2f" + (0.995 * n.getValue().getCost()));
			}
			
			if(n.getValue().getBrand().equalsIgnoreCase("samsung")){
				extra = 0.005;
			} 
			
			if(n.getValue().getType().equalsIgnoreCase("windows")) {
				System.out.println("Discounted Price = " + String.format("%.2f", ((0.99 - extra) * n.getValue().getCost())));
			}
			
			if(n.getValue().getType().equalsIgnoreCase("android")) {
				System.out.println("Discounted Price = " + String.format("%.2f",((0.98 - extra) * n.getValue().getCost())));
			}
			
			System.out.println(LINEBREAK);
		}	
	}


	@Override
	public void showActions() {
		// TODO Auto-generated method stub
		System.out.println("Inventory - Menu");
		System.out.println("-------------------------");
		
		System.out.println("1. Add a Phone");
		System.out.println("2. Delete a Phone");
		System.out.println("3. Search for a Phone by Criteria");
		System.out.println("4. Search by Cost");
		System.out.println("5. Display Inventory");
		System.out.println("6. Display Discounted Price");
		System.out.println("0. Exit");

		
		
	}

}
