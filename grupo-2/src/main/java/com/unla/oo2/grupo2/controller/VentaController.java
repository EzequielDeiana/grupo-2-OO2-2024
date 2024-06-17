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

import com.unla.oo2.grupo2.dtos.VentaDTO;
import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.helper.UserUtil;
import com.unla.oo2.grupo2.service.UserService;
import com.unla.oo2.grupo2.serviceInterfaces.IVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private IVentaService ventaService;
	private UserService userService;
	private ModelMapper modelMapper = new ModelMapper();

	public VentaController(IVentaService ventaService, UserService userService) {
		this.ventaService = ventaService;
		this.userService = userService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.VENTA_INDEX);
		boolean hasRole = UserUtil.isRol(UserUtil.ROLE_ADMIN);

		if (!hasRole) {
			modelAndView.addObject("ventas", ventaService.findAllClient(UserUtil.getUser().getId()));
		} else {
			modelAndView.addObject("ventas", ventaService.findAll());
		}

		modelAndView.addObject("isAdmin", hasRole);
		return modelAndView;
	}

	@GetMapping("/historial")
	public ModelAndView historial() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.VENTA_INDEX);
		boolean hasRole = UserUtil.isRol(UserUtil.ROLE_ADMIN);

		if (!hasRole) {
			modelAndView.addObject("ventas", ventaService.findAllClient(UserUtil.getUser().getId()));
		} else {
			modelAndView.addObject("ventas", ventaService.findAll());
		}

		modelAndView.addObject("isAdmin", hasRole);
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(RouteHelper.VENTA_INDEX);
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") VentaDTO ventaDTO) {
		User cliente = userService.findUserByUsername(ventaDTO.getCliente().getUsername());
		if (cliente != null) {
			ventaService.add(modelMapper.map(ventaDTO, Venta.class));
		}
		return new RedirectView(RouteHelper.VENTA_INDEX);
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView(RouteHelper.VENTA_NEW);
		model.addObject("clientes", userService.findUsers());
		model.addObject("venta", new VentaDTO());
		return model;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.VENTA_UPDATE);
		VentaDTO ventaDTO = modelMapper.map(ventaService.findById(id).get(), VentaDTO.class);
		modelAndView.addObject("venta", ventaDTO);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("venta") VentaDTO ventaDTO) {
		ventaService.add(modelMapper.map(ventaDTO, Venta.class));
		return new RedirectView(RouteHelper.VENTA_INDEX);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		ventaService.delete(id);
		return new RedirectView(RouteHelper.VENTA_INDEX);
	}

}
