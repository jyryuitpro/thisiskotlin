package io.jyryuitpro.aop.part4.fileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.jyryuitpro.aop.part4.fileio.databinding.ActivityMainBinding
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val directoryName = "memo"
            val fileName = "memo02.txt"

            btnSave.setOnClickListener {
                val contents = binding.textWrite.text.toString()
                writeTextFile(directoryName, fileName, contents)
            }

            val path = directoryName + "/" + fileName
            val writtenContents = readTextFile(path)
            textRead.setText(writtenContents)
        }
    }

    fun readTextFile(path: String): String {
        val fullPath = File(filesDir.path + "/" + path)
        if (!fullPath.exists()) return ""

        val reader = FileReader(fullPath)
        val buffer = BufferedReader(reader)

        val result = StringBuilder() // StringBuffer()
        var temp: String? = ""
        while (true) {
            temp = buffer.readLine()
            if (temp == null) break
            result.append(temp).append("\n")
        }
        buffer.close()
        reader.close()
        return result.toString()
    }

    fun writeTextFile(directoryName: String, fileName: String, contents: String) {
        // 앱 기본경로 / files / memo
        val dir = File(filesDir.path + "/" + directoryName)
        if (!dir.exists()) dir.mkdirs()

        val fullPath = dir.path + "/" + fileName
        val writer = FileWriter(fullPath)
        val buffer = BufferedWriter(writer)
        buffer.write(contents)
        buffer.close()
        writer.close()
    }
}