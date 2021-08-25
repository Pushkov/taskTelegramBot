package nicomed.tms.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping("")
    public String getEmptyIndex() {
        return "redirect:/tms/index";
    }

    @GetMapping("/tms")
    public String getIndexTMS() {
        return "redirect:/tms/index";
    }

    @GetMapping("/tms/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/tms/about")
    public String getAboutPage() {
        return "index";
    }
}
