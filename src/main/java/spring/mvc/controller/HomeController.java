package spring.mvc.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import spring.mvc.exeptionhandler.UnauthorizedException;

@Controller
public class HomeController {

	private static final Logger logger=LogManager.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String home() {
		logger.debug("Hello from Log4j 2");
		logger.debug("This is a Debug Message!");
		logger.info("This is an Info Message!");
		logger.error("And here comes the Error Message!");
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/test1")
	public String test1() {
		return "test1";
	}

	@RequestMapping(value = "/page1")
	public String page1() {
		return "page1";
	}

	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	public RedirectView redirectView(@RequestParam(value = "name") String name, RedirectAttributes redirectAttributes) {
		System.out.println("Name: " + name);
		redirectAttributes.addAttribute("name", name);
		return new RedirectView("page2");
	}

	@RequestMapping(value = "/page2")
	public String page2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "page2";
	}

	@RequestMapping(value = "/unauthorizedException")
	public String testUnauthorized() throws IOException {
		throw new UnauthorizedException();
	}

	@ExceptionHandler(value = NullPointerException.class)
	public String processNullPointerException() {
		return "null-pointer-exception";
	}

	@RequestMapping(value = "/nullPointerException")
	public String testNullpointerException() throws NullPointerException {
		throw new NullPointerException("");
	}

	@RequestMapping(value = "/ioException")
	public String testIOException() throws IOException {
		throw new IOException("this is io exception.");
	}
	
}
