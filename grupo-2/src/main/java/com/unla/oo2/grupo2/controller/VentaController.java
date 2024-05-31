package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo.serviceInterfaces.IProductoVendido;
import com.unla.oo2.grupo.serviceInterfaces.IVenta;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private IVenta venteService;

	public VentaController(IVenta venteService) {
		this.venteService = venteService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/venta/index").addObject("venta", venteService.getAll());
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/venta/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/venta/new");
		model.addObject("venta", new PedidoCompra());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") Venta venta) {
		venteService.insertOrUpdate(venta);
		return new RedirectView("/venta/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") Long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/venta/update");
		modelAndView.addObject("venta", venteService.findById(id).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("pedidocompra") Venta venta) {
		venteService.insertOrUpdate(venta);
		return new RedirectView("/venta/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		venteService.remove(id);
		return new RedirectView("/venta/index");
	}

}
