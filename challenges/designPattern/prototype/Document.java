package challenges.designPattern.prototype;

public class Document implements Prototype {
    private String title;
    private String content;
    
    public Document(String title, String content) {
    	this.title = title;
    	this.content = content;
    }
    
    public Document(Document doc) {
       this.title = doc.title;
       this.content = doc.content;
    			
    }
    
    public Prototype clone() {
    	return new Document(this);
    }
}

