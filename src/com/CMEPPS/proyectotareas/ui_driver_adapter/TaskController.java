package com.CMEPPS.proyectotareas.ui_driver_adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @PostMapping("/add-task")
    public String agregarTarea(@RequestParam String descripcion, @RequestParam String nombre, @RequestParam float tiempoEstimado, @RequestParam int prioridad) {
        // Puedes agregar otros parámetros según tus necesidades

        // Guarda la tarea en la base de datos
        taskService.guardarTarea(nombre, descripcion, tiempoEstimado, prioridad, 1L, false);

        // Redirige a la página de lista de tareas u otra página según tus necesidades
        return "redirect:/list-todos";
    }

    
   
}
