package ru.mirea.springtask.base.main.java;
import org.springframework.beans.factory.InitializingBean;

public class BaseHello implements InitializingBean {
    private static String text;
    private String description;


    public String getText() {
        return text;
    }


    public void setText(String text){
    this.text = text;
    }

    public String getDescription() { return  description; }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.text = "Good Day";

    }
}
