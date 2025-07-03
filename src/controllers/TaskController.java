package controllers;
import com.google.gson.*;
import models.TaskModel;
import services.TaskService;
import utils.LocalDateTimeAdapter;
import utils.ResMsg;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class TaskController {

    private final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    TaskService service = new TaskService();

    public String create (String id, String description) {
        return GSON.toJson(service.createNewTask(id, description));
    }

    public String find (String id) {
        return GSON.toJson(service.findExistingTask(id));
    }

    public String list () {
        return GSON.toJson(service.getList());
    }

    public String listByStatus (String whichStatus) {
        return GSON.toJson(service.getListByStatus(whichStatus));
    }

    public String update (String id, String description, String status) {
        return GSON.toJson(service.update(id, description, status));
    }

    public String delete (String id) {
        return GSON.toJson(service.delete(id));
    }
}
