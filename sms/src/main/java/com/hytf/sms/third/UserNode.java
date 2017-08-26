package com.hytf.sms.third;


import java.io.Serializable;
import java.math.BigDecimal;

public class UserNode implements Serializable{
	private static final long serialVersionUID = -8366709786147773738L;
	
	private String nick;
    private String gmt_created;
    private String mobile;
    private String email;
    private String ip_whitelist;
    private String api_version;
    private BigDecimal balance;
    private BigDecimal alarm_balance;
    private String emergency_contact;
    private String emergency_mobile;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(String gmt_created) {
        this.gmt_created = gmt_created;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp_whitelist() {
        return ip_whitelist;
    }

    public void setIp_whitelist(String ip_whitelist) {
        this.ip_whitelist = ip_whitelist;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAlarm_balance() {
        return alarm_balance;
    }

    public void setAlarm_balance(BigDecimal alarm_balance) {
        this.alarm_balance = alarm_balance;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getEmergency_mobile() {
        return emergency_mobile;
    }

    public void setEmergency_mobile(String emergency_mobile) {
        this.emergency_mobile = emergency_mobile;
    }

    @Override
    public String toString() {
        return "UserNode{" +
                "nick='" + nick + '\'' +
                ", gmt_created='" + gmt_created + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", ip_whitelist='" + ip_whitelist + '\'' +
                ", api_version='" + api_version + '\'' +
                ", balance=" + balance +
                ", alarm_balance=" + alarm_balance +
                ", emergency_contact='" + emergency_contact + '\'' +
                ", emergency_mobile='" + emergency_mobile + '\'' +
                '}';
    }
}
