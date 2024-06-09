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
import com.unla.oo2.grupo2.entity.PedidoCompra;

@Controller
@RequestMapping("/pedidocompra")
public class PedidoCompraController {

	private IPedidoCompra pedidocompraService;

	public PedidoCompraController(IPedidoCompra pedidocompraService) {
		this.pedidocompraService = pedidocompraService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/pedidocompra/index");
		modelAndView.addObject("pedidos", pedidocompraService.findAll());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/pedidocompra/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/pedidocompra/new");
		model.addObject("pedidocompra", new PedidoCompra());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedidocompra") PedidoCompra pedidocompra) {
		pedidocompraService.add(pedidocompra);
		return new RedirectView("/pedidocompra/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/pedidocompra/update");
		modelAndView.addObject("pedidocompra", pedidocompraService.findById(id).get());
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("pedidocompra") PedidoCompra pedidocompra) {
		pedidocompraService.add(pedidocompra);
		return new RedirectView("/pedidocompra/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		pedidocompraService.delete(id);
		return new RedirectView("/pedidocompra/index");
	}

}
