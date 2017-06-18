//Ashley Zhang and Grace Gent

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskPanel extends JPanel
{
   private RucksackPanel ruck;
   private Task current;
   private String na;
   private int dur;
   private int pr;
   private Time de;
	private JPanel panel;
	private JLabel name;
	private JLabel duration;
	private JLabel priority;
	private JLabel deadline;
	private JTextField n;
	private JTextField du;
   private JComboBox dHour;
   private JComboBox dMinute;
   private JSlider prioritySlider;
	private JButton enterButton;
	
	public TaskPanel(RucksackPanel r) {
      ruck = r;
      
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(500,500));
		panel.setBackground(Color.WHITE);
		
      //text fields for name and estimated duration
		name = new JLabel("Name:");
		panel.add(name);
		n = new JTextField(20);
		panel.add(n);
		duration = new JLabel("Duration (minutes):");
		panel.add(duration);
		du = new JTextField(20);
		panel.add(du);
      
		//slider to set priority
		priority = new JLabel ("Priority:                           ");
		panel.add(priority);
      prioritySlider = new JSlider(1, 5);
      panel.add(prioritySlider);
      
      //deadline
      deadline = new JLabel("   Deadline: ");
		panel.add(deadline);
      JLabel h = new JLabel("Hour:");
      panel.add(h);
      String[] hours = new String[24];
      for(int i = 0; i < hours.length; i++) {
         hours[i] = (i + 1) + "";
      }
      dHour = new JComboBox(hours);
		panel.add(dHour);
      JLabel m = new JLabel("Minute:");
      panel.add(m);
      String[] minutes = new String[60];
      for(int i = 0; i < minutes.length; i++) {
         minutes[i] = (i + 1) + "";
      }
      dMinute = new JComboBox(minutes);
		panel.add(dMinute);

      //enter button to create new task with information currently inputted
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
			pr = prioritySlider.getValue();
         dur = Integer.parseInt(du.getText());
         na = n.getText();
         de = new Time(Integer.parseInt(dHour.getSelectedItem().toString()), Integer.parseInt(dMinute.getSelectedItem().toString()));
         current = new Task(na, null, null, dur, de, pr);  
         
         //add new task and redraw RucksackPanel
         ruck.tas.add(current);
         ruck.revalidate();
         ruck.repaint();
		}
	}
}