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

/**
 * A class for shared parameters.
 * 
 * @author peter
 *
 */
public class Constants {
	
	/**
	 * The request parameter for storing the message.
	 */
	public static final String MESSAGE_PARAM = "message";

	/**
	 * A default message for {@link PortletPreferences.getValue()}.
	 */
	public static final String DEFAULT_MESSAGE = "Default message if there is an error.";
}
