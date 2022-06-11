package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperites {
	Properties pro;
	
	public ReadProperites(){
		File file = new File("./Configuration/Config.properties");
		try {
			FileInputStream src = new FileInputStream(file);
			pro =new Properties();
			pro.load(src);
		} catch (Exception e) {
			
			System.out.println("Exception is"+e.getMessage());
		} 	
	}
	public String getUsername() {
		String usernames =pro.getProperty("username");
		return usernames;
	}
	
	public String getPassword() {
		String passwords =pro.getProperty("Password");
		return passwords;
	}
	public String getbaseUrl() {
		String baseUrls =pro.getProperty("baseUrl");
		return baseUrls;
	}
	public String getchromePath() {
		String chromePaths =pro.getProperty("chromePath");
		return chromePaths;
	}
	

}
