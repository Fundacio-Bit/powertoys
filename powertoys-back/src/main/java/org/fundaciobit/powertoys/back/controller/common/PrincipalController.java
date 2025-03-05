package org.fundaciobit.powertoys.back.controller.common;

import org.fundaciobit.powertoys.commons.utils.Configuracio;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @autor jpou
 * 
 */
@Controller
public class PrincipalController {

	protected final Logger log = Logger.getLogger(getClass());

	@RequestMapping(value = "/common/principal.html")
	public ModelAndView principal(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Boolean initialized = (Boolean) session.getAttribute("inicialitzat");

		if (initialized == null) {
			HtmlUtils.saveMessageInfo(request, "MessageInfo : Benvingut a PowerToys");
			session.setAttribute("inicialitzat", true);
		}

		return new ModelAndView(new RedirectView("/public/index.html", true));
	}

	@RequestMapping(value = "/canviarIdioma/{idioma}", method = RequestMethod.GET)
	public ModelAndView canviarIdioma(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(name = "idioma") String idioma) throws Exception {
		org.fundaciobit.powertoys.back.utils.PowerToysSessionLocaleResolver.setLocaleManually(request, idioma);
		return new ModelAndView("homepublic");
	}

	@RequestMapping(value = "/canviarPipella", method = RequestMethod.GET)
	public ModelAndView canviarPipella(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return canviarPipella(request, response, null);
	}

	@RequestMapping(value = "/canviarPipella/{pipella}", method = RequestMethod.GET)
	public ModelAndView canviarPipella(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String pipella) throws Exception {

		if (pipella != null && pipella.trim().length() != 0) {
			if ("admin".equals(pipella)) {
				return new ModelAndView(new RedirectView("/admin/aplicacio/list/1", true));
			}

			if ("user".equals(pipella)) {
				return new ModelAndView("user");
			}

			if ("webdb".equals(pipella)) {
				return new ModelAndView("webdb");
			}

			if (Configuracio.isDesenvolupament() && "desenvolupament".equals(pipella)) {
				return new ModelAndView("desenvolupament");
			}

			log.error("S'ha accedit a canviarPipella amb un paràmetre desconegut: " + pipella);
		}

		return new ModelAndView("homepublic");
	}

}
