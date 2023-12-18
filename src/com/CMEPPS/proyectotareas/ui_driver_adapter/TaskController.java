package com.CMEPPS.proyectotareas.ui_driver_adapter;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping("/addTarea")
	public String showFormAddTaskPage(ModelMap model) {
		return "add-task";
	}

	@GetMapping("/seleccion-semana")
	public String showSeleccionTareas() {
		return "seleccion-semana";
	}

	@PostMapping("/seleccion-semana")
	public String seleccionSemana(@RequestParam int semana, @RequestParam int mes, @RequestParam int anio,
			ModelMap model) {

		if (anio < 2023) {
			return "seleccion-semana";
		}
		System.out.println("Semana: " + semana);
		System.out.println("Mes: " + mes);
		System.out.println("Año: " + anio);
		return "redirect:/planificar-tareas?anio=" + anio + "&mes=" + mes + "&semana=" + semana;
	}

	@GetMapping("/planificar-tareas")
	public String showPlanificarTareas(ModelMap model, @RequestParam int anio, @RequestParam int mes,
	        @RequestParam int semana) {

	    int TiempoMax = 10; // Modificar para elegir el tiempo máximo por semana
	    List<Task> tareasSemana = taskService.TareasDeLaSemana(semana, mes, anio);
	    Task taux;
	    
	    // Calcular tiempo restante
	    for (int i = 0; i < tareasSemana.size(); i++) {
	        taux = tareasSemana.get(i);
	        TiempoMax -= taux.getTiempoEstimado();
	    }

	    model.put("tmax", TiempoMax);
	    model.put("anio", anio);
	    model.put("mes", mes);
	    model.put("semana", semana);

	    // Filtrar tareas sin planificar
	    List<Task> tasks = taskService.TareasSinPlanificar();
	    List<Task> tasksFiltradas = new ArrayList<>();

	    // Seleccionar tareas que no excedan el tiempo máximo restante
	    for (int i = 0; i < tasks.size(); i++) {
	        taux = tasks.get(i);
	        if (taux.getTiempoEstimado() <= TiempoMax) {
	            tasksFiltradas.add(taux);
	        }
	    }

	    model.put("tasks", tasksFiltradas);

	    return "planificar-tareas";
	}


	@GetMapping("/")
	public String showWelcomePage(ModelMap model) {
		return "welcome";
	}

	@GetMapping("/list-todos")
	public String showTodos(ModelMap model) {
		Long idUser = (long) 1; // Ajusta esto según tus necesidades
		List<Task> tasks = taskService.listarTareas(idUser);
		model.put("tasks", tasks);
		return "list-todos";
	}

	@GetMapping("/list-completadas")
	public String showCompletadas(ModelMap model) {
		Long idUser = (long) 1; // Ajusta esto según tus necesidades
		List<Task> tasks = taskService.listarCompletadas(idUser);
		model.put("tasks", tasks);
		return "list-completadas";
	}

	@GetMapping(value = "/actualizar")
	public String ShowActualizaTarea(@RequestParam Long id, ModelMap model) {
		Task tarea = taskService.getTask(id);
		model.put("tarea", tarea);
		taskService.borrar(id);
		return "editar-tarea";
	}

	@GetMapping(value = "/delete-task")
	public String deleteTask(@RequestParam long id) {
		taskService.borrar(id);
		return "redirect:/list-todos";
	}

	@GetMapping(value = "/complete-task")
	public String completeTask(@RequestParam long id) {
		Task tarea = taskService.getTask(id);
		tarea.setCompletada(true);
		taskService.actualizarTask(tarea);
		return "redirect:/list-todos";
	}
	
	@GetMapping(value = "/cancela-completado")
	public String CancelcompleteTask(@RequestParam long id) {
		Task tarea = taskService.getTask(id);
		tarea.setCompletada(false);
		taskService.actualizarTask(tarea);
		return "redirect:/list-completadas";
	}
	
	@GetMapping(value = "/planificar-task")
	public String PlanificarTask(@RequestParam long id, @RequestParam int semana, @RequestParam int mes, @RequestParam int anio) {
		Task tarea = taskService.getTask(id);
		tarea.setSemana(semana);
		tarea.setMes(mes);
		tarea.setAnio(anio);
		taskService.actualizarTask(tarea);
		return "redirect:/planificar-tareas?anio=" + anio + "&mes=" + mes + "&semana=" + semana;
	}
	
	@GetMapping(value = "/ver-semana")
	public String VerSemana(@RequestParam int semana, @RequestParam int mes, @RequestParam int anio, ModelMap model) {
		model.put("anio", anio);
		model.put("mes", mes);
		model.put("semana", semana);
		
		System.out.println(semana+"/"+mes+"/"+anio);

		List<Task> tasks = taskService.TareasDeLaSemana(semana,mes,anio);
		model.put("tasks", tasks);
		
		return "ver-semana";
	}
	
	@GetMapping(value = "/cancela-tarea")
	public String CancelaTarea(@RequestParam long id, @RequestParam int semana, @RequestParam int mes, @RequestParam int anio) {
		Task tarea = taskService.getTask(id);
		tarea.setSemana(0);
		tarea.setMes(0);
		tarea.setAnio(0);
		taskService.actualizarTask(tarea);
		return "redirect:/ver-semana?anio=" + anio + "&mes=" + mes + "&semana=" + semana;
	}

	@PostMapping("/add-task")
	public String agregarTarea(@RequestParam String descripcion, @RequestParam String nombre,
			@RequestParam float tiempoEstimado, @RequestParam int prioridad) {
		// Puedes agregar otros parámetros según tus necesidades

		// Guarda la tarea en la base de datos
		taskService.guardarTarea(nombre, descripcion, tiempoEstimado, prioridad, 1L, false, 0, 0, 0);

		// Redirige a la página de lista de tareas u otra página según tus necesidades
		return "redirect:/list-todos";
	}

	@PostMapping("/actualizar")
	public String actualizarTarea(@ModelAttribute("tarea") Task tarea) {
		Task tareaExistente = new Task(tarea.getId(), tarea.getNombre(), tarea.getDescripcion(),
				tarea.getTiempoEstimado(), tarea.getPrioridad(), 1L, tarea.getCompletada(), tarea.getSemana(),
				tarea.getMes(), tarea.getAnio());
		// Actualizar la tarea existente con los nuevos valores
		taskService.actualizarTask(tareaExistente);

		// Redirigir a la página de lista de tareas o a otra página según sea necesario
		return "redirect:/list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

}
