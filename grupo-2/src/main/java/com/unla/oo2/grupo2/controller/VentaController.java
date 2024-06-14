package com.unla.oo2.grupo2.controller;

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

import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.entity.UserRole;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.service.UserService;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;
import com.unla.oo2.grupo2.serviceInterfaces.IVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private IVentaService ventaService;
	private UserService userService;

	public VentaController(IVentaService ventaService, IProductoService productoService, UserService userService) {
		this.ventaService = ventaService;
		this.userService = userService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/venta/index");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = userService.findUserByUsername(userDetails.getUsername());
		for (UserRole userRole : user.getUserRoles()) {
			if (userRole.getRole().equals("ROLE_ADMIN")) {
				modelAndView.addObject("ventas", ventaService.findAll());
				modelAndView.addObject("clientes", userService.findAdmins());
			}
		}
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/venta/index");
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") Venta venta) {
		User cliente = userService.findUserByUsername(venta.getCliente().getUsername());
		if (cliente != null) {
			ventaService.add(venta);
		}
		return new RedirectView("/venta/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/venta/new");
		model.addObject("clientes", userService.findUsers());
		model.addObject("venta", new Venta());
		return model;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/venta/update");
		modelAndView.addObject("venta", ventaService.findById(id).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("venta") Venta venta) {
		ventaService.add(venta);
		return new RedirectView("/venta/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		ventaService.delete(id);
		return new RedirectView("/venta/index");
	}

}
