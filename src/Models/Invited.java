/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author federicoponcedeleon
 */
public class Invited {
    private String userId,
           meetingId;
    private boolean assisted;
    
    public Invited(String usuId, String meetingId, boolean assisted) {
        this.userId = usuId;
        this.meetingId = meetingId;
        this.assisted = assisted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public boolean assisted() {
        return assisted;
    }

    public void setAssisted(boolean assisted) {
        this.assisted = assisted;
    }
         
}
