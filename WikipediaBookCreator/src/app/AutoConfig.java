package app;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutoConfig {
	
	public static String ServerURL = "http://en.wikipedia.org/wiki/Main_Page/";
	
	public static DesiredCapabilities GetIECaps() {
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		return caps;
	}
}
