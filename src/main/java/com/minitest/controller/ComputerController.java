package com.minitest.controller;


import com.minitest.dto.ComputerDTO;
import com.minitest.model.Computer;
import com.minitest.model.Type;
import com.minitest.service.IComputerService;
import com.minitest.service.ITypeService;
import com.minitest.service.computer.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/computer")

public class ComputerController {

    @Autowired
    private IComputerService computerService;
    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllCustomer() {
        List<Computer> computers = (List<Computer>) computerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }


//    @ModelAttribute("types")
//    public Iterable<Type> listTypes() {
//        return typeService.findAll();
//    }
//
//    @GetMapping("")
//    public ModelAndView listComputers(
//            @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Computer> computers = computerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/computer/list");
//        modelAndView.addObject("computers", computers);
//        return modelAndView;
//    }
//
//    @GetMapping("/search")
//    public ModelAndView listComputerSearch(@RequestParam("search") Optional<String> search,
//                                           @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Computer> computers;
//        if (search.isPresent()) {
//            computers = computerService.findAllByNameContaining(pageable, search.get());
//        } else {
//            computers = computerService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/computer/list");
//        modelAndView.addObject("computers", computers);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView createComputerForm() {
//        ModelAndView modelAndView = new ModelAndView("/computer/create");
//        modelAndView.addObject("computerDTO", new ComputerDTO());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public String createComputer(@ModelAttribute("computerDTO") ComputerDTO computerDTO,
//                                 RedirectAttributes redirectAttributes) {
//        Optional<Type> typeOptional = typeService.findById(computerDTO.getTypeId());
//        if (!typeOptional.isPresent()) {
//            return "redirect:/error_404";
//        }
//        Computer computer = new Computer();
//        computer.setId(computerDTO.getId());
//        computer.setCode(computerDTO.getCode());
//        computer.setName(computerDTO.getName());
//        computer.setProducer(computerDTO.getProducer());
//        computer.setComputerType(typeOptional.get());
//
//        computerService.save(computer);
//        redirectAttributes.addFlashAttribute("message", "Created computer successfully");
//        return "redirect:/computer";
//    }
//
//    @GetMapping("/update/{id}")
//    public ModelAndView updateComputerForm(@PathVariable Long id) {
//        Optional<Computer> computerOptional = computerService.findById(id);
//        if (computerOptional.isPresent()) {
//            Computer computer = computerOptional.get();
//            ComputerDTO computerDTO = new ComputerDTO();
//            computerDTO.setId(computer.getId());
//            computerDTO.setCode(computer.getCode());
//            computerDTO.setName(computer.getName());
//            computerDTO.setProducer(computer.getProducer());
//            if(computer.getComputerType() != null) {
//                computerDTO.setTypeId(computer.getComputerType().getId());
//            }
//            ModelAndView modelAndView = new ModelAndView("/computer/update");
//            modelAndView.addObject("computerDTO", computerDTO);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error_404");
//        }
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateComputer(@PathVariable Long id,
//                                 @ModelAttribute("computerDTO") ComputerDTO computerDTO,
//                                 RedirectAttributes redirectAttributes) {
//        Optional<Type> typeOptional = typeService.findById(computerDTO.getTypeId());
//        if (!typeOptional.isPresent()) {
//            return "redirect:/error_404";
//        }
//        Computer computer = new Computer();
//        computer.setId(id);
//        computer.setCode(computerDTO.getCode());
//        computer.setName(computerDTO.getName());
//        computer.setProducer(computerDTO.getProducer());
//        computer.setComputerType(typeOptional.get());
//
//        computerService.save(computer);
//        redirectAttributes.addFlashAttribute("message", "Updated computer successfully");
//        return "redirect:/computer";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteComputer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//        computerService.remove(id);
//        redirectAttributes.addFlashAttribute("message", "Deleted computer successfully");
//        return "redirect:/computer";
//    }
}