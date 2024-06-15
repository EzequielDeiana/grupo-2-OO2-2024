package com.unla.oo2.grupo2.controller;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
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
		ModelAndView model = new ModelAndView("/producto/new");
		model.addObject("producto", new ProductoDTO());
		return model;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") ProductoDTO productoDTO) {
		productoService.add(modelMapper.map(productoDTO, Producto.class));
		return new RedirectView("/producto/index");
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/producto/update");
		ProductoDTO productoDTO = modelMapper.map(productoService.findById(id).get(), ProductoDTO.class);
		modelAndView.addObject("producto", productoDTO);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public RedirectView update(@ModelAttribute("producto") ProductoDTO productoDTO) {
		productoService.add(modelMapper.map(productoDTO, Producto.class));
		return new RedirectView("/producto/index");
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productoService.disable(id);
		return new RedirectView("/producto/index");
	}

	@GetMapping("/all")
	public ModelAndView prueba() {
		ModelAndView model = new ModelAndView("/producto/new");
		productoService.add(new Producto("1", "1", "1", 1, 1, true, "1"));
		return model;
	}

	@GetMapping("/comprar/{id}")
	public RedirectView comprar(@PathVariable("id") int id) {
		Producto producto = null;
		List<PedidoCompra> pedidoCompra = null;
		boolean existePedidoCompraDiaria = false;

		try {
			producto = productoService.findById(id).orElseThrow(() -> new Exception("Producto no encontrado"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (producto.getStockRestante() > 0) {
			producto.setStockRestante(producto.getStockRestante() - 1);
			productoService.add(producto);
		} else {
			return new RedirectView("/producto/index");
		}

		User user = null;
		try {
			user = UserUtil.getUser();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Venta nuevaVenta = new Venta(LocalDate.now(), user, 0, producto);
			ventaService.add(nuevaVenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new RedirectView("/error");
		}

		if (producto.getStockRestante() < 5) {
			pedidoCompra = pedidoCompraService.findAll();
			int j = 0;

			while (j < pedidoCompra.size() && !existePedidoCompraDiaria) {
				if (pedidoCompra.get(j).getProducto().getId() == id) {
					if (pedidoCompra.get(j).getFechaLanzamiento().isEqual(LocalDate.now())) {
						existePedidoCompraDiaria = true;
					}
				}
				j++;
			}

			if (!existePedidoCompraDiaria) {
				pedidoCompraService.add(new PedidoCompra(producto, LocalDate.now(), false, 0));
			}
		}

		return new RedirectView("/producto/index");
	}

}
