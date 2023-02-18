package com.Ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    NotificationService notifica;
    public UserService(NotificationService notifica) {
        System.out.println("Ejecutando constructor GestorFacturas");
        this.notifica = notifica;
    }
}
