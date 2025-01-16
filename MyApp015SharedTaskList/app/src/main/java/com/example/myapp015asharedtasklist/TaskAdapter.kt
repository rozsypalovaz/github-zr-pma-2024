package com.example.myapp015asharedtasklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp015asharedtasklist.databinding.ItemTaskBinding

class TaskAdapter(
    private val tasks: List<Task>, // Seznam úkolů
    private val onTaskChecked: (Task) -> Unit // Callback pro změnu stavu úkolu
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTaskName.text = task.name // Nastavení názvu úkolu
            binding.cbTaskCompleted.isChecked = task.isCompleted // Nastavení stavu checkboxu dle stavu úkolu
            binding.tvAssignedTo.text = if (task.assignedTo.isNotEmpty()) {
                "Assigned to: ${task.assignedTo}"
            } else {
                "Assigned to: None"
            }

            binding.cbTaskCompleted.setOnCheckedChangeListener { _, isChecked ->
                task.isCompleted = isChecked // Aktualizace stavu úkolu podle stavu checkboxu
                onTaskChecked(task)  // Vyvolání callback funkce pro změnu stavu úkolu
            }

            // Logika pro zarezervování úkolu
            binding.root.setOnClickListener {
                if (task.assignedTo.isEmpty()) {
                    task.assignedTo = "YourName" // Zatím hardcoded, později to bude dynamické
                    binding.tvAssignedTo.text = "Assigned to: ${task.assignedTo}"
                    onTaskChecked(task)
                }
            }
        }
    }

    //Inflatuje layout pro jednotlivé položky v seznamu (Inflatovat = vytvořit instance View elementů (jako jsou tlačítka, textová pole atd.) z XML souboru layoutu
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    //Připojuje data (úkol) k ViewHolderu na konkrétní pozici
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    //Vrací počet položek (úkolů) v seznamu.
    override fun getItemCount(): Int = tasks.size
}