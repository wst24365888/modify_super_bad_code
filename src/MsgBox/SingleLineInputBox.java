package MsgBox;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pack.SendText;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class SingleLineInputBox extends JFrame
{
	private JPanel		contentPane;
	private JTextField	textField;
	MsgBoxHandler		mbh;

	/**
	 * Create the frame.
	 */
	public SingleLineInputBox(MsgBoxHandler mbh)
	{
		this.mbh = mbh;
		setVisible(true);
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent arg0)
			{
				close();
			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				close();
			}
		});
		setTitle("Edit context");
		setBounds(100, 100, 240, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		textField = new JTextField();
		textField.setBounds(10, 35, 200, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//
		JLabel lblNewLabel = new JLabel("New context:");
		lblNewLabel.setBounds(10, 10, 200, 15);
		contentPane.add(lblNewLabel);
		//
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				btnOK();
			}
		});
		btnOk.setBounds(10, 82, 87, 23);
		contentPane.add(btnOk);
		//
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				btnCancel();
			}
		});
		btnCancel.setBounds(127, 82, 87, 23);
		contentPane.add(btnCancel);
	}

	void btnOK()
	{
		mbh.callBack(new SendText(textField.getText(), null));
		close();
	}

	void btnCancel()
	{
		close();
	}

	void close()
	{
		this.setAlwaysOnTop(false);
		this.setVisible(false);
	}
}
