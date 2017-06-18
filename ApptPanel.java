//Ashley Zhang and Grace Gent

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApptPanel extends JPanel
{
   private Appt current;
   private Time start;
   private Time end;
   private String name;
	private JPanel panel;
   private JLabel nameLabel;
	private JLabel sHourLabel;
   private JLabel sMinuteLabel;
   private JLabel eHourLabel;
   private JLabel eMinuteLabel;
	private JTextField n;
   private JComboBox sHourBox;
	private JComboBox sMinuteBox;
   private JComboBox eHourBox;
   private JComboBox eMinuteBox;
   private JButton enterButton;
	
	public ApptPanel(RucksackPanel r) {
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(500,500));
		panel.setBackground(Color.WHITE);
      
      //name text field
      nameLabel = new JLabel("Name:");
		panel.add(nameLabel);
		n = new JTextField(20);
		panel.add(n);
		
      //start time
		sHourLabel = new JLabel("Start hour:");
		panel.add(sHourLabel);
      String[] hours = new String[24];
      for(int i = 0; i < hours.length; i++) {
         hours[i] = (i + 1) + "";
      }
      sHourBox = new JComboBox(hours);
		panel.add(sHourBox);
      sMinuteLabel = new JLabel("Start minute:");
      panel.add(sMinuteLabel);
      String[] minutes = new String[60];
      for(int i = 0; i < minutes.length; i++) {
         minutes[i] = (i + 1) + "";
      }
      sMinuteBox = new JComboBox(minutes);
		panel.add(sMinuteBox);
      
      //end time
      eHourLabel = new JLabel("End hour:");
      panel.add(eHourLabel);
      eHourBox = new JComboBox(hours);
      panel.add(eHourBox);
      eMinuteLabel = new JLabel("End minute:");
      panel.add(eMinuteLabel);
      eMinuteBox = new JComboBox(minutes);
      panel.add(eMinuteBox);
		
		//enter button to create new appointment with information currently inputted
      enterButton = new JButton("Enter");
		enterButton.setForeground(Color.BLACK);
		enterButton.setBackground(Color.WHITE);
		enterButton.setPreferredSize(new Dimension(200,50));
		enterButton.addActionListener(new enterListener());
      panel.add(enterButton);
	}
	
	private class enterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
         //storing inputs
         name = n.getText();
         start = new Time(Integer.parseInt(sHourBox.getSelectedItem().toString()), Integer.parseInt(sMinuteBox.getSelectedItem().toString()));
         end = new Time(Integer.parseInt(eHourBox.getSelectedItem().toString()), Integer.parseInt(eMinuteBox.getSelectedItem().toString()));
         current = new Appt(name, start, end);
		}
	}
}