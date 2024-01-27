package com.uco.tfg.app.service;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.repository.AssignedTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignedTaskService {

    private final AssignedTaskRepository assignedTaskRepository;

    @Autowired
    public AssignedTaskService(AssignedTaskRepository assignedTaskRepository) {
        this.assignedTaskRepository = assignedTaskRepository;
    }

    public AssignedTask getAssignedTaskById(Long id) {
        Optional<AssignedTask> optionalAssignedTask = assignedTaskRepository.findById(id);
        return optionalAssignedTask.orElse(null);
    }

    public List<AssignedTask> getAllAssignedTasks() {
        return assignedTaskRepository.findAll();
    }

    public AssignedTask createAssignedTask(AssignedTask assignedTask) {
        // Puedes realizar validaciones o lógica adicional antes de guardar en la base de datos
        return assignedTaskRepository.save(assignedTask);
    }

    public AssignedTask updateAssignedTask(AssignedTask updatedAssignedTask) {
        Optional<AssignedTask> optionalAssignedTask = assignedTaskRepository.findById(updatedAssignedTask.getId());

        if (optionalAssignedTask.isPresent()) {
            AssignedTask existingAssignedTask = optionalAssignedTask.get();
            // Actualiza los campos necesarios con los valores proporcionados en updatedAssignedTask
            existingAssignedTask.setHomeId(updatedAssignedTask.getHomeId());
            existingAssignedTask.setUserId(updatedAssignedTask.getUserId());
            existingAssignedTask.setDate(updatedAssignedTask.getDate());
            existingAssignedTask.setDayOfWeek(updatedAssignedTask.getDayOfWeek());
            existingAssignedTask.setPriority(updatedAssignedTask.getPriority());
            existingAssignedTask.setDone(updatedAssignedTask.getDone());
            existingAssignedTask.setTask(updatedAssignedTask.getTask());

            // Puedes realizar validaciones o lógica adicional antes de guardar en la base de datos
            return assignedTaskRepository.save(existingAssignedTask);
        } else {
            // Manejar el caso en el que no se encuentra la tarea asignada con el ID proporcionado
            return null;
        }
    }

    public void deleteAssignedTask(Long id) {
        assignedTaskRepository.deleteById(id);
    }
}
