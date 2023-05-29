package com.booking.tickets.controllers;

import com.booking.tickets.models.Ticket;
import com.booking.tickets.repositories.TicketRepository;
import com.booking.tickets.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;

    @RequestMapping("/createTicket")
    public String createTicket(){
        return "CreateTicket";
    }


    @RequestMapping("saveTicket")
    public String saveTicket(@Valid Ticket ticket, BindingResult bindingResult){
        if(bindingResult.hasErrors())return "CreateTicket";
        ticketService.saveTicket(ticket);
        return "CreateTicket";
    }


    @RequestMapping("/ticketList")
    public String ticketList(ModelMap modelMap,
                             @RequestParam(name="page",defaultValue ="0" ) int page,
                             @RequestParam(name="size",defaultValue = "5") int size
                             ){
        Page<Ticket> ticketsController =ticketService.getAllticketsByPage(page,size);
        modelMap.addAttribute("ticketsJsp",ticketsController);
        modelMap.addAttribute("pages",new int[ticketsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "TicketsList";

    }

    @RequestMapping("/deleteTicket")
    public String deleteTicket(@RequestParam("id") Long id,ModelMap modelMap,
                               @RequestParam(name="page",defaultValue ="0" ) int page,
                               @RequestParam(name="size",defaultValue = "5") int size
     ){
        ticketService.deleteTicketById(id);
        Page<Ticket> ticketsController =ticketService.getAllticketsByPage(page,size);
        modelMap.addAttribute("ticketsJsp",ticketsController);
        modelMap.addAttribute("pages",new int[ticketsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "TicketsList";
    }

    @RequestMapping("/showTicket")
    public String showTicket(@RequestParam("id") Long id,ModelMap modelMap){
        Ticket ticketController=ticketService.getTicket(id);
        modelMap.addAttribute("ticketsJsp",ticketController);
        return "EditeTicket";
    }

   @RequestMapping("/updateTicket")
    public String updateTicket(@ModelAttribute("ticket") Ticket ticket){
        Ticket memo=ticketService.saveTicket(ticket);
        return "CreateTicket";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/ticketList";
    }

    @GetMapping("accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }




    }







