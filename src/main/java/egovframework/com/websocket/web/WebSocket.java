package egovframework.com.websocket.web;

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
	    private final String DB_URL = "jdbc:mysql://192.168.1.31/IS_AIOT";
	    
	    private final String USER_NAME = "IS_AIOT";
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
	        
	        String deviceid = "CD:E2:AE:DE:C0:56";
	        int pm10 = 8;
	        int pm25 = 9;
	        int pm100 = 10;
	        float tempc = 29.59f;
	        float tempf = 81.67f;
	        float humi =  85.0f;
	        float co2 = 731.0f;
	        float tvoc = 134.0f;
	        int score = 68;
	        
	        Connection conn = null;
	        Statement state = null;
	       
	        
	        try {
	        	Class.forName(JDBC_DRIVER);
	        	conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	        	System.out.println("mysql Connection");
	        	state = conn.createStatement();
	        	
	        	String sql;
	        	sql = "UPDATE IS_AIOT_IAQ SET DEVICE_ID= " + deviceid ;
	        	sql += ", PM_1_0=" + pm10;
	        	sql += ", PM_2_5=" + pm25;
	        	sql += ", PM_10_0=" + pm100;
	        	sql += ", Temp_c=" + tempc;
	        	sql += ", Temp_f=" + tempf;
	        	sql += ", HUMI=" + humi;
	        	sql += ", CO2=" + co2;
	        	sql += ", TVOC=" + tvoc;
	        	sql += ", SCORE=" + score;
	        	sql += ", DATE=SYSDATE()";
	        	
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
	    		
	    		String deviceId = obj.getAsJsonObject().get("deviceId").getAsString();
	    		int pm10 = Integer.parseInt(obj.getAsJsonObject().get("pm10").getAsString());
	    		int pm25 = Integer.parseInt(obj.getAsJsonObject().get("pm25").getAsString());
	    		int pm100 = Integer.parseInt(obj.getAsJsonObject().get("pm10").getAsString());
	    		float tempc = Integer.valueOf(obj.getAsJsonObject().get("tempc").getAsString());
	    		float tempf = Integer.valueOf(obj.getAsJsonObject().get("tempf").getAsString());
	    		float humi = Integer.valueOf(obj.getAsJsonObject().get("humi").getAsString());
    			float co2 = Integer.valueOf(obj.getAsJsonObject().get("co2").getAsString());
    			float tvoc = Integer.valueOf(obj.getAsJsonObject().get("tvoc").getAsString());
    			int score = Integer.parseInt(obj.getAsJsonObject().get("score").getAsString());
	    		
	    		
	    		
    			System.out.println("deviceId ==" + deviceId);
    			System.out.println("pm10 ==" + pm10);
    			System.out.println("pm25 ==" + pm25);
    			System.out.println("pm100 ==" + pm100);
    			System.out.println("tempc ==" + tempc);
    			System.out.println("temf ==" + tempf);
    			System.out.println("humi ==" + humi);
    			System.out.println("co2 ==" + co2);
    			System.out.println("tvoc ==" + tvoc);
    			System.out.println("score ==" + score);
    			
    			Connection conn = null;
    	        Statement state = null;
    	        
    	        try {
    	        	Class.forName(JDBC_DRIVER);
    	        	conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    	        	System.out.println("mysql Connection");
    	        	state = conn.createStatement();
    	        	
    	        	String sql;
    	        	sql = "UPDATE IS_AIOT_IAQ SET DEVICE_ID = " + deviceId ;
    	        	sql += ", PM_1_0=" + pm10;
    	        	sql += ", PM_2_5=" + pm25;
    	        	sql += ", PM_10_0=" + pm100;
    	        	sql += ", Temp_c=" + tempc;
    	        	sql += ", Temp_f=" + tempf;
    	        	sql += ", HUMI=" + humi;
    	        	sql += ", CO2=" + co2;
    	        	sql += ", TVOC=" + tvoc;
    	        	sql += ", SCORE=" + score;
    	        	sql += ", DATE=SYSDATE()";
    	        	
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
	   private void broadcast(final String msg) {
	    	Iterator<WebSocket> ss = connections.iterator();
	        for (int i=0;i<connections.size();i++) {
	        	final WebSocket client = ss.next();
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
	
