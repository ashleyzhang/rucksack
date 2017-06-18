//Ashley Zhang and Grace Gent

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class RucksackPanel extends JPanel
{
   private RucksackPanel r;
   public static ArrayList<Appt> app = new ArrayList<Appt>();
   public static ArrayList<Task> tas = new ArrayList<Task>();
   public ArrayList<Appt> scheduled = new ArrayList<Appt>();
   private JLabel tasksLabel;
   private JLabel apptsLabel;
   private JLabel tasLabel;
   private JLabel appLabel;
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton taskButton;
	private JButton apptButton;
	
	public RucksackPanel() {
		setLayout(new BorderLayout());
      
      //reference to this RucksackPanel to pass to other panels as parameter
      r = this;
		
		//top panel
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		add(topPanel, BorderLayout.NORTH);
		topPanel.setPreferredSize(new Dimension(500,300));
		topPanel.setBackground(Color.WHITE);
		
		//left panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout());
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setPreferredSize(new Dimension(250,300));
		leftPanel.setBackground(Color.GRAY);
		
		taskButton = new JButton("New Task");
		
		taskButton.setForeground(Color.BLACK);
		taskButton.setBackground(Color.WHITE);
		taskButton.setPreferredSize(new Dimension(200,50));

		taskButton.addActionListener(new taskListener());
		
		leftPanel.add(taskButton);
		
		apptButton = new JButton("New Appt");
		
		apptButton.setForeground(Color.BLACK);
		apptButton.setBackground(Color.WHITE);
		apptButton.setPreferredSize(new Dimension(200,50));

		apptButton.addActionListener(new apptListener());
		
		leftPanel.add(apptButton);
		
		
		//right panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new FlowLayout());
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setPreferredSize(new Dimension(250,300));
		rightPanel.setBackground(Color.PINK);

		update();
	}

	public void update() {
		//tasks list
      tasLabel = new JLabel("<html>Tasks:<br>");
      rightPanel.add(tasLabel);
		String temp = "<html>";
		for(int i = 0; i < tas.size(); i++) {
			temp += tas.get(i) + "<br>";
		}
		temp += "<html>";

		if(tasksLabel != null) {
			rightPanel.remove(tasksLabel);
		}
		tasksLabel = new JLabel(temp);
		rightPanel.add(tasksLabel);

		//appts list
      appLabel = new JLabel("<html>Appts:<br>");
      rightPanel.add(appLabel);
		temp = "<html>";
		for(int i = 0; i < app.size(); i++) {
			temp += app.get(i) + "<br>";
		}
		temp += "<html>";
		if (apptsLabel != null) {
			rightPanel.remove(apptsLabel);
		}
		apptsLabel = new JLabel(temp);
		rightPanel.add(apptsLabel);
	}

   public void schedule() {
      //algorithm adapted from http://www.es.ele.tue.nl/education/5MC10/Solutions/knapsack.pdf
      //duplicate arrays
      ArrayList<Task> t = new ArrayList<Task>();
      for(int i = 0; i < tas.size(); i++) {
         t.add(tas.get(i));
      }
      ArrayList<Appt> a = new ArrayList<Appt>();
      for(int i = 0; i < app.size(); i++) {
         a.add(app.get(i));
      }
      //sort appointments by start time
      Collections.sort(a);
      //array of times between appointments
      int[] w = new int[a.size() - 1];
      for(int i = 0 ; i < a.size() - 1; i++) {
         w[i] = a.get(i).minBetween(a.get(i+1));
      }
      //array of priorities of each task
      int[] p = new int[t.size()];
      for(int i = 0 ; i < t.size(); i++) {
          p[i] = t.get(i).getPriority();
      }

      boolean keep[] = new boolean[t.size()];
      //
      for(int i = 0; i < w.length; i++) { 
         for(int j = 0; j < w[i]; j++) {
            
         }
      }
		int[][] v = new int[num][w];
		for(int i = 0; i <= w; i++) {
			v[0][i] = 0;
		}
		for(int i = 1; i <= num; i++) {
			for(int j = 0; j <= w; j++) {
				if(w[i] <= w) {
					v[i][j] = max[v[i-1][j]][val[i] + v[i-1][w-w[i]]];
				}
				else {
					v[i][j] = v[i-1, w];
				}
			}
		}
   }
	
	private class taskListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame taskFrame = new JFrame("New Task");
			taskFrame.setSize(400,250);
			taskFrame.setLocation(600,0);
			taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			taskFrame.setContentPane(new TaskPanel(r));
         taskFrame.setVisible(true);
		}
	}
	
	private class apptListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame apptFrame = new JFrame("New Appointment");
			apptFrame.setSize(350,200);
			apptFrame.setLocation(600,400);
			apptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			apptFrame.setContentPane(new ApptPanel(r));
			apptFrame.setVisible(true);
		}
	}
}