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
	public static void main(String[] args)
	{
		Random rng = new Random();
		
		ArrayQueue<Integer> customerQueue = new ArrayQueue<Integer>(50);
		DictionaryNode<Integer, Integer> dict = new DictionaryNode<Integer, Integer>();
		
		ArrayStack<Integer> cheese = new Stack<Integer>();
		ArrayStack<Integer> bun = new Stack<Integer>();
		ArrayStack<Integer> patty = new Stack<Integer>();
		ArrayStack<Integer> lettus = new Stack<Integer>();
		ArrayStack<Integer> tomato = new Stack<Integer>();
		ArrayStack<Integer> onion = new Stack<Integer>();
		
		List[] menu = new List[6];
		List burger = new List<Stack>();
		List cheeseBurger = new List<Stack>();
		List veganBurger = new List<Stack>();
		List burgerNoOnion = new List<Stack>();
		List cheeseBurgerNoOnion = new List<Stack>();
		List burgerNoTomato = new List<Stack>();
		
		int lostCustomers;
		int wasteCheese;
		int wasteBun;
		int wastePatty;
		int wasteLettus;
		int wasteTomato;
		int wasteOnion;
		int orderOne;
		int orderTwo;
		int orderThree;
		int orderFour;
		int orderFive;
		int orderSix;
		
		
		
	}
}