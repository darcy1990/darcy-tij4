package proxy;

public interface Operation {
	
	public String read() ;
	
	public void write(String write) ;
	
	public void delete();
	
	public void create() ;
	
}
