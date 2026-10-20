package com.example.lsmartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> pantryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize pantry inventory list with default items
        pantryItems = new ArrayList<>(Arrays.asList(
                "Flour (1 kg)",
                "Sugar (500 g)",
                "Milk (2 Liters)",
                "Eggs (1 Dozen)",
                "Cooking Oil (750 ml)"
        ));

        Button btnAddItem = findViewById(R.id.btnAddItem);
        Button btnViewItems = findViewById(R.id.btnViewItems);

        // Add Item Button - Opens a pop-up text box to type your ingredient
        btnAddItem.setOnClickListener(v -> {
            final EditText inputField = new EditText(MainActivity.this);
            inputField.setHint("e.g., Rice (2 kg)");

            // Add some padding inside the popup box for a cleaner look
            int padding = 40;
            inputField.setPadding(padding, padding, padding, padding);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Add New Pantry Item")
                    .setMessage("Enter the name and quantity of your ingredient:")
                    .setView(inputField)
                    .setPositiveButton("Add", (dialog, which) -> {
                        String newItem = inputField.getText().toString().trim();
                        if (!newItem.isEmpty()) {
                            pantryItems.add(newItem);
                            Toast.makeText(MainActivity.this, newItem + " added to pantry!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Item name cannot be empty!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        // View Items Button - Opens the list to view and delete items
        btnViewItems.setOnClickListener(v -> {
            showInventoryDialog();
        });
    }

    private void showInventoryDialog() {
        if (pantryItems.isEmpty()) {
            Toast.makeText(this, "Your pantry is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] itemsArray = pantryItems.toArray(new String[0]);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Pantry Inventory (Tap item to delete)")
                .setItems(itemsArray, (dialog, which) -> {
                    String selectedItem = itemsArray[which];

                    // Prompt to delete the selected item
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Remove Item")
                            .setMessage("Do you want to delete " + selectedItem + "?")
                            .setPositiveButton("Delete", (d, w) -> {
                                pantryItems.remove(selectedItem);
                                Toast.makeText(MainActivity.this, selectedItem + " deleted!", Toast.LENGTH_SHORT).show();
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
                })
                .setPositiveButton("Close", null)
                .show();
    }
}