package scibby.util;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer{

	private Clip clip;

	public AudioPlayer(String fileName){
		try{
			AudioInputStream ais = new ResourceLoader().loadAudio(fileName);

			AudioFormat baseFormat = ais.getFormat(); //The undecoded format.
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false); //The decoded format.
			AudioInputStream dias = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dias);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void play(){
		if(clip == null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	public void stop(){
		if(clip.isRunning()) clip.stop();
	}

	public void close(){
		stop();
		clip.close();
	}
}
