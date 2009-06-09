import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class StartScreen {
	Display display;
	Shell shell;
	
	StartScreen() {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.RESIZE);
		shell.setSize(300,300);
		shell.setImage(new Image(display, "c:\\eclipse\\images.jpg")); 
		shell.setText("test");
		final Button b1 = new Button(shell, SWT.PUSH); 
		b1.setBounds(90,90,75,40); 
		b1.setText("Start!"); 
		//adding the listener so that we can change view when clicking...
		b1.addSelectionListener(new SelectionAdapter( ) {    public void widgetSelected(SelectionEvent e) { 
	         System.out.println("Push Me Was Pushed"); 
	   } 
	});
		final Label l1 = new Label(shell, SWT.CENTER);
		l1.setText("The alcoholic bartender");
	    l1.setBounds(80,60,75,40);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
