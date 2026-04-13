package challenges.designPattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
	
	Map<String, NewProtoType> protoMap = new HashMap<>();
	
	public void addInRegistry(String key, NewProtoType protoType) {
		protoMap.put(key, protoType);
	}
	
	public NewProtoType getProtoType(String key) {
		return protoMap.get(key) != null ? protoMap.get(key).clone():null;
	}

}
