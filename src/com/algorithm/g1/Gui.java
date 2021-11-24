package com.algorithm.g1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
	JFrame frame;
	JLabel Text;
	ArrayList<Object> vertices;
	Object from;
	Object to;
	
	Gui(ArrayList<Object> vertices){
		this.vertices = vertices;
		//Creating the frame
		frame = new JFrame("Transportation Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
       
       
        //Adding Components
        Text = new JLabel("From: ");
        JButton Search = new JButton("Search");
        JButton button = new JButton("Clear");
        Object[] source = vertices.toArray();
        JComboBox Sources = new JComboBox(source);
        Text.setBounds(70, 50, 100, 20);
        Search.setBounds(70, 100, 100, 50);
        button.setBounds(200, 100, 100, 50);
        Sources.setBounds(130, 50, 250, 20);
        
        Search.addActionListener(new SetText());
        Sources.addActionListener(new GetSource());
        frame.getContentPane().add(Text);
        frame.getContentPane().add(Search);
	    frame.getContentPane().add(button);
	    frame.getContentPane().add(Sources);
        frame.setVisible(true);
        
        this.from = Sources.getSelectedItem();
	}
	class SetText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Text.setText("Source: ");
		}
	}
	class GetSource implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox)e.getSource();
			from = (Object)cb.getSelectedItem();
		}
	}
	
}
