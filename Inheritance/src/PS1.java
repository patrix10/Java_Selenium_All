import org.testng.annotations.Test;

public class PS1 extends PS {
	@Test
	public void TestRun() {
		doThis();
		// without inheritance(extend key word), take values by creating obj
	PS2 obj = new PS2(3); //parameterized constructor
	System.out.println(obj.inc());
	System.out.println(obj.dec());
	// PS3 obj1 = new PS3(3); we could have also used this
	System.out.println(obj.mul2());
	System.out.println(obj.mul3());
	}
}