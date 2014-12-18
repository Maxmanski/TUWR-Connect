package data;

import java.sql.SQLException;

import etc.DoubleLinkedList;

public class DataCenter{
	
	private RunnableConnection con;
	private SQLConnection db = new SQLConnection();
	private static DataCenter instance;
	protected DoubleLinkedList<ConnectData> data = new DoubleLinkedList<>(); 
	
	private DataCenter(){}
	
	public static DataCenter getInstance(){
		if(instance == null){
			return (instance = new DataCenter());
		}
		else{
			return null;
		}
	}
	
	public ConnectData getOldestDataEntry(){
		@SuppressWarnings("unused")
		int i = 0;
		while(this.data.isEmpty()){
			i++; // so that the CPU is not bored senseless
		}
		return this.data.getAndRemoveLast();
	}
	
	public DoubleLinkedList<ConnectData> getData(){
		return data;
	}
	
	public synchronized void addToList(ConnectData conDat) throws SQLException {
		data.addFirst(conDat);
		db.insert(conDat, con.getId());
		while(data.size() > 1024){
			data.remove(1023);
		}
	}
	
	public void select(String stmt) throws SQLException{
		db.select(stmt);
	}
	
	public DoubleLinkedList<ConnectData> getPuffer(){
		return data;
	}
	
	public void connect(RunnableConnection con){
		Thread udpThread = new Thread(con);
		udpThread.start();
	}

	public RunnableConnection getConnect(){
		return con;
	}
}