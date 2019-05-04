//Sachin Subramanian P2
package main;



import java.util.ArrayList;

import java.util.List;

public class PersonDatabase {

	/**
	 * This Node is the root of a tree of Person
	 * objects that is sorted by last
	 * name and then first name (ignoring case).
	 * This tree allows duplicate names (as long as
	 * the birth dates are different).
	 */
	private Node rootOfNameTree;
	
	/**
	 * This Node is the root of a tree 
	 * of Person objects that is sorted by birth
	 * date. This tree allows duplicate 
	 * birth dates (as long as the names are
	 * different).
	 */
	private Node rootOfBirthDateTree;

	/**
	 * The number of nodes in the tree.
	 * Both trees should have the same
	 * number of nodes.
	 */
	private int size;
	
	
	/**
	 * Returns number of Persons in
	 * the database
	 * @return number of Persons
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Add person to the database unless 
	 * a Person object that is equal already
	 * exists. If a node is created, it 
	 * should be added to both the name tree
	 * and the birth date tree.
	 * @param p  a person
	 * @return true if person is added, false otherwise
	 */
	public boolean put(Person p) {
		//hint: create two private put methods
		// for each of the trees and call
		// them here
		
		
		Node newNode = new Node(p);
	
		if (rootOfBirthDateTree == null || rootOfNameTree == null) {
			rootOfNameTree = newNode;
			rootOfBirthDateTree = newNode;
			
			size++;
			return true;
		} else {
			boolean name = sortName(p);
			boolean date = sortDate(p);
			if (name && date) {
				return true;
			}
			
			System.out.println(size);
			return false;
		}
		
		}
	
		private boolean sortName(Person p) {
			Node otherNode = new Node(p);

			
			Node runnerTwo = rootOfNameTree;
			String fullNameOne = runnerTwo.item.lastName + " " + runnerTwo.item.firstName;
			
			String fullNameTwo = p.lastName + " " + p.firstName;
			//String fullNameOne = runnerTwo.item.lastName + " " + runnerTwo.item.firstName;
			//System.out.println(p + "**");
				while (runnerTwo != null) {
					//System.out.println(runnerTwo.item.lastName);
					//System.out.println(newNode.item.lastName);
					//System.out.println(size);
					
						if (runnerTwo.item.equals(p) ) {
							
							return false;
							
						}
						 if (fullNameOne.equals(fullNameTwo)) {
							
								//System.out.println("yes");
								//return sortDate(otherNode.item);
							
							
								
								
									
									
									if (runnerTwo.left == null) {
										runnerTwo.left = otherNode;
										//System.out.println(runnerTwo.left.item + "*");
										size++;
										return true;
									} else {  
										if (runnerTwo.right == null) {
											runnerTwo.right = otherNode;
											//System.out.println(runnerTwo.right.item + "#");
											size++;
											return true;
										} else {
											runnerTwo = runnerTwo.left;
										}
									}
								
									
								
								
						} else if (fullNameOne.compareTo(fullNameTwo) > 0) {
							if (runnerTwo.left == null) {
								runnerTwo.left = otherNode;
								size++;
								return true;
							} else {
								
							runnerTwo = runnerTwo.left;
							}
						} else {
							if (runnerTwo.right == null) {
								runnerTwo.right = otherNode;
								size++;
								return true;
							} else {
								
							runnerTwo = runnerTwo.right;
							}
						}
							
				}
				
			
				return false; 
		}
		private boolean sortDate(Person p) {
			Node newNode = new Node(p);
		
			Node runnerOne = rootOfBirthDateTree;
			
			while (runnerOne != null) {
				
				String dateOne = runnerOne.item.birthYear + "/"  + runnerOne.item.birthMonth + "/" + runnerOne.item.birthDay;
				String dateTwo = p.birthYear + "/"  + p.birthMonth + "/" + p.birthDay;
		       // System.out.println(runnerOne.item);
				if (runnerOne.item.equals(p) ) {
					//System.out.println(runnerTwo.right.item.lastName);
					//System.out.println(newNode.item.lastName);
					return false;
					
				} 
				if (dateOne.equals(dateTwo)) {
							//return sortName(newNode.item);
					while ( runnerOne.left != null) {
						
						runnerOne = runnerOne.left;
						
						
					}
					
					
					runnerOne.left = newNode;
					return true;
				} else if (dateOne.compareTo(dateTwo) > 0) {
					if (runnerOne.left == null) {
						runnerOne.left = newNode;
						
						return true;
					} else {
						runnerOne = runnerOne.left;
					}
				} else {
					if (runnerOne.right == null) {
						runnerOne.right = newNode;
						
						return true;
					} else {
						runnerOne = runnerOne.right;
					}
				}
			
				
			}
		
			
			//System.out.println(size);
			return false;
		}
		public int printJohnSmith(Node root,int depth, String firstName, String lastName) {
			int count = 0;
		
			if (root == null) {
				return 0;
			} 
			
			System.out.println(root.item);
			System.out.println("The depth is " + depth);
			if (root.item.lastName.equals(lastName) && root.item.firstName.equals(firstName) )  {
				count++;
				System.out.println(firstName + " " + lastName + " was found at a depth of " + depth);
				
			}
			if (root.left != null && root.right != null) {
				System.out.println("There are two children");
				System.out.println(root.left.item + "!!");
				System.out.println(root.right.item + "##");
			} else if (root.left != null) {
				System.out.println("Child on the left");
			} else if (root.right != null) {
				System.out.println("Child on the right");
			} else {
				System.out.println("No kids");
			}
			
			if (root.left != null ) {
				depth++;
				System.out.println("Coming from the left");
				return count + printJohnSmith(root.left, depth, firstName, lastName);
				
			} if (root.right != null) {
				
				System.out.println("Coming from the right");
				depth++;
				return count + printJohnSmith(root.right, depth, firstName, lastName);
				
			} else {
				System.out.println("");
				System.out.println("Right is null");
			}
			
			return count;
			
		}

	/**
	 * Returns a list of all Person objects in the database with the given name.
	 * This method should search in name tree.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return a list of Person objects (possibly empty)
	 */
	public List<Person> find(String firstName, String lastName) {
		List<Person> names = new ArrayList<Person>();
		
		
		if (rootOfNameTree == null) {
			names = null;
		} else {
			
			Node runner = rootOfNameTree;
			if (runner.item.lastName.equals(lastName) && runner.item.firstName.equals(firstName)) {
				names.add(runner.item);
			}
			while (runner.right != null || runner.left != null ) {
				if (runner.right != null) {
				 if (runner.right.item.lastName.equals(lastName) && (runner.right.item.firstName.equals(firstName)) ) {
					names.add(runner.right.item);
					runner = runner.right;
				} else {
					runner = runner.right;
				 }
				}
				if (runner.left != null) {
		     	if (runner.left.item.firstName.equals(firstName) && runner.left.item.lastName.equals(lastName))  {
					names.add(runner.left.item);
					runner = runner.left;
			
					
				}  else {
					runner = runner.left;
				}
				}
		     	//System.out.println(names);
		    	
				
			}
			
		}
		
	
		//consider using LinkedList
		//consider sorting the tree alphabetically
		return names;
	}

	/**
	 * Returns a list of all Person objects in the database with the given birth
	 * date. This method should search in the birth date tree.
	 * 
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 * @return a list of Person objects (possibly empty)
	 */
	public List<Person> find(int birthDay, int birthMonth, int birthYear) {
		List<Person> dates = new ArrayList<Person>();
		if (rootOfBirthDateTree == null) {
			dates = null;
		} else {
			Node runner = rootOfBirthDateTree;
			if (runner.item.birthDay == birthDay && runner.item.birthMonth == birthMonth && runner.item.birthYear == birthYear ) {
				dates.add(runner.item);
			}
			while (runner.right != null || runner.left != null) {
				if (runner.right != null) {
				if (runner.right.item.birthDay == birthDay && runner.right.item.birthMonth == birthMonth && runner.right.item.birthYear == birthYear) {
					dates.add(runner.right.item);
					runner = runner.right;
				} else {
					runner = runner.right;
				}
				}
				if (runner.left != null) {
				if (runner.left.item.birthDay == birthDay && runner.left.item.birthMonth == birthMonth && runner.left.item.birthYear == birthYear) {
					dates.add(runner.left.item);
					runner = runner.left;
				} else {
					runner = runner.left;
				}
				}
			}
			//System.out.println(dates);
		}
		//consider using LinkedList
		//consider sorting the tree alphabetically
		return dates;
	}
	
	
	//***** For testing purposes
	public Node getNameRoot() {
		return rootOfNameTree;
	}
	
	public Node getBDayRoot() {
		return rootOfBirthDateTree;
	}
	

}
