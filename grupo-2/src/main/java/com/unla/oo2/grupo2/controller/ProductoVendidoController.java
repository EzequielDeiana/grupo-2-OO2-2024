package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo.serviceInterfaces.IPedidoCompra;
import com.unla.oo2.grupo.serviceInterfaces.IProductoVendido;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
@RequestMapping("/productovendido")
public class ProductoVendidoController {

	private IProductoVendido productovendidoService;

	public ProductoVendidoController(IProductoVendido productovendidoService) {
		this.productovendidoService = productovendidoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/productovendido/index").addObject("productovendido", productovendidoService.getAll());
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/productovendido/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/productovendido/new");
		model.addObject("productovendido", new PedidoCompra());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("productovendido") ProductoVendido productovendido) {
		productovendidoService.insertOrUpdate(productovendido);
		return new RedirectView("/pedidocompra/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") Long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/productovendido/update");
		modelAndView.addObject("productovendido", productovendidoService.findById(id).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("pedidocompra") ProductoVendido productovendido) {
		productovendidoService.insertOrUpdate(productovendido);
		return new RedirectView("/productovendido/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productovendidoService.remove(id);
		return new RedirectView("/pedidocompra/index");
	}

}
