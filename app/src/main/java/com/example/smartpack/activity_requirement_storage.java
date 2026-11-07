
package com.example.smartpack;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class activity_requirement_storage {

    private static final String PREF_NAME = "TeacherRequirements";
    private static final String KEY_REQUIREMENTS = "requirements";

    public static boolean saveRequirement(
            Context context,
            String grade,
            String section,
            String title,
            String date,
            ArrayList<String> items) {

        SharedPreferences preferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );

        try {
            JSONArray requirements = getRequirements(context);

            JSONObject requirement = new JSONObject();
            requirement.put("grade", grade);
            requirement.put("section", section);
            requirement.put("title", title);
            requirement.put("date", date);

            JSONArray itemArray = new JSONArray();

            for (String item : items) {
                itemArray.put(item);
            }

            requirement.put("items", itemArray);

            requirements.put(requirement);

            return preferences.edit()
                    .putString(KEY_REQUIREMENTS, requirements.toString())
                    .commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONArray getRequirements(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );

        String savedData = preferences.getString(KEY_REQUIREMENTS, "[]");

        try {
            return new JSONArray(savedData);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static int getRequirementsCount(Context context) {
        return getRequirements(context).length();
    }
}
