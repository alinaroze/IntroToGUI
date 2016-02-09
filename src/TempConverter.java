import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TempConverter extends JFrame implements ActionListener{

	JPanel confPanel, inputPanel, outputPanel;
	JRadioButton c2fButton, f2cButton;
	JLabel inputLabel;
	JTextField inputField;
	JButton convertButton;
	JLabel outputLabel;
	
	private float celsius;
	Scanner scanFahrenheit;

	public TempConverter() {
		super("Temperature Converter");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Configuration pane
		confPanel = new JPanel(new GridLayout(2, 1));//this makes a grid layout of 2 rows and 1 column

		c2fButton = new JRadioButton("Celcius to Fahreneit");
		f2cButton = new JRadioButton("Fahreneit to Celcius");
		
		ButtonGroup group = new ButtonGroup();
		group.add(c2fButton);
		group.add(f2cButton);

		confPanel.add(c2fButton);
		confPanel.add(f2cButton);
		
		this.add(confPanel);

		// Input panel
		inputPanel = new JPanel(new BorderLayout());

		inputLabel = new JLabel("Temperature");
		inputField = new JTextField(10);//the text field is 10 long
		convertButton = new JButton("Convert");
		convertButton.setSize(10, 5);
		convertButton.addActionListener(this);

		inputPanel.add(inputLabel, BorderLayout.WEST); //the border layout tells you to put it on the south, east, west of panel
		inputPanel.add(inputField, BorderLayout.EAST);
		inputPanel.add(convertButton, BorderLayout.SOUTH);
		
		this.add(inputPanel);

		// Output panel
		outputPanel = new JPanel();

		outputLabel = new JLabel();

		outputPanel.add(outputLabel);

		JPanel mainPanel = new JPanel();
		mainPanel.add(confPanel);
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		
		this.add(mainPanel);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TempConverter tc = new TempConverter();
	}
	
	public static double c2f(double c){
		return ((c*9.09)/5.0)+32;
	}
	
	public static double f2c(double f){
		return (f-32)*5.0/9.0;
	}
	
	@Override
	public void actionPerformed(ActionEvent as){
		double result = 0;
		if(c2fButton.isSelected()){
			result = c2f(Double.parseDouble(inputField.getText()));
		}else if(f2cButton.isSelected()){
			result = f2c(Double.parseDouble(inputField.getText()));
		}
		
		outputLabel.setText(result+"");
	}
}
