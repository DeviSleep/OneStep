import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 *
 */
public class Player {
	public static  boolean isStop;
	
	public static Thread t;
	private int loc;
	private int volume;
	private AudioInputStream input;
	private SourceDataLine line;
	public static String name;
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Player(){}
	public Player(String path){
		name=path;
		AudioFormat format=null;
		isStop=false;
		while(isStop){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		try {
			 input=AudioSystem.getAudioInputStream(new File(path));
			 format=input.getFormat();
			//
			if(format.getEncoding()!=AudioFormat.Encoding.PCM_SIGNED){
				format=new AudioFormat(
						AudioFormat.Encoding.PCM_SIGNED,
						format.getSampleRate(),
						16,
						format.getChannels(),
						format.getChannels()*2,
						format.getSampleRate(),
						false);
				input=AudioSystem.getAudioInputStream(format,input);
			}
			//
			DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
			line=(SourceDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();
			
			t=new Thread(new play(input,line));
			t.start();
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

class play implements Runnable {
	private AudioInputStream input;
	private SourceDataLine line; 
	public play(AudioInputStream input,SourceDataLine line){
		this.input=input;
		this.line=line;
	}
	
	public void run(){
		byte[] buffer=new byte[1024];
		int data=-1;
		try {
			while((data=input.read(buffer, 0, buffer.length))!=-1){
				if(Player.isStop){
					break;
				}
				if(data>0){
				line.write(buffer, 0, data);
				}
			}		
			line.drain();
			line.close();
			} catch (IOException e) {

			e.printStackTrace();
		}finally{
			Player.isStop=true;
		}
	}
}	
