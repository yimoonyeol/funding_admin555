package funding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	
 @RequestMapping("/content")
 public String content(Model model) {
	 System.out.println("컨트롤러 시작");
	 return "sQApply_view";
	 
 }
}

