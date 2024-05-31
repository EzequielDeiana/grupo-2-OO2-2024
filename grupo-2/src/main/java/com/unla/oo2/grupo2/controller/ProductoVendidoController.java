package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo.serviceInterfaces.IProducto;
import com.unla.oo2.grupo.serviceInterfaces.IProductoVendido;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
@RequestMapping("/productovendido")
public class ProductoVendidoController {

	private IProductoVendido productovendidoService;

	public ProductoVendidoController(IProductoVendido productovendidoService, IProducto productoService) {
		this.productovendidoService = productovendidoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/productovendido/index");
		modelAndView.addObject("productovendido", productovendidoService.getAll());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/productovendido/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/productovendido/new");
		model.addObject("productovendido", new ProductoVendido());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("productovendido") ProductoVendido productovendido) {
		productovendidoService.agregar(productovendido);
		return new RedirectView("/productovendido/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/productovendido/update");
		modelAndView.addObject("productovendido", productovendidoService.getById(id));
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("productovendido") ProductoVendido productovendido) {
		productovendidoService.agregar(productovendido);
		return new RedirectView("/productovendido/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productovendidoService.delete(id);
		return new RedirectView("/productovendido/index");
	}
	


}
