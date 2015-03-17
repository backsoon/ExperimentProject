//import java.util.Properties;

public class TestJNI {

	private native boolean FenceStart(String keyName, String keyValue,
			String fold);

	private native boolean FenceEnd();

	private native String getLastError();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Properties props=System.getProperties();
		// props.list(System.out);
		TestJNI tst = new TestJNI();
		boolean startFlg = tst.FenceStart("CPECONFIG01", "123456",
				"C:\\CPEConfigTool\\SecureFolder");
		System.out.println("Start: " + startFlg);
		boolean endFlg = tst.FenceEnd();
		System.out.println("End: " + endFlg);
		System.out.println(tst.getLastError());
	}

	static {
		System.loadLibrary("jnitest");
	}

}
