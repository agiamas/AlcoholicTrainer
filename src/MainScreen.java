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
		b1.setBounds(90,90,75,40); 
		b1.setText("submit"); 
		
		//adding the listener so that we can change view when clicking...
		b1.addSelectionListener(new SelectionAdapter( ) 
		{    
			public void widgetSelected(SelectionEvent e) { 
				Button[] checkedButtons;
				NextQuestion nq = new NextQuestion();
				checkedButtons = nq.RenderNextQuestion(shell, numberOfQuestions);
				//if its the first time invoked, do nothing, else get the values for the buttons
				//and then clear the buttons from the gui
				if(checkedButtons != null) {
				System.out.println("button 0:"+checkedButtons[0]);
				this.processAnswer(checkedButtons);
				for(int i=0; i< checkedButtons.length; i++) {
					//checkedButtons[i].dispose();
					System.out.println("button " + i + " is set");
				}
				if(numberOfQuestions<=0) { 
					//@TODO: replace the exit with drawing the final screen.
					System.out.println("finished the test. now draw the final screen");
					System.exit(0);
				}
				}
				
			/*	System.out.println("button name:" + checkedButtons[0].getText());
				System.out.println("button value:" + checkedButtons[0].isEnabled());
				System.out.println("go ahead");*/
		}
			private void processAnswer(Button[] checkedButtons){
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
