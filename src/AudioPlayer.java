/*
 * @file AudioPlayer.java
 * 
 * @brief Class to implement audio (music and sfx) for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 */
import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl; 

public class AudioPlayer {
	
	static final float initVolume = -20.0f;	//Initial volume
	static final String effectFile = "Effects/";
    Long currentFrame; 						//Current frame of the song
    Clip clip; 								//Clip that plays the song
    String status;   						//status (whether the game is paused or playing)
    AudioInputStream audioInputStream; 		//Inputstream for the AudioFile
    String mainFolder = "audio/";			//Mainfolder of the audio files
    String filePath = "dif1.aif"; 			//File path for the current level
    static String sourceFolder = "Classic/";//Source folder of the current look and feel
    static float volume = initVolume;		//Volume that is playing on the game right now
    FloatControl gainControl;				//FloatControl to set the volume
    
    /*
     * @brief Constructor for song audio players (has a different song for each level)
     */
    AudioPlayer(int level) {
    	filePath = "dif" + Integer.toString(level) + ".aif";
    	try {
    		audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
    		clip = AudioSystem.getClip();   
 	        clip.open(audioInputStream); 
 	        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
 	        changeSound(volume);
 	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
 		} catch (Exception e) {
 			e.printStackTrace();
 		}                    
    }
    
    /*
     * @brief Constructor for the sound effects. Receives the path of the sound effect and plays it once
     */
    AudioPlayer(String effectPath) {
    	try {
    		audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + effectFile + effectPath).getAbsoluteFile());
 	        clip = AudioSystem.getClip();   
 	        clip.open(audioInputStream); 
 	        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
 	        changeSound(volume); 
 	        play();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /*
     * @brief Method to change the volume of the object audioPlayer
     */
    public void changeSound(float decibes) {
    	volume = decibes;
        gainControl.setValue(volume);
    }
    
    /*
     * @brief Method to play the audio
     */
    public void play() { 
        clip.start(); 
        status = "play"; 
    } 
    
    /*
     * @brief Method to start the audio all over again
     */
    public void restart()  { 
    	clip.stop(); 
    	clip.close(); 
    	resetAudioStream(); 
    	currentFrame = 0L; 
    	clip.setMicrosecondPosition(0); 
    	play(); 
    } 
    
    /*
     * @brief Method to stop the audio from playing
     */
    public void stop() {
    	currentFrame = 0L; 
    	clip.stop(); 
    	clip.close();
    } 
    
    /*
     * @brief Method that resets the audio stream from which the audio is read
     */
    public void resetAudioStream() { 
        try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(mainFolder + sourceFolder + filePath).getAbsoluteFile());
	        clip.open(audioInputStream); 
	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
    
    /*
     * @brief Pauses the song to continue later
     */
    public void pause() {
    	if(status.equals("paused")) return;
    	currentFrame = clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
    
    /*
     * @brief Resumes audio from where it was playing
     */
    public void resumeAudio() { 
    	if (status.equals("play")) return;
    	clip.close(); 
    	resetAudioStream(); 
    	clip.setMicrosecondPosition(currentFrame); 
    	play(); 
    	status = "play";
    } 
    
    /*
     * @brief sets current media path, changing it while the object is still there
     */
    public void setMediaPath(String path) {
    	filePath = path;
    }
}

