package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bgWork.handler.PanelHandler;

public class HandlerActionListener implements MouseListener
{
	PanelHandler handler;

	public HandlerActionListener(PanelHandler h)
	{
		this.handler = h;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		handler.ActionPerformed(e);
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}
}
