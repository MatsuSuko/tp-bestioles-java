package com.souvanny.demojpa.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CronService {

    // L'intervalle de temps sera lu depuis le fichier application.properties
    @Value("${cron.schedule}")
    private String cronSchedule;

    // Méthode qui sera exécutée selon l'expression cron définie
    @Scheduled(cron = "${cron.schedule}")
    public void printCurrentDate() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Current Date/Time: " + currentDate);
    }
}
