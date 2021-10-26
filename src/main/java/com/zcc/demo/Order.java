package com.zcc.demo;

import java.util.Date;

/**
 * @author zcc
 * @ClassName Order
 * @description 预定请求的实体类
 * @date 2021/10/26 19:32
 * @Version 1.0
 */

public class Order {

    //工作时间
    private String workingTime;
    //发起请求时间
    private Date requestTime;
    //员工id
    private String employeeId;
    //会议开始时间
    private Date meetingStartTime;
    //会议市场
    private int durationTime;

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getMeetingStartTime() {
        return meetingStartTime;
    }

    public void setMeetingStartTime(Date meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
