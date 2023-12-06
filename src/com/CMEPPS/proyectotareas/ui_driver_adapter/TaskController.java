package com.CMEPPS.proyectotareas.ui_driver_adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CMEPPS.proyectotareas.core.domain.TaskDoesNotExistException;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskService;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks")
    public ResponseEntity getTask(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(taskService.getTask(id));
        } catch (TaskDoesNotExistException e){
            return ResponseEntity.ok("We don't have this book!");
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
