import java.applet.Applet;
import java.awt.*;
import java.awt.event.*; 
import java.util.Random;
 
public class RiemmanSumApplet extends Applet implements ActionListener {
	
	// OUR VARIABLES 
    // Construct the button
    // Construct the button
    Button beep = new Button("CALCULATE this sh*t");
    String actionMessage="";


	// Prompt:
    Label prompt, prompt1, prompt2, prompt3, promptA, promptparam;
 
    //TextField degree;
    TextField option, rectangles, leftBound, rightBound, answer;
    TextField[] degreeArr = new TextField[4];
    
    // Global variables
    String myOption;
    int numRec, leftB, rightB;
    double[] parameters = new double[4];
    

    //String endpoint;
    //boolean isValid = true;
 
    Image picture;
    //Image picture2;
 
    
    public void init() {
        setSize(1500, 700);
        // Initialize the number of guesses to zero
        numRec = 0;
        
        //promptdeg = new Label( "Enter degree of Polynomial" );
        //degree = new TextField(1);
        
        prompt = new Label( "Option: left(L), right(R) or center(C)" );
        option = new TextField(1);

        prompt1 = new Label( "Number of rectangles:" );
        rectangles = new TextField(1);
        
        prompt2 = new Label( "Left bound (a):");
       leftBound = new TextField(1);
       
       prompt3 = new Label( "Right bound (b):");
       rightBound = new TextField(1);
        
        //promptspace = new Label("\n");
        promptparam = new Label( "Parameters:");
        for (int i=0; i< 4;i++){
        	degreeArr[i]=new TextField(1);
        }
        
        promptA = new Label( "Answer:");
        answer = new TextField(5);

        // Add the PROMPT and INPUT fields to the applet
        
        // add the button to the layout
        this.add(beep);
        beep.addActionListener(this);
        
        add(prompt);                                    
        add(option);
        
        add(prompt1);                                    
        add(rectangles);
        
        add(prompt2);                                    
        add(leftBound);
        
        add(prompt3);                                    
        add(rightBound);
        
        add(promptparam);
        for (int i=0; i< 4;i++){
        	add(degreeArr[i]);
        }
        
        this.add(beep);
        beep.addActionListener(this);
        
        //add(promptA); 
        //add(answer);
        
        //add(promptspace);

        //PICTURE
        
        picture = getImage(getCodeBase(), "lol.jpg");
        //picture2 = getImage(getCodeBase(), "lol2.jpg");
        

    }
  
    
    // METHOD1
    public static double calculateRiemmanSum(double leftEnd, double rightEnd, int rectangles, double[] parameters, String whichSum) {
      	double width = (rightEnd - leftEnd)/rectangles;
        double sum = 0;
        double typeSum = 0;
        if(whichSum.equals("R")) {
          typeSum = 0;
        }
        if(whichSum.equals("L")) {
          typeSum = 1;
        }
        if(whichSum.equals("C")) {
          typeSum = 0.5;
        }
        for(int i = 0; i < rectangles; i++) {
          double x = leftEnd + (i + 1 - typeSum)*width;
          double funcVal = 0;
          for(int j = 0; j < parameters.length; j++) {
          	funcVal += parameters[j] * Math.pow(x, parameters.length - 1 - j);
          }
          sum += funcVal * width; 
        }
        return sum;
      }
    
    //METHOD2
    /*
    public static int[] function(int numParameters) {
        int[] parameters = new int[numParameters];

        for(int i = 0; i < parameters.length; i++) {
        	parameters[i] = reader.nextInt();
            //System.out.println(parameters[i]);
        }
        return parameters;
      }
      */
 
    
    public void actionPerformed( ActionEvent e ) {
    	
		if (e.getSource() == beep){ 
			actionMessage ="Answer: "+calculateRiemmanSum(leftB, rightB, numRec, parameters, myOption);
		}
		repaint();
		
        /*try {
            // Parse the input guess into an integer value
            numRec = Integer.parseInt( e.getActionCommand() );
            secNum = Integer.parseInt( e.getActionCommand() );
        }
        catch (NumberFormatException nfe) {
            // If the guess is not an integer than mark it -999
            numRec = 10;
        }
 
        // Clear the input text box
        input.setText( "" );       
        // Force a call to paint()
        repaint();  */                  
    }
 
    public void paint (Graphics g) {
        // OUR PICTURE HERE
        g.drawImage(picture, 140, 100, this);
        
        // STORE VARIABLES NEEDED
        myOption = option.getText();
        numRec = Integer.parseInt(rectangles.getText());
        leftB = Integer.parseInt(leftBound.getText());
        rightB = Integer.parseInt(rightBound.getText());
        parameters[0] = Integer.parseInt(degreeArr[0].getText());
        parameters[1] = Integer.parseInt(degreeArr[1].getText());
        parameters[2] = Integer.parseInt(degreeArr[2].getText());
        parameters[3] = Integer.parseInt(degreeArr[3].getText());
        
        if(!myOption.equals("L") && !myOption.equals("R") && !myOption.equals("C")) {
        	myOption = "L";
          }
        
        Font myFont = new Font("Arial", Font.BOLD,20);
        g.setFont(myFont);
        g.drawString(actionMessage,600,50);
       
        //answer.setText(String.valueOf(calculateRiemmanSum(leftB, rightB, numRec, parameters, myOption)));// return of answer method as input
        //boolean displayIm = true;
        
        //g.drawString(numRec + secNum + "", 15, 170);
        
        //if (displayIm) 
        //picture2 = getImage(getCodeBase(),"lol2.jpg");
        //else
            //g.drawString("SOMETHING WENT WRONG LOL!", 15, 170);
        
        }
    }
