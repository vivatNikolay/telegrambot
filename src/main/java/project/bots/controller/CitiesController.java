package project.bots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.bots.model.Cities;
import project.bots.model.CitiesRepo;

@Controller
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CitiesRepo citiesRepo;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("showAllCities", citiesRepo.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        Cities cities = new Cities();
        model.addAttribute("cit", cities);

        return "save";
    }

    @GetMapping("/update")
    public String upadate(@RequestParam(name = "id", required=false) Integer id, Model model) {
        Cities cities = citiesRepo.findById(id).get();
        model.addAttribute("cit", cities);
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("cit")@Validated Cities cit, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "save";
        }
        citiesRepo.save(cit);
        model.addAttribute("showAllCities", citiesRepo.findAll());
        return "index";
    }

    @GetMapping("/view")
    public String show(@RequestParam(name = "id", required=false) Integer id, Model model) {
        model.addAttribute("show", citiesRepo.findById(id).get());
        return "view";
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(name = "id", required=false) Integer id, Model model) {
        citiesRepo.deleteById(id);
        return new ModelAndView("redirect:/cities/");
    }
}
