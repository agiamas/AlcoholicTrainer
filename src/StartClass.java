import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.w3c.dom.*;
import java.util.LinkedList;
import java.util.*;

public class StartClass {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Iterator iterator;
		PropertiesReader pr = new PropertiesReader("c:\\Users\\kenny\\workspace\\AlcoholicTrainer\\drinks.xml");
		Document tempdoc;
		tempdoc = pr.getDocument();
		LinkedList drinks = pr.getDrinks();

		LinkedList drinkelements = pr.getDrinkElements(drinks.get(1).toString());
		 Iterator itr = drinkelements.iterator();
		 while(itr.hasNext()) {
			 System.out.println("drink elements:" + itr.next());	
		 }
		
		// testing code for the linkedlist of the drinks we got.
		/*		iterator = drinks.iterator();     
	    while (iterator.hasNext()){
	      System.out.print("the drinks we got: " + iterator.next()+" ");  
	    }
	*/
		// TODO Auto-generated method stub

	}
	
	
}
