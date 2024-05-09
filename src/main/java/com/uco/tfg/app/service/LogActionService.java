package com.uco.tfg.app.service;

import com.uco.tfg.app.dto.LogActions;
import com.uco.tfg.app.model.LogAction;
import com.uco.tfg.app.repository.LogActionRepository;
import com.uco.tfg.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogActionService {

    private final LogActionRepository logActionRepository;
    private final UserService userService; // Inyectamos el servicio UserService


    @Autowired
    public LogActionService(LogActionRepository logActionRepository,UserService userService) {
        this.logActionRepository = logActionRepository;
        this.userService = userService;

    }
    
    public List<LogAction> getAllLogActions() {
        return logActionRepository.findAll();
    }

    public LogAction getLogActionById(Long id) {
        return logActionRepository.findById(id).orElse(null);
    }

    public LogAction createLogAction(LogAction logAction) {
    	
    	String description = "";
    	LogActions action = LogActions.valueOf(logAction.getActionName());
    	boolean samePerson = logAction.getUserId() == logAction.getSecondUserId() ? true : false;

    	switch (action) {
    	case ASSIGN_TASK:
    	        if (samePerson) {
    	            description = "se ha asignado la tarea";
    	        } else {
    	        	String secondaryName = userService.findById(logAction.getSecondUserId()).get().getFirstName();
    	        	logAction.setUser2name(secondaryName);
    	            description = "ha asignado la tarea";
    	        }
    	        break;
        case ASSIGN_ITINERARY:
        	if (samePerson) {
        		String secondaryName = userService.findById(logAction.getSecondUserId()).get().getFirstName();
        		logAction.setUser2name(secondaryName);
	            description = "se ha asignado el itinerario";
	        } else {
	            description = "ha asignado el itinerario";
	        }
            break;
        case TASK_DONE:
            description = "ha completado la tarea";
            break;
        case CREATE_SHOPPING_LIST:
            description = "ha creado la lista de la compra";
            break;
        case MODIFY_SHOPPING_LIST:
            description = "ha modificado la lista de la compra";
            break;
        case NEW_USER_IN_HOME:
            description = "se ha unido al hogar.";
            break;
        default:
        	description = "Acción no reconocida";
            break;
    }
    	
    	logAction.setDescription(description);

    	
        return logActionRepository.save(logAction);
    }

    public LogAction updateLogAction(Long id, LogAction logAction) {
        LogAction existingLogAction = logActionRepository.findById(id).orElse(null);
        if (existingLogAction != null) {
            // Actualiza las propiedades del LogAction existente con las nuevas propiedades proporcionadas
            existingLogAction.setHomeId(logAction.getHomeId());
            existingLogAction.setUserId(logAction.getUserId());
            existingLogAction.setActionName(logAction.getActionName());
            existingLogAction.setSecondUserId(logAction.getSecondUserId());
            existingLogAction.setActionDate(logAction.getActionDate());

            return logActionRepository.save(existingLogAction);
        } else {
            return null;
        }
    }

    public void deleteLogAction(Long id) {
        logActionRepository.deleteById(id);
    }

	public List<LogAction> getLogActionByHomeId(Long homeId) {
		return logActionRepository.getLogActionByHomeId(homeId);
	}
}
 