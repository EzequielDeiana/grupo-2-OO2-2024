package com.unla.oo2.grupo2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.dtos.ProductoVendidoDTO;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoVendidoService;

@Controller
@RequestMapping("/productovendido")
public class ProductoVendidoController {

	private IProductoVendidoService productovendidoService;
	private ModelMapper modelMapper = new ModelMapper();

	public ProductoVendidoController(IProductoVendidoService productovendidoService, IProductoService productoService) {
		this.productovendidoService = productovendidoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/productovendido/index");
		modelAndView.addObject("productovendido", productovendidoService.findAll());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView("/productovendido/index");
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("productovendido") ProductoVendidoDTO productoVendidoDTO) {
		productovendidoService.add(modelMapper.map(productoVendidoDTO, ProductoVendido.class));
		return new RedirectView("/productovendido/index");
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView("/productovendido/new");
		model.addObject("productovendido", new ProductoVendidoDTO());
		return model;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/productovendido/update");
		ProductoVendidoDTO productoVendidoDTO = modelMapper.map(productovendidoService.findById(id).get(), ProductoVendidoDTO.class);
		modelAndView.addObject("productovendido",productoVendidoDTO);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("productovendido") ProductoVendidoDTO productoVendidoDTO) {
		productovendidoService.add(modelMapper.map(productoVendidoDTO, ProductoVendido.class));
		return new RedirectView("/productovendido/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productovendidoService.delete(id);
		return new RedirectView("/productovendido/index");
	}

}
