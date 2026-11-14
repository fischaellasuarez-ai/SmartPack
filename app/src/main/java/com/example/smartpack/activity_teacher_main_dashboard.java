package com.example.smartpack;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class activity_teacher_main_dashboard extends AppCompatActivity {


    private TextView classesCount;
    private TextView requirementsCount;
    private TextView studentsReadyCount;


    private Button viewAllButton;
    private TextView recentViewAll;


    private CardView createRequirementCard;
    private CardView createRequirementForm;

    private TextView arrowIcon;

    private AutoCompleteTextView gradeLevelDropdown;
    private AutoCompleteTextView sectionDropdown;
    private AutoCompleteTextView dateDropdown;

    private TextInputEditText requirementTitle;

    private Button itemsButton;
    private Button createSendButton;

    // RECENT REQUIREMENTS
    private TextView recentTitle1;
    private TextView recentTitle2;
    private TextView recentTitle3;

    // BOTTOM NAVIGATION
    private ImageButton homeButton;
    private ImageButton addClassesButton;
    private ImageButton profileButton;

    // REQUIREMENT ITEMS
    private final ArrayList<String> itemsList = new ArrayList<>();

    private boolean isFormExpanded = false;


    private static final String SECTION_PREF = "TeacherSections";
    private static final String SECTION_KEY = "sections";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_dashboard);

        initializeViews();

        setupGradeDropdown();
        setupSectionDropdown();
        setupDatePicker();

        setupButtons();
        setupExpandableForm();
        setupRecentRequirementClicks();

        refreshDashboard();


        openCreateRequirementIfRequested(getIntent());
    }




    private void initializeViews() {

        classesCount = findViewById(R.id.classesCount);
        requirementsCount = findViewById(R.id.requirementsCount);
        studentsReadyCount = findViewById(R.id.studentsReadyCount);


        viewAllButton = findViewById(R.id.viewAllButton);
        recentViewAll = findViewById(R.id.recentViewAll);

        createRequirementCard = findViewById(R.id.createRequirementCard);
        createRequirementForm = findViewById(R.id.createRequirementForm);

        arrowIcon = findViewById(R.id.arrowIcon);

        gradeLevelDropdown = findViewById(R.id.gradeLevelDropdown);
        sectionDropdown = findViewById(R.id.sectionDropdown);
        dateDropdown = findViewById(R.id.dateDropdown);

        requirementTitle = findViewById(R.id.requirementTitle);

        itemsButton = findViewById(R.id.itemsButton);
        createSendButton = findViewById(R.id.createSendButton);


        recentTitle1 = findViewById(R.id.recentTitle1);
        recentTitle2 = findViewById(R.id.recentTitle2);
        recentTitle3 = findViewById(R.id.recentTitle3);


        homeButton = findViewById(R.id.homeButton);
        addClassesButton = findViewById(R.id.addClasses_Button);
        profileButton = findViewById(R.id.profileButton);
    }




    private void setupGradeDropdown() {

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

        gradeLevelDropdown.setOnClickListener(
                v -> gradeLevelDropdown.showDropDown()
        );

        gradeLevelDropdown.setOnItemClickListener(
                (parent, view, position, id) -> {

                    sectionDropdown.setText("", false);

                    loadSectionsForSelectedGrade();
                }
        );
    }



    private void setupSectionDropdown() {

        sectionDropdown.setOnClickListener(v -> {

            loadSectionsForSelectedGrade();

            sectionDropdown.showDropDown();
        });
    }


    private void loadSectionsForSelectedGrade() {

        String selectedGrade =
                gradeLevelDropdown.getText().toString().trim();

        ArrayList<String> savedSections = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences(
                SECTION_PREF,
                MODE_PRIVATE
        );

        String savedData = preferences.getString(
                SECTION_KEY,
                "[]"
        );

        try {

            JSONArray sections = new JSONArray(savedData);

            for (int i = 0; i < sections.length(); i++) {

                JSONObject section = sections.optJSONObject(i);

                if (section == null) {
                    continue;
                }

                String grade = section.optString("grade");
                String sectionName = section.optString("section");

                if (grade.equalsIgnoreCase(selectedGrade)
                        && !sectionName.isEmpty()
                        && !savedSections.contains(sectionName)) {

                    savedSections.add(sectionName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                savedSections
        );

        sectionDropdown.setAdapter(adapter);

        if (savedSections.isEmpty()) {

            Toast.makeText(
                    this,
                    "No saved sections for this grade. Add a section first.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    private void setupDatePicker() {

        dateDropdown.setOnClickListener(v -> openDatePicker());

        dateDropdown.setFocusable(false);
        dateDropdown.setClickable(true);
    }


    private void openDatePicker() {

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {

                    String selectedDate = (selectedMonth + 1)
                            + "/" + selectedDay
                            + "/" + selectedYear;

                    dateDropdown.setText(selectedDate, false);
                },
                year,
                month,
                day
        );

        datePickerDialog.getDatePicker().setMinDate(
                calendar.getTimeInMillis()
        );

        datePickerDialog.show();
    }


    private void openAllRequirements() {

        Intent intent = new Intent(
                activity_teacher_main_dashboard.this,
                activity_all_requirements_teacher_main_dashboard.class
        );

        startActivity(intent);
    }


    private void setupButtons() {


        viewAllButton.setOnClickListener(v -> openAllRequirements());


        recentViewAll.setOnClickListener(v -> openAllRequirements());


        itemsButton.setOnClickListener(v -> showItemsDialog());


        createSendButton.setOnClickListener(v -> saveRequirement());


        homeButton.setOnClickListener(v -> refreshDashboard());


        addClassesButton.setOnClickListener(
                v -> toggleCreateRequirementForm()
        );


        profileButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    activity_teacher_main_dashboard.this,
                    activity_teacher_profile.class
            );

            startActivity(intent);
        });
    }




    private void openCreateRequirementIfRequested(Intent intent) {

        if (intent != null
                && intent.getBooleanExtra("openCreateRequirement", false)) {

            if (!isFormExpanded) {
                toggleCreateRequirementForm();
            }

            intent.removeExtra("openCreateRequirement");
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);

        openCreateRequirementIfRequested(intent);
    }


    private void setupExpandableForm() {

        createRequirementForm.setVisibility(View.GONE);

        arrowIcon.setText(">");
        arrowIcon.setRotation(0);

        arrowIcon.setClickable(false);
        arrowIcon.setFocusable(false);

        createRequirementCard.setOnClickListener(
                v -> toggleCreateRequirementForm()
        );
    }


    private void toggleCreateRequirementForm() {

        if (isFormExpanded) {

            collapseCreateRequirementForm();

        } else {

            createRequirementForm.setVisibility(View.VISIBLE);

            arrowIcon.setText(">");
            arrowIcon.setRotation(90);

            isFormExpanded = true;
        }
    }


    private void collapseCreateRequirementForm() {

        createRequirementForm.setVisibility(View.GONE);

        arrowIcon.setText(">");
        arrowIcon.setRotation(0);

        isFormExpanded = false;
    }




    private void showItemsDialog() {

        EditText input = new EditText(this);

        input.setHint("Enter items separated by commas");

        input.setText(String.join(", ", itemsList));

        new AlertDialog.Builder(this)

                .setTitle("Items to Bring")

                .setMessage(
                        "Enter the materials or requirements students need to bring."
                )

                .setView(input)

                .setPositiveButton("Save", (dialog, which) -> {

                    String enteredItems =
                            input.getText().toString().trim();

                    itemsList.clear();

                    if (!enteredItems.isEmpty()) {

                        String[] splitItems = enteredItems.split(",");

                        for (String item : splitItems) {

                            String cleanItem = item.trim();

                            if (!cleanItem.isEmpty()
                                    && !itemsList.contains(cleanItem)) {

                                itemsList.add(cleanItem);
                            }
                        }
                    }

                    updateItemsButton();
                })

                .setNegativeButton("Cancel", null)

                .show();
    }


    private void updateItemsButton() {

        itemsButton.setText(itemsList.size() + " Items added");
    }




    private void saveRequirement() {

        String grade =
                gradeLevelDropdown.getText().toString().trim();

        String section =
                sectionDropdown.getText().toString().trim();

        String title = requirementTitle.getText() == null
                ? ""
                : requirementTitle.getText().toString().trim();

        String date =
                dateDropdown.getText().toString().trim();


        if (grade.isEmpty()
                || section.isEmpty()
                || title.isEmpty()
                || date.isEmpty()) {

            Toast.makeText(
                    this,
                    "Please complete all fields.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        if (itemsList.isEmpty()) {

            Toast.makeText(
                    this,
                    "Please add at least one item.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        boolean saved = activity_requirement_storage.saveRequirement(
                this,
                grade,
                section,
                title,
                date,
                itemsList
        );


        if (saved) {

            new AlertDialog.Builder(this)

                    .setTitle("Requirement Sent!")

                    .setMessage(
                            "Requirement: " + title +
                                    "\nGrade: " + grade +
                                    "\nSection: " + section +
                                    "\nDue Date: " + date +
                                    "\nItems: " + String.join(", ", itemsList)
                    )

                    .setPositiveButton("OK", (dialog, which) -> {

                        clearRequirementForm();

                        collapseCreateRequirementForm();

                        refreshDashboard();
                    })

                    .show();

        } else {

            Toast.makeText(
                    this,
                    "Failed to save requirement. Please try again.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    private void clearRequirementForm() {

        gradeLevelDropdown.setText("", false);

        sectionDropdown.setText("", false);

        requirementTitle.setText("");

        dateDropdown.setText("", false);

        itemsList.clear();

        updateItemsButton();
    }


    private void refreshDashboard() {

        updateClassesCount();

        updateRequirementsCount();

        updateRecentRequirements();

        studentsReadyCount.setText("67%");
    }


    private void updateClassesCount() {

        SharedPreferences preferences = getSharedPreferences(
                SECTION_PREF,
                MODE_PRIVATE
        );

        try {

            JSONArray sections = new JSONArray(
                    preferences.getString(SECTION_KEY, "[]")
            );

            classesCount.setText(String.valueOf(sections.length()));

        } catch (Exception e) {

            classesCount.setText("0");
        }
    }


    private void updateRequirementsCount() {

        int count =
                activity_requirement_storage.getRequirementsCount(this);

        requirementsCount.setText(String.valueOf(count));
    }


    private void updateRecentRequirements() {

        JSONArray requirements =
                activity_requirement_storage.getRequirements(this);

        TextView[] recentTitles = {
                recentTitle1,
                recentTitle2,
                recentTitle3
        };

        int total = requirements.length();

        for (int i = 0; i < recentTitles.length; i++) {

            if (recentTitles[i] == null) {
                continue;
            }

            if (i < total) {

                JSONObject requirement =
                        requirements.optJSONObject(total - 1 - i);

                if (requirement != null) {

                    String title = requirement.optString(
                            "title",
                            "Untitled Requirement"
                    );

                    recentTitles[i].setText(title);

                } else {

                    recentTitles[i].setText("Untitled Requirement");
                }

            } else {

                recentTitles[i].setText("No recent requirement");
            }
        }
    }


    private void setupRecentRequirementClicks() {

        recentTitle1.setOnClickListener(v -> showRequirementDetails(0));

        recentTitle2.setOnClickListener(v -> showRequirementDetails(1));

        recentTitle3.setOnClickListener(v -> showRequirementDetails(2));
    }


    private void showRequirementDetails(int position) {

        JSONArray requirements =
                activity_requirement_storage.getRequirements(this);

        int total = requirements.length();

        if (position >= total) {

            Toast.makeText(
                    this,
                    "No requirement available.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        JSONObject requirement =
                requirements.optJSONObject(total - 1 - position);

        if (requirement == null) {
            return;
        }

        String title = requirement.optString(
                "title",
                "Untitled Requirement"
        );

        String grade = requirement.optString("grade", "N/A");

        String section = requirement.optString("section", "N/A");

        String date = requirement.optString("date", "N/A");

        JSONArray items = requirement.optJSONArray("items");

        StringBuilder itemsText = new StringBuilder();

        if (items != null && items.length() > 0) {

            for (int i = 0; i < items.length(); i++) {

                itemsText.append("• ")
                        .append(items.optString(i))
                        .append("\n");
            }

        } else {

            itemsText.append("No items listed.");
        }

        new AlertDialog.Builder(this)

                .setTitle(title)

                .setMessage(
                        "Grade: " + grade +
                                "\nSection: " + section +
                                "\nDue Date: " + date +
                                "\n\nItems to Bring:\n" + itemsText
                )

                .setPositiveButton("OK", null)

                .show();
    }



    @Override
    protected void onResume() {
        super.onResume();

        refreshDashboard();
    }
}
