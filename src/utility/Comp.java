package utility;

import java.util.Comparator;

public class Comp implements Comparator<Activity> {

	@Override
	public int compare(Activity a1, Activity a2) {
		// TODO Auto-generated method stub
		return a1.getEnd()-a2.getStart();
	}

}
