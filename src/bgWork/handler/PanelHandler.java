package bgWork.handler;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import bgWork.Core;
import bgWork.InitProcess;

public class PanelHandler
{
	Core		core;
	InitProcess	process;
	JPanel		contextPanel;
	Dimension	panelSize;
	int			boundDistance;

	public PanelHandler(JPanel Container, InitProcess process)
	{
		if (process.isCore(process))
		{
			core = (Core) process;
		}
		else
		{
			this.process = process;
		}
	}

	void initContextPanel()
	{
	}

	public void ActionPerformed(MouseEvent e)
	{
	}

	public JPanel getContectPanel()
	{
		return contextPanel;
	}
}
