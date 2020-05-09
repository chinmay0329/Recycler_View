package com.example.rough3adapter;

public class viewLeadsItem
{
    private String lead_cust_firstname;
    private String lead_cust_lastname;
    private String lead_cust_email;
    private String lead_cust_mobile;

//    public viewLeadsItem(String lead_cust_firstname, String lead_cust_lastname, String lead_cust_email, String lead_cust_mobile) {
//        this.lead_cust_firstname = lead_cust_firstname;
//        this.lead_cust_lastname = lead_cust_lastname;
//        this.lead_cust_email = lead_cust_email;
//        this.lead_cust_mobile = lead_cust_mobile;
//    }


    public viewLeadsItem() {
        this.lead_cust_firstname = this.lead_cust_firstname;
        this.lead_cust_lastname = this.lead_cust_lastname;
        this.lead_cust_email = this.lead_cust_email;
        this.lead_cust_mobile = this.lead_cust_mobile;
    }

    public String getLead_cust_firstname() {
        return lead_cust_firstname;
    }

    public void setLead_cust_firstname(String lead_cust_firstname) {
        this.lead_cust_firstname = lead_cust_firstname;
    }

    public String getLead_cust_lastname() {
        return lead_cust_lastname;
    }

    public void setLead_cust_lastname(String lead_cust_lastname) {
        this.lead_cust_lastname = lead_cust_lastname;
    }

    public String getLead_cust_email() {
        return lead_cust_email;
    }

    public void setLead_cust_email(String lead_cust_email) {
        this.lead_cust_email = lead_cust_email;
    }

    public String getLead_cust_mobile() {
        return lead_cust_mobile;
    }

    public void setLead_cust_mobile(String lead_cust_mobile) {
        this.lead_cust_mobile = lead_cust_mobile;
    }
}
