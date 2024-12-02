package com.microecom.notification_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.notification_service.Models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{


    
}
