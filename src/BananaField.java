

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class BananaField extends Application {
	
    public static final int NUMBER_OF_ROWS = 15, NUMBER_OF_COLUMNS= 15;
    private static final int CELL_SIZE = 25;
    private static final int CELL_PADDING = 4;
    private static final String CELL_CONTENTS_DESTROYED = "#"; // "#*+" 
    private static final String CELL_CONTENTS_INTACT = " "; // "#*+"
    private static final Insets CELL_INSETS = new Insets(CELL_PADDING,CELL_PADDING,CELL_PADDING,CELL_PADDING);
    
    private final List<BananaButton> buttons = new ArrayList<BananaButton>();
    private final Map<String,BananaButton> buttonsMap = new HashMap<String, BananaButton>();
    private TextArea textArea; 
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banana Trees ");
        
        //StackPane root = new StackPane();
        GridPane root = new GridPane();

        generateBananaButtons(root);
        
        generateStringControls(root);
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void generateBananaButtons(GridPane root) {
        BananaButton btn;
        int r,c;

        for (int i=0;i<NUMBER_OF_ROWS*NUMBER_OF_COLUMNS;i++ ) {
        	r = i/NUMBER_OF_COLUMNS; c=i%NUMBER_OF_COLUMNS;
        	btn = getDefaultButton(r,c);
        	buttons.add(btn);
        	buttonsMap.put(btn.getDisplayId(), btn);
        	root.getChildren().add(btn);
        	root.setConstraints(btn, c, r, 1, 1, 
        			HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER, 
        			CELL_INSETS);
        }
    }
    
    private void generateStringControls(GridPane root) {
    	
    	Button btn = new Button(" Generate() ");
    	btn.setOnAction(generateStringEventHandler());
    	
        root.getChildren().add(btn);
        root.setConstraints(btn, 0, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS+1, 1,
        		HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, 
    			CELL_INSETS);
        
        textArea = new TextArea();
        textArea.setEditable(true);
        root.getChildren().add(textArea);
        root.setConstraints(textArea, 0, NUMBER_OF_ROWS+1, NUMBER_OF_COLUMNS+1, 1,
        		HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, 
    			CELL_INSETS);

    	Button loadBtn = new Button(" Load() ");
    	loadBtn.setOnAction(loadStringEventHandler());
        root.getChildren().add(loadBtn);
        root.setConstraints(loadBtn, 0, NUMBER_OF_ROWS+2, NUMBER_OF_COLUMNS+1, 1,
        		HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, 
    			CELL_INSETS);

        
    }

    private EventHandler generateStringEventHandler() {
    	return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	StringBuilder sb = new StringBuilder("(");
            	for(BananaButton btn:buttons) {
            		if(btn.isDestroyed()) {
            			sb.append("("+(btn.getR()+1)+","+(btn.getC()+1)+")").append(',');
            		}
            	}
            	if(sb.charAt(sb.length()-1)==',') {
            		sb.deleteCharAt(sb.length()-1);
            	}
            	sb.append(')');
            	System.out.println(sb.toString());
            	textArea.setText(sb.toString());
            }
        };
    }
    
    private EventHandler loadStringEventHandler() {
    	return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String stringContents = textArea.getText();
            	System.out.println(stringContents);
            	int index=1;
            	String s1, s2;
            	int i1, i2;
            	index = stringContents.indexOf('(',index);
                while(index>0&&index<stringContents.length()-2) {
                	index = stringContents.indexOf('(',index);
                	s1 = stringContents.substring(index+1, index=stringContents.indexOf(',',index));
                	s2 = stringContents.substring(index+1, index=stringContents.indexOf(')',index));
//                	System.out.println(s1 + " " + s2);
                	i1 = Integer.parseInt(s1);
                	i2 = Integer.parseInt(s2);
                	String idString = BananaButton.getDisplayId(i1-1, i2-1);
                	buttonsMap.get(idString).setDestroyed(true);
                	System.out.println(idString);
                }          	
            }
            
            private void deselectAll() {
            	for(BananaButton btn: buttonsMap.values()) {
            		btn.setDestroyed(false);
            	}
            }
            
        };
    }
    
    private BananaButton getDefaultButton(int r, int c) {
    	BananaButton btn = new BananaButton(r,c);
    	btn.setText(CELL_CONTENTS_INTACT);
    	btn.setMinSize(CELL_SIZE, CELL_SIZE);
    	btn.setMaxSize(CELL_SIZE, CELL_SIZE);
    	return btn;
    }
    
    static class BananaButton extends ToggleButton {

    	private int r,c;
    	private boolean destroyed=false;
    	
		public BananaButton(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.setOnAction(toggler);
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		public String getDisplayId() {
			return this.getDisplayId(r, c);
		}
		
		public static String getDisplayId(int r, int c) {
			return r+"#"+c;
		}
		
		public boolean isDestroyed() {
			return destroyed;
		}

		public void setDestroyed(boolean destroyed) {
			this.destroyed = destroyed;
			this.updateButtonState();
		}

		private void updateButtonState() {
			if(destroyed) {
				this.setText(CELL_CONTENTS_DESTROYED);
				this.setSelected(true);
			}else{
				this.setText(CELL_CONTENTS_INTACT);
				this.setSelected(false);
    		}
		}
   	
    }
    
    static EventHandler toggler = new EventHandler<ActionEvent>() {
    	@Override
    	public void handle(ActionEvent event) {
    		BananaButton btn = (BananaButton)event.getSource();
    		if(btn.isSelected()) {
    			btn.setDestroyed(true);
    		} else {
    			btn.setDestroyed(false);
    		}
    	}
    };

}