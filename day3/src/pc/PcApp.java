package pc;

public class PcApp {

	public static void main(String[] args) {
		Pc pc = new Pc();
		pc.setUsb(new USBMemory());
		pc.executeUSB();
		pc.setUsb(new USBFan());
		pc.executeUSB();
		pc.setUsb(new USBKeyboard());
		pc.executeUSB();
	}
}
class USBMemory implements IUSB{
	@Override
	public void execute() {
		System.out.println("データを保存できます");
	}
}
class USBFan implements IUSB{

	@Override
	public void execute() {
		System.out.println("涼しい風ぶぉぉぉ");
	}
}
class USBKeyboard implements IUSB{

	@Override
	public void execute() {
		System.out.println("カタカタカタカッターン！！");
	}

}