package GUI;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Lists extends JFrame {
	
	private JList list;
	private static String[] colornames = {"Black", "Blue", "Red", "White"};
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};
	
	public Lists(){
		super("Cores");
		setLayout(new FlowLayout());
		
		list = new JList (colornames);
		list.setVisibleRowCount(4);
		list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		list.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						getContentPane().setBackground(colors[list.getSelectedIndex()]);
						
					}
				}
		);
		
	}

}
