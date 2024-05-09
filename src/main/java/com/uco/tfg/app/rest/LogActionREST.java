package com.uco.tfg.app.rest;

import com.uco.tfg.app.model.LogAction;
import com.uco.tfg.app.service.LogActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/logActions")
public class LogActionREST {

    private final LogActionService logActionService;

    @Autowired
    public LogActionREST(LogActionService logActionService) {
        this.logActionService = logActionService;
    }

    @GetMapping
    public ResponseEntity<List<LogAction>> getAllLogActions() {
        List<LogAction> logActions = logActionService.getAllLogActions();
        return ResponseEntity.ok(logActions);
    }

    @PostMapping
    public ResponseEntity<LogAction> createLogAction(@RequestBody LogAction logAction) {
        LogAction createdLogAction = logActionService.createLogAction(logAction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLogAction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogAction> getLogActionById(@PathVariable Long id) {
        LogAction logAction = logActionService.getLogActionById(id);
        if (logAction != null) {
            return ResponseEntity.ok(logAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogAction> updateLogAction(@PathVariable Long id, @RequestBody LogAction logAction) {
        LogAction updatedLogAction = logActionService.updateLogAction(id, logAction);
        if (updatedLogAction != null) {
            return ResponseEntity.ok(updatedLogAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogAction(@PathVariable Long id) {
        logActionService.deleteLogAction(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/home/{homeId}")
    public ResponseEntity<List<LogAction>> getLogActionByHomeId(@PathVariable Long homeId) {
    	List<LogAction> logActions = logActionService.getLogActionByHomeId(homeId);
        return ResponseEntity.ok(logActions);
    }
    
    
}
