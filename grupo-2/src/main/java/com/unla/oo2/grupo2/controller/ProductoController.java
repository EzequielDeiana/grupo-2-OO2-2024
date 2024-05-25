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
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	private IProducto productoService;

	public ProductoController(IProducto productoService) {
		this.productoService = productoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/producto/index").addObject("producto", productoService.getAll());
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/producto/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/producto/new");
		model.addObject("pedidocompra", new PedidoCompra());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") Producto producto) {
		productoService.insertOrUpdate(producto);
		return new RedirectView("/producto/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") Long id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/producto/update");
		modelAndView.addObject("producto", productoService.findById(id).get());
		return modelAndView;
	}

	@GetMapping("/{name}")
	public ModelAndView get(@PathVariable("name") String name) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/producto/update");
		modelAndView.addObject("producto", productoService.findByName(name).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("producto") Producto producto) {
		productoService.insertOrUpdate(producto);
		return new RedirectView("/producto/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productoService.remove(id);
		return new RedirectView("/producto/index");
	}

}
