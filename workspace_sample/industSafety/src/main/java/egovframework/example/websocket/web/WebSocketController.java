package egovframework.example.websocket.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cmm.annotation.IncludedInfo;

@Controller
public class WebSocketController {

	@RequestMapping(value = "/main.do")
	public String socketView(ModelMap model) throws Exception {
		return "websocket/WebSocket.tiles";
	}
	
}
