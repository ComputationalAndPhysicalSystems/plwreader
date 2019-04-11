package com.capsidaho;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates a JPanel which is added into the filedialog box.
 * It adds a checkbox (to represent whether the output file
 * should be split or not) and a textfield which represents
 * the point at which the output file should be split.
 */
public class splitFileOption extends JPanel implements ActionListener  {

	private JCheckBox cb1;
	private JTextField tf1;
	private static final long serialVersionUID = -6461828381068445975L;


	/**
	 * Creates the JPanel containing all the other components. Registers
	 * a listener to the checkbox to enable / disable the textfield.
	 */
	public splitFileOption() {
		setLayout(new GridLayout(2,1));
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		cb1 = new JCheckBox();
		cb1.addActionListener(this);
		cb1.setSelected(false);
		tf1=new JTextField("65000");
		tf1.setEnabled(false);
		JLabel lb1 = new JLabel("Check this box to split the file");
		JLabel lb2 = new JLabel("Max number of lines per file");
		top.add(lb1);
		top.add(cb1);
		bot.add(lb2);
		bot.add(tf1);
		add(top);
		add(bot);
	}

	/**
	 * To allow the user to select if the output file should be
	 * a single file or split. Splits happen after a max number
	 * of lines per file are reached.
	 * 
	 * @return True to split the file; false to remain as a single file.
	 */
	public boolean getCBState() {
		return cb1.isSelected();
	}

	/**
	 * To allow the user to set the max number of lines per file.
	 * 
	 * @return Value in the textfield
	 */
	public String getMaxLines() {
		return tf1.getText();
	}

	/* (non-Javadoc)
	 * Toggles the enabled state of the textfield, dependent on
	 * the checkbox.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		tf1.setEnabled(cb1.isSelected());
	}

}
