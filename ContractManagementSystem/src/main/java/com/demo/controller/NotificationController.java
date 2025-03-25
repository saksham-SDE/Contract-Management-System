package com.demo.controller;

import com.demo.DTO.Notification;
import com.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService service;
    @Autowired
    private MessageSource messageSource;
    //Get Notifications
    @GetMapping
    public List<Notification> getAllNotifications(){
        return service.getAllNotification();
    }
    //Get Notification
    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable int id){
        return service.getNotificationById(id);
    }
    //Add Notification
    @PostMapping
    public ResponseEntity<?> addNotification(@RequestBody Notification notification,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.addNotification(notification);
        String message=messageSource.getMessage("notification.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("notification", notification);
        return ResponseEntity.ok(response);
    }
    //Delete Notification
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteNotificationById(id);
        String message=messageSource.getMessage("notification.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Notifications Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNotification(@PathVariable int id, @RequestBody Notification notification,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.updateNotificationById(id, notification);
        String message=messageSource.getMessage("notification.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("notification", notification);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteNotifications(List<Integer> notifications,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteNotificationByIDs(notifications);
        String message=messageSource.getMessage("notification.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

}