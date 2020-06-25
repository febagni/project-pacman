import java.io.File; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl; 

public class SoundManager {

    // to store current position 
    static Long currentFrame; 
    static Clip clip; 
      
    // current status of clip 
    static String status; 
      
    static AudioInputStream audioInputStream; 
    
    static final String mainFolder = "audio/";
    static String filePath = "Dif1.aif"; 
    static String sourceFolder = "Classic/";
    static FloatControl gainControl;
  
    // constructor to initialize streams and clip 
    public static void setSong(String path) { 
    	filePath = path;
        // create AudioInputStream object 
        try {
        	//stop();
			audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
			// create clip reference 
	        clip = AudioSystem.getClip(); 
	          
	        // open audioInputStream to the clip 
	        clip.open(audioInputStream); 
	        
	        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        
	        changeSound(-25.0f);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}                    
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
        play();
    } 
    
    public static void changeSound(float decibes) {
        gainControl.setValue(decibes);
    }
    
    public static void play() { 
        //start the clip 
        clip.start(); 
        status = "play"; 
    } 
    
    public static void restart()  { 
    	clip.stop(); 
    	clip.close(); 
    	resetAudioStream(); 
    	currentFrame = 0L; 
    	clip.setMicrosecondPosition(0); 
    	play(); 
    } 

    // Method to stop the audio 
    public static void stop() throws Exception { 
    	currentFrame = 0L; 
    	clip.stop(); 
    	clip.close(); 
    } 
    
 // Method to reset audio stream 
    public static void resetAudioStream() { 
        try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
	        clip.open(audioInputStream); 
	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
		} catch (Exception e) {

			e.printStackTrace();
		}
    } 
    
    // Method to pause the audio 
    public static void pause() {
        currentFrame = clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
    
    public static void resumeAudio() { 
    	clip.close(); 
    	resetAudioStream(); 
    	clip.setMicrosecondPosition(currentFrame); 
    	play(); 
    } 
    
    public static void setMediaPath(String path) {
    	filePath = path;
    }
}

