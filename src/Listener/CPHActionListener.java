package Listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Pack.DragPack;
import bgWork.handler.CanvasPanelHandler;
import bgWork.handler.PanelHandler;

public class CPHActionListener extends HandlerActionListener
		implements MouseMotionListener, MouseListener
{
	Point	from		= new Point(0, 0);
	Object	fromObj;
	Point	to			= new Point(0, 0);
	Object	toObj;
	int		clickShift	= 3;

	public CPHActionListener(PanelHandler h)
	{
		super(h);
		clear();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		from = e.getPoint();
		fromObj = e.getComponent();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		to = e.getPoint();
		toObj = e.getComponent();
		try
		{
			DragPack dp = new DragPack(from, to);
			dp.setFromObj(fromObj);
			dp.setToObj(toObj);
			((CanvasPanelHandler) handler).ActionPerformed(dp);
		}
		catch (Exception excp)
		{
			// TODO: handle exception
		}
		clear();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		handler.ActionPerformed(e);
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	void clear()
	{
		to = new Point(0, 0);
		toObj = new Object();
		from = new Point(0, 0);
		fromObj = new Object();
	}
}
