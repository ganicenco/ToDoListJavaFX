package com.example.todolistjavafx.Controller;

import com.example.todolistjavafx.datamodel.ToDoData;
import com.example.todolistjavafx.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePiker;

    public TodoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePiker.getValue();
        // return the item that was created. after creation, it is automatic selected
        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        ToDoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
