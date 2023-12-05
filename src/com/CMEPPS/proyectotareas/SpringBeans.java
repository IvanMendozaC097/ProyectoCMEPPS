package com.CMEPPS.proyectotareas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.CMEPPS.proyectotareas.core.driven_ports.TaskRepository;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskService;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskServiceImpl;

@Configuration
public class SpringBeans {
        @Bean
        TaskService taskService(final TaskRepository taskRepository) {
            return new TaskServiceImpl(taskRepository);
}
}
