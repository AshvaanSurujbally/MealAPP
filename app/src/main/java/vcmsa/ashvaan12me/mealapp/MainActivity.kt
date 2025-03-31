package vcmsa.ashvaan12me.mealapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }// end of main code
        // start of code

        // start by declaring variables that will be used
        val bTReset = findViewById<Button>(R.id.bTReset)
        val bTGo = findViewById<Button>(R.id.bTGo)
        val timeOfDay = findViewById<EditText>(R.id.edTTimeOfDay)
        val mealSuggestions = findViewById<TextView>(R.id.tvMealSuggestion)

        // now we need the to get the user to input the time of day
        bTGo.setOnClickListener {
            val time = timeOfDay.text.toString()
            // now we check what the user is valid time of day (AI assisted and corrected)
            if (time.equals("Morning", ignoreCase = true) ||
                time.equals("Mid-morning", ignoreCase = true) ||
                time.equals("Afternoon", ignoreCase = true) ||
                time.equals("Mid-afternoon", ignoreCase = true) ||
                time.equals("Dinner", ignoreCase = true) ||
                time.equals("Desserts", ignoreCase = true) ||
                time.equals("Snack", ignoreCase = true)
            ) {
                // now we display the suggestions of meals
                    // now we display the suggestions of meals for Morning
                    if (time.equals("Morning", ignoreCase = true)) {
                        mealSuggestions.text = "Eggs,Toast,Pancakes,Porridge,Oatmeal"

                        //now we display the suggestions of meals for Mid-morning
                    } else if (time.equals("Mid-morning", ignoreCase = true)) {
                        mealSuggestions.text =
                            "Sliced fruits,Tea and biscuts, Yogurt with Berries,Almonds"
                        //now we display the suggestions of meals for Afternoon
                    } else if (time.equals("Afternoon", ignoreCase = true)) {
                        mealSuggestions.text =
                            "Chicken cease salad,Chicken sandwich,Pasta,Chia Pudding,"
                        //now we display the suggestions of meals for Mid-afternoon
                    } else if (time.equals("Mid-afternoon", ignoreCase = true)) {
                        mealSuggestions.text =
                            "Biltong,Samoosas,Milk tart,Masala Chips,Rooiboss tea"
                        //now we display the suggestions of meals for Dinner
                    } else if (time.equals("Dinner", ignoreCase = true)) {
                        mealSuggestions.text =
                            "Mutton curry,Bunny chow,Stir fry,Braai,Roasted vegetables,"
                        //now we display the suggestions of meals for Desserts
                    } else if (time.equals("Desserts", ignoreCase = true)) {
                        mealSuggestions.text = "Ice cream,Fruitcake,Malva pudding,Muffins"
                        //now we display the suggestions of meals for Snack
                    } else if (time.equals("Snack", ignoreCase = true)) {
                        mealSuggestions.text = "Almonds,Chips,Berries,Yogurt,Cookies"

                        // now we prompt the user if they didnt suggest any of the options
                    } else if (time.isEmpty() ||time.isNullOrBlank()) {
                        // If the time input is not valid, show a Toast message
                        Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT)
                            .show()


                    }
                     //now we prompt the user if they entered an invalid time
                } else {
                    Toast.makeText(this, "Please enter a valid time of day", Toast.LENGTH_SHORT)
                        .show()

                }
                // now we clear the text field with the reset button
                bTReset.setOnClickListener {
                    timeOfDay.text.clear()
                    mealSuggestions.text = " meal suggestion"
                }


            }


        }


    }






