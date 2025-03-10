public class PS2 extends PS3 {
	int a;
	
	public PS2(int a) {
		super(a);  //invokes the constructor of parent class(PS3)
		this.a=a;  // refers to current obj being created
	}
	public int inc() {
		a=a+1;
		return a;
	}
	public int dec() {
		a=a-1;
		return a;
	}
}