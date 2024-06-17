package com.unla.oo2.grupo2.controller;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.dtos.ProductoDTO;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.helper.UserUtil;
import com.unla.oo2.grupo2.serviceInterfaces.IPedidoCompraService;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;
import com.unla.oo2.grupo2.serviceInterfaces.IVentaService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	private IProductoService productoService;
	private IPedidoCompraService pedidoCompraService;
	private IVentaService ventaService;
	private ModelMapper modelMapper = new ModelMapper();

	public ProductoController(IProductoService productoService, IPedidoCompraService pedidoCompraService,
			IVentaService ventaService) {
		this.productoService = productoService;
		this.pedidoCompraService = pedidoCompraService;
		this.ventaService = ventaService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.PRODUCTO_INDEX);

		boolean isAdmin = UserUtil.isRol(UserUtil.ROLE_ADMIN);

		List<Producto> productos;
		if (isAdmin) {
			productos = productoService.findProductos();

		} else {
			productos = productoService.findProductosDisponibles();
		}

		modelAndView.addObject("productos", productos);

		modelAndView.addObject("isAdmin", UserUtil.isRol(UserUtil.ROLE_ADMIN));

		try {
			modelAndView.addObject("productosMasVendidos", ventaService.productoMasVendido());
			modelAndView.addObject("productosMenosVendidos", ventaService.productoMenosVendido());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectHome() {
		return new RedirectView(RouteHelper.INDEX);
	}

	@GetMapping("/new")
	public ModelAndView createForm() {
		ModelAndView model = new ModelAndView(RouteHelper.PRODUCTO_NEW);
		model.addObject("producto", new ProductoDTO());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") ProductoDTO productoDTO) {
		productoService.add(modelMapper.map(productoDTO, Producto.class));
		return new RedirectView(RouteHelper.PRODUCTO_INDEX);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.PRODUCTO_UPDATE);
		ProductoDTO productoDTO = modelMapper.map(productoService.findById(id).get(), ProductoDTO.class);
		modelAndView.addObject("producto", productoDTO);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("producto") ProductoDTO productoDTO) {
		productoService.add(modelMapper.map(productoDTO, Producto.class));
		return new RedirectView(RouteHelper.PRODUCTO_INDEX);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productoService.delete(id);
		return new RedirectView(RouteHelper.PRODUCTO_INDEX);
	}

	@GetMapping("/all")
	public ModelAndView prueba() {
		ModelAndView model = new ModelAndView(RouteHelper.PRODUCTO_NEW);
		productoService.add(new Producto("1", "1", "1", 1, 1, true, "1"));
		return model;
	}

	@PostMapping("/comprar/{id}")
	public ModelAndView comprar(@PathVariable("id") int id, @Param("cantidadSolicitada") int cantidadSolicitada) {
		ModelAndView modelAndView = index();
		;
		User user = null;
		Producto producto = null;
		List<PedidoCompra> pedidoCompra = null;
		boolean existePedidoCompraDiaria = false;

		try {
			producto = productoService.findById(id).orElseThrow(() -> new Exception("Producto no encontrado"));
			user = UserUtil.getUser();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (producto.getStockRestante() > 0 && producto.getStockRestante() >= cantidadSolicitada) {
			producto.setStockRestante(producto.getStockRestante() - cantidadSolicitada);
			productoService.add(producto);
			Venta nuevaVenta = new Venta(LocalDate.now(), user, cantidadSolicitada * producto.getPrecio(), producto,
					cantidadSolicitada);
			ventaService.add(nuevaVenta);

			if (producto.getStockRestante() < 5) {
				pedidoCompra = pedidoCompraService.findPedidoCompraNoComprado();
				int j = 0;

				while (j < pedidoCompra.size() && !existePedidoCompraDiaria) {
					if (pedidoCompra.get(j).getProducto().getId() == id) {
						existePedidoCompraDiaria = true;
					}
					j++;
				}

				if (!existePedidoCompraDiaria) {
					pedidoCompraService.add(new PedidoCompra(producto, LocalDate.now(), false, 0));
				}
			}
			
			modelAndView = index();
		} else {
			modelAndView = index();
			modelAndView.addObject("error", "Error: Cantidad solicitada es superior al Stock Restante");
		}
		
		return modelAndView;
	}
	
}