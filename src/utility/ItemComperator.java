package utility;

import java.util.Comparator;

public class ItemComperator implements Comparator<Item> {

	
	@Override
	public int compare(Item a1, Item a2) {
		// TODO Auto-generated method stub
//		return a1.getEnd()-a2.getStart();
	   return (a1.getValue()/a1.getWeight()) - (a2.getValue()/a2.getWeight());
	}

}
