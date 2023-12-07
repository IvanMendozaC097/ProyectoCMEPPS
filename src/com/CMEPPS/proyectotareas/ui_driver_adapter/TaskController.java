package com.CMEPPS.proyectotareas.ui_driver_adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.domain.TaskDoesNotExistException;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskService;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks")
    public ResponseEntity getTask(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(taskService.getTask(id));
        } catch (TaskDoesNotExistException e){
            return ResponseEntity.ok("This task doesn´t exist!");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
    	Long idUser = (long) 1;  // Ajusta esto según tus necesidades
        List<Task> tasks = taskService.listarTareas(idUser);
        model.put("tasks", tasks);
        return "list-todos";
    }
    
   
}
