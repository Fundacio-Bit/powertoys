package org.fundaciobit.powertoys.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.powertoys.back.controller.webdb.RepoCompilacioController;
import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioFilterForm;
import org.fundaciobit.powertoys.back.form.webdb.RepoCompilacioForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@MenuOption(labelCode = "repoCompilacio.repoCompilacio.plural", order = 3, group = "ADMIN", addSeparatorBefore = true)
@Controller
@RequestMapping(value = RepoCompilacioAdminController.CONTEXTWEB)
@SessionAttributes(types = { RepoCompilacioForm.class, RepoCompilacioFilterForm.class })
public class RepoCompilacioAdminController extends RepoCompilacioController {

  public static final String CONTEXTWEB = "/admin/repocompilacio";

  @Override
  public String getTileForm() {
    return "repoCompilacioFormAdmin";
  }

  @Override
  public String getTileList() {
    return "repoCompilacioListAdmin";
  }

  // @Override
  // public String getRedirectWhenModified(HttpServletRequest request, EntornForm entornForm, Throwable __e) {
  //   if (__e == null) {
  //     // XYZ ZZZ
  //     return "redirect:" + AplicacioAdminController.CONTEXTWEB + "/list"; // getContextWeb()
  //   } else {
  //     return getTileForm();
  //   }
  // }

}
