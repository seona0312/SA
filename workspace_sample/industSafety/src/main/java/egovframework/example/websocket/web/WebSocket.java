package egovframework.example.websocket.web;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@ServerEndpoint(value = "/websocket2") //클라이언트가 접속할 때 사용될 URI
public class WebSocket{
	
	    private static final String GUEST_PREFIX = "Guest";

	    // AtomicInteger 클래스는 getAndIncrement()를 호출할 때마다 카운터를 1씩 증가하는 기능을 가지고 있다
	    private static final AtomicInteger connectionIds = new AtomicInteger(0);

	    // CopyOnWriteArraySet 을 사용하면 컬렉션에 저장된 객체를 좀더 간편하게 추출할 수 있다
	    // 예를 들어, toArray()메소드를 통해 쉽게 Object[] 형의 데이터를 추출할 수 있다.
	    private static final Set<WebSocket> connections = new CopyOnWriteArraySet<WebSocket>();

	    private final String nickname;
	    
	    // 클라이언트가 새로 접속할 때마다 한개의 Session 객체가 생성된다.
	    // Session 객체를 컬렉션에 보관하여 두고 해당 클라이언트에게 데이터를 전송할 때마다 사용한다
	    private Session session;

	    
	    	
	    //db연결
	    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    private final String DB_URL = "jdbc:mysql://192.168.1.31/test_DB";
	    
	    private final String USER_NAME = "root";
	    private final String PASSWORD = "rasqlalf";
	    
	    
	    public WebSocket() { // 클라이언트가 새로 접속할 때마다 이 클래스의 인스턴스가 새로 생성됨
	    
	    	// 클라이언트가 접속할 때마다 서버측에서는 Thread 가 새로 생성되는 것을 확인할 수 있다
	    	String threadName = "Thread-Name:"+Thread.currentThread().getName();
	    	// getAndIncrement()은 카운트를 1 증가하고 증가된 숫자를 리턴한다
	        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	        System.out.println(threadName+", "+nickname);
	    }


	    @OnOpen
	    public void start(Session session, EndpointConfig conf) {
	        System.out.println("클라이언트 접속됨 "+session);
	        //Session:접속자마다 한개의 세션이 생성되어 데이터 통신수단으로 사용됨
	        //한개의 브라우저에서 여러개의 탭을 사용해서 접속하면 Session은 서로 다르지만 HttpSession 은 동일함
	        this.session = session;
	        connections.add(this);
	        String message = String.format("* %s %s", nickname, "has joined.");
	        //broadcast(message);	    
	        
	    }

	    @OnClose
	    public void end() {
	        connections.remove(this);
	        String message = String.format("* %s %s", nickname, "has disconnected.");
	        //broadcast(message);
	    }
	    
	    // 현재 세션과 연결된 클라이언트로부터 메시지가 도착할 때마다 새로운 쓰레드가 실행되어 incoming()을 호출함
	    @OnMessage
	    public void incoming(String message) throws Exception {
	    	String threadName = "Thread-Name:"+Thread.currentThread().getName();
	    	System.out.println(threadName+", "+nickname);
	        if(message==null || message.trim().equals("")) return;
	        String filteredMessage = String.format("%s: %s", nickname, message);
	        //WebSocket2.broadcast(filteredMessage);	
	        
	        int co2 = 32;
	        int temp = 54;
	        int humidity = 43;
	        int heartRate = 24;
	        int activity = 12;
	        int dust = 44;
	        int harmfulGas = 25;
	        
	        Connection conn = null;
	        Statement state = null;
	       
	        
	        try {
	        	Class.forName(JDBC_DRIVER);
	        	conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	        	System.out.println("mysql Connection");
	        	state = conn.createStatement();
	        	
	        	String sql;
	        	sql = "UPDATE TB_REALTIME_DATA SET CO2= " + co2 ;
	        	sql += ", TEMP=" + temp;
	        	sql += ", HUMIDITY=" + humidity;
	        	sql += ", HEART_RATE=" + heartRate;
	        	sql += ", ACTIVITY=" + activity;
	        	sql += ", DUST=" + dust;
	        	sql += ", HARMFUL_GAS=" + harmfulGas;
	        	sql += ", UPDATE_DATE=SYSDATE()";
	        	
	        	System.out.println("sql ==" + sql);
	        	state.executeUpdate(sql);
	        	
	        }catch(Exception e) {
	        	System.out.println("Exception = " + e);
	        }
	    }

	    @OnMessage
	    public void echoBinaryMessage(Session session, ByteBuffer bb, boolean last) {
	    		
	    		Charset charset = Charset.forName("UTF-8");
	    		String data = charset.decode(bb).toString();
	    		
	    		System.out.println("string data =" + data);
	    		
	    		JsonParser parser = new JsonParser(); 
	    		
	    		JsonElement obj = parser.parse(data);
	    		
	    		int co2 = Integer.parseInt(obj.getAsJsonObject().get("co2").getAsString());
	    		int temp = Integer.parseInt(obj.getAsJsonObject().get("temp").getAsString());
	    		int humidity = Integer.parseInt(obj.getAsJsonObject().get("humidity").getAsString());
	    		int heartRate = Integer.parseInt(obj.getAsJsonObject().get("heartRate").getAsString());
	    		int activity = Integer.parseInt(obj.getAsJsonObject().get("activity").getAsString());
	    		int dust = Integer.parseInt(obj.getAsJsonObject().get("dust").getAsString());
	    		int harmfulGas = Integer.parseInt(obj.getAsJsonObject().get("harmfulGas").getAsString());
    			
    			System.out.println("co2 ==" + co2);
    			System.out.println("temp ==" + temp);
    			System.out.println("humidity ==" + humidity);
    			System.out.println("heartRate ==" + heartRate);
    			System.out.println("activity ==" + activity);
    			System.out.println("dust ==" + dust);
    			System.out.println("harmfulGas ==" + harmfulGas);
    			
    			Connection conn = null;
    	        Statement state = null;
    	        
    	        try {
    	        	Class.forName(JDBC_DRIVER);
    	        	conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    	        	System.out.println("mysql Connection");
    	        	state = conn.createStatement();
    	        	
    	        	String sql;
    	        	sql = "UPDATE TB_REALTIME_DATA SET CO2 = " + co2 ;
    	        	sql += ", TEMP=" + temp;
    	        	sql += ", HUMIDITY=" + humidity;
    	        	sql += ", HEART_RATE=" + heartRate;
    	        	sql += ", ACTIVITY=" + activity;
    	        	sql += ", DUST=" + dust;
    	        	sql += ", HARMFUL_GAS=" + harmfulGas;
    	        	sql += ", UPDATE_DATE=SYSDATE()";
    	        	
    	        	System.out.println("sql ==" + sql);
    	        	state.executeUpdate(sql);
    	        	
    	        }catch(Exception e) {
    	        	System.out.println("Exception = " + e);
    	        }
	    		
	    }

	    
	    @OnError
	    public void onError(Throwable t) throws Throwable {	    	
	        System.err.println("Chat Error: " + t.toString());
	    }

	    // 현재 세션으로부터 도착한 메시지를 모든 접속자에게 전송한다
	   private void broadcast(String msg) {
	    	Iterator<WebSocket> ss = connections.iterator();
	        for (int i=0;i<connections.size();i++) {
	        	WebSocket client = ss.next();
	            try {
	                synchronized (client) {
	                    // 서버에 접속 중인 모든 이용자에게 메지지를 전송한다
	                    client.session.getBasicRemote().sendText(msg);
	                }
	            } catch (IllegalStateException ise){
	            	// 특정 클라이언트에게 현재 메시지 보내기 작업 중인 경우에 동시에 쓰기작업을 요청하면 오류 발생함
	            	if(ise.getMessage().indexOf("[TEXT_FULL_WRITING]")!=-1) {
	            		new Thread() {
	            			@Override
	            			public void run() {
			            		while(true) {
			            			try{
			            				client.session.getBasicRemote().sendText(msg);
			            				break;
			            			}catch(IllegalStateException _ise){
			            				try {
								Thread.sleep(100); // 메시지 보내기 작업을 마치도록 기다려준다
								} catch (InterruptedException e) {}
			            			}
			            			catch(IOException ioe){
			            				ioe.printStackTrace();
			            			}
			            		}
	            			}
	            		}.start();
	            	}
	            } catch (Exception e) {
	            	// 메시지 전송 중에 오류가 발생(클라이언트 퇴장을 의미함)하면 해당 클라이언트를 서버에서 제거한다
	                System.err.println("Chat Error: Failed to send message to client:"+e);
	                connections.remove(client);
	                try {
	                	// 접속 종료
	                    client.session.close();
	                } catch (IOException e1) {
	                    // Ignore
	                }
	                // 한 클라이언트의 퇴장을 모든 이용자에게 알린다
	                String message = String.format("* %s %s",
	                        client.nickname, "has been disconnected.");
	                broadcast(message);
	            }
	        }
	    }
}
	
