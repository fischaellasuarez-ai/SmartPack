package com.example.smartpack;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class activity_all_requirements_teacher_main_dashboard
        extends AppCompatActivity {

    private LinearLayout requirementsContainer;
    private TextView requirementsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_requirments_teacher_main_dashboard);

        requirementsContainer = findViewById(R.id.requirementsContainer);
        requirementsCount = findViewById(R.id.requirementsCount);

        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton addClassesButton = findViewById(R.id.addClasses_Button);
        ImageButton profileButton = findViewById(R.id.profileButton);


        if (homeButton != null) {
            homeButton.setOnClickListener(v -> {
                Intent intent = new Intent(
                        this,
                        activity_teacher_main_dashboard.class
                );

                intent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                );

                startActivity(intent);
                finish();
            });
        }


        if (addClassesButton != null) {
            addClassesButton.setOnClickListener(v -> {
                Intent intent = new Intent(
                        this,
                        activity_teacher_main_dashboard.class
                );

                intent.putExtra("openCreateRequirement", true);

                intent.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                );

                startActivity(intent);
                finish();
            });
        }


        if (profileButton != null) {
            profileButton.setOnClickListener(v -> {
                startActivity(new Intent(
                        this,
                        activity_teacher_profile.class
                ));
            });
        }

        displayAllRequirements();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (requirementsContainer != null) {
            displayAllRequirements();
        }
    }


    private JSONArray getSavedRequirements() {
        return activity_requirement_storage.getRequirements(this);
    }


    private void updateRequirementsCount() {

        int totalRequirements =
                activity_requirement_storage.getRequirementsCount(this);

        if (requirementsCount != null) {
            requirementsCount.setText(
                    totalRequirements +
                            (totalRequirements == 1
                                    ? " Requirement Sent"
                                    : " Requirements Sent")
            );
        }
    }


    private void displayAllRequirements() {

        if (requirementsContainer == null) {
            return;
        }

        requirementsContainer.removeAllViews();

        JSONArray requirements = getSavedRequirements();

        updateRequirementsCount();

        if (requirements.length() == 0) {
            showEmptyMessage();
            return;
        }


        for (int i = requirements.length() - 1; i >= 0; i--) {

            try {

                JSONObject requirement = requirements.getJSONObject(i);

                String title = requirement.optString(
                        "title",
                        "Untitled Requirement"
                );

                String grade = requirement.optString("grade", "");
                String section = requirement.optString("section", "");
                String date = requirement.optString("date", "");

                JSONArray items = requirement.optJSONArray("items");

                addRequirementCard(
                        title,
                        grade,
                        section,
                        date,
                        items
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void showEmptyMessage() {

        TextView emptyMessage = new TextView(this);

        emptyMessage.setText(
                "No requirements sent yet.\n\n" +
                        "Your saved requirements will appear here."
        );

        emptyMessage.setTextColor(Color.GRAY);
        emptyMessage.setTextSize(15);
        emptyMessage.setGravity(Gravity.CENTER);
        emptyMessage.setPadding(20, 50, 20, 50);

        requirementsContainer.addView(emptyMessage);
    }


    private void addRequirementCard(
            String title,
            String grade,
            String section,
            String date,
            JSONArray items) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 16, 18, 16);

        GradientDrawable cardBackground = new GradientDrawable();
        cardBackground.setColor(Color.WHITE);
        cardBackground.setCornerRadius(18);

        card.setBackground(cardBackground);
        card.setElevation(4);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, 0, 0, 14);
        card.setLayoutParams(cardParams);

        // HEADER
        LinearLayout header = new LinearLayout(this);

        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout titleContainer = new LinearLayout(this);

        titleContainer.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams titleParams =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );

        header.addView(titleContainer, titleParams);


        TextView titleText = new TextView(this);

        titleText.setText(title);
        titleText.setTextColor(Color.rgb(0, 73, 172));
        titleText.setTextSize(17);
        titleText.setTypeface(null, Typeface.BOLD);

        titleContainer.addView(titleText);


        TextView dateText = new TextView(this);

        dateText.setText("Due Date: " + date);
        dateText.setTextColor(Color.DKGRAY);
        dateText.setTextSize(13);

        LinearLayout.LayoutParams dateParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        dateParams.topMargin = 5;
        titleContainer.addView(dateText, dateParams);


        TextView arrow = new TextView(this);

        arrow.setText(">");
        arrow.setTextColor(Color.rgb(0, 73, 172));
        arrow.setTextSize(18);
        arrow.setPadding(12, 8, 4, 8);

        header.addView(arrow);
        card.addView(header);


        LinearLayout details = new LinearLayout(this);

        details.setOrientation(LinearLayout.VERTICAL);
        details.setVisibility(View.GONE);

        LinearLayout.LayoutParams detailsParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        detailsParams.topMargin = 16;
        card.addView(details, detailsParams);


        View divider = new View(this);

        divider.setBackgroundColor(Color.LTGRAY);

        LinearLayout.LayoutParams dividerParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1
                );

        dividerParams.bottomMargin = 12;
        details.addView(divider, dividerParams);


        addDetailText(details, "Grade: " + grade);
        addDetailText(details, "Section: " + section);
        addDetailText(details, "Due Date: " + date);


        TextView itemsTitle = new TextView(this);

        itemsTitle.setText("Items to Bring:");
        itemsTitle.setTextColor(Color.rgb(0, 73, 172));
        itemsTitle.setTextSize(15);
        itemsTitle.setTypeface(null, Typeface.BOLD);

        LinearLayout.LayoutParams itemsTitleParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        itemsTitleParams.topMargin = 10;
        details.addView(itemsTitle, itemsTitleParams);


        if (items != null && items.length() > 0) {

            for (int i = 0; i < items.length(); i++) {

                addDetailText(
                        details,
                        "• " + items.optString(i)
                );
            }

        } else {
            addDetailText(details, "No items listed.");
        }


        header.setOnClickListener(v -> {

            if (details.getVisibility() == View.GONE) {

                details.setVisibility(View.VISIBLE);


                arrow.setText("⮟");

            } else {

                details.setVisibility(View.GONE);


                arrow.setText(">");
            }
        });

        requirementsContainer.addView(card);
    }


    private void addDetailText(
            LinearLayout container,
            String text) {

        TextView detail = new TextView(this);

        detail.setText(text);
        detail.setTextColor(Color.DKGRAY);
        detail.setTextSize(14);
        detail.setPadding(0, 5, 0, 5);

        container.addView(detail);
    }
}
