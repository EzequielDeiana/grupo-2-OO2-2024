package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo.serviceInterfaces.ICompraServices;
import com.unla.oo2.grupo.serviceInterfaces.IPedidoCompra;
import com.unla.oo2.grupo.serviceInterfaces.IProducto;
import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.service.PedidoCompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {

	private ICompraServices compraService;
	private PedidoCompraService pedidoCompra;
	private IProducto productoService;

	public CompraController(ICompraServices compraService, PedidoCompraService pedidoCompra, IProducto productoService) {
		this.compraService = compraService;
		this.pedidoCompra = pedidoCompra;
		this.productoService = productoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("compra/index");
				modelAndView.addObject("compras", compraService.getAll());
			
			return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/compra/new");
		model.addObject("pedidosDeCompra", pedidoCompra.getAll());
		model.addObject("compra", new Compra());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("compra") Compra compra) {
		compraService.insertOrUpdate(compra);
		return new RedirectView("/compra/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/compra/update");
		modelAndView.addObject("compra", compraService.findById(id).get());
		return modelAndView;
	}
/*
	@GetMapping("/{name}")
	public ModelAndView get(@PathVariable("name") String name) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/compra/update");
		modelAndView.addObject("compra", compraService.findByName(name).get());
		return modelAndView;
	}
	*/
	
	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("compra") Compra compra) {
		compraService.insertOrUpdate(compra);
		return new RedirectView("/compra/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		compraService.remove(id);
		return new RedirectView("/compra/index");
	}

}
