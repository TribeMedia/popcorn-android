/*
 * This file is part of Popcorn Time.
 *
 * Popcorn Time is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Popcorn Time is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Popcorn Time. If not, see <http://www.gnu.org/licenses/>.
 */

package pct.droid.base.utils;

import android.content.res.Configuration;

import java.util.Locale;

import pct.droid.base.PopcornApplication;

public class LocaleUtils {

    public static String getCurrent() {
        return getLanguageCode(Locale.getDefault());
    }

    public static void setCurrent(Locale locale) {
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        PopcornApplication.getAppContext().getResources().updateConfiguration(config, PopcornApplication.getAppContext().getResources().getDisplayMetrics());
    }

    public static String getLanguageCode(Locale locale) {
        String languageCode = locale.getLanguage();
        if (!locale.getCountry().isEmpty()) {
            languageCode += "-" + locale.getCountry();
        }
        return languageCode;
    }

    public static Locale toLocale(String languageCode) {
        String[] language = languageCode.split("-");
        if (language.length > 1) {
            return new Locale(language[0], language[1]);
        }
        return new Locale(language[0]);
    }

}
