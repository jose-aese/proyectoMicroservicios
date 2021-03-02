package com.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.springboot.app.commons.models.entity.Producto;
import com.springboot.app.item.clientes.ProductoClienteRest;
import com.springboot.app.item.models.Item;

@Service("serviceFeing")
@Primary
public class ItemServiceFeing implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeing;
	
	
	@Override
	public List<Item> findAll() {
		return clienteFeing.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeing.detalle(id),cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeing.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeing.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeing.eliminar(id);
	}

}
