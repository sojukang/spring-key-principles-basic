package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	// private final ObjectProvider<MyLogger> myLoggerProvider;

	@RequestMapping("log-demo")
	@ResponseBody //view 를 거치지 않고 문자를 그대로 보낸다
	public String logDemo(HttpServletRequest request) throws InterruptedException { //java 에서 정의한 http 요청정보를 받을 수 있다
		String requestURL = request.getRequestURI().toString();
		// MyLogger myLogger = myLoggerProvider.getObject(); //필요한 시점에
		System.out.println("myLogger = " + myLogger.getClass());
		myLogger.setRequestURL(requestURL);

		myLogger.log("controller test");
		Thread.sleep(1000);
		logDemoService.logic("testId");
		return "OK";
	}

}
