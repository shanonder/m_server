package web.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/error")
public class ErrorController {
  @RequestMapping("/")
  public @ResponseBody String greeting() {
      return "Hello World";
  }
}
