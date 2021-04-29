package mod.instance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import bgWork.handler.CanvasPanelHandler;
import mod.IClassPainter;
import mod.IFuncComponent;

public class BasicClass extends JPanel implements IFuncComponent, IClassPainter
{
	Vector <String>		texts			= new Vector <>();
	Dimension			defSize			= new Dimension(150, 25);
	int					maxLength		= 20;
	int					textShiftX		= 5;
	boolean				isSelect		= false;
	int					selectBoxSize	= 5;
	CanvasPanelHandler	cph;

	public BasicClass(CanvasPanelHandler cph)
	{
		texts.add("New Class");
		texts.add("<empty>");
		reSize();
		this.setVisible(true);
		this.setLocation(0, 0);
		this.setOpaque(true);
		this.cph = cph;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		reSize();
		for (int i = 0; i < texts.size(); i ++)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, (int) (0 + i * defSize.getHeight()),
					(int) defSize.getWidth() - 1, (int) defSize.height - 1);
			g.setColor(Color.BLACK);
			g.drawRect(0, (int) (0 + i * defSize.getHeight()),
					(int) defSize.getWidth() - 1, (int) defSize.height - 1);
			if (texts.elementAt(i).length() > maxLength)
			{
				g.drawString(texts.elementAt(i).substring(0, maxLength) + "...",
						textShiftX,
						(int) (0 + (i + 0.8) * defSize.getHeight()));
			}
			else
			{
				g.drawString(texts.elementAt(i), textShiftX,
						(int) (0 + (i + 0.8) * defSize.getHeight()));
			}
		}
		if (isSelect == true)
		{
			paintSelect(g);
		}
	}

	@Override
	public void reSize()
	{
		switch (texts.size())
		{
			case 0:
				this.setSize(defSize);
				break;
			default:
				this.setSize(defSize.width, defSize.height * texts.size());
				break;
		}
	}

	@Override
	public void setText(String text)
	{
		texts.clear();
		texts.add(text);
		texts.add("<empty>");
		this.repaint();
	}

	public void addText(String text)
	{
		texts.add(text);
		this.repaint();
	}

	public void removeText(int index)
	{
		if (index < texts.size() && index >= 0)
		{
			texts.remove(index);
			this.repaint();
		}
	}

	public boolean isSelect()
	{
		return isSelect;
	}

	public void setSelect(boolean isSelect)
	{
		System.out.println(isSelect);
		this.isSelect = isSelect;
	}

	@Override
	public void paintSelect(Graphics gra)
	{
		gra.setColor(Color.BLACK);
		gra.fillRect(this.getWidth() / 2 - selectBoxSize, 0, selectBoxSize * 2,
				selectBoxSize);
		gra.fillRect(this.getWidth() / 2 - selectBoxSize,
				this.getHeight() - selectBoxSize, selectBoxSize * 2,
				selectBoxSize);
		gra.fillRect(0, this.getHeight() / 2 - selectBoxSize, selectBoxSize,
				selectBoxSize * 2);
		gra.fillRect(this.getWidth() - selectBoxSize,
				this.getHeight() / 2 - selectBoxSize, selectBoxSize,
				selectBoxSize * 2);
	}
}
