package bgWork;

public class Launcher
{
	public static void main(String[] args)
	{
		CoreMgr cm = new CoreMgr();
		cm.addProcess(new Core(cm));
	}
}
