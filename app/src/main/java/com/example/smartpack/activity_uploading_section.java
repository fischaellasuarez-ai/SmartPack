
package com.example.smartpack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class activity_uploading_section extends AppCompatActivity {

    private AutoCompleteTextView gradeLevelDropdown;
    private EditText sectionName;

    private Button saveSectionButton;

    private View uploadSectionForm;
    private View uploadSectionHeader;
    private TextView arrowIcon;

    private boolean isFormExpanded = false;

    private static final String PREF_NAME = "TeacherSections";
    private static final String KEY_SECTIONS = "sections";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading_section);


        gradeLevelDropdown = findViewById(R.id.gradeLevelDropdown);
        sectionName = findViewById(R.id.sectionDropdown);

        saveSectionButton = findViewById(R.id.createSendButton);

        uploadSectionHeader = findViewById(R.id.createRequirementHeader);
        uploadSectionForm = findViewById(R.id.createRequirementForm);
        arrowIcon = findViewById(R.id.arrowIcon);


        String[] grades = {
                "Grade 7",
                "Grade 8",
                "Grade 9",
                "Grade 10",
                "Grade 11",
                "Grade 12"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                grades
        );

        gradeLevelDropdown.setAdapter(adapter);

        gradeLevelDropdown.setOnClickListener(v ->
                gradeLevelDropdown.showDropDown()
        );


        uploadSectionForm.setVisibility(View.GONE);

        arrowIcon.setText(">");
        arrowIcon.setRotation(0);


        arrowIcon.setClickable(false);
        arrowIcon.setFocusable(false);


        uploadSectionHeader.setOnClickListener(v ->
                toggleSectionForm()
        );


        saveSectionButton.setOnClickListener(v ->
                saveSection()
        );


        View backButton = findViewById(R.id.homeButton);

        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }
    }




    private void toggleSectionForm() {

        if (isFormExpanded) {

            uploadSectionForm.setVisibility(View.GONE);

            arrowIcon.setText(">");
            arrowIcon.setRotation(0);

            isFormExpanded = false;

        } else {

            uploadSectionForm.setVisibility(View.VISIBLE);

            arrowIcon.setText(">");
            arrowIcon.setRotation(90);

            isFormExpanded = true;
        }
    }




    private void saveSection() {

        String grade = gradeLevelDropdown.getText()
                .toString().trim();

        String section = sectionName.getText()
                .toString().trim();

        if (grade.isEmpty() || section.isEmpty()) {

            Toast.makeText(
                    this,
                    "Please complete all fields.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        SharedPreferences preferences = getSharedPreferences(
                PREF_NAME,
                MODE_PRIVATE
        );

        JSONArray sections;

        try {

            sections = new JSONArray(
                    preferences.getString(KEY_SECTIONS, "[]")
            );

        } catch (Exception e) {

            sections = new JSONArray();
        }


        for (int i = 0; i < sections.length(); i++) {

            JSONObject savedSection = sections.optJSONObject(i);

            if (savedSection != null
                    && savedSection.optString("grade").equalsIgnoreCase(grade)
                    && savedSection.optString("section").equalsIgnoreCase(section)) {

                Toast.makeText(
                        this,
                        "This section is already saved.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }
        }

        try {

            JSONObject newSection = new JSONObject();

            newSection.put("grade", grade);
            newSection.put("section", section);

            sections.put(newSection);

            boolean saved = preferences.edit()
                    .putString(KEY_SECTIONS, sections.toString())
                    .commit();

            if (saved) {

                Toast.makeText(
                        this,
                        "Section saved successfully!",
                        Toast.LENGTH_SHORT
                ).show();

                clearSectionForm();


                uploadSectionForm.setVisibility(View.GONE);

                arrowIcon.setText(">");
                arrowIcon.setRotation(0);

                isFormExpanded = false;

            } else {

                Toast.makeText(
                        this,
                        "Failed to save section.",
                        Toast.LENGTH_SHORT
                ).show();
            }

        } catch (Exception e) {

            e.printStackTrace();

            Toast.makeText(
                    this,
                    "An error occurred while saving.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    private void clearSectionForm() {

        gradeLevelDropdown.setText("", false);
        sectionName.setText("");
    }
}
