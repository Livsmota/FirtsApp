package com.liviamota.firtsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.liviamota.firtsapp.service.model.Pessoa
import com.liviamota.firtsapp.service.repository.PessoaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllPessoasViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PessoaRepository(application)

    private val mPessoaList = MutableLiveData<List<Pessoa>>()
    val pessoaList: LiveData<List<Pessoa>> = mPessoaList

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            mPessoaList.postValue(repository.getPessoas())
        }
    }
}