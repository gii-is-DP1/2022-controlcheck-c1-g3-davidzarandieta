package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

@Controller
public class RecoveryRoomController {
    @Autowired
    RecoveryRoomService recoveryRoomService;

    private static final String VIEWS_RECROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    
    @GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recovery_room", recoveryRoom);
        model.put("recovery_room_type", recoveryRoomService.getAllRecoveryRoomTypes());
		return VIEWS_RECROOM_CREATE_FORM;

        
    
    } 
    @PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, Map<String, Object> model) throws DuplicatedRoomNameException {
        
		if (result.hasErrors()) {
            model.put("recovery_room", recoveryRoom);
            model.put("recovery_room_type", recoveryRoomService.getAllRecoveryRoomTypes());
			return VIEWS_RECROOM_CREATE_FORM;
		}
		else {
			//creating owner, user, and authority
			this.recoveryRoomService.save(recoveryRoom);
			return "welcome";
		}
	}
    }