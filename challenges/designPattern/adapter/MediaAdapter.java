package challenges.designPattern.adapter;

public class MediaAdapter implements MediaPlayer{
	
	private AdvancedMediaPlayer advance;
	private String fileType;
	
	
	public MediaAdapter(String fileType) {
		this.fileType = fileType;
		
		if("VLC".equals(fileType)) {
			advance = new PlayVlcMedia();
		}else if("MP4".equals(fileType)) {
			advance = new PlayMp4Media();
		}
	}

	@Override
	public void play() {
		if("VLC".equals(fileType)) {
			advance.playVLC();;
		}else if("MP4".equals(fileType)) {
			advance.playMP4();;
		}else {
			System.out.println(" play mp3 ");
		}
		
	}

}
