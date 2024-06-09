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
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	private IProducto productoService;

	public ProductoController(IProducto productoService) {
		this.productoService = productoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.PRODUCTO_INDEX);
		modelAndView.addObject("productos", productoService.findProductosDisponibles());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectHome() {
		return new RedirectView(RouteHelper.INDEX);
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") Producto producto) {
		productoService.add(producto);
		return new RedirectView("/producto/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/producto/new");
		model.addObject("producto", new Producto());
		return model;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/producto/update");
		modelAndView.addObject("producto", productoService.findById(id).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("producto") Producto producto) {
		productoService.add(producto);
		return new RedirectView("/producto/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productoService.delete(id);
		return new RedirectView("/producto/index");
	}

	@GetMapping("/all")
	public ModelAndView prueba() {
		ModelAndView model = new ModelAndView("/producto/new");
		productoService.add(new Producto("1", "1", "1", 1, 1, true));
		return model;
	}

}
