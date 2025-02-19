package org.fundaciobit.powertoys.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.back.controller.webdb.EntornController;
import org.fundaciobit.powertoys.back.form.webdb.EntornFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.EntornForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@MenuOption(labelCode = "versionsentorns.entorn.plural", order = 2, group = "ADMIN", addSeparatorBefore = false)
@Controller
@RequestMapping(value = EntornAdminController.CONTEXTWEB)
@SessionAttributes(types = { EntornForm.class, EntornFilterForm.class })
public class EntornAdminController extends EntornController {

  public static final String CONTEXTWEB = "/admin/entorn";

  @Override
  public String getTileForm() {
    return "entornFormAdmin";
  }

  @Override
  public String getTileList() {
    return "entornListAdmin";
  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request, EntornForm entornForm, Throwable __e) {
    if (__e == null) {
      // XYZ ZZZ
      return "redirect:" + AplicacioAdminController.CONTEXTWEB + "/list"; // getContextWeb()
    } else {
      return getTileForm();
    }
  }

}
