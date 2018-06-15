package com.company;

import java.util.Date;

public class Experience {
    public String title;
    public String placeOfWork;
    public String startDate;
    public String endDate;
    public String duty1, duty2;

    public Experience(String title, String placeOfWork, String startDate,String endDate, String duty1, String duty2) {
        this.title = title;
        this.placeOfWork = placeOfWork;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duty1 = duty1;
        this.duty2 = duty2;
    }
}
