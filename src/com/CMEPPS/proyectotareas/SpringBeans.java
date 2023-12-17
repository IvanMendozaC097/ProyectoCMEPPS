package com.CMEPPS.proyectotareas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.CMEPPS.proyectotareas.core.driven_ports.TaskRepository;
import com.CMEPPS.proyectotareas.core.driven_ports.UserRepository;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskService;
import com.CMEPPS.proyectotareas.core.driver_ports.TaskServiceImpl;
import com.CMEPPS.proyectotareas.core.driver_ports.UserService;
import com.CMEPPS.proyectotareas.core.driver_ports.UserServiceImpl;

@Configuration
public class SpringBeans {
        @Bean
        TaskService taskService(final TaskRepository taskRepository) {
            return new TaskServiceImpl(taskRepository);
        }
        @Bean
        UserService userService(final UserRepository userRepository) {
            return new UserServiceImpl(userRepository);

   }    
}
