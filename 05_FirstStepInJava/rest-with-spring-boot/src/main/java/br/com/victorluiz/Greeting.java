package br.com.victorluiz;

public class Greeting {

	private final long id;
	private String content;
	
	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public long getId() {
		return id;
	}
	
	
}
