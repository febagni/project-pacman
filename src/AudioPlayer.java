import java.io.File; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl; 

public class AudioPlayer {

    // to store current position 
     Long currentFrame; 
     Clip clip; 
      
    // current status of clip 
     String status ; 
      
     AudioInputStream audioInputStream; 
    
     String mainFolder = "audio/";
     String filePath = "dif1.aif"; 
     static String sourceFolder = "Classic/";
     FloatControl gainControl;
     
     AudioPlayer(int level) {
    	 filePath = "dif" + Integer.toString(level) + ".aif";
    	 try {
 			audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
 	        clip = AudioSystem.getClip();   
 	        clip.open(audioInputStream); 
 	        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
 	        changeSound(-15.0f);
 	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
 	        
 		} catch (Exception e) {
 			e.printStackTrace();
 		}                    
    }
    
    AudioPlayer(String effectPath) {
    	try {
    		audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + effectPath).getAbsoluteFile());
 	        clip = AudioSystem.getClip();   
 	        clip.open(audioInputStream); 
 	        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
 	        changeSound(-15.0f); 
 	        play();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
     
    public void changeSound(float decibes) {
        gainControl.setValue(decibes);
    }
    
    public void play() { 
        clip.start(); 
        status = "play"; 
    } 
    
    public void restart()  { 
    	clip.stop(); 
    	clip.close(); 
    	resetAudioStream(); 
    	currentFrame = 0L; 
    	clip.setMicrosecondPosition(0); 
    	play(); 
    } 

    public void stop() {  //NOT WORKING
    	currentFrame = 0L; 
    	clip.stop(); 
    	clip.close();
    } 
    
    public void resetAudioStream() { 
        try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
	        clip.open(audioInputStream); 
	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
		} catch (Exception e) {

			e.printStackTrace();
		}
    } 
    
    // Method to pause the audio 
    public void pause() {
    	if(status.equals("paused")) return;
        currentFrame = clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
    
    public void resumeAudio() { 
    	if (status.equals("play")) return;
    	clip.close(); 
    	resetAudioStream(); 
    	clip.setMicrosecondPosition(currentFrame); 
    	play(); 
    	status = "play";
    } 
    
    public void setMediaPath(String path) {
    	filePath = path;
    }
}

