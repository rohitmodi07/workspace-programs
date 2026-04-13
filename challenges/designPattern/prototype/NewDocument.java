package challenges.designPattern.prototype;

public class NewDocument implements NewProtoType{
	
	private String docTitle;
	private String docName;
	
	public NewDocument(String docTitle, String docName) {
		this.docName = docName;
		this.docTitle = docTitle;
	}
	
	public NewProtoType clone() {
		return new NewDocument(docTitle, docName);
	}

	@Override
	public String toString() {
		return "NewDocument [docTitle=" + docTitle + ", docName=" + docName + "]";
	}
	
	

}
