import java.util.LinkedList;
import java.util.Random;

import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;


public class MainScreen {
// 20 drinks quiz.
	Display display;
	Shell shell;
	String selectedMode;
	Button[] checkBoxs;
	

	//@TODO : make this configurable through ini file 
	int numberOfQuestions = 4;
	MainScreen(int mode) {
		if(mode == 1){
			selectedMode = "simple";
		}
		else if(mode == 2) {
			selectedMode = "intermediate";
		}
		else if(mode == 3) {
			selectedMode = "advanced";
		}
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.RESIZE);
		shell.setSize(300,300);
		shell.setImage(new Image(display, "c:\\eclipse\\images.jpg")); 
		shell.setText("alcoholic trainer test");

		final Button b1 = new Button(shell, SWT.PUSH); 
		b1.setBounds(140,140,75,40); 
		b1.setText("submit"); 
		
		//adding the listener so that we can change view when clicking...
		b1.addSelectionListener(new SelectionAdapter( ) 
		{    
			public void widgetSelected(SelectionEvent e) {
			if(checkBoxs != null){	
				this.processAnswer(checkBoxs);
				for(int i = 0; i < checkBoxs.length; i++) {
					checkBoxs[i].dispose();
				}
			}
				this.drawChoices();
				if(numberOfQuestions<=0) { 
					//@TODO: replace the exit with drawing the final screen.
					System.out.println("finished the test. now draw the final screen");
					System.exit(0);
				}
				}
				
			/*	System.out.println("button name:" + checkedButtons[0].getText());
				System.out.println("button value:" + checkedButtons[0].isEnabled());
				System.out.println("go ahead");*/
		
			private void drawChoices() {
				//get a random drink from the list
				PropertiesReader pr = new PropertiesReader("c:\\Users\\kenny\\workspace\\AlcoholicTrainer\\drinks.xml");
				LinkedList drinks = pr.getDrinks();
				Random r = new Random();
				int randomDrink = r.nextInt(drinks.size());
				//System.out.println("random drink:" + randomDrink);
				LinkedList drinkelements = pr.getDrinkElements(drinks.get(randomDrink).toString(), 0);

				shell.setText(drinks.get(randomDrink).toString());
				checkBoxs = new Button[drinkelements.size()];
				//System.out.println("drink elements size:" + drinkelements.size());
				for(int i=0; i< drinkelements.size(); i++) {
					checkBoxs[i] = new Button(shell, SWT.CHECK);
					checkBoxs[i].setSelection(true);
					checkBoxs[i].setBounds(50,50+25*i, 75+25*i,200);
					checkBoxs[i].setText(drinkelements.get(i).toString());
					checkBoxs[i].pack();
				}
				
			}
			private void processAnswer(Button[] checkedButtons){
				System.out.println("checking in input params>>>>>>>>>>>>>>");
				System.out.println(checkedButtons[0].getSelection());
				System.out.println(checkedButtons[1].getSelection());
				System.out.println(checkedButtons[2].getSelection());
				System.out.println(checkedButtons[3].getSelection());
				//getselection returns true or false.
				
				System.out.println("question is:");
				Random r = new Random();
				Boolean bool = r.nextBoolean();
				if(bool) {
					System.out.println("correct");
				}
				else {
					System.out.println("wrong");
				}
					System.out.println(numberOfQuestions);
					numberOfQuestions--;
			}

		
	});
		//final Label l1 = new Label(shell, SWT.CENTER);
		//l1.setText("The alcoholic bartender");
	    //l1.setBounds(80,60,75,40);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		System.out.println("main test screen");
	}
}
