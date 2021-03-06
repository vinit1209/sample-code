// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.video.v1.RecordingSettings;

import java.net.URI;

public class Example {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        RecordingSettings recordingSettings = RecordingSettings.creator(
                "Upload encrypted to external bucket")
            .setAwsS3Url(
                URI.create("https://my-bucket.s3.amazonaws.com/recordings"))
            .setAwsStorageEnabled(true)
            .setAwsCredentialsSid("CRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
            .setEncryptionEnabled(true)
            .setEncryptionKeySid("CRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
            .create();

        System.out.println(recordingSettings.getFriendlyName());
    }
}