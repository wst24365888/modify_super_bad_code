package Listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import bgWork.InitProcess;

public class MainFrameListener implements WindowListener
{
	InitProcess proc;

	public MainFrameListener(InitProcess proc)
	{
		this.proc = proc;
	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// iproc.dispose(iproc);
	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		proc.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub
	}
}
