package com.minitest.controller;
import com.minitest.dto.TypeDTO;
import com.minitest.model.Computer;
import com.minitest.model.Type;
import com.minitest.service.IComputerService;
import com.minitest.service.ITypeService;
import com.minitest.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private ITypeService typeService;
    @Autowired
    private IComputerService computerService;

    @GetMapping
    public ResponseEntity<Iterable<Type>> findAllCustomer() {
        List<Type> types = (List<Type>) typeService.findAll();
        if (types.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Type> findCustomerById(@PathVariable Long id) {
        Optional<Type> typeOptional = typeService.findById(id);
        if (!typeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Type> typeCustomer(@RequestBody Type type) {
        return new ResponseEntity<>(typeService.save(type), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type type) {
        Optional<Type> typeOptional = typeService.findById(id);
        if (!typeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        type.setId(typeOptional.get().getId());
        return new ResponseEntity<>(typeService.save(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Type> deleteType(@PathVariable Long id) {
        Optional<Type> typeOptional = typeService.findById(id);
        if (!typeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeService.remove(id);
        return new ResponseEntity<>(typeOptional.get(), HttpStatus.OK);
    }
}



//    @GetMapping("")
//    public ModelAndView listTypes() {
//        Iterable<Type> types = typeService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/type/list");
//        modelAndView.addObject("types", types);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView createTypeForm() {
//        ModelAndView modelAndView = new ModelAndView("/type/create");
//        modelAndView.addObject("typeDTO", new TypeDTO());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public String createType(@ModelAttribute("typeDTO") TypeDTO typeDTO,
//                             RedirectAttributes redirectAttributes) {
//        Type type = new Type();
//        type.setId(typeDTO.getId());
//        type.setName(typeDTO.getName());
//        typeService.save(type);
//        redirectAttributes.addFlashAttribute("message", "Created type successfully");
//        return "redirect:/type";
//    }
//
//    @GetMapping("/update/{id}")
//    public ModelAndView updateTypeForm(@PathVariable Long id) {
//        Optional<Type> typeOptional = typeService.findById(id);
//        if (typeOptional.isPresent()) {
//            Type type = typeOptional.get();
//            TypeDTO typeDTO = new TypeDTO();
//            typeDTO.setId(type.getId());
//            typeDTO.setName(type.getName());
//            ModelAndView modelAndView = new ModelAndView("/type/update");
//            modelAndView.addObject("typeDTO", typeDTO);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error_404");
//        }
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateType(@PathVariable Long id,
//                             @ModelAttribute("typeDTO") TypeDTO typeDTO,
//                             RedirectAttributes redirectAttributes) {
//        Type type = new Type();
//        type.setId(id);
//        type.setName(typeDTO.getName());
//        typeService.save(type);
//        redirectAttributes.addFlashAttribute("message", "Updated type successfully");
//        return "redirect:/type";
//    }
//
//    @GetMapping("/view-type/{id}")
//    public ModelAndView viewType(@PathVariable("id") Long id) {
//        Optional<Type> typeOptional = typeService.findById(id);
//        if (!typeOptional.isPresent()) {
//            return new ModelAndView("/error_404");
//        }
//        Iterable<Computer> computers = computerService.findAllByType(typeOptional.get());
//        ModelAndView modelAndView = new ModelAndView("/computer/list");
//        modelAndView.addObject("computers", computers);
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteType(@PathVariable Long id) {
//        Optional<Type> typeOptional = typeService.findById(id);
//        if (typeOptional.isPresent()) {
//            typeService.remove(id);
//            return "redirect:/type";
//        }
//        return "redirect:/error_404";
//    }