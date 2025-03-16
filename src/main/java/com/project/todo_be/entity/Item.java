package com.project.todo_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private boolean isCompleted;

    public String getText() {
        return text;
    }

    public  boolean getIsCompleted() {
        return  isCompleted;
    }

    public void setText(String t) {
        text = t;
    }

    public  void setIsCompleted(boolean i) {
        isCompleted = i;
    }
}
