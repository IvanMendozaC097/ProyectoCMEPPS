package com.CMEPPS.proyectotareas.ui_driver_adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.proyectotareas.core.domain.User;
import com.CMEPPS.proyectotareas.core.driver_ports.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("list-user")
	public String showUser(ModelMap model) {
		Long idUser = (long) 1;
		List<User> users= userService.listarUsuario(idUser);
		model.put("users", users);
		return "list-user";
	}
	@GetMapping(value = "/editar-disponibilidad")
	public String showActualizarUser(@RequestParam Long id, ModelMap model) {
		User user = userService.getUser(id);
		model.put("user", user);
		return "editar-disponibilidad";
	}
	
	@PostMapping("/actualizar-disponibilidad")
	public String actualizarUser(@ModelAttribute("usuario") User usuario) {
		User userExistente = new User(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getDisponibilidad(), usuario.getNombre());
		userService.actualizarUser(userExistente);
		return "redirect:/list-user";
	}
	
}
