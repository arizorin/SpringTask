package ru.mirea.springtask.ext2.main.java;

import org.springframework.beans.factory.InitializingBean;
import ru.mirea.springtask.base.main.java.BaseHello;

public class DoubleHello extends BaseHello implements InitializingBean{
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       setText(getText()+getText());
    }
}
