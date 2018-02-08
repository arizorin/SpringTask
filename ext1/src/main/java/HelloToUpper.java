package ru.mirea.springtask.ext1.main.java;

import org.springframework.beans.factory.InitializingBean;
import ru.mirea.springtask.base.main.java.BaseHello;

public class HelloToUpper extends BaseHello implements InitializingBean {

    private String description;




    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setText(super.getText().toUpperCase());
}
}
