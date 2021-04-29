package Pack;

import javax.swing.JPanel;

public class SendText extends Package
{
	public void setText(String text)
	{
		this.text = text;
	}

	public void setDest(JPanel dest)
	{
		this.dest = dest;
	}

	String	text	= "";
	JPanel	dest;

	public SendText(String text, JPanel dest)
	{
		this.text = text;
		this.dest = dest;
	}

	public String getText()
	{
		return text;
	}

	public JPanel getDest()
	{
		return dest;
	}

	public void printContext()
	{
		System.out.println("SendText: " + this);
		System.out.println("Text: " + text);
		System.out.println("Dest: " + dest);
	}
}
