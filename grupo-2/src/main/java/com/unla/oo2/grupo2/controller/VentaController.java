package com.unla.oo2.grupo2.controller;

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
import com.unla.oo2.grupo2.entity.Cliente;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.service.ClienteService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private IVenta venteService;
	private IProducto productoService;
	private ClienteService clienteService;

	public VentaController(IVenta venteService, IProducto productoService, ClienteService clienteService) {
		this.venteService = venteService;
		this.productoService = productoService;
		this.clienteService = clienteService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/venta/index");
		modelAndView.addObject("ventas", venteService.getAll());
		modelAndView.addObject("clientes", clienteService.getAll());
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
		model.addObject("venta", new Venta());
		return model;
	}

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
		return new ModelAndView("/venta/index");
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
