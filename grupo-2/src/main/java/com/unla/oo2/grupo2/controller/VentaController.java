package com.unla.oo2.grupo2.controller;

import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo.serviceInterfaces.IProducto;
import com.unla.oo2.grupo.serviceInterfaces.IVenta;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.entity.UserRole;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.service.UserService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private IVenta venteService;
	private IProducto productoService;
	private UserService userService;
	

	public VentaController(IVenta venteService, IProducto productoService, UserService userService) {
		this.venteService = venteService;
		this.productoService = productoService;
		this.userService = userService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/venta/index");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = userService.findUserByUsername(userDetails.getUsername());
		
		
		for (UserRole userRole : user.getUserRoles()) {
			if(userRole.getRole().equals("ROLE_ADMIN")) {
				System.out.println("Entre al equals");
				modelAndView.addObject("ventas", venteService.getAll());
				modelAndView.addObject("clientes", userService.findAdmins());
			}
		}
		
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/venta/index");
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/venta/update");
		modelAndView.addObject("venta", venteService.findById(id).get());
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/venta/new");
		model.addObject("clientes", userService.findUsers());
		model.addObject("venta", new Venta());
		return model;
	}
/*
	@PostMapping("/create")
	public ModelAndView create(@ModelAttribute("venta") Venta venta) {
        Cliente cliente = clienteService.getById(venta.getCliente().getId());
        
        if (cliente == null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("error", "El ID del cliente no existe.");
            modelAndView.addObject("clientes", clienteService.getAll());
            return modelAndView;
        }
        
		venteService.agregar(venta);
		System.out.println("previo a return");
		return new ModelAndView("/venta/index");
	}
	
*/
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") Venta venta) {
		
		User cliente = userService.findUserByUsername(venta.getCliente().getUsername());
        
        if (cliente != null) {
        	venteService.agregar(venta);
        }
		
		return new RedirectView("/venta/index");
	}

	
	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("venta") Venta venta) {
		venteService.insertOrUpdate(venta);
		return new RedirectView("/venta/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		venteService.delete(id);
		return new RedirectView("/venta/index");
	}

}
