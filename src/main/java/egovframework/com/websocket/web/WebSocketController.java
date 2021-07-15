package egovframework.com.websocket.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping(value = "/webSocket.do")
	public String socketView(ModelMap model) throws Exception {
		return "websocket/WebSocket.tiles";
	}
	
}
