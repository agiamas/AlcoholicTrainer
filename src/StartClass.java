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
		Iterator itr2 = drinks.iterator();

		LinkedList drinkelements = pr.getDrinkElements(drinks.get(0).toString(), 0);
		//LinkedList drinkelements = pr.getDrinkElements("screaming orgasm");
		 Iterator itr = drinkelements.iterator();
		 while(itr.hasNext()) {
			 System.out.println("drink elements:" + itr.next());	
		 }
		StartScreen ss = new StartScreen();
				
		
	}
	
	
}
