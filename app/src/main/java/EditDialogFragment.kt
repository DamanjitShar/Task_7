import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.daman.task7.R


class EditDialogFragment : DialogFragment() {

    private var onEditListener: OnEditListener? = null

    interface OnEditListener {
        fun onEdit(name: String, college: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_edit, null)

        builder.setView(view)
            .setTitle("Edit Information")
            .setPositiveButton("Save") { _, _ ->
                val name = view.nameEditText.text.toString()
                val college = view.collegeEditText.text.toString()
                onEditListener?.onEdit(name, college)
            }
            .setNegativeButton("Cancel", null)

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnEditListener) {
            onEditListener = context
        }
    }

    fun setOnEditListener(onEditListener: EditDialogFragment.OnEditListener) {

    }
}
