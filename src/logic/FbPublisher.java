package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class FbPublisher {
	private static String accesToken = "EAAD597NzAh8BAM8NZAi5XNUdlvO9eNHpLxWLG74feqXBowfwEt4noGZBDw1NpyZAJh60FxFihKnLKj6oqkYolp7T0ZBcBPByZAZB5Si4IycY0zZCEmw2kUSBYFvbAy9fZAOkdtNYdIUGiEHNgBXEfu4A9BIInYqSctMZD";


	@SuppressWarnings("deprecation")
	public static void publishPhoto(File photo,String message) {
		InputStream is = null;
		try {
			is = new FileInputStream(photo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacebookClient facebookClient = new DefaultFacebookClient(accesToken);

		FacebookType publishPhotoResponse = facebookClient.publish("me/photos", FacebookType.class,
				BinaryAttachment.with(message, is),
				Parameter.with("message", message));

		System.out.println("Published photo ID: " + publishPhotoResponse.getType());
	}
}
