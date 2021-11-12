import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField = new JTextField(30);
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JButton btnClr, btnAdd, btnSub, btnMult, btnDiv, btnEq, btnDec;
    
    // create panels for the frame, mainPanel holds the others 
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel functionPanel = new JPanel();
    JPanel textPanel = new JPanel();
    


	// track which operation is being used
	Boolean addOp = false;
	Boolean subOp = false;
	Boolean multOp = false;
	Boolean divOp = false;
    
    Double lhs;
	Double rhs;

    
    Calculator() {
    	// setup the frame    	
        frame = new JFrame("Calculator");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        textField.setBounds(45, 25, 300, 50);
        textPanel.add(textField);
	   
        // Create buttons 
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
	   
        btnEq = new JButton("=");
        btnDec = new JButton(".");
        btnClr = new JButton("AC");
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMult = new JButton("*");
        btnDiv = new JButton("/");
        
        // add action listeners        
        btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
		btnEq.addActionListener(this);
		btnDec.addActionListener(this);
		btnClr.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
        
        // add buttons to panel
        buttonPanel.add(btn7);
        buttonPanel.add(btn8);
        buttonPanel.add(btn9);
	   	buttonPanel.add(btn4);
	   	buttonPanel.add(btn5);
	   	buttonPanel.add(btn6);
	   	buttonPanel.add(btn1);
	   	buttonPanel.add(btn2);
	   	buttonPanel.add(btn3);
	   	buttonPanel.add(btn0);
	   	buttonPanel.add(btnDec);
	   	buttonPanel.add(btnEq);
	   	
	   	// add function buttons	   	
//	   	functionPanel.add(btnClr);
	   	functionPanel.add(btnAdd);
	   	functionPanel.add(btnSub);
	   	functionPanel.add(btnMult);
	   	functionPanel.add(btnDiv);
	   
	   	// set panel layouts/styling
	   	buttonPanel.setLayout(new GridLayout(4, 3, 10, 10));
	   	functionPanel.setLayout(new GridLayout(4, 1, 10, 10));
	   	functionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); 
	   	
	   	// add to panels to mainPanel to frame
	   	mainPanel.add(textPanel);
	   	mainPanel.add(buttonPanel);
	   	mainPanel.add(functionPanel);
	   	
	   	frame.add(mainPanel);
	   	frame.setVisible(true); 
    }
    
    public static void main(String[] args) {
        System.out.println("Simple Calculator Program");
        Calculator calc = new Calculator();
    }    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// button actions
		if (e.getSource() == btn9) {
			textField.setText("9");
		}
		else if (e.getSource() == btn8) {
			textField.setText("8");
		}
		else if (e.getSource() == btn7) {
			textField.setText("7");
		}
		else if (e.getSource() == btn6) {
			textField.setText("6");
		}
		else if (e.getSource() == btn5) {
			textField.setText("5");
		}
		else if (e.getSource() == btn4) {
			textField.setText("4");
		}
		else if (e.getSource() == btn3) {
			textField.setText("3");
		}
		else if (e.getSource() == btn2) {
			textField.setText("2");
		}
		else if (e.getSource() == btn1) {
			textField.setText("1");
		}
		else if (e.getSource() == btn0) {
			textField.setText("0");
		}
		
		// function actions, once clicked we can save the number
		else if (e.getSource() == btnDec) {
			textField.setText(".");
		}
		else if (e.getSource() == btnAdd) {
			lhs = Double.parseDouble(textField.getText());
			addOp = true;
		}
		else if (e.getSource() == btnSub) {
			lhs = Double.parseDouble(textField.getText());
			subOp = true;
		}
		else if (e.getSource() == btnDiv) {
			lhs = Double.parseDouble(textField.getText());
			divOp = true;
		}
		else if (e.getSource() == btnMult) {
			lhs = Double.parseDouble(textField.getText());
			multOp = true;
		}

		// set rhs when = is clicked
		else if (e.getSource() == btnEq) {
			System.out.println(lhs);
			System.out.println(textField.getText());
			rhs = Double.parseDouble(textField.getText());
			if (addOp) {
				textField.setText(String.valueOf(lhs + rhs));
			}
			else if (subOp) {
				textField.setText(String.valueOf(lhs - rhs));
			}
			else if (multOp) {
				textField.setText(String.valueOf(lhs * rhs));
			}
			else if (divOp) {
				textField.setText(String.valueOf(lhs / rhs));
			}

//			lhs = 0.0;
			addOp = false;
			subOp = false;
			divOp = false;
			multOp = false;
		}
	}
}

