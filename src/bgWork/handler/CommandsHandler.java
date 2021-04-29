package bgWork.handler;

import java.util.Vector;

import bgWork.InitProcess;

public class CommandsHandler
{
	InitProcess		process;
	Vector <String>	cmdList	= new Vector <>();

	public CommandsHandler(InitProcess process)
	{
		this.process = process;
		init();
	}

	void init()
	{
		cmdList.add("New Window");	// #0
		cmdList.add("Exit");		// #1
		cmdList.add("Change Object Name");// #2
		cmdList.add("Group");		// #3
		cmdList.add("Ungroup");		// #4
	}

	public int execv(String cmd)
	{
		switch (cmdList.indexOf(cmd))
		{
			case 0:
				break;
			case 1:
				process.dispose();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
		}
		return -1;
	}
}
