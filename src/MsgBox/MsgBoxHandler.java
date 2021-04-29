package MsgBox;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Define.MsgBoxType;
import Pack.SendText;
import Pack.TextRequest;
import bgWork.Core;
import bgWork.InitProcess;

public class MsgBoxHandler
{
	InitProcess		core;
	Vector <String>	boxTypeList	= new Vector <>();
	JFrame			msgBox;
	TextRequest		trCache		= new TextRequest();
	MsgBoxType		typeDefine;

	public MsgBoxHandler(InitProcess process)
	{
		this.core = process;
		init();
	}

	void init()
	{
		typeDefine = core.getMsgBoxTypeDefine();
		boxTypeList.addElement(typeDefine.SINGLE_LINE_INPUT_BOX);
	}

	public void callBox(TextRequest tr)
	{
		trCache = new TextRequest();
		try
		{
			switch (boxTypeList.indexOf(tr.getDest()))
			{
				case 0:
					trCache = tr;
					msgBox = new SingleLineInputBox(this);
					break;
				default:
					break;
			}
		}
		catch (Exception e)
		{
			System.err.println("MsgBox error:");
			System.err.println("src: " + tr.getSrc());
			System.err.println("dest: " + tr.getDest());
			System.err.println(e.getStackTrace());
		}
	}

	public void callBack(SendText tr)
	{
		tr.setDest((JPanel) trCache.getSrc());
		if (core.isCore(core))
		{
			((Core) core).msgBoxCallBack(tr);
		}
	}
}
