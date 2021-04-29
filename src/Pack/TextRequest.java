package Pack;

public class TextRequest extends Package
{
	String	text	= "";
	Object	src;
	Object	dest;

	public TextRequest()
	{
		// TODO Auto-generated constructor stub
	}

	public TextRequest(String t, Object src, Object dest)
	{
		this.setText(text);
		this.setSrc(src);
		this.setDest(dest);
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Object getSrc()
	{
		return src;
	}

	public void setSrc(Object src)
	{
		this.src = src;
	}

	public Object getDest()
	{
		return dest;
	}

	public void setDest(Object dest)
	{
		this.dest = dest;
	}
}
