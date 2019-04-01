package application;

import java.sql.*;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;  
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;  
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;  


public class DA3 extends Application{
	
	float getCredit(TextField cf)
	{
		if(cf.getText().equals(""))
			return 0;
		else
			return Float.parseFloat(cf.getText());
	}
	
	int getGrade(TextField tf)
	{
		if(tf.getText().equals("S"))
			return 10;
		
		if(tf.getText().equals("A"))
			return 9;
		
		if(tf.getText().equals("B"))
			return 8;
		
		if(tf.getText().equals("C"))
			return 7;
		
		if(tf.getText().equals("D"))
			return 6;
		if(tf.getText().equals("E"))
			return 5;
		
		if(tf.getText().equals(""))
			return 0;
		
		return 1;
	}
	public void start(Stage primaryStage) throws Exception 
	{
		Label l1 = new Label("Subject 1 : ");
		Label l2 = new Label("Subject 2 : ");
		Label l3 = new Label("Subject 3 : ");
		Label l4 = new Label("Subject 4 : ");
		Label l5 = new Label("Subject 5 : ");
		Label l6 = new Label("Subject 6 : ");
		Label l7 = new Label("Subject 7 : ");
		Label reg = new Label("Enter Reg No : ");
		Label sqlRes = new Label("");
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		TextField tf6 = new TextField();
		TextField tf7 = new TextField();
		TextField regno = new TextField();
		
		tf1.setPromptText("Enter your grade here");
		tf2.setPromptText("Enter your grade here");
		tf3.setPromptText("Enter your grade here");
		tf4.setPromptText("Enter your grade here");
		tf5.setPromptText("Enter your grade here");
		tf6.setPromptText("Enter your grade here");
		tf7.setPromptText("Enter your grade here");
		regno.setPromptText("Enter your reg no. here");
		
		TextField cf1 = new TextField();
		TextField cf2 = new TextField();
		TextField cf3 = new TextField();
		TextField cf4 = new TextField();
		TextField cf5 = new TextField();
		TextField cf6 = new TextField();
		TextField cf7 = new TextField();
		
		cf1.setPromptText("Number of credits");
		cf2.setPromptText("Number of credits");
		cf3.setPromptText("Number of credits");
		cf4.setPromptText("Number of credits");
		cf5.setPromptText("Number of credits");
		cf6.setPromptText("Number of credits");
		cf7.setPromptText("Number of credits");
		
		Button bt1 = new Button("Calculate GPA");
		
		Label lr = new Label("Your GPA is :");
		Label ts = new Label("");
		
		GridPane root=new GridPane();    
		root.setHgap(15);  
		root.setVgap(20);  
		
		Scene scene = new Scene(root,750,600);
		root.addRow(1, reg, regno);
		root.addRow(2, l1, tf1, cf1);
		root.addRow(3, l2, tf2, cf2);
		root.addRow(4, l3, tf3, cf3);
		root.addRow(5, l4, tf4, cf4);
		root.addRow(6, l5, tf5, cf5);
		root.addRow(7, l6, tf6, cf6);
		root.addRow(8, l7, tf7, cf7);
		root.addRow(9, bt1);
		root.addRow(10, lr,ts);
		root.addRow(12, sqlRes); 
		
		bt1.setOnAction(new EventHandler<ActionEvent>() 
        {   
			
        	              
            @Override  
            public void handle(ActionEvent arg0) 
            {  
                // TODO Auto-generated method stub   
            	int g1, g2, g3, g4, g5, g6, g7;
                float c1, c2, c3, c4, c5, c6, c7;              
           
                c1 = getCredit(cf1);
                c2 = getCredit(cf2);
                c3 = getCredit(cf3);
                c4 = getCredit(cf4);
                c5 = getCredit(cf5);
                c6 = getCredit(cf6);
                c7 = getCredit(cf7);
                
              /*c1 = Float.parseFloat(cf1.getText());
                c2 = Float.parseFloat(cf2.getText());
                c3 = Float.parseFloat(cf3.getText());
                c4 = Float.parseFloat(cf4.getText());
                c5 = Float.parseFloat(cf5.getText());
                c6 = Float.parseFloat(cf5.getText());
                c7 = Float.parseFloat(cf5.getText());
                */
                System.out.println(c1);
                System.out.println(c2);
                System.out.println(c3);
                System.out.println(c4);
                System.out.println(c5);
                System.out.println(c6);
                System.out.println(c7);
                
                g1 = getGrade(tf1);
                g2 = getGrade(tf2);
                g3 = getGrade(tf3);
                g4 = getGrade(tf4);
                g5 = getGrade(tf5);
                g6 = getGrade(tf6);
                g7 = getGrade(tf7); 
                System.out.println(g1);
                System.out.println(g2);
                System.out.println(g3);
                System.out.println(g4); 
                System.out.println(g5);
                System.out.println(g6);
                System.out.println(g7);
                float gpa;
                 
                
                	gpa = (c1*g1 + c2*g2 + c3*g3 + c4*g4 + c5*g5 + c6*g6 + c7*g7) / (c1+c2+c3+c4+c5+c6+c7);
                	if(regno.getText().equals("")||c1+c2+c3+c4+c5+c6+c7 == 0)
                	{
                		ts.setText("Not Applicable");
                		sqlRes.setText("");
                	}
                	else
                	{
                		try {
                		ts.setText(Float.toString(gpa));
                		Class.forName("com.mysql.cj.jdbc.Driver");
            			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/da3java","root","");
            			Statement stmt=con.createStatement();
            			
            			int r=stmt.executeUpdate("insert into lab13 values('"+ regno.getText()+ "'," + gpa + ")");
            			sqlRes.setText("DATABASE UPDATED");

                		}
                		catch(Exception e)
                		{
                			System.out.println(e);
                		}
                	}
                	System.out.println(gpa);
                
                
                //ts.setText(Float.toString(gpa));

                         
            }    
        });
        
		
		primaryStage.setScene(scene);    
		primaryStage.setTitle("GPA_CALCULATOR - 16BCE1380-DA3");  
		primaryStage.show();    
	}
		public static void main(String args[])
		{
			launch(args);
		}
}
