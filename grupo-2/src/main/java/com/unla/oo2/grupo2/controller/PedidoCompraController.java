package com.unla.oo2.grupo2.controller;

import java.time.LocalDate;

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
import com.unla.oo2.grupo2.dtos.PedidoCompraDTO;
import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.helper.DatosPruebaUtil;
import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.serviceInterfaces.ICompraService;
import com.unla.oo2.grupo2.serviceInterfaces.IPedidoCompraService;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/pedidocompra")
public class PedidoCompraController {

	private IPedidoCompraService pedidoCompraService;
	private ICompraService compraService;
	private IProductoService productoService;
	private ModelMapper modelMapper = new ModelMapper();

	public PedidoCompraController(IPedidoCompraService pedidoCompraService, ICompraService compraService,
			IProductoService productoService) {
		this.pedidoCompraService = pedidoCompraService;
		this.compraService = compraService;
		this.productoService = productoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.PEDIDOCOMPRA_INDEX);
		modelAndView.addObject("pedidosCompra", pedidoCompraService.findPedidoCompraNoComprado());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(RouteHelper.PEDIDOCOMPRA_INDEX);
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView(RouteHelper.PEDIDOCOMPRA_NEW);
		model.addObject("pedidocompra", new PedidoCompraDTO());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedidocompra") PedidoCompraDTO pedidoCompraDTO) {
		pedidoCompraService.add(modelMapper.map(pedidoCompraDTO, PedidoCompra.class));
		return new RedirectView(RouteHelper.PEDIDOCOMPRA_INDEX);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.PEDIDOCOMPRA_UPDATE);
		PedidoCompraDTO pedidoCompraDTO = modelMapper.map(pedidoCompraService.findById(id).get(),
				PedidoCompraDTO.class);
		modelAndView.addObject("pedidocompra", pedidoCompraDTO);

		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("pedidocompra") PedidoCompraDTO pedidoCompraDTO) {
		pedidoCompraService.add(modelMapper.map(pedidoCompraDTO, PedidoCompra.class));
		return new RedirectView(RouteHelper.PEDIDOCOMPRA_INDEX);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		pedidoCompraService.delete(id);
		return new RedirectView(RouteHelper.PEDIDOCOMPRA_INDEX);
	}

	@GetMapping("/newcompra/{id}")
	public ModelAndView createCompraForm(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(RouteHelper.PEDIDOCOMPRA_NEW);
		Compra compra = new Compra();
		compra.setPedidoCompra(pedidoCompraService.findById(id).get());
		modelAndView.addObject("compra", compra);
		modelAndView.addObject("proveedores", DatosPruebaUtil.proveedores);
		return modelAndView;
	}

	@PostMapping("/createcompra/{id}")
	public RedirectView createCompra(@PathVariable("id") int id, @ModelAttribute("compra") CompraDTO compraDTO) {
		Compra compra = modelMapper.map(compraDTO, Compra.class);
		compra.setPedidoCompra(pedidoCompraService.findById(id).get());
		System.out.println(compra.getPedidoCompra());
		compra.setFechaLanzamiento(LocalDate.now());
		compra.setFechaEntrega(LocalDate.now().plusDays(7));

		PedidoCompra pedidoCompra = compra.getPedidoCompra();
		Producto producto = pedidoCompra.getProducto();
		producto.setStockRestante(producto.getStockRestante() + compra.getCantidadComprada());
		productoService.add(producto);

		pedidoCompra.setComprado(true);
		pedidoCompraService.add(pedidoCompra);

		compraService.add(compra);
		return new RedirectView(RouteHelper.PEDIDOCOMPRA_INDEX);
	}

}
