package com.hackathon.healthmap.service;

import com.hackathon.healthmap.model.MeditationLog;
import com.hackathon.healthmap.model.User;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MeditationApp {
    /**
     * This method deducts badges if the user is inactive for 7 days+
     * Also will send a reminder message to meditate every day
     * @param a
     */
    public void deductBadges(User a) {
        Date currentDate = new Date();
        List<MeditationLog> logs = a.getLogs();
        logs.add(new MeditationLog(currentDate));
        for (int i = 1; i<logs.size(); i++) {
            if (diffBetweenDates(logs.get(i).getStartDate(),logs.get(i-1).getEndDate())>7) {
                a.setBadges(a.getBadges()-1);
                //Tell user they have lost a badge
            }
            if(i==logs.size()-2) {
                if (diffBetweenDates(logs.get(i+1).getStartDate(),logs.get(i).getEndDate())>1) {
                    a.reminderMessage();
                }
            }
        }
    }
    public long diffBetweenDates(Date second, Date first) {
        long diffInMillies = Math.abs(second.getTime() - first.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }
}
