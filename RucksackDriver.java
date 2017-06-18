//Ashley Zhang and that chick who sits next to her
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class RucksackDriver {
	public static void main(String[] args)
	{
		JFrame ruckFrame = new JFrame("Rucksack");
		ruckFrame.setSize(500,800);
		ruckFrame.setLocation(0,0);
		ruckFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ruckFrame.setContentPane(new RucksackPanel());
		ruckFrame.setVisible(true);
	}
}                                                                                                    