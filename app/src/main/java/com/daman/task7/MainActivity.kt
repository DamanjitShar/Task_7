import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.daman.task7.R

class MainActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var collegeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.nameTextView)
        collegeTextView = findViewById(R.id.collegeTextView)

        val editButton: Button = findViewById(R.id.editButton)
        editButton.setOnClickListener {
            showEditDialog()
        }

        val clearButton: Button = findViewById(R.id.clearButton)
        clearButton.setOnClickListener {
            showClearConfirmationDialog()
        }
    }

    private fun showEditDialog() {
        val dialog = EditDialogFragment()
        dialog.show(supportFragmentManager, "EditDialogFragment")
        dialog.setOnEditListener(object : EditDialogFragment.OnEditListener {
            override fun onEdit(name: String, college: String) {
                nameTextView.text = name
                collegeTextView.text = college
            }
        })
    }

    private fun showClearConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Clear Data")
        builder.setMessage("Are you sure you want to clear the name and college?")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            clearData()
        }
        builder.setNegativeButton("No", null)
        builder.show()
    }

    private fun clearData() {
        nameTextView.text = ""
        collegeTextView.text = ""
    }
}
