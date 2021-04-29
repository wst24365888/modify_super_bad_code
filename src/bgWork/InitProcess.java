package bgWork;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Define.AreaDefine;
import Define.MsgBoxType;
import Listener.MainFrameListener;
import MsgBox.MsgBoxHandler;
import bgWork.handler.CanvasPanelHandler;
import bgWork.handler.CommandsHandler;
import bgWork.handler.FuncPanelHandler;
import bgWork.handler.MenuBarHandler;
import bgWork.handler.PanelHandler;

public class InitProcess
{
	protected String		version				= "1.1";
	JFrame					mainFrame;
	JPanel					mainPanel;
	Vector <PanelHandler>	handlerList			= new Vector <>();
	CanvasPanelHandler		cph;
	FuncPanelHandler		fph;
	MenuBarHandler			mbh;
	MsgBoxHandler			msgBoxHandler;
	CoreMgr					cMgr;
	CommandsHandler			cmdHandler;
	Dimension				minFrameSize		= new Dimension(920, 680);
	MsgBoxType				msgBoxTypeDefine	= new MsgBoxType();
	AreaDefine				areaDefine			= new AreaDefine();

	public InitProcess(CoreMgr cm)
	{
		this.cMgr = cm;
		init();
	}

	public void fork()
	{
		// TODO: Bug: Could not keep the existed core alive.
		switch (getCoreTypeIndex(this))
		{
			case 0:
				cMgr.addProcess(new Core(cMgr));
				break;
			default:
				break;
		}
	}

	void init()
	{
		initMainFrame();
		initMainPanel();
		mainFrame.setContentPane(mainPanel);
		initFPH();
		initMBH();
		initCPH();
		mainFrame.setSize(minFrameSize.width, minFrameSize.height + 100);
		mainFrame.setSize(minFrameSize);
		initMsgBoxHandler();
		repaint();
	}

	void initCmdHandler()
	{
		cmdHandler = new CommandsHandler(this);
	}

	void initMainFrame()
	{
		mainFrame = new JFrame("UML Editor");
		mainFrame.addWindowListener(new MainFrameListener((InitProcess) this));
		mainFrame.setSize(minFrameSize);
		mainFrame.setMinimumSize(minFrameSize);
		mainFrame.setMaximumSize(minFrameSize);
		mainFrame.setVisible(true);
	}

	void initMsgBoxHandler()
	{
		msgBoxHandler = new MsgBoxHandler(this);
	}

	void initMainPanel()
	{
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
	}

	void initMBH()
	{
		this.mbh = new MenuBarHandler(mainFrame, this);
	}

	void initCPH()
	{
		cph = new CanvasPanelHandler(mainPanel, this);
	}

	void initFPH()
	{
		fph = new FuncPanelHandler(mainPanel, this);
	}

	public void dispose()
	{
		this.handlerList = new Vector <>();
		this.mainPanel = null;
		this.mainFrame.dispose();
		cMgr.removeProcess(this);
		System.out.println("Dispose success.");
		System.out.println("proc = " + this);
	}

	public CoreMgr getCoreMgr()
	{
		return this.cMgr;
	}

	public String getVersion()
	{
		return version;
	}

	public void repaint()
	{
		mainFrame.repaint();
	}

	public boolean isCore(Object obj)
	{
		return obj instanceof Core;
	}

	public int getCoreTypeIndex(Object obj)
	{
		if (isCore(obj))
		{
			return 0;
		}
		return -1;
	}

	public MsgBoxType getMsgBoxTypeDefine()
	{
		return msgBoxTypeDefine;
	}

	public AreaDefine getAreaDefine()
	{
		return areaDefine;
	}

	public FuncPanelHandler getFuncPanelHandler()
	{
		return fph;
	}

	public CanvasPanelHandler getCanvasPanelHandler()
	{
		return cph;
	}
	public boolean isJPanel(Object obj)
	{
		return obj instanceof JPanel;
	}
}
