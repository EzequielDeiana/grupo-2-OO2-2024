package com.unla.oo2.grupo2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.dtos.CompraDTO;
import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.service.PedidoCompraService;
import com.unla.oo2.grupo2.serviceInterfaces.ICompraService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/compra")
public class CompraController {

	private ICompraService compraService;
	private PedidoCompraService pedidoCompra;
	private ModelMapper modelMapper = new ModelMapper();

	public CompraController(ICompraService compraService, PedidoCompraService pedidoCompra) {
		this.compraService = compraService;
		this.pedidoCompra = pedidoCompra;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.COMPRA_INDEX);
		modelAndView.addObject("compras", compraService.findAll());

		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(RouteHelper.INDEX);
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView(RouteHelper.COMPRA_NEW);
		model.addObject("pedidosDeCompra", pedidoCompra.findAll());
		model.addObject("compra", new CompraDTO());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("compra") CompraDTO compraDTO) {
		compraService.add(modelMapper.map(compraDTO, Compra.class));
		return new RedirectView(RouteHelper.COMPRA_INDEX);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.COMPRA_UPDATE);
		CompraDTO compraDTO = modelMapper.map(compraService.findById(id).get(), CompraDTO.class);
		modelAndView.addObject("compra", compraDTO);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("compra") CompraDTO compraDTO) {
		compraService.add(modelMapper.map(compraDTO, Compra.class));
		return new RedirectView(RouteHelper.COMPRA_INDEX);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		compraService.delete(id);
		return new RedirectView(RouteHelper.COMPRA_INDEX);
	}

}
