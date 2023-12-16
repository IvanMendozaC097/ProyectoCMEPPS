package com.CMEPPS.proyectotareas.ui_driver_adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.domain.TaskDoesNotExistException;
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
    public String SemanaSeleccionada(@RequestParam int semana,@RequestParam int mes, @RequestParam int año) {
        return "seleccion-semana";
    }
    
    @GetMapping("/")
    public String showWelcomePage(ModelMap model) {
        return "welcome";
    }
    
    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
    	Long idUser = (long) 1;  // Ajusta esto según tus necesidades
        List<Task> tasks = taskService.listarTareas(idUser);
        model.put("tasks", tasks);
        return "list-todos";
    }
    
    @GetMapping("/list-completadas")
    public String showCompletadas(ModelMap model) {
    	Long idUser = (long) 1;  // Ajusta esto según tus necesidades
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
    
    
    @PostMapping("/add-task")
    public String agregarTarea(@RequestParam String descripcion, @RequestParam String nombre, @RequestParam float tiempoEstimado, @RequestParam int prioridad) {
        // Puedes agregar otros parámetros según tus necesidades

        // Guarda la tarea en la base de datos
        taskService.guardarTarea(nombre, descripcion, tiempoEstimado, prioridad, 1L, false);

        // Redirige a la página de lista de tareas u otra página según tus necesidades
        return "redirect:/list-todos";
    }
    
    @PostMapping("/actualizar")
    public String actualizarTarea(@ModelAttribute("tarea") Task tarea) {
            // Validar la tarea o manejar excepciones según sea necesario

            // Obtener la tarea existente
            Task tareaExistente = new Task(tarea.getId(),tarea.getNombre(), tarea.getDescripcion(), tarea.getTiempoEstimado(), tarea.getPrioridad(), 1L, tarea.getCompletada());

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
