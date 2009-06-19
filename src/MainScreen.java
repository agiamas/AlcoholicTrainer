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
	int numberOfQuestions = 2;
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
		b1.setText("Next"); 
		//adding the listener so that we can change view when clicking...
		b1.addSelectionListener(new SelectionAdapter( ) {    public void widgetSelected(SelectionEvent e) { 
	         System.out.println("go ahead");
	         while ( numberOfQuestions > 0 ) {
	        	 this.NextQuestion();
	        	 numberOfQuestions--;
	         }
	         
	   }

		private void NextQuestion() {
			 b1.dispose();
	        shell.setText("drink1");
	        final Button choice1 = new Button(shell, SWT.CHECK); 
	        choice1.setBounds(50,50,75,20); 
	        choice1.setText("Check Me1"); 
	        final Button choice2 = new Button(shell, SWT.CHECK); 
	        choice2.setBounds(50,75,100,20); 
	        choice2.setText("No, Check Me2");
	        final Button choice3 = new Button(shell, SWT.CHECK); 
	        choice3.setBounds(50,100,125,20); 
	        choice3.setText("No, Check Me3");
	        final Button choice4 = new Button(shell, SWT.CHECK); 
	        choice4.setBounds(50,125,150,20); 
	        choice4.setText("No, Check Me4");
	        final Button submitChoice = new Button(shell, SWT.PUSH);
	        submitChoice.setBounds(50,150,175,40);
	        submitChoice.setText("submit");
	       
			// TODO Auto-generated method stub
			
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
