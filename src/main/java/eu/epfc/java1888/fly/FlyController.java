package eu.epfc.java1888.fly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FlyController {
    private final FlyRepository repository;

    public FlyController(FlyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flies")
    public String showFlies(Model model){
    List<Fly> flies = repository.findAll();
    model.addAttribute("list", flies);
    return "flies-view";

    }
}
