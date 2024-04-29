package com.liviamota.firtsapp.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.liviamota.firtsapp.service.model.Pessoa

@Database(entities = [Pessoa::class], version = 1)
 abstract class FirtsAppDataBase: RoomDatabase() {

     abstract fun  pessoaDAO(): PessoaDAO

     companion object {
         @Volatile
         private  lateinit var  INSTANCE: FirtsAppDataBase

         fun getDataBase(context:Context):FirtsAppDataBase{
             if(!Companion::INSTANCE.isInitialized){
                 synchronized(this){
                     INSTANCE = Room.databaseBuilder(context,
                         FirtsAppDataBase::class.java, "firtsapp_database"
                     ).build()
                 }

             }
             return INSTANCE
         }
     }
}

