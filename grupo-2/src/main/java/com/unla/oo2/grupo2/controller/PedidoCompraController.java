package com.unla.oo2.grupo2.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.helper.DatosPruebaUtil;
import com.unla.oo2.grupo2.serviceInterfaces.ICompraService;
import com.unla.oo2.grupo2.serviceInterfaces.IPedidoCompraService;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;

@Controller
@RequestMapping("/pedidocompra")
public class PedidoCompraController {

	private IPedidoCompraService pedidoCompraService;
	private ICompraService compraService;
	private IProductoService productoService;

	public PedidoCompraController(IPedidoCompraService pedidoCompraService, ICompraService compraService, IProductoService productoService) {
		this.pedidoCompraService = pedidoCompraService;
		this.compraService = compraService;
		this.productoService = productoService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/pedidocompra/index");
		
		for (PedidoCompra pedidoCompra : pedidoCompraService.findAll()) {
			try {
				Compra compra = compraService.findById(pedidoCompra.getId()).get();
				pedidoCompra.setCantidadSolicitada(compra.getCantidadComprada());
				if(pedidoCompra.getCantidadSolicitada() > 0) {
					pedidoCompra.setComprado(true);
				}
				pedidoCompraService.add(pedidoCompra);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		modelAndView.addObject("pedidosCompra", pedidoCompraService.findAll());
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
		pedidoCompraService.add(pedidocompra);
		return new RedirectView("/pedidocompra/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/pedidocompra/update");
		modelAndView.addObject("pedidocompra", pedidoCompraService.findById(id).get());
		
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("pedidocompra") PedidoCompra pedidoCompra) {
		pedidoCompraService.add(pedidoCompra);
		return new RedirectView("/pedidocompra/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		pedidoCompraService.delete(id);
		return new RedirectView("/pedidocompra/index");
	}

	@GetMapping("/newcompra")
	public ModelAndView createCompraForm(@RequestParam("pedidoCompraId") int pedidoCompraId) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<Compra> existingCompra = compraService.findById(pedidoCompraId);
		modelAndView.addObject("proveedores", DatosPruebaUtil.proveedores);
		if (existingCompra.isPresent()) {
			modelAndView.setViewName("/pedidocompra/index");
			modelAndView.addObject("error", "Error: Compra ya realizada para el Pedido ID " + pedidoCompraId);
			modelAndView.addObject("pedidosCompra", pedidoCompraService.findAll());
		} else {
			modelAndView.setViewName("/pedidocompra/new");
			modelAndView.addObject("pedidoCompraId", pedidoCompraId);
			Compra compra = new Compra();
			compra.setPedidoCompra(pedidoCompraService.findById(pedidoCompraId).get());
			modelAndView.addObject("compra", compra);
		}

		return modelAndView;
	}

	@PostMapping("/createcompra")
	public RedirectView createCompra(@ModelAttribute("compra") Compra compra) {
		compra.setFechaLanzamiento(LocalDate.now());
		compra.setFechaEntrega(LocalDate.now().plusDays(7));
		compraService.add(compra);
		PedidoCompra pedidoCompra = pedidoCompraService.findById(compra.getId()).get();
		pedidoCompra.getProducto().setStockRestante(compra.getCantidadComprada() + pedidoCompra.getProducto().getStockRestante());
		productoService.add(pedidoCompra.getProducto());
		return new RedirectView("/pedidocompra/index");
	}

}
