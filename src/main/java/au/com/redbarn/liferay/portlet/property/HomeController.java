/*
 * This file is part of portlet-property-demo.
 *
 * portlet-property-demo is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * portlet-property-demo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * portlet-property-demo. If not, see <http://www.gnu.org/licenses/>.
 */
package au.com.redbarn.liferay.portlet.property;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.RenderRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Handles requests for the view mode.
 */
@Controller
@RequestMapping("VIEW")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RenderMapping
	public String home(RenderRequest request, Locale locale, Model model) {

		log.info("Welcome home! the client locale is "+ locale.toString());

		model.addAttribute(Constants.MESSAGE_PARAM, request.getPreferences().getValue(Constants.MESSAGE_PARAM, Constants.DEFAULT_MESSAGE));

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
}
