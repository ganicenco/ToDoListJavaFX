package com.example.todolistjavafx;

import com.example.todolistjavafx.datamodel.ToDoData;
import com.example.todolistjavafx.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
//        TodoItem item = new TodoItem("Mail birthday card", "buy a 31th birthday card for my sister",
//                LocalDate.of(2023, Month.FEBRUARY, 18));
//        TodoItem item1 = new TodoItem("Doctor", "go to doctor for the second opinion",
//                LocalDate.of(2023, Month.MAY, 18));
//        TodoItem item2 = new TodoItem("Cake", "Buy a 31th birthday cake for mom",
//                LocalDate.of(2023, Month.FEBRUARY, 17));
//        TodoItem item3 = new TodoItem("Clean", "Clean the garage",
//                LocalDate.of(2023, Month.JULY, 6));
//        TodoItem item4 = new TodoItem("Vet", "Take the dog to the doctor",
//                LocalDate.of(2022, Month.FEBRUARY, 18));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item);
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//
//        ToDoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(ToDoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        System.out.println("the selected item is: " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
    }
}