package cn.com.dhcc.cgn.mobins.inspection.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandFormatTest {

	@Test
	public void testFormat() {
		String cmdsa[] = {"sdflks askl ${DATE_DOT}DS","SJLKAFJSLldskjfl dlks dsk, sdjkfl ${AAA} sdlkjaf",
				"ipconfig /all"};
		String s = CommandFormat.format(cmdsa[0]);
		System.out.println(s);
		assertEquals(true, s!=null);
	}

}
