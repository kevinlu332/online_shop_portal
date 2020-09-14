
package onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomePageController{
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String sayIndex() {
		return "index";
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, 
							  @RequestParam(value="logout", required = false) String logout) {
		ModelAndView  mav = new ModelAndView();
		mav.setViewName("login");
		if(error!=null) mav.addObject("error", "Invalid username and Password");
		if(logout!=null) mav.addObject("logout", "You have logged out succcessfully");
		return mav;
	}
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)	
	public String sayAbout() {
		return "aboutUs";
	}
}