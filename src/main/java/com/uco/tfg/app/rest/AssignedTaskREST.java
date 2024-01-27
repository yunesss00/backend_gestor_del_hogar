package com.uco.tfg.app.rest;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.service.AssignedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/assignedTasks")
public class AssignedTaskREST {

	@Autowired
    private AssignedTaskService assignedTaskService;

    @GetMapping("/{id}")
    public AssignedTask getAssignedTaskById(@PathVariable Long id) {
        return assignedTaskService.getAssignedTaskById(id);
    }

    @GetMapping("/all")
    public List<AssignedTask> getAllAssignedTasks() {
        return assignedTaskService.getAllAssignedTasks();
    }

    @PostMapping("/create")
    public AssignedTask createAssignedTask(@RequestBody AssignedTask assignedTask) {
        return assignedTaskService.createAssignedTask(assignedTask);
    }

    @PutMapping("/update/{id}")
    public AssignedTask updateAssignedTask(@RequestBody AssignedTask assignedTask) {
        return assignedTaskService.updateAssignedTask(assignedTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignedTask(@PathVariable Long id) {
        assignedTaskService.deleteAssignedTask(id);
    }
}
