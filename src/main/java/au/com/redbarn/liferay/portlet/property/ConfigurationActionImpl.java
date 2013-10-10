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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * A {@link ConfigurationAction} for custom configuration for the portlet.
 * 
 * @author peter
 *
 */
public class ConfigurationActionImpl implements ConfigurationAction {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigurationActionImpl.class);

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.ConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("Hit processAction() in config action.");
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

		// Read, validate, and then set form parameters as portlet preferences
		String message = actionRequest.getParameter(Constants.MESSAGE_PARAM);
		prefs.setValue(Constants.MESSAGE_PARAM, message);

		prefs.store();

		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.ConfigurationAction#render(javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		String message = renderRequest.getPreferences().getValue(Constants.MESSAGE_PARAM, Constants.DEFAULT_MESSAGE);
		renderRequest.setAttribute(Constants.MESSAGE_PARAM, message);
		return "/configuration.jsp";
	}
}
