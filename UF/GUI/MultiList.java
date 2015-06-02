package GUI; // command + Shift + o

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultiList extends JFrame {
	
	private JList leftlist;
	private JList rightlist;
	private JButton movebutton;
	private static String[] foods = {"Bacon", "Ice Cream", "Hot Dog", "Beef", "Fries"};
	
	public MultiList() {
		super("Comidas - Foods");
		setLayout(new FlowLayout());
		
		leftlist = new JList(foods);
		leftlist.setVisibleRowCount(3);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(leftlist));
		
		movebutton = new JButton("Move ->");
		movebutton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						rightlist.setListData(leftlist.getSelectedValues());
					}
				}
		);
		add(movebutton);
		
		rightlist = new JList();
		rightlist.setVisibleRowCount(3);
		rightlist.setFixedCellWidth(100);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add (new JScrollPane(rightlist));
		
	}

}
