package no.hib.dat152;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShorttextTag extends SimpleTagSupport{
	int maxChars;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringWriter stringWriter = new StringWriter();
		getJspBody().invoke(stringWriter);
		
		String text = stringWriter.toString();
		if(text.length()>maxChars){
			out.print(text.substring(0,maxChars) + "...");
		}else{
			out.print(text);
		}
		
	}
	
	public void setMaxchars(String maxChars) {
		this.maxChars = Integer.parseInt(maxChars);
	}
}
