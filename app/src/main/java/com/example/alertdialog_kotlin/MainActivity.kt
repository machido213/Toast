package com.example.alertdialog_kotlin

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Btn =findViewById<Button>(R.id.button)

        fun showToast(){
            val toast =Toast(this)
                /*val inflater=layoutInflater
                val layout=inflater.inflate(R.layout.custom_toast,findViewById(R.id.custom_toast_root))*/
                toast.view=layoutInflater.inflate(R.layout.custom_toast,null)
                toast.duration=Toast.LENGTH_SHORT
                toast.setGravity(Gravity.TOP,0,0)
                toast.show()
        }
        fun showlistDiglog(){
            //var list ="abc"
            val list = arrayOf<String>("message1","message2","message3","message4","message5")
            AlertDialog.Builder(this)
                .setTitle("使用list呈現")
                .setItems(list){_,i ->
                    Toast.makeText(this, "你選擇的是"+list[i], Toast.LENGTH_SHORT).show()

                }
                .show()
        }

        Btn.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消"){Dialog,which->
                    Toast.makeText(this,"Dialog關閉",Toast.LENGTH_SHORT).show()}
                .setNegativeButton("自訂義Toast"){Dialog,which->
                    showToast()
                }
                .setPositiveButton("顯示list"){Dialog,which->
                    showlistDiglog()
                }
                .show()


        }


    }
}