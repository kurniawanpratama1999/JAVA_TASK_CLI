package services;

import models.TaskModel;
import utils.ResMsg;

import java.util.*;

public class TaskService {
    private final LinkedHashMap<String, TaskModel> LIST_OF_TASK = new LinkedHashMap<>();

    public ResMsg<TaskModel> createNewTask (String id, String description) {
        if (LIST_OF_TASK.containsKey(id)) return ResMsg.fail("ID is already used");

        TaskModel taskModel = new TaskModel(id, description);

        LIST_OF_TASK.put(id, taskModel);
        return ResMsg.ok(description + " is added", taskModel);
    }

    public ResMsg<TaskModel> findExistingTask (String id) {
        TaskModel taskModel = LIST_OF_TASK.get(id);

        if (taskModel == null) return ResMsg.fail("ID " + id + " is not found");

        return ResMsg.ok("ID " + id + " is found", taskModel);
    }

    public ResMsg<Set<TaskModel>> getList () {
        Set<TaskModel> col = new LinkedHashSet<>(LIST_OF_TASK.values());
        return ResMsg.ok("Found List", col);
    }

    public ResMsg<Set<TaskModel>> getListByStatus (String whichStatus) {
        List<TaskModel> listByStatus = new ArrayList<>(LIST_OF_TASK.values().stream().filter(item -> item.getStatus().equalsIgnoreCase(whichStatus)).toList());
        Set<TaskModel> list = new LinkedHashSet<>(listByStatus);


        return ResMsg.ok("Found List", list);
    }

    public ResMsg<TaskModel> update (String id, String description, String status) {
        if (!LIST_OF_TASK.containsKey(id)) return ResMsg.fail("ID not found");

        TaskModel task = LIST_OF_TASK.get(id);

        if (description != null && !description.equalsIgnoreCase("null")) {
            task.setDescription(description);
        }

        if (status != null && !status.equalsIgnoreCase("null")) {
            task.setStatus(status);
        }

        return ResMsg.ok("ID " + id + " is updated", task);
    }

    public ResMsg<Set<TaskModel>> delete (String id) {
        if (!LIST_OF_TASK.containsKey(id)) return ResMsg.fail("ID not found");

        TaskModel taskModel = LIST_OF_TASK.get(id);
        LIST_OF_TASK.remove(id);
        Set<TaskModel> col = new LinkedHashSet<>(LIST_OF_TASK.values());

        return ResMsg.ok("ID " + id + " with description: " + taskModel.getDescription() + " is removed", col);
    }

 }
