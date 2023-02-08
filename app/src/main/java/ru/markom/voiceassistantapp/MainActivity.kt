package ru.markom.voiceassistantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SimpleAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    val tag = "MainActivity"

    lateinit var requestInput: TextInputEditText

    lateinit var podsAdapter: SimpleAdapter

    lateinit var progressBar: ProgressBar

    val pods= mutableListOf<HashMap<String, String>>(
        HashMap<String, String>().apply{
            put("title", "title1")
            put("content", "content1")
        },
        HashMap<String, String>().apply{
            put("title", "title2")
            put("content", "content2")
        },
        HashMap<String, String>().apply{
            put("title", "title3")
            put("content", "content3")
        },
        HashMap<String, String>().apply{
            put("title", "title4")
            put("content", "content4")
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        requestInput = findViewById(R.id.text_input_edit)

        val podsList: ListView = findViewById(R.id.pods_list)
        podsAdapter = SimpleAdapter(
            applicationContext,
            pods,
            R.layout.item_pod,
            arrayOf("title", "content"),
            intArrayOf(R.id.title,R.id.content)
        )
        podsList.adapter = podsAdapter

        val voiceInputButton: FloatingActionButton = findViewById(R.id.voice_input_button)
        voiceInputButton.setOnClickListener{
            Log.d(tag,"Floating Action Button on click")
        }

        progressBar = findViewById(R.id.progress_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_stop-> {
                Log.d(tag, "actions_stop")
                return true
            }
            R.id.action_clear-> {
                Log.d(tag, "actions_clear")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}