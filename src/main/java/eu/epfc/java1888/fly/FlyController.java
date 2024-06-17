package eu.epfc.java1888.fly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FlyController {
    private final FlyRepository repository;

    public FlyController(FlyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flies")
    public String showFlies(Model model) {
        List<Fly> flies = repository.findAll();
        model.addAttribute("list", flies);
        return "flies-view";
    }

    @GetMapping("/fly-number")
    public String showFlyNum(Model model){
        Fly fly = new Fly();
        model.addAttribute("fly", fly);
        return "fly-view";
    }

    @PostMapping("/flies")
    public String createGiftProcessor(@ModelAttribute("fly") Fly fly) {
        repository.save(fly);
        return "redirect:flies";
    }
}
