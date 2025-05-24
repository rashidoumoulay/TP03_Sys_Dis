package oumoulay.net.tp03.web;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import oumoulay.net.tp03.entities.Patient;
import oumoulay.net.tp03.repositories.PatientRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model ,
                        @RequestParam(name = "page" , defaultValue = "0") int page ,
                        @RequestParam(name = "size" , defaultValue = "3") int size ,
                        @RequestParam(name="keyword" , defaultValue = "") String kw ){
        Page<Patient> pagePatients = patientRepository.findByNomContains(kw,PageRequest.of(page, size));
        model.addAttribute("pages" , new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage" , page);
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("keyword" , kw);
        return "Patients";
    }
    @GetMapping("/delete")
    public String delete(Long id , String page , String keyword){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

}
