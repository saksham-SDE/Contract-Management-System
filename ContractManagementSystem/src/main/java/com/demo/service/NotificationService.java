package com.demo.service;

import com.demo.DTO.Notification;
import com.demo.repository.NotificationRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;
    //Retrieves all notifications form the database
    public List<Notification> getAllNotification(){
        return notificationRepo.findAll();
    }
    //Retrieve notification by id from the database
    public Notification getNotificationById(int id){
        return notificationRepo.findById(id).orElse(null);
    }
    //Add notification to the database
    public Notification addNotification(Notification notification){
        return notificationRepo.save(notification);
    }
    //Delete notification by id from the database
    public void deleteNotificationById(int id){
            notificationRepo.deleteById(id);
    }
    //Update notification details by id in database
    public Notification updateNotificationById(int id, Notification updateNotification){
        return notificationRepo.findById(id)
                .map(notification -> {
                    if(updateNotification.getNotification_status()!=null){
                        notification.setNotification_status(updateNotification.getNotification_status());
                    }
                    if(updateNotification.getNotification_type()!=null){
                        notification.setNotification_type(updateNotification.getNotification_type());
                    }
                    if(updateNotification.getN_description()!=null){
                        notification.setN_description(updateNotification.getN_description());
                    }
                    if(updateNotification.getN_released_date()!=null){
                        notification.setN_released_date(updateNotification.getN_released_date());
                    }
                    if(updateNotification.getN_expiring_date()!=null){
                        notification.setN_expiring_date(updateNotification.getN_expiring_date());
                    }
                    if(updateNotification.getN_title()!=null){
                        notification.setN_title(updateNotification.getN_title());
                    }
                    if(updateNotification.getFilePathURl()!=null){
                        notification.setFilePathURl(updateNotification.getFilePathURl());
                    }
                    return notificationRepo.save(notification);
                }).orElse(null);
    }
    public void deleteNotificationByIDs(List<Integer> notificationIDs){
        notificationRepo.deleteAllById(notificationIDs);
    }

}
