package bgWork;

import java.util.Vector;

public class CoreMgr implements Runnable
{
	Vector <InitProcess> procList = new Vector <>();

	/**
	 * <pre>
	 * The effective booting procedure is create a core manager(coreMgr)
	 * first, then create a new process and add it to the manager.
	 * </pre>
	 */
	// necessary empty constructor
	public CoreMgr()
	{
		// TODO Auto-generated constructor stub
	}

	public CoreMgr(InitProcess proc)
	{
		this.addProcess(proc);
		run();
	}

	public void addProcess(InitProcess proc)
	{
		// Prevent adding the same process.
		switch (procList.indexOf(proc))
		{
			case -1:
				procList.addElement(proc);
				break;
			default:
				break;
		}
	}

	void removeProcess(InitProcess proc)
	{
		// Remove a existed process.
		// Should only called by InitProcess.dispose()
		switch (procList.indexOf(proc))
		{
			case -1:
				System.err.println("CoreMgr: " + this);
				System.err.println("Caller: " + proc);
				for (int i = 0; i < procList.size(); i ++)
				{
					System.err.println(
							"List[" + i + "]: " + procList.elementAt(i));
				}
				break;
			default:
				procList.remove(proc);
				break;
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			// Check if there is no running process.
			switch (procList.size())
			{
				case 0:
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}
}
