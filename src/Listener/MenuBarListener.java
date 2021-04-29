package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bgWork.handler.MenuBarHandler;

public class MenuBarListener implements ActionListener
{
	MenuBarHandler mbh;

	public MenuBarListener(MenuBarHandler mbh)
	{
		this.mbh = mbh;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		mbh.ActionPerformed(e);
	}
}
