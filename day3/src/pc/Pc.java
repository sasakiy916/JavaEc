package pc;
public class Pc {
	private IUSB usb;
	public void setUsb(IUSB usb) {
		this.usb = usb;
	}
	public void executeUSB() {
		this.usb.execute();
	}
}
