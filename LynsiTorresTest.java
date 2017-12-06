/*
	Final Part 1
	
	Simulates a day at In and Out
	
	@author Drue Hidalgo
	@version 1.0
*/

import java.util.Random;
import java.util.Iterator;

public class LynsiTorresTest
{
	private static final int SHIPMENT_MAX = 1000;
	
	public static void main(String[] args)
	{
		Random rng = new Random();
		
		ArrayQueue<Integer> customerQueue = new ArrayQueue<Integer>(50);
		DictionaryNode<Integer, Integer> dict = new DictionaryNode<Integer, Integer>();
		
		ArrayStack<Integer> cheese = new ArrayStack<Integer>(SHIPMENT_MAX);
		ArrayStack<Integer> bun = new ArrayStack<Integer>(SHIPMENT_MAX);
		ArrayStack<Integer> patty = new ArrayStack<Integer>(SHIPMENT_MAX);
		ArrayStack<Integer> lettuce = new ArrayStack<Integer>(SHIPMENT_MAX);
		ArrayStack<Integer> tomato = new ArrayStack<Integer>(SHIPMENT_MAX);
		ArrayStack<Integer> onion = new ArrayStack<Integer>(SHIPMENT_MAX);
		
		ListFixesSizedArray[] menu = new ListFixesSizedArray[6];
		ListFixesSizedArray burger = new ListFixesSizedArray<ArrayStack>();
		ListFixesSizedArray cheeseBurger = new ListFixesSizedArray<ArrayStack>();
		ListFixesSizedArray veganBurger = new ListFixesSizedArray<ArrayStack>();
		ListFixesSizedArray burgerNoOnion = new ListFixesSizedArray<ArrayStack>();
		ListFixesSizedArray cheeseBurgerNoOnion = new ListFixesSizedArray<ArrayStack>();
		ListFixesSizedArray burgerNoTomato = new ListFixesSizedArray<ArrayStack>();
		
		menu[0] = burger;
		menu[1] = cheeseBurger;
		menu[2] = veganBurger;
		menu[3] = burgerNoOnion;
		menu[4] = cheeseBurgerNoOnion;
		menu[5] = burgerNoTomato;
		
		burger.add(lettuce);
		burger.add(bun);
		burger.add(patty);
		burger.add(tomato);
		burger.add(onion);

		cheeseBurger.add(onion);
		cheeseBurger.add(cheese);
		cheeseBurger.add(lettuce);
		cheeseBurger.add(tomato);
		cheeseBurger.add(patty);
		cheeseBurger.add(bun);

		veganBurger.add(lettuce);
		veganBurger.add(lettuce);
		veganBurger.add(tomato);
		veganBurger.add(onion);

		burgerNoOnion.add(lettuce);
		burgerNoOnion.add(patty);
		burgerNoOnion.add(tomato);
		burgerNoOnion.add(bun);

		cheeseBurgerNoOnion.add(cheese);
		cheeseBurgerNoOnion.add(bun);
		cheeseBurgerNoOnion.add(lettuce);
		cheeseBurgerNoOnion.add(tomato);
		cheeseBurgerNoOnion.add(patty);

		burgerNoTomato.add(patty);
		burgerNoTomato.add(lettuce);
		burgerNoTomato.add(bun);
		burgerNoTomato.add(onion);
		
		int lostCustomers;
		int wasteCheese;
		int wasteBun;
		int wastePatty;
		int wasteLettuce;
		int wasteTomato;
		int wasteOnion;
		int orderOne;
		int orderTwo;
		int orderThree;
		int orderFour;
		int orderFive;
		int orderSix;
		
		int month = 12;
		for(int day = 1; day < 31; day++)
		{
			int currentDay = month*100 + day;
			
			lostCustomers = 0;
			wasteCheese = 0;
			wasteBun = 0;
			wastePatty = 0;
			wasteLettuce = 0;
			wasteTomato = 0;
			wasteOnion = 0;
			orderOne = 0;
			orderTwo = 0;
			orderThree = 0;
			orderFour = 0;
			orderFive = 0;
			orderSix = 0;
			
			int untilShipment = 0;
			
			dict.clear();
			
			for(int hour = 9; hour < 22; hour++)
			{
				if(hour == 9 && untilShipment == 0)
				{
					System.out.println("Shimpment today");
					int shipment = SHIPMENT_MAX - rng.nextInt(300);
					
					for(int i = 0; i < shipment; i++)
					{
						int item = rng.nextInt(6);
						if(item == 0)
						{
							bun.push(currentDay);
						}
						else if(item == 1)
						{
							patty.push(currentDay);
						}
						else if(item == 2)
						{
							lettuce.push(currentDay);
						}
						else if(item == 3)
						{
							tomato.push(currentDay);
						}
						else if(item == 4)
						{
							onion.push(currentDay);
						}
						else
						{
							cheese.push(currentDay);
						}
					}
					untilShipment = 6 - rng.nextInt(4);
				}
				
				else if(hour > 9 && hour < 20)
				{
					int customers = rng.nextInt(100) + 1;
					if(customers > 50)
					{
						lostCustomers += customers - 50;
						customers = 50;
					}
					for(int i = 0; i < customers; i++)
					{
						int customerID = hour*100 +i;
						customerQueue.enqueue(customerID);
					}
					for(int i = 0; i < customers; i++)
					{
						int order = rng.nextInt(6);
						boolean inStock = true;
						
						int customerID = customerQueue.dequeue();
						if(inStock)
						{
							for(int j = 0; j < menu[order].getLength(); j++)
							{
								menu[order].remove(j);
							}
							if(order == 0)
							{
								orderOne++;
							}
							else if(order == 1)
							{
								orderTwo++;
							}
							else if(order == 2)
							{
								orderThree++;
							}
							else if(order == 3)
							{
								orderFour++;
							}
							else if(order == 4)
							{
								orderFive++;
							}
							else if(order == 5)
							{
								orderSix++;
							}
						}
						dict.add(customerID, order + 1);
					}
				}
				else if(hour == 21)
				{
					MergeRecursive.sort(cheese.toArray(), 0, cheese.getSize() - 1);
					MergeRecursive.sort(bun.toArray(), 0, bun.getSize() - 1);
					MergeRecursive.sort(lettuce.toArray(), 0, lettuce.getSize() - 1);
					MergeRecursive.sort(tomato.toArray(), 0, tomato.getSize() - 1);
					MergeRecursive.sort(onion.toArray(), 0, onion.getSize() - 1);
					MergeRecursive.sort(patty.toArray(), 0, patty.getSize() - 1);
					
					while (!patty.isEmpty() && currentDay - patty.peek() > 4)
					{
						patty.pop();
						wastePatty++;
					}
					while (!lettuce.isEmpty() && currentDay - lettuce.peek() > 3)
					{
						lettuce.pop();
						wasteLettuce++;
					} 
					while (!tomato.isEmpty() && currentDay - tomato.peek() > 3)
					{
						tomato.pop();
						wasteTomato++;
					}
					while (!onion.isEmpty() && currentDay - onion.peek() > 5)
					{
						onion.pop();
						wasteOnion++;
					}
					while (!cheese.isEmpty() && currentDay - cheese.peek() > 2)
					{
						cheese.pop();
						wasteCheese++;
					}
					while (!bun.isEmpty() && currentDay - bun.peek() > 5) //pop expired items off stack - since sorted, will pop all off
					{
						bun.pop();
						wasteBun++;
					}
				}
			}
			untilShipment--;
			System.out.printf("December " + day); 
            System.out.printf("Customers lost: " + lostCustomers);
            System.out.printf("Wasted cheese: " + wasteCheese);
            System.out.printf("Wasted buns: " + wasteBun);
            System.out.printf("Wasted patties: " + wastePatty);
            System.out.printf("Wasted lettuce: " + wasteLettuce);
            System.out.printf("Wasted tomato: " + wasteTomato);
            System.out.printf("Wasted onion: " + wasteOnion);
            System.out.printf("Item 1 ordered " + orderOne + " times");
            System.out.printf("Item 2 ordered " + orderTwo + " times");
            System.out.printf("Item 3 ordered " + orderThree + " times");
            System.out.printf("Item 4 ordered " + orderFour + " times");
            System.out.printf("Item 5 ordered " + orderFive + " times");
            System.out.printf("Item 6 ordered " + orderSix + " times");
		}
		
		Iterator key = dict.getKeyIterator();
		Iterator value = dict.getValueIterator();
		while(key.hasNext())
		{
			System.out.print("Customer "+ key.next() + " ordered " + value.next());
		}
		
		System.out.println("______________________");
	}
}