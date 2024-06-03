package com.ankurtripathi.oneclickdrivetechtask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ankurtripathi.oneclickdrivetechtask.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
//    Code by Ankur Tripathi
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // View Binding
        binding.calculateButton.setOnClickListener {
            if(binding.editText1.text.isEmpty() && binding.editText2.text.isEmpty() &&  binding.editText3.text.isEmpty())
            {  Toast.makeText(applicationContext, "Enter numbers in each fields", Toast.LENGTH_LONG).show() }
            else { calculateResults() } } }
         private fun calculateResults() {
        // Getting reference of views
        val input1 = binding.editText1.text.toString()
        val input2 = binding.editText2.text.toString()
        val input3 = binding.editText3.text.toString()
        // Parse comma-separated numbers from input strings
        val list1 = input1.split(",").map { it.trim().toInt() }.toSet()
        val list2 = input2.split(",").map { it.trim().toInt() }.toSet()
        val list3 = input3.split(",").map { it.trim().toInt() }.toSet()
        // Calculate intersection, union, and max number
        val intersection = list1.intersect(list2).intersect(list3)
        val union = list1.union(list2).union(list3)
        val maxNumber = union.maxOrNull()
        // Display results
        binding.resultTextView.text = """
            Intersection: ${intersection.joinToString(", ")}
            Union: ${union.joinToString(", ")}
            Highest Number: $maxNumber
        """.trimIndent()
    }
}
