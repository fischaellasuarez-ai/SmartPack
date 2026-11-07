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
import org.json.JSONException;
import org.json.JSONObject;

public class activity_all_requirements_teacher_main_dashboard
        extends AppCompatActivity {

    private LinearLayout requirementsContainer;

    private ImageButton homeButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_requirments_teacher_main_dashboard);

        requirementsContainer = findViewById(R.id.requirementsContainer);

        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);

        homeButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    activity_all_requirements_teacher_main_dashboard.this,
                    activity_teacher_main_dashboard.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });

        profileButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    activity_all_requirements_teacher_main_dashboard.this,
                    activity_teacher_profile.class
            );

            startActivity(intent);
        });

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

    private void displayAllRequirements() {

        requirementsContainer.removeAllViews();

        JSONArray requirements = getSavedRequirements();

        if (requirements.length() == 0) {

            TextView emptyMessage = new TextView(this);

            emptyMessage.setText("No requirements sent yet.");
            emptyMessage.setTextSize(16);
            emptyMessage.setTextColor(Color.GRAY);
            emptyMessage.setGravity(Gravity.CENTER);
            emptyMessage.setPadding(16, 30, 16, 30);

            requirementsContainer.addView(emptyMessage);

            return;
        }

        for (int i = requirements.length() - 1; i >= 0; i--) {

            try {

                JSONObject requirement = requirements.getJSONObject(i);

                String title = requirement.optString(
                        "title",
                        "Untitled Requirement"
                );

                String grade = requirement.optString("grade");
                String section = requirement.optString("section");
                String date = requirement.optString("date");

                JSONArray items = requirement.optJSONArray("items");

                // REQUIREMENT BOX
                LinearLayout requirementBox = new LinearLayout(this);

                requirementBox.setOrientation(LinearLayout.VERTICAL);
                requirementBox.setPadding(
                        dp(12), dp(10), dp(12), dp(10)
                );

                GradientDrawable boxBackground = new GradientDrawable();
                boxBackground.setColor(Color.WHITE);
                boxBackground.setCornerRadius(dp(13));
                boxBackground.setStroke(
                        dp(1),
                        Color.rgb(220, 235, 240)
                );

                requirementBox.setBackground(boxBackground);

                LinearLayout.LayoutParams boxParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );

                boxParams.setMargins(
                        dp(4), dp(5), dp(4), dp(9)
                );

                requirementBox.setLayoutParams(boxParams);


                LinearLayout titleRow = new LinearLayout(this);

                titleRow.setOrientation(LinearLayout.HORIZONTAL);
                titleRow.setGravity(Gravity.CENTER_VERTICAL);

                // REQUIREMENT TITLE
                TextView titleText = new TextView(this);

                titleText.setText(title);
                titleText.setTextColor(Color.rgb(41, 41, 41));
                titleText.setTextSize(18);
                titleText.setTypeface(null, Typeface.BOLD);
                titleText.setMaxLines(2);

                LinearLayout.LayoutParams titleParams =
                        new LinearLayout.LayoutParams(
                                0,
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                1
                        );

                titleText.setLayoutParams(titleParams);

                TextView arrow = new TextView(this);

                arrow.setText(">");
                arrow.setTextSize(20);
                arrow.setTextColor(Color.rgb(34, 34, 34));
                arrow.setGravity(Gravity.CENTER);
                arrow.setClickable(true);
                arrow.setFocusable(true);

                arrow.setBackgroundResource(
                        android.R.drawable.list_selector_background
                );

                LinearLayout.LayoutParams arrowParams =
                        new LinearLayout.LayoutParams(
                                dp(40),
                                dp(40)
                        );

                arrow.setLayoutParams(arrowParams);

                titleRow.addView(titleText);
                titleRow.addView(arrow);

                TextView dateText = new TextView(this);

                dateText.setText("Due: " + date);
                dateText.setTextColor(Color.GRAY);
                dateText.setTextSize(11);

                LinearLayout details = new LinearLayout(this);

                details.setOrientation(LinearLayout.VERTICAL);
                details.setPadding(
                        dp(10), dp(10), dp(10), dp(10)
                );

                GradientDrawable detailsBackground =
                        new GradientDrawable();

                detailsBackground.setColor(
                        Color.rgb(234, 247, 252)
                );

                detailsBackground.setCornerRadius(dp(10));
                details.setBackground(detailsBackground);

                LinearLayout.LayoutParams detailsParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );

                detailsParams.setMargins(0, dp(10), 0, 0);
                details.setLayoutParams(detailsParams);


                TextView detailsHeading = new TextView(this);

                detailsHeading.setText("Requirement Details");
                detailsHeading.setTextColor(Color.rgb(34, 34, 34));
                detailsHeading.setTextSize(16);
                detailsHeading.setTypeface(null, Typeface.BOLD);


                TextView detailsInfo = new TextView(this);

                StringBuilder message = new StringBuilder();

                message.append("Grade: ").append(grade);
                message.append("\nSection: ").append(section);
                message.append("\nDue Date: ").append(date);
                message.append("\n\nItems to bring:");

                if (items == null || items.length() == 0) {

                    message.append("\nNo items added.");

                } else {

                    for (int j = 0; j < items.length(); j++) {

                        message.append("\n• ")
                                .append(items.optString(j));
                    }
                }

                detailsInfo.setText(message.toString());
                detailsInfo.setTextColor(Color.rgb(68, 68, 68));
                detailsInfo.setTextSize(14);
                detailsInfo.setPadding(0, dp(6), 0, 0);

                details.addView(detailsHeading);
                details.addView(detailsInfo);

                details.setVisibility(View.GONE);

                arrow.setOnClickListener(v -> {

                    if (details.getVisibility() == View.GONE) {

                        details.setVisibility(View.VISIBLE);
                        arrow.setText("⌄");

                    } else {

                        details.setVisibility(View.GONE);
                        arrow.setText(">");
                    }
                });


                requirementBox.addView(titleRow);
                requirementBox.addView(dateText);
                requirementBox.addView(details);


                requirementsContainer.addView(requirementBox);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private int dp(int value) {

        return (int) (
                value * getResources().getDisplayMetrics().density
        );
    }
}
