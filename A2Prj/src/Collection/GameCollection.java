package Collection;

import java.util.ArrayList;
import java.util.Vector;

import Interfaces.ICollection;
import Interfaces.IIterator;
import Objects.GameObject;

//Class for a user defined collection for the Iterator design Pattern
public class GameCollection  implements ICollection{
	
	//Attributes for the class ObjectCollection---------------------------------------------
	
	private ArrayList<GameObject> objCollection;
	
	//Behaviours for the class ObjectCollection---------------------------------------------
	
	//Constructor
	public GameCollection() {
		
		objCollection = new ArrayList<GameObject>();
		
	}

	//Method to add
	@Override
	public boolean add(GameObject obj) {
		
		if(obj != null) {
			
			objCollection.add(obj);
			return true;
			
		}
		else
			return false;
		
	}

	//method to return an iterator over the collection
	@Override
	public IIterator getIterator() {

		return new ArrayIterator();
		
	}

	//method to remove from collection
	@Override
	public boolean remove(GameObject obj) {
		
		if(obj != null) {
			
			objCollection.remove(obj);
			return true;
			
		}
		else
			return false;
	}
	
	//Inner class
	private class ArrayIterator implements IIterator{

		//Attributes for the inner class vectorIterator-----------------------------------
		
		private int currentIndex;
		
		//Behaviours for the class vectorIterator-----------------------------------------
		
		public ArrayIterator() {
			
			currentIndex = -1;
			
		}
		
		@Override
		public boolean hasNext() {
			
			if(objCollection.size() <= 0)
				return false;
			if(currentIndex == objCollection.size() - 1)
				return false;
			else 
				return true;
			
		}

		@Override
		public GameObject getNext() {
			
			currentIndex++;
			return objCollection.get(currentIndex);
			
		}
	
	}

	//returns size of the collection
	@Override
	public int size() {
		
		return objCollection.size();
	}

}
