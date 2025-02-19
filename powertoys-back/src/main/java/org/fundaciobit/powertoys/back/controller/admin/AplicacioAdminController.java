package org.fundaciobit.powertoys.back.controller.admin;

import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.back.controller.all.VersionsAplicacioPublicController;
import org.fundaciobit.powertoys.back.form.webdb.AplicacioFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.AplicacioForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author jpou
 *
 */
@MenuOption(labelCode = "versionsaplicacions.aplicacio.plural", order = 1, group = "ADMIN", addSeparatorBefore = false)
@Controller
@RequestMapping(value = AplicacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { AplicacioForm.class, AplicacioFilterForm.class })
public class AplicacioAdminController extends VersionsAplicacioPublicController {

    public static final String CONTEXTWEB = "/admin/aplicacio";

    @Override
    public boolean isAdmin() {
        return true;
    }

}
