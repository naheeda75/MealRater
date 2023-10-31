package com.example.mealrater;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText dishNameEditText;
    private EditText restaurantNameEditText;
    private TextView openRatingButton;
    private TextView displayRatingLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dishNameEditText = findViewById(R.id.dishNameEditText);
        restaurantNameEditText = findViewById(R.id.restaurantNameEditText);
        openRatingButton = findViewById(R.id.openRatingButton);
        displayRatingLabel = findViewById(R.id.displayRatingLabel);
        openRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the rating activity here
                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            float rating = data.getFloatExtra("mealRating", 0);
            String restaurantName = restaurantNameEditText.getText().toString();
            String dishName = dishNameEditText.getText().toString();
            displayRatingLabel.setText("Dish Name: " + dishName +"\nrestaurant Name: "+restaurantName+
                    "\nMeal Rating: " + rating
            );
        }
    }
}
