import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import java.io.File;

public class PlayFartSound {

    public static void main(String[] args) {

        try {
            // Load WAV file into byte array
            File file1 = new File("fart-4.wav");
            AudioInputStream audio1 = AudioSystem.getAudioInputStream(file1);
            byte[] buffer1 = new byte[(int)audio1.getFrameLength() * audio1.getFormat().getFrameSize()];
            audio1.read(buffer1);

            // Create SourceDataLine object for playing the sound
            SourceDataLine line1 = AudioSystem.getSourceDataLine(audio1.getFormat());
            line1.open();

            // Start playing the sound
            line1.start();
            line1.write(buffer1, 0, buffer1.length);

            // Wait for the sound to finish playing
            line1.drain();

            // Close the line
            line1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
