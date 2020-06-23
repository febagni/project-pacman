import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class SoundManager {

    // to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 
    protected String filePath; 
  
    // constructor to initialize streams and clip 
    public SoundManager(String filePath) { 
    	this.filePath = filePath;
        // create AudioInputStream object 
        try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
			// create clip reference 
	        clip = AudioSystem.getClip(); 
	          
	        // open audioInputStream to the clip 
	        clip.open(audioInputStream); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                    
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
        play();
    } 
    
    public void play() { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
    
    public void restart()  { 
    	clip.stop(); 
    	clip.close(); 
    	resetAudioStream(); 
    	currentFrame = 0L; 
    	clip.setMicrosecondPosition(0); 
    	this.play(); 
    } 

    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
    	currentFrame = 0L; 
    	clip.stop(); 
    	clip.close(); 
    } 
    
 // Method to reset audio stream 
    public void resetAudioStream() { 
        try {
			audioInputStream = AudioSystem.getAudioInputStream( 
			new File(filePath).getAbsoluteFile());
	        clip.open(audioInputStream); 
	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
		} catch (Exception e) {

			e.printStackTrace();
		}
    } 
    
    // Method to pause the audio 
    public void pause()  
    { 
        this.currentFrame = this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
    
    public void resumeAudio() { 
    	clip.close(); 
    	resetAudioStream(); 
    	clip.setMicrosecondPosition(currentFrame); 
    	this.play(); 
    } 
    
    public void setMediaPath(String filePath) {
    	this.filePath = filePath;
    }
}

