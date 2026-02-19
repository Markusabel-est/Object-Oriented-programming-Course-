package pair;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void firstInOut() {
		Pair p = new Pair("foo", true);
		assertEquals("foo", (String) p.first());
		assertEquals(true, (Boolean) p.second());
	}

	@Test
	public void fails()
	{
		Pair p = new Pair("foo", true);
		// This should be a compile error, not a run time error
		assertEquals(true, (Boolean) p.first());
		assertEquals("foo", (String) p.second());
	}
}
