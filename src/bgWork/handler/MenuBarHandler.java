package bgWork.handler;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Listener.MenuBarListener;
import Pack.TextRequest;
import bgWork.Core;
import bgWork.InitProcess;

public class MenuBarHandler
{
	Core						core;
	InitProcess					process;
	Vector <Vector <String>>	menuList	= new Vector <>();

	public MenuBarHandler(JFrame container, InitProcess process)
	{
		if (process.isCore(process))
		{
			core = (Core) process;
		}
		else
		{
			this.process = process;
		}
		initMenuList();
		container.setJMenuBar(initMenuBar());
	}

	void initMenuList()
	{
		Vector <String> temp = new Vector <>();
		temp.add("File");
		temp.add("New Window");
		temp.add("Exit");
		menuList.addElement(temp);
		temp = new Vector <>();
		temp.add("Edit");
		temp.add("Change Object Name");
		temp.add("Group");
		temp.add("Ungroup");
		menuList.addElement(temp);
	}

	JMenuBar initMenuBar()
	{
		JMenuBar jmb = new JMenuBar();
		jmb.setVisible(true);
		JMenu menu[] = new JMenu[menuList.size()];
		for (int i = 0; i < menu.length; i ++)
		{
			menu[i] = new JMenu(menuList.elementAt(i).elementAt(0));
			for (int j = 1; j < menuList.elementAt(i).size(); j ++)
			{
				JMenuItem jmi = new JMenuItem(
						menuList.elementAt(i).elementAt(j));
				jmi.addActionListener(new MenuBarListener(this));
				menu[i].add(jmi);
			}
			jmb.add(menu[i]);
		}
		return jmb;
	}

	public void ActionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		int cmdGroup = -1;
		int cmdIndex = -1;
		for (int i = 0; i < menuList.size(); i ++)
		{
			for (int j = 1; j < menuList.elementAt(i).size(); j ++)
			{
				if (cmd == menuList.elementAt(i).elementAt(j))
				{
					cmdGroup = i;
					cmdIndex = j;
					break;
				}
			}
			if (cmdGroup > -1)
			{
				break;
			}
		}
		switch (cmdGroup)
		{
			case 0:
				cmdGroup_File(cmdIndex);
				break;
			case 1:
				cmdGroup_Edit(cmdIndex);
				break;
			default:
				break;
		}
	}

	void cmdGroup_File(int index)
	{
		switch (index)
		{
			case 1:
				core.fork();
			case 2:
				core.dispose();
				break;
			default:
				break;
		}
	}

	void cmdGroup_Edit(int index)
	{
		switch (index)
		{
			case 1:
				printCmd(1, index);
				TextRequest tr = new TextRequest("", this,
						"SINGLE_LINE_INPUT_BOX");
				core.callMsgBox(tr);
				break;
			case 2:
				printCmd(1, index);
				core.setGroup();
				break;
			case 3:
				printCmd(1, index);
				core.setUngroup();
				break;
			default:
				break;
		}
	}

	void printCmd(int group, int index)
	{
		System.out.println(menuList.elementAt(group).elementAt(index));
	}
}
