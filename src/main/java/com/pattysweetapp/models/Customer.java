package com.pattysweetapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customers")
public class Customer {

    @Id
    private  String id;
    private  String lineID;
    private  String firstName;
    private  String lastName;
    private  String nickName;
    private  String mobileNo;
    private Date createdDate;
    private  Date updatedDate;
    public Customer(){
    }
    public  Customer(String lineID,String firstName,String lastName,String nickName, String mobileNo){
        this.lineID=lineID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.nickName=nickName;
        this.mobileNo=mobileNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public  String toString(){
        return  String.format("Customer [id=%s, firstname='%s', lastname='%s',nickname='%s',MobileNo='%s']",id,firstName,lastName,nickName,mobileNo);
    }
}
