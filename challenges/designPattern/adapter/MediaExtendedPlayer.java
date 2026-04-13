package challenges.designPattern.adapter;

public class MediaExtendedPlayer {
	
	public static void main(String[] args) {
		MediaAdapter ma1 = new MediaAdapter("VLC");
		MediaAdapter ma2 = new MediaAdapter("MP4");
		MediaAdapter ma3 = new MediaAdapter("MP3");
		
		ma1.play();
		ma2.play();
		ma3.play();
	}

}
