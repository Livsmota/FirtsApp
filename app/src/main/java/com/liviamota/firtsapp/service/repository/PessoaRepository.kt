package com.liviamota.firtsapp.service.repository

import android.content.Context
import com.liviamota.firtsapp.service.model.Pessoa
import com.liviamota.firtsapp.service.repository.local.FirtsAppDataBase

class PessoaRepository(context: Context) {
    private val firstAppDb = FirtsAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun insertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa)
    }
    suspend fun getPessoa(id: Int):Pessoa{
        return firstAppDb.getPessoa(id)
    }

    suspend fun getPessoas(): List<Pessoa> {
        return firstAppDb.getAll()
    }
    suspend fun updatePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }
    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }

}