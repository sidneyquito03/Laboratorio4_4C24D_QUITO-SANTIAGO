package com.quitosantiago.sidney.laboratorio4calificado
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quitosantiago.sidney.laboratorio4calificado.databinding.ActivityGalleryBinding
import com.quitosantiago.sidney.laboratorio4calificado.databinding.ListItemImgBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val directory = File(externalMediaDirs[0].absolutePath)
        val files = directory.listFiles() as Array<File>

        val adapter = GalleryAdapter(files.reversedArray())
        binding.viewPager.adapter=adapter
        }
    }

    class GalleryAdapter(private val filerArray: Array<File>) :
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

        class ViewHolder(private val binding: ListItemImgBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(file: File) {
                Glide.with(binding.root).load(file).into(binding.localImg)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ViewHolder(ListItemImgBinding.inflate(layoutInflater, parent, false))  // 'false' en vez de 'attachToParent = false'
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(filerArray[position])
        }

        override fun getItemCount(): Int {
            return filerArray.size
        }
        }

