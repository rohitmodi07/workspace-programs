package challenges.designPattern.factory;

public class SportsFactory {
	
	public Sports play(String gameType) {
		if("football".equals(gameType)) {
			return new Football();
		}else if("cricket".equals(gameType)) {
			return new Cricket();
		}else {
			return null;
		}
	}

}
