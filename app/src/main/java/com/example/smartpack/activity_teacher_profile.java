package com.example.smartpack;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class activity_teacher_profile extends AppCompatActivity {

    private TextInputEditText etName;
    private TextInputEditText etUsername;
    private TextInputEditText etPassword;
    private TextInputEditText etEmail;
    private TextInputEditText etPhone;
    private TextInputEditText etCountry;

    private AutoCompleteTextView etGender;

    private MaterialButton btnSaveProfile;


    private ImageButton homeButton;
    private ImageButton addClassesButton;
    private ImageButton profileButton;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);


        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etGender = findViewById(R.id.etGender);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etCountry = findViewById(R.id.etCountry);

        btnSaveProfile = findViewById(R.id.btnSaveProfile);


        homeButton = findViewById(R.id.homeButton);
        addClassesButton = findViewById(R.id.addClasses_Button);
        profileButton = findViewById(R.id.profileButton);


        preferences = getSharedPreferences(
                "TeacherProfile",
                MODE_PRIVATE
        );


        String[] genders = {
                "Male",
                "Female",
                "Other",
                "Prefer not to say"
        };

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                genders
        );

        etGender.setAdapter(genderAdapter);


        loadProfile();


        btnSaveProfile.setOnClickListener(v -> saveProfile());


        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    activity_teacher_profile.this,
                    activity_teacher_main_dashboard.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });


        addClassesButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    activity_teacher_profile.this,
                    activity_teacher_main_dashboard.class
            );

            intent.putExtra("openCreateRequirement", true);

            startActivity(intent);
            finish();
        });


        profileButton.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "You are already on the Profile page.",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }


    private void loadProfile() {

        etName.setText(preferences.getString(
                "name", "Fischaella Suarez"
        ));

        etUsername.setText(preferences.getString(
                "username", ""
        ));

        etPassword.setText(preferences.getString(
                "password", ""
        ));

        etGender.setText(preferences.getString(
                "gender", "Male"
        ), false);

        etEmail.setText(preferences.getString(
                "email", "fischaellasuarez@gmail.com"
        ));

        etPhone.setText(preferences.getString(
                "phone", "09934784780098"
        ));

        etCountry.setText(preferences.getString(
                "country", "Philippines"
        ));
    }


    private void saveProfile() {

        String name = etName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String gender = etGender.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String country = etCountry.getText().toString().trim();


        if (name.isEmpty()) {
            etName.setError("Please enter your name.");
            etName.requestFocus();
            return;
        }


        if (username.isEmpty()) {
            etUsername.setError("Please enter your username.");
            etUsername.requestFocus();
            return;
        }


        if (password.isEmpty()) {
            etPassword.setError("Please enter your password.");
            etPassword.requestFocus();
            return;
        }


        if (gender.isEmpty()) {
            etGender.setError("Please select your gender.");
            etGender.requestFocus();
            return;
        }


        if (email.isEmpty() ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email.");
            etEmail.requestFocus();
            return;
        }


        if (phone.isEmpty()) {
            etPhone.setError("Please enter your phone number.");
            etPhone.requestFocus();
            return;
        }


        if (country.isEmpty()) {
            etCountry.setError("Please enter your country.");
            etCountry.requestFocus();
            return;
        }


        boolean saved = preferences.edit()
                .putString("name", name)
                .putString("username", username)
                .putString("password", password)
                .putString("gender", gender)
                .putString("email", email)
                .putString("phone", phone)
                .putString("country", country)
                .commit();

        if (saved) {

            Toast.makeText(
                    this,
                    "Profile saved successfully!",
                    Toast.LENGTH_SHORT
            ).show();


            Intent intent = new Intent(
                    activity_teacher_profile.this,
                    activity_teacher_main_dashboard.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );


            startActivity(intent);
            finish();

        } else {

            Toast.makeText(
                    this,
                    "Unable to save profile. Please try again.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
